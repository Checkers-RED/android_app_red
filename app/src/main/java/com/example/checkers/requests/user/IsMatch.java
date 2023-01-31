package com.example.checkers.requests.user;

import com.example.checkers.Globals;
import com.example.checkers.json.GetSession;
import com.example.checkers.json.IsInMatch;
import com.example.checkers.requests.templates.PostTemplate;

import java.io.IOException;
import java.util.ArrayList;

public class IsMatch {
    public static String stringIsMatch(String current_session){
        return "{\"current_session\": \"" + current_session + "\"}";
    }

    public static void check(String json){
        ArrayList<String> response;
        try {
            response = PostTemplate.makeResponse("/IsInMatch", json);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        if (!response.get(0).equals("200")) {
            return;
        }

        IsInMatch deserializedJson;
        try {
            deserializedJson = Globals.gson.fromJson(response.get(1), IsInMatch.class);
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        Globals.setIsMatch(deserializedJson.getStatus());
    }
}
