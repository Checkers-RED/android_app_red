package com.example.checkers.requests.user;

import com.example.checkers.requests.templates.PostTemplate;

import java.io.IOException;
import java.util.ArrayList;

public class RevokingMatch {
    public static String stringRevokeMatch(String current_session, String f_id){
        return "{\"current_session\": \"" + current_session + "\", \"f_id\": \"" + f_id + "\"}";
    }

    public static void revoking(String json) {
        ArrayList<String> response;

        try {
            response = PostTemplate.makeResponse("/RevokeMatch", json);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
    }

}
