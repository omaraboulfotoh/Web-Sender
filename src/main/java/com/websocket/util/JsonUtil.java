package com.websocket.util;

import javax.json.Json;
import java.util.Date;

public class JsonUtil {

    public static String formatMessage(String message, String user) {
        return Json.createObjectBuilder()
                .add("message", message)
                .add("sender", user)
                .add("timeStamp", new Date().toString())
                .build().toString();
    }

}
