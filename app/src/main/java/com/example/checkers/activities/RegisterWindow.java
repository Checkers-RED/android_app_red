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
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.checkers.Globals;
import com.example.checkers.MainActivity;
import com.example.checkers.R;
import com.example.checkers.requests.user.Registration;
import com.example.checkers.requests.user.Score;

public class RegisterWindow extends AppCompatActivity {

    private void asyncRegistration(String nick, String pass, String ques, String ans) {
        Intent intent = new Intent(RegisterWindow.this, MainMenu.class);

        AsyncTask.execute(() -> {
            try {
                Registration.register(Registration.stringRegister(nick, pass, ques, ans));
                if (!Globals.getCurrentSession().equals("")) {
                    Score.setScore(Score.stringCurrentSession(Globals.getCurrentSession()));
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
        setContentView(R.layout.activity_register_window);

        ImageButton backButton = (ImageButton) findViewById(R.id.backButton);
        ImageButton eyeBtn = (ImageButton) findViewById(R.id.eyeBtn);
        ImageButton eyeBtn2 = (ImageButton) findViewById(R.id.eyeBtn2);
        ImageButton eyeBtn3 = (ImageButton) findViewById(R.id.eyeBtn3);
        EditText name = (EditText) findViewById(R.id.person_name);
        EditText passInput = (EditText) findViewById(R.id.passInput);
        EditText passRepeat = (EditText) findViewById(R.id.passRepeat);
        EditText question = (EditText) findViewById(R.id.question);
        EditText answer = (EditText) findViewById(R.id.answer);
        TextView textView1 = (TextView) findViewById(R.id.textView1);
        TextView textView2 = (TextView) findViewById(R.id.textView2);


        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterWindow.this, MainActivity.class);
                startActivity(intent);
            }
        });
        eyeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(passInput.getTransformationMethod().equals(HideReturnsTransformationMethod.getInstance())){
                    eyeBtn.setBackgroundResource(R.drawable.hide_password);
                    passInput.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
                else{
                    eyeBtn.setBackgroundResource(R.drawable.hide_password_active);
                    passInput.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }
            }
        });
        eyeBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(passRepeat.getTransformationMethod().equals(HideReturnsTransformationMethod.getInstance())){
                    eyeBtn2.setBackgroundResource(R.drawable.hide_password);
                    passRepeat.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
                else{
                    eyeBtn2.setBackgroundResource(R.drawable.hide_password_active);
                    passRepeat.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }
            }
        });

        eyeBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(answer.getTransformationMethod().equals(HideReturnsTransformationMethod.getInstance())){
                    eyeBtn3.setBackgroundResource(R.drawable.hide_password);
                    answer.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
                else{
                    eyeBtn3.setBackgroundResource(R.drawable.hide_password_active);
                    answer.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }
            }
        });

        Button registerBtn = (Button) findViewById(R.id.register_btn);
        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nick = name.getText().toString();
                String pass = passInput.getText().toString();
                String pass2 = passRepeat.getText().toString();
                String ques = question.getText().toString();
                String ans = answer.getText().toString();

                if(pass.equals(pass2)){
                    asyncRegistration(nick, pass, ques, ans);
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