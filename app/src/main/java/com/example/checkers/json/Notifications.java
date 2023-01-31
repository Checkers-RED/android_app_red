package com.example.checkers.json;

public class Notifications {
    String type;
    String actEl1;
    String actEl2;

    public Notifications(String type, String actEl1, String actEl2){
        this.type = type;
        this.actEl1 = actEl1;
        this.actEl2 = actEl2;
    }

    public String getType() {
        return type;
    }

    public String getActEl1() {
        return actEl1;
    }

    public String getActEl2() {
        return actEl2;
    }
}
