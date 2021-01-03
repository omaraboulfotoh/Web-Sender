package com.websocket.model;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Message {

    private final String message;
    private String timeStamp;

    Message(String message) {
        this.message = message;
        this.setTimeStamp();
    }

    public String getMessage() {
        return message;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    private void setTimeStamp() {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy-hh:mm:ss");
        String dateString = format.format(new Date());
        this.timeStamp = dateString;
    }

    @Override
    public String toString() {

        JsonArrayBuilder content = Json.createArrayBuilder();
        String[] splitMessage = this.message.split(",");
        for (int i = 0; i < splitMessage.length; i++) {
            content.add(splitMessage[i]);
        }
        return Json.createObjectBuilder().add("message", content.build().toString())
                .add("timeStamp", this.getTimeStamp())
                .build().toString();
    }
}
