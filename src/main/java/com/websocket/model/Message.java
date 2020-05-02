package com.websocket.model;

import java.util.Date;

public class Message {

    private String content;
    private String sender;
    private Date timeStamp;

    public final String getContent() {
        return content;
    }

    public final void setContent(final String content) {
        this.content = content;
    }

    public final String getSender() {
        return sender;
    }

    public final void setSender(final String sender) {
        this.sender = sender;
    }

    public final Date getTimeStamp() {
        return timeStamp;
    }

    public final void setTimeStamp(final Date timeStamp) {
        this.timeStamp = timeStamp;
    }

}
