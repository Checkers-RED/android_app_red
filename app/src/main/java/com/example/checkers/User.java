package com.example.checkers;

import androidx.annotation.NonNull;

import org.jetbrains.annotations.Contract;

public class User {
    private static String nick;
    private static String pass;
    private static String ques;
    private static String ans;
    private static String current_session;
    private static String token;
    private static String fId;
    private static String rulesId;
    private static String moveTime;
    private static String orgNick;
    private static String colorWin;
    private static String searchNick;
    private static String score;
    private static String photo;



    User (String nick, String pass, String ques, String ans){
        this.nick = nick;
        this.pass = pass;
        this.ques = ques;
        this.ans = ans;
    }


    public static void setNick(String nick){ User.nick = nick; }

    public static String getNick(){ return User.nick; }

    public static void setPass(String pass){
        User.pass = pass;
    }

    public static String getPass(){
        return User.pass;
    }

    public static void setQues(String ques){
        User.ques = ques;
    }

    public static String getQues(){
        return User.ques;
    }

    public static void setAns(String ans){
        User.ans = ans;
    }

    public static String getAns(){
        return User.ans;
    }

    public static void setCurrent_session(String current_session){ User.current_session = current_session; }

    public static String getCurrent_session(){
        return User.current_session;
    }

    public static void setToken(String token){ User.token= token; }

    public static String getToken(){
        return User.token;
    }

    public static void setFId(String fId){
        User.fId = fId;
    }

    public static String getFId(){
        return User.fId;
    }

    public static void setRulesId(String rulesId){ User.rulesId = rulesId; }

    public static String getRulesId(){
        return User.rulesId;
    }

    public static void setMoveTime(String moveTime){
        User.moveTime = moveTime;
    }

    public static String getMoveTime(){
        return User.moveTime;
    }

    public static void setOrgNick(String orgNick){
        User.orgNick = orgNick;
    }

    public static String getOrgNick(){
        return orgNick;
    }

    public static void setColorWin(String colorWin){
        User.colorWin = colorWin;
    }

    public static String getColorWin(){
        return User.colorWin;
    }

    public static void setSearchNick(String searchNick){ User.searchNick = searchNick; }

    public static String getSearchNick(){ return User.searchNick; }

    public static void setScore(String score){ User.score = score; }

    public static String getScore(){ return User.score; }

    public static void setPhoto(String photo){ User.photo = photo; }

    public static String getPhoto(){ return User.photo; }

    //Строки для ручек авторизации
    public static String stringRegister(){
        return "{\"nick\": \"" + nick + "\", \"pass\": \"" + pass + "\", \"ques\": \"" + ques
                + "\", \"ans\": \"" + ans + "\"}";
    }

    public static String stringAutorize(){
        return "{\"nick\": \"" + nick + "\", \"pass\": \"" + pass + "\"}";
    }

    public static String stringReqNick(){
        return "{\"nick\": \"" + nick + "\"}";
    }

    public static String stringAnsQues(){
        return "{\"token\": \"" + token + "\", \"ans\": \"" + ans + "\"}";
    }


    public static String stringNewPass(){
        return "{\"token\": \"" + token + "\", \"pass\": \"" + pass + "\"}";
    }

    //Строки для ручек получения информации
    public static String stringCurrentSession(){
        return "{\"current_session\": \"" + current_session + "\"}";
    }

    public static String stringSearchNick(){
        return "{\"nick\": \"" + searchNick + "\"}";
    }

    public static String stringFriend(){
        return "{\"current_session\": \"" + current_session + "\", \"f_id\": \"" + fId + "\"}";
    }

    //Строки для ручек организации игрового процесса
    public static String stringRanked(){
        return "{\"current_session\": \"" + current_session + "\", \"rules_id\": \"" + rulesId + "\"}";
    }

    public static String stringInviteFriend(){
        return "{\"current_session\": \"" + current_session + "\", \"f_id\": \"" + fId
                + "\", \"move_time\": \"" + moveTime + "\", \"rules_id\": \"" + rulesId + "\"}";
    }

    public static String stringOrgNick(){
        return "{\"current_session\": \"" + current_session + "\", \"org_nick\": \"" + orgNick + "\"}";
    }

    public static void toVariableCurrentSession(String string){
        String[] array = string.split("\"");
        current_session = array[3];
    }

    public static void toVariableReqNick(String string){
        String[] array = string.split("\"");
        token = array[3];
        ques = array[7];
    }

    public static void toVariableToken(String string){
        String[] array = string.split("\"");
        token = array[3];
    }

    public static void toVariableUserScore(String string){
        String[] array = string.split("\"");
        nick = array[3];
        photo = array[7];
        score = array[11];
    }


}
