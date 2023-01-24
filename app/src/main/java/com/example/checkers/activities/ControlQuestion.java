package com.example.checkers.activities;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.PopupMenu;

import androidx.appcompat.app.AppCompatActivity;

import com.example.checkers.Globals;
import com.example.checkers.R;
import com.example.checkers.requests.user.Answering;
import com.example.checkers.requests.user.Registration;

public class ControlQuestion extends AppCompatActivity {

    private void asyncAnswering(String token, String ans) {
        Intent intent = new Intent(ControlQuestion.this, PasswordChange.class);

        AsyncTask.execute(() -> {
            try {
                Answering.answer(Answering.stringAnsQues(token, ans));
                if (!Globals.getToken().equals("")) {
                    runOnUiThread(() -> {
                        try {
                            startActivity(intent);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    });
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control_question);


        ImageButton eyeBtn = (ImageButton) findViewById(R.id.eyeBtn);
        EditText answer = (EditText) findViewById(R.id.answer);
        ImageButton backButton = (ImageButton) findViewById(R.id.backButton);
        Button continueButton = (Button) findViewById(R.id.continueButton);
        EditText questionInput = (EditText) findViewById(R.id.question);
        questionInput.setText(Globals.getQuestion());

        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ans = answer.getText().toString();
                String token = Globals.getToken();
                asyncAnswering(token, ans);
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ControlQuestion.this, passwordRecovery.class);
                startActivity(intent);
            }
        });

        eyeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(answer.getTransformationMethod().equals(HideReturnsTransformationMethod.getInstance())){
                    eyeBtn.setBackgroundResource(R.drawable.hide_password);
                    answer.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
                else{
                    eyeBtn.setBackgroundResource(R.drawable.hide_password_active);
                    answer.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }
            }
        });
    }
    public void showSettingsMenu(View view) {
        PopupMenu stMenu = new PopupMenu(this, view);
        MenuInflater inf = stMenu.getMenuInflater();
        inf.inflate(R.menu.settings_menu, stMenu.getMenu());
        stMenu.show();
    }
}