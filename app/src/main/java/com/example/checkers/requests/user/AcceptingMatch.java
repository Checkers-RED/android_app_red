package com.example.checkers.requests.user;

import com.example.checkers.requests.templates.PostTemplate;

import java.io.IOException;
import java.util.ArrayList;

public class AcceptingMatch {
    public static String stringAcceptMatch(String current_session, String org_nick){
        return "{\"current_session\": \"" + current_session + "\", \"f_id\": \"" + org_nick + "\"}";
    }

    public static void accepting(String json) {
        ArrayList<String> response;

        try {
            response = PostTemplate.makeResponse("/AcceptMatch", json);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
    }

    public static class GiveUp {
    }
}
