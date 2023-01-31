package com.example.checkers.json;

public class GetMoveTimeColor {
    String color;
    String dttime;

    public GetMoveTimeColor(String color, String dttime){
        this.color = color;
        this.dttime = dttime;
    }

    public String getColor() {
        return color;
    }

    public String getDttime() {
        return dttime;
    }
}
