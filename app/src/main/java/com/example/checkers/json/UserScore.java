package com.example.checkers.json;

public class UserScore {
    String nick;
    String photo;
    String score;

    public String getNick() {
        return nick;
    }

    public String getPhoto() {
        return photo;
    }

    public String getScore() {
        return score;
    }

    public UserScore(String nick, String photo, String score){
        this.nick = nick;
        this.photo = photo;
        this.score = score;
    }
}
