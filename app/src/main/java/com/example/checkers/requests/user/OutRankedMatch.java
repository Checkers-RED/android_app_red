package com.example.checkers.requests.user;

import com.example.checkers.requests.templates.PostTemplate;

import java.io.IOException;
import java.util.ArrayList;

public class OutRankedMatch {
    public static String stringOutRanked(String current_session){
        return "{\"current_session\": \"" + current_session + "\"}";
    }

    public static void stopping(String json) {
        ArrayList<String> response;

        try {
            response = PostTemplate.makeResponse("/OutRankedMatch", json);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
    }
}
