package com.example.checkers.requests.user;

import com.example.checkers.Globals;
import com.example.checkers.json.GetSession;
import com.example.checkers.json.UserScore;
import com.example.checkers.requests.templates.PostTemplate;

import java.io.IOException;
import java.util.ArrayList;

public class Score {
    public static String stringCurrentSession(String current_session){
        return "{\"current_session\": \"" + current_session + "\"}";
    }

    public static void setScore(String json){
        ArrayList<String> response;

        try {
            response = PostTemplate.makeResponse("/UserScore", json);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        if (!response.get(0).equals("200")) {
            return;
        }

        UserScore deserializedJson;
        try {
            deserializedJson = Globals.gson.fromJson(response.get(1), UserScore.class);
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        Globals.setNick(deserializedJson.getNick());
        Globals.setScore(deserializedJson.getScore());
        Globals.setPhoto(deserializedJson.getPhoto());
    }
}
