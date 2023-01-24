package com.example.checkers;

import com.google.gson.Gson;

import java.security.PublicKey;

public class Globals {
    private static String score;

    public static String getScore() {
        return score;
    }

    public static void setScore(String score) {
        Globals.score = score;
    }

    private static String photo;

    public static String getPhoto() {
        return photo;
    }

    public static void setPhoto(String photo) {
        Globals.photo = photo;
    }

    private static String nick;

    public static String getNick() {
        return nick;
    }

    public static void setNick(String nick) {
        Globals.nick = nick;
    }

    private static String currentSession;

    public static String getCurrentSession() {
        return currentSession;
    }

    public static void setCurrentSession(String currentSession) {
        Globals.currentSession = currentSession;
    }

    private static String token;

    public static String getToken() { return token; }

    public static void setToken(String token) {
        Globals.token = token;
    }

    private static String question;

    public static String getQuestion() {
        return question;
    }

    public static void setQuestion(String question) {
        Globals.question = question;
    }

    private static final String ipAddress = "http://85.143.223.149";

    public static String getIpAddress() {
        return ipAddress;
    }

    private static final String ipPort = "2020";

    public static String getIpPort() {
        return ipPort;
    }

    public static final Gson gson = new Gson();
}
