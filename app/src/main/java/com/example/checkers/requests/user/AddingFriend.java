package com.example.checkers.requests.user;

import com.example.checkers.Globals;
import com.example.checkers.json.AnsQues;
import com.example.checkers.requests.templates.PostTemplate;

import java.io.IOException;
import java.util.ArrayList;

public class AddingFriend {
    public static String stringAddFriend(String current_session, String f_id){
        return "{\"current_session\": \"" + current_session + "\", \"f_id\": \"" + f_id + "\"}";
    }

    public static void adding(String json) {
        ArrayList<String> response;

        try {
            response = PostTemplate.makeResponse("/AddFriend", json);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
    }
}
