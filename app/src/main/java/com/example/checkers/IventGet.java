package com.example.checkers;

import android.nfc.Tag;
import android.os.AsyncTask;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class IventGet extends AppCompatActivity {
    static String ip_address = "http://85.143.223.149";
    static String ip_port = "2020";
    private static String resultCode;
    private static String resultBody;
    private static String textView1;
    private static String textView2;
    private String TAG = "hello";

    private void buttonGetClick(String textView1, String textView2) throws IOException {
        URL IPAddress = new URL(ip_address + ":" + ip_port + "/TestConnection/");
        HttpURLConnection URLConnection = null;


        try {
            URLConnection = (HttpURLConnection) IPAddress.openConnection();
            URLConnection.setRequestProperty("User-Agent", "rest-api-example-app-1.0.0");
            URLConnection.setRequestProperty("Content-Type", "application/json");
            URLConnection.setRequestMethod("GET");

            resultCode = String.valueOf(URLConnection.getResponseCode());
            resultBody = String.valueOf(URLConnection.getResponseMessage());
            Log.i(TAG, "running too");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (URLConnection != null) {
                URLConnection.disconnect();
            }
        }
    }

    private Runnable asyncTaskButtonGetClick(String textView1, String textView2) {
        return new Runnable() {
            @Override
            public void run() {
                Log.i(TAG, "running");
                try {
                    buttonGetClick(textView1, textView2);
                } catch (Exception e) {
                    e.printStackTrace();
                    Log.i(TAG, "wrong");
                }
            }
        };
    }

    public void getIvent(){
        String text1 = "1";
        String text2 = "2";
        AsyncTask.execute(asyncTaskButtonGetClick(text1, text2));

    }

    public String getTextView1() {
        return this.resultBody;
    }
}
