package com.example.checkers;

import com.google.gson.Gson;

public class Globals {
    private static String currentSession;

    public static String getCurrentSession() {
        return currentSession;
    }

    public static void setCurrentSession(String currentSession) {
        Globals.currentSession = currentSession;
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
