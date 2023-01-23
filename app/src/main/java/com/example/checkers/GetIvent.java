package com.example.checkers;

import android.view.MenuItem;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class GetIvent extends AppCompatActivity {
    String ip_address = "http://85.143.223.149";
    String ip_port = "2020";
    MenuItem status = (MenuItem) findViewById(R.id.status);

    private void buttonGetClick(TextView textView1, TextView textView2) throws IOException {
        URL IPAddress = new URL(ip_address + ":" + ip_port + "/TestConnection/");
        HttpURLConnection URLConnection = null;

        try {
            URLConnection = (HttpURLConnection) IPAddress.openConnection();
            URLConnection.setRequestProperty("User-Agent", "rest-api-example-app-1.0.0");
            URLConnection.setRequestProperty("Content-Type", "application/json");
            URLConnection.setRequestMethod("GET");

            String resultCode = String.valueOf(URLConnection.getResponseCode());
            String resultBody = String.valueOf(URLConnection.getResponseMessage());

            this.runOnUiThread(() -> {
                textView1.setText(resultCode);
                textView2.setText(resultBody);
            });
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (URLConnection != null) {
                URLConnection.disconnect();
            }
        }
    }

    public Runnable asyncTaskButtonGetClick(TextView textView1, TextView textView2) {
        return new Runnable() {
            @Override
            public void run() {
                try {
                    buttonGetClick(textView1, textView2);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
    }
}
