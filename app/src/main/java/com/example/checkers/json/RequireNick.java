package com.example.checkers.json;

public class RequireNick {
    String token;

    public String getToken() {
        return token;
    }

    String question;

    public String getQuestion() {
        return question;
    }

    public RequireNick(String token, String question) {
        this.token = token;
        this.question = question;
    }
}
