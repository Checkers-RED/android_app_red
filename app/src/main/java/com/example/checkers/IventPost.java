package com.example.checkers;

import android.os.AsyncTask;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class IventPost extends AppCompatActivity {
    String ip_address = "http://85.143.223.149";
    String ip_port = "2020";

    public ArrayList<String> postIvent(TextView textView1, TextView textView2, String json){
        AsyncTask.execute(() -> {
            try {
                ArrayList<String> response;
                response = buttonPostClick(textView1, textView2, json);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        return null;
    }

    private ArrayList<String> buttonPostClick(TextView textView1, TextView textView2, String json) throws IOException {
        String data = json;

        ArrayList<String> response = postTemplate(data);
        return response;

    }

    private ArrayList<String> postTemplate(String data) throws IOException {

        URL IPAddress = new URL(ip_address + ":" + ip_port + "/TestConnection/");
        HttpURLConnection URLConnection = null;

        try {
            URLConnection = (HttpURLConnection) IPAddress.openConnection();

            URLConnection.setRequestProperty("User-Agent", "rest-api-example-app-1.0.0");
            URLConnection.setRequestProperty("Content-Type", "application/json");
            URLConnection.setRequestMethod("POST");

            URLConnection.setDoOutput(true);

            //Преобразуем входные данные в байт-код
            OutputStream outputStream = URLConnection.getOutputStream();
            byte[] input = data.getBytes(StandardCharsets.UTF_8);
            outputStream.write(input, 0, input.length);

            //Читаем поток данных от сервера = выполняем запрос к серверу
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(
                            URLConnection.getInputStream(), StandardCharsets.UTF_8
                    ));

            //Обрабатываем запрос от сервера = преобразуем полученный байткод в строку
            StringBuilder response = new StringBuilder();
            String responseLine;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }

            ArrayList<String> returnArray = new ArrayList<>();
            returnArray.add( String.valueOf(URLConnection.getResponseCode()) );
            returnArray.add(response.toString());

            return returnArray;

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (URLConnection != null) {
                URLConnection.disconnect();
            }
        }
        return new ArrayList<>();
    }
}
