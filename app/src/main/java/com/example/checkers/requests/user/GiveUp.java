package com.example.checkers.requests.user;

import com.example.checkers.Globals;
import com.example.checkers.json.IsInMatch;
import com.example.checkers.requests.templates.PostTemplate;

import java.io.IOException;
import java.util.ArrayList;

public class GiveUp {
    public static String stringGiveUp(String current_session){
        return "{\"current_session\": \"" + current_session + "\"}";
    }

    public static void givingUp(String json){
        ArrayList<String> response;
        try {
            response = PostTemplate.makeResponse("/GiveUp", json);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        if (!response.get(0).equals("200")) {
            return;
        }
    }
}
