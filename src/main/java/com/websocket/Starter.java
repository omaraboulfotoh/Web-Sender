package com.websocket;

import java.util.Scanner;


public class Starter {

    // TODO: 1/3/21 Does this function really throws?
    public static void main(String[] args) throws Exception {
        WebSenderService webSenderService = WebSenderService.getInstance();
        Scanner scanner = new Scanner(System.in);
        String message;

        do {
            System.out.println("Type 'quit' to stop the server..");
            message = scanner.nextLine();
            webSenderService.sendMessage(message);
        } while (!message.equalsIgnoreCase("quit"));

        webSenderService.stopSender();
    }
}
