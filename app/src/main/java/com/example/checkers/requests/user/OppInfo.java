package com.example.checkers.requests.user;

import com.example.checkers.Globals;
import com.example.checkers.json.OpponentInfo;
import com.example.checkers.json.UserScore;
import com.example.checkers.requests.templates.PostTemplate;

import java.io.IOException;
import java.util.ArrayList;

public class OppInfo {
    public static String stringOpponentInfo(String current_session){
        return "{\"current_session\": \"" + current_session + "\"}";
    }

    public static void gettingInfo(String json){
        ArrayList<String> response;

        try {
            response = PostTemplate.makeResponse("/OpponentInfo", json);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        if (!response.get(0).equals("200")) {
            return;
        }

        OpponentInfo deserializedJson;
        try {
            deserializedJson = Globals.gson.fromJson(response.get(1), OpponentInfo.class);
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        Globals.setUserNick(deserializedJson.getNick());
        Globals.setUserScore(deserializedJson.getScore());
        Globals.setUserPhoto(deserializedJson.getPhoto());
        Globals.setUserUid(deserializedJson.getU_id());
    }
}
