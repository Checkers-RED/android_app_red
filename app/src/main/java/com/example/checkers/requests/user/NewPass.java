package com.example.checkers.requests.user;

import com.example.checkers.Globals;
import com.example.checkers.json.AnsQues;
import com.example.checkers.json.ChangePass;
import com.example.checkers.json.GetSession;
import com.example.checkers.requests.templates.PostTemplate;

import java.io.IOException;
import java.util.ArrayList;

public class NewPass {
    public static String stringNewPass(String token, String newPass){
        return "{\"token\": \"" + token + "\", \"newPass\": \"" + newPass + "\"}";
    }

    public static void acceptPass(String json){
        ArrayList<String> response;

        try {
            response = PostTemplate.makeResponse("/ChangePass", json);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        if (!response.get(0).equals("200")) {
            return;
        }

        GetSession deserializedJson;
        try {
            deserializedJson = Globals.gson.fromJson(response.get(1), GetSession.class);
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        Globals.setCurrentSession(deserializedJson.get_current_session());
    }
}
