package com.websocket.model;

import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

public class MessageDecoder implements Decoder.Text<Message> {

    @Override
    public void init(final EndpointConfig config) {
    }

    @Override
    public void destroy() {
    }

    @Override
    public Message decode(final String textMessage) throws DecodeException {
        // TODO: 1/3/21 Does this function really throws?
        return new Message(textMessage);
    }

    @Override
    public boolean willDecode(final String s) {
        return true;
    }

}
