package com.example.checkers.requests.user;

import com.example.checkers.Globals;
import com.example.checkers.json.GetSession;
import com.example.checkers.json.RequireNick;
import com.example.checkers.requests.templates.PostTemplate;

import java.io.IOException;
import java.util.ArrayList;

public class Restore {
    public static String stringRestore(String nick){
        return "{\"nick\": \"" + nick + "\"}";
    }

    public static void restore(String json){
        ArrayList<String> response;

        try {
            response = PostTemplate.makeResponse("/ReqNick", json);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        if (!response.get(0).equals("200")) {
            return;
        }

        RequireNick deserializedJson;
        try {
            deserializedJson = Globals.gson.fromJson(response.get(1), RequireNick.class);
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        Globals.setToken(deserializedJson.getToken());
        Globals.setQuestion(deserializedJson.getQuestion());
    }
}
