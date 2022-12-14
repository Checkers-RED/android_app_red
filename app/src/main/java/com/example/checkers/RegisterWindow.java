package com.example.checkers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.MenuInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.PopupMenu;

public class RegisterWindow extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_window);

        ImageButton backButton = (ImageButton) findViewById(R.id.backButton);
        ImageButton eyeBtn = (ImageButton) findViewById(R.id.eyeBtn);
        ImageButton eyeBtn2 = (ImageButton) findViewById(R.id.eyeBtn2);
        ImageButton eyeBtn3 = (ImageButton) findViewById(R.id.eyeBtn3);
        EditText passInput = (EditText) findViewById(R.id.passInput);
        EditText passRepeat = (EditText) findViewById(R.id.passRepeat);
        EditText answer = (EditText) findViewById(R.id.answer);

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
    }

    public void showSettingsMenu(View view) {
        PopupMenu stMenu = new PopupMenu(this, view);
        MenuInflater inf = stMenu.getMenuInflater();
        inf.inflate(R.menu.settings_menu, stMenu.getMenu());
        stMenu.show();
    }
}