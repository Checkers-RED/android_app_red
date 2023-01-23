package com.example.checkers.requests.user;

import com.example.checkers.Globals;
import com.example.checkers.MainActivity;
import com.example.checkers.json.GetSession;
import com.example.checkers.requests.templates.PostTemplate;

import java.io.IOException;
import java.util.ArrayList;

public class Authorization extends MainActivity {
    public static String stringAuthorize(String nick, String pass){
        return "{\"nick\": \"" + nick + "\", \"pass\": \"" + pass + "\"}";
    }

    public static void authorize(String json) {
        ArrayList<String> response;
        try {
            response = PostTemplate.makeResponse("/Authorization", json);
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
