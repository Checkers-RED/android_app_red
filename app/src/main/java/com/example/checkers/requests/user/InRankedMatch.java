package com.example.checkers.requests.user;

import com.example.checkers.requests.templates.PostTemplate;

import java.io.IOException;
import java.util.ArrayList;

public class InRankedMatch {
    public static String stringRanked(String current_session, String rules_id){
        return "{\"current_session\": \"" + current_session + "\", \"rules_id\": \"" + rules_id + "\"}";
    }

    public static void starting(String json) {
        ArrayList<String> response;

        try {
            response = PostTemplate.makeResponse("/InRankedMatch", json);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
    }
}
