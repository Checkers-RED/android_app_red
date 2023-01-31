package com.example.checkers.requests.user;

import com.example.checkers.Globals;
import com.example.checkers.json.AnsQues;
import com.example.checkers.json.GetInvitedFriendId;
import com.example.checkers.requests.templates.PostTemplate;

import java.io.IOException;
import java.util.ArrayList;

public class GettingInvitedFriendId {
    public static String stringGetFriendId(String current_session){
        return "{\"current_session\": \"" + current_session + "\"}";
    }

    public static void getting(String json){
        ArrayList<String> response;

        try {
            response = PostTemplate.makeResponse("/GetInvitedFriendId", json);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        if (!response.get(0).equals("200")) {
            return;
        }

        GetInvitedFriendId deserializedJson;
        try {
            deserializedJson = Globals.gson.fromJson(response.get(1), GetInvitedFriendId.class);
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        Globals.setF_id(deserializedJson.getId());
    }
}
