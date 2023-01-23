package com.example.checkers.requests.templates;

import androidx.appcompat.app.AppCompatActivity;

import com.example.checkers.Globals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class PostTemplate extends AppCompatActivity {
    public static ArrayList<String> makeResponse(String path, String json) throws IOException {

        URL IPAddress = new URL(Globals.getIpAddress() + ":" + Globals.getIpPort() + path);
        HttpURLConnection URLConnection = null;

        try {
            URLConnection = (HttpURLConnection) IPAddress.openConnection();

            URLConnection.setRequestProperty("User-Agent", "rest-api-example-app-1.0.0");
            URLConnection.setRequestProperty("Content-Type", "application/json");
            URLConnection.setRequestMethod("POST");

            URLConnection.setDoOutput(true);

            //Преобразуем входные данные в байт-код
            OutputStream outputStream = URLConnection.getOutputStream();
            byte[] input = json.getBytes(StandardCharsets.UTF_8);
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
