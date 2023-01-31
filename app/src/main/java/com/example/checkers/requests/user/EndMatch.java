package com.example.checkers.requests.user;

import com.example.checkers.Globals;
import com.example.checkers.json.IsInMatch;
import com.example.checkers.requests.templates.PostTemplate;

import java.io.IOException;
import java.util.ArrayList;

public class EndMatch {
    public static String stringEndMatch(String current_session, String color_win){
        return "{\"current_session\": \"" + current_session + ", \"color_win\": " + color_win + "\"}";
    }

    public static void ending(String json){
        ArrayList<String> response;
        try {
            response = PostTemplate.makeResponse("/EndMatch", json);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        if (!response.get(0).equals("200")) {
            return;
        }

    }
}
