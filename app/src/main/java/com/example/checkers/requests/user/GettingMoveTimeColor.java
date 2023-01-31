package com.example.checkers.requests.user;

import com.example.checkers.Globals;
import com.example.checkers.json.GetMoveTimeColor;
import com.example.checkers.json.OpponentInfo;
import com.example.checkers.requests.templates.PostTemplate;

import java.io.IOException;
import java.util.ArrayList;

public class GettingMoveTimeColor {
    public static String stringGettingMoveTimeColor(String current_session){
        return "{\"current_session\": \"" + current_session + "\"}";
    }

    public static void getting(String json){
        ArrayList<String> response;

        try {
            response = PostTemplate.makeResponse("/GetMoveTimeColor", json);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        if (!response.get(0).equals("200")) {
            return;
        }

        GetMoveTimeColor deserializedJson;
        try {
            deserializedJson = Globals.gson.fromJson(response.get(1), GetMoveTimeColor.class);
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }
}
