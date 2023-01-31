package com.example.checkers.json;

public class GetUser {
    String uid;
    String nick;
    String photo;

    public String getUid() {
        return uid;
    }

    public String getNick() {
        return nick;
    }

    public String getPhoto() {
        return photo;
    }

    public GetUser(String uid, String nick, String photo){
        this.uid = uid;
        this.nick = nick;
        this.photo = photo;
    }
}
