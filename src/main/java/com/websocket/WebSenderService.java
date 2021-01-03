package com.websocket;

import com.websocket.endpoint.ClientEndpoint;
import com.websocket.endpoint.ServerEndpoint;
import org.glassfish.tyrus.client.ClientManager;
import org.glassfish.tyrus.server.Server;

import javax.websocket.DeploymentException;
import javax.websocket.Session;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class WebSenderService {
    private static WebSenderService webSenderService;
    private static final String SERVER = "ws://localhost:8025/ws/chat";
    private static Server server;
    private static ClientManager client;
    private static Session session;

    private WebSenderService() {
        server = new Server("localhost", 8025, "/ws", ServerEndpoint.class);
        client = ClientManager.createClient();
        try {
            server.start();
            session = client.connectToServer(ClientEndpoint.class, new URI(SERVER));
        } catch (DeploymentException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    public static WebSenderService getInstance() {
        if (webSenderService == null) {
            webSenderService = new WebSenderService();
        }
        return webSenderService;
    }

    public void sendMessage(String message) {
        try {
            session.getBasicRemote().sendText(message);
        } catch (IOException e) {
            System.out.println("there is error when sending to the server");
            e.printStackTrace();
        }
    }

    public void stopSender() {
        server.stop();
    }

}
