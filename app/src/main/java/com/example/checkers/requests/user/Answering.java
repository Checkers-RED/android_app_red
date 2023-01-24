package com.example.checkers.requests.user;

import com.example.checkers.Globals;
import com.example.checkers.json.AnsQues;
import com.example.checkers.json.RequireNick;
import com.example.checkers.requests.templates.PostTemplate;

import java.io.IOException;
import java.util.ArrayList;

public class Answering {
    public static String stringAnsQues(String token, String ans){
        return "{\"token\": \"" + token + "\", \"ans\": \"" + ans + "\"}";
    }

    public static void answer(String json){
        ArrayList<String> response;

        try {
            response = PostTemplate.makeResponse("/AnsQues", json);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        if (!response.get(0).equals("200")) {
            return;
        }

        AnsQues deserializedJson;
        try {
            deserializedJson = Globals.gson.fromJson(response.get(1), AnsQues.class);
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        Globals.setToken(deserializedJson.getNewToken());
    }
}
