package com.example.checkers.requests.user;

import com.example.checkers.Globals;
import com.example.checkers.json.BoxOfFriendsResponse;
import com.example.checkers.json.BoxOfNotifications;
import com.example.checkers.requests.templates.PostTemplate;

import java.io.IOException;
import java.util.ArrayList;

public class GettingNotifications {
    public static String stringGetNotifications(String current_session){
        return "{\"current_session\": \"" + current_session + "\"}";
    }

    public static void getNotifications(String json){
        ArrayList<String> response;

        try {
            response = PostTemplate.makeResponse("/GetNotifs", json);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        if (!response.get(0).equals("200")) {
            return;
        }

        BoxOfNotifications deserializedJson;
        try {
            deserializedJson = Globals.gson.fromJson(response.get(1), BoxOfNotifications.class);
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        Globals.setNotifications(deserializedJson.getNotifications());
    }
}
