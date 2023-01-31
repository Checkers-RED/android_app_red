package com.example.checkers.requests.user;

import com.example.checkers.requests.templates.PostTemplate;

import java.io.IOException;
import java.util.ArrayList;

public class DeletingFriend {
    public static String stringDeleteFriend(String current_session, String f_id){
        return "{\"current_session\": \"" + current_session + "\", \"f_id\": \"" + f_id + "\"}";
    }

    public static void deleting(String json) {
        ArrayList<String> response;

        try {
            response = PostTemplate.makeResponse("/DeleteFriend", json);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
    }
}
