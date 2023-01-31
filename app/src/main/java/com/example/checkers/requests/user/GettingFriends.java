package com.example.checkers.requests.user;

import com.example.checkers.Globals;
import com.example.checkers.json.AnsQues;
import com.example.checkers.json.BoxOfFriendsResponse;
import com.example.checkers.requests.templates.PostTemplate;

import java.io.IOException;
import java.util.ArrayList;

public class GettingFriends {
    public static String stringGetFriends(String current_session){
        return "{\"current_session\": \"" + current_session + "\"}";
    }

    public static void getFriends(String json){
        ArrayList<String> response;

        try {
            response = PostTemplate.makeResponse("/GetFriends", json);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        if (!response.get(0).equals("200")) {
            return;
        }

        BoxOfFriendsResponse deserializedJson;
        try {
            deserializedJson = Globals.gson.fromJson(response.get(1), BoxOfFriendsResponse.class);
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        Globals.setFriends(deserializedJson.getFriends());
    }
}
