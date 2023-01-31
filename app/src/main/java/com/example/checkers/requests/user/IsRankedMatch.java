package com.example.checkers.requests.user;

import com.example.checkers.Globals;
import com.example.checkers.json.IsInMatch;
import com.example.checkers.json.IsInRankedMatch;
import com.example.checkers.requests.templates.PostTemplate;

import java.io.IOException;
import java.util.ArrayList;

public class IsRankedMatch {
    public static String stringIsRankedMatch(String current_session){
        return "{\"current_session\": \"" + current_session + "\"}";
    }

    public static void check(String json) {
        ArrayList<String> response;
        try {
            response = PostTemplate.makeResponse("/IsInRankedMatch", json);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        if (!response.get(0).equals("200")) {
            return;
        }

        IsInRankedMatch deserializedJson;
        try {
            deserializedJson = Globals.gson.fromJson(response.get(1), IsInRankedMatch.class);
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        Globals.setIsMatch(deserializedJson.getStatus());
    }
}
