package com.example.checkers.requests.user;

import com.example.checkers.Globals;
import com.example.checkers.json.IsInMatch;
import com.example.checkers.json.IsNotInRankedMatch;
import com.example.checkers.requests.templates.PostTemplate;

import java.io.IOException;
import java.util.ArrayList;

public class IsNotRankedMatch {
    public static String stringIsNotMatch(String current_session){
        return "{\"current_session\": \"" + current_session + "\"}";
    }

    public static void check(String json){
        ArrayList<String> response;
        try {
            response = PostTemplate.makeResponse("/IsNotInRankedMatch", json);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        if (!response.get(0).equals("200")) {
            return;
        }

        IsNotInRankedMatch deserializedJson;
        try {
            deserializedJson = Globals.gson.fromJson(response.get(1), IsNotInRankedMatch.class);
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        Globals.setIsMatch(deserializedJson.getStatus());
    }
}
