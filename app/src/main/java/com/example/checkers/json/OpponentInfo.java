package com.example.checkers.json;

public class OpponentInfo {
    String u_id;
    String nick;
    String score;
    String photo;

    public OpponentInfo(String u_id, String nick, String score, String photo){
        this.u_id = u_id;
        this.nick = nick;
        this.score = score;
        this.photo = photo;
    }

    public String getU_id() {
        return u_id;
    }

    public String getNick() {
        return nick;
    }

    public String getScore() {
        return score;
    }

    public String getPhoto() {
        return photo;
    }
}
