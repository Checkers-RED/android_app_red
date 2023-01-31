package com.example.checkers.requests.user;

import com.example.checkers.requests.templates.PostTemplate;

import java.io.IOException;
import java.util.ArrayList;

public class RejectingMatch {
    public static String stringRejectMatch(String current_session, String org_nick){
        return "{\"current_session\": \"" + current_session + "\", \"f_id\": \"" + org_nick + "\"}";
    }

    public static void rejecting(String json) {
        ArrayList<String> response;

        try {
            response = PostTemplate.makeResponse("/RejectMatch", json);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
    }
}
