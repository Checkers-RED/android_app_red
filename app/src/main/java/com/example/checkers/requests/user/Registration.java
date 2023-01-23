package com.example.checkers.requests.user;

import com.example.checkers.Globals;
import com.example.checkers.json.GetSession;
import com.example.checkers.requests.templates.PostTemplate;

import java.io.IOException;
import java.util.ArrayList;

public class Registration {
    //Строки для ручек регистрации
    public static String stringRegister(String nick, String pass, String ques, String ans) {
        return "{\"nick\": \"" + nick + "\", \"pass\": \"" + pass + "\", \"ques\": \"" + ques
                + "\", \"ans\": \"" + ans + "\"}";
    }

    public static void register(String json) {

        ArrayList<String> response;

        try {
            response = PostTemplate.makeResponse("/CreateAccount", json);
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
