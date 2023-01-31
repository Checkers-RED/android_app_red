package com.example.checkers;

import com.example.checkers.json.Friends;
import com.example.checkers.json.Notifications;
import com.google.gson.Gson;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

public class Globals {
    private static Boolean statusMatch;

    public static Boolean getIsMatch() {
        return statusMatch;
    }

    public static void setIsMatch(Boolean statusMatch) {
        Globals.statusMatch = statusMatch;
    }

    private static Boolean statusRanked;

    public static Boolean getStatusMatch() {
        return statusMatch;
    }

    public static Boolean getStatusRanked() {
        return statusRanked;
    }

    private static String rules_id;

    public static String getRules_id() {
        return rules_id;
    }

    public static void setRules_id(String rules_id) {
        Globals.rules_id = rules_id;
    }

    private static String f_id;

    public static String getF_id() {
        return f_id;
    }

    public static void setF_id(String f_id) {
        Globals.f_id = f_id;
    }

    private static List<Notifications> notifications = new ArrayList<Notifications>();

    public static List<Notifications> getNotifications() {
        return notifications;
    }

    public static void setNotifications(List<Notifications> notifications) {
        Globals.notifications = notifications;
    }

    private static List<Friends> friends = new ArrayList<Friends>();

    public static List<Friends> getFriends() {
        return friends;
    }

    public static void setFriends(List<Friends> friends) {
        Globals.friends = friends;
    }

    private static String userUid;

    public static String getUserUid() {
        return userUid;
    }

    public static void setUserUid(String userUid) {
        Globals.userUid = userUid;
    }

    private static String userNick = "";

    public static String getUserNick() {
        return userNick;
    }

    public static void setUserNick(String userNick) {
        Globals.userNick = userNick;
    }

    private static String userPhoto;

    public static String getUserPhoto() {
        return userPhoto;
    }

    public static void setUserPhoto(String userPhoto) {
        Globals.userPhoto = userPhoto;
    }

    private static String userScore;

    public static String getUserScore() {
        return userScore;
    }

    public static void setUserScore(String userScore) {
        Globals.userScore = userScore;
    }

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
