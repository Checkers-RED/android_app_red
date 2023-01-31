package com.example.checkers.requests.user;

import com.example.checkers.requests.templates.PostTemplate;

import java.io.IOException;
import java.util.ArrayList;

public class InvitingFriend {
    public static String stringInviteFriend(String current_session, String f_id, String move_time, String rules_id){
        return "{\"current_session\": \"" + current_session + "\", \"f_id\": \"" + f_id
                + "\", \"move_time\": \"" + move_time + "\", \"rules_id\": \"" + rules_id + "\"}";
    }

    public static void inviting(String json) {
        ArrayList<String> response;

        try {
            response = PostTemplate.makeResponse("/InviteFriend", json);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
    }
}
