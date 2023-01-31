package com.example.checkers.requests.user;

import com.example.checkers.Globals;
import com.example.checkers.json.GetSession;
import com.example.checkers.json.GetUser;
import com.example.checkers.requests.templates.PostTemplate;

import java.io.IOException;
import java.util.ArrayList;

public class SearchingFriend {
    public static String stringSearching(String nick){
        return "{\"nick\": \"" + nick + "\"}";
    }

    public static void search(String json) {
        ArrayList<String> response;
        try {
            response = PostTemplate.makeResponse("/SearchUser", json);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        if (!response.get(0).equals("200")) {
            return;
        }

        GetUser deserializedJson;
        try {
            deserializedJson = Globals.gson.fromJson(response.get(1), GetUser.class);
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        Globals.setUserUid(deserializedJson.getUid());
        Globals.setUserNick(deserializedJson.getNick());
        Globals.setUserPhoto(deserializedJson.getPhoto());
    }
}
