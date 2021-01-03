package com.websocket.endpoint;

import com.websocket.model.Message;
import com.websocket.model.MessageDecoder;
import com.websocket.model.MessageEncoder;

import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;

import static java.lang.String.format;

@javax.websocket.ClientEndpoint(encoders = MessageEncoder.class, decoders = MessageDecoder.class)
public class ClientEndpoint {

    @OnOpen
    public void onOpen(Session session) {
        System.out.printf("Connection established. session id: %s%n", session.getId());
    }

    @OnMessage
    public void onMessage(Message message) {
        System.out.println(message);
    }
}
