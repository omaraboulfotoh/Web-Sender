package com.websocket.endpoint;

import static java.lang.String.format;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import javax.websocket.EncodeException;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;

import com.websocket.model.Message;
import com.websocket.model.MessageDecoder;
import com.websocket.model.MessageEncoder;

@javax.websocket.server.ServerEndpoint(value = "/chat", encoders = MessageEncoder.class, decoders = MessageDecoder.class)
public class ServerEndpoint {
    static Set<Session> peers = Collections.synchronizedSet(new HashSet<Session>());

    @OnOpen
    public void onOpen(Session session) {
        peers.add(session);
    }

    @OnMessage
    public void onMessage(Message message, Session session) throws IOException, EncodeException {
//        String user = (String) session.getUserProperties().get("user");
//        if (user == null) {
//            session.getUserProperties().put("user", message.getSender());
//        }
        if ("quit".equalsIgnoreCase(message.getMessage())) {
            session.close();
        }
        System.out.println(format("[%s] %s", message.getTimeStamp(), message.getMessage()));

        //broadcast the message
        for (Session peer : peers) {
            if (!session.getId().equals(peer.getId())) { // do not resend the message to its sender
                peer.getBasicRemote().sendObject(message);
            }
        }
    }

    @OnClose
    public void onClose(Session session) throws IOException, EncodeException {
        System.out.println("Connection with the client is closed");
        peers.remove(session);
        //notify peers about leaving the chat room
//        for (Session peer : peers) {
//            Message chatMessage = new Message();
//            chatMessage.setMessage(format("left the chat room"));
//            chatMessage.setTimeStamp(DateUtile.formattedDate());
//            peer.getBasicRemote().sendObject(chatMessage);
//        }
    }

}