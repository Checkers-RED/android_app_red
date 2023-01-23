package com.example.checkers.activities;

import android.content.Intent;
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

import com.example.checkers.MainActivity;
import com.example.checkers.R;

public class PasswordChange extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password_change);

        ImageButton eyeBtn = (ImageButton) findViewById(R.id.eyeBtn);
        ImageButton eyeBtn2 = (ImageButton) findViewById(R.id.eyeBtn2);
        EditText passNew = (EditText) findViewById(R.id.passNew);
        EditText passRepeat = (EditText) findViewById(R.id.passRepeat);
        ImageButton backButton = (ImageButton) findViewById(R.id.backButton);
        Button changePass = (Button) findViewById(R.id.changePass);

        changePass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(PasswordChange.this, MainActivity.class);
                startActivity(intent);

            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PasswordChange.this, ControlQuestion.class);
                startActivity(intent);
            }
        });

        eyeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(passNew.getTransformationMethod().equals(HideReturnsTransformationMethod.getInstance())){
                    eyeBtn.setBackgroundResource(R.drawable.hide_password);
                    passNew.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
                else{
                    eyeBtn.setBackgroundResource(R.drawable.hide_password_active);
                    passNew.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
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
    }
    public void showSettingsMenu(View view) {
        PopupMenu stMenu = new PopupMenu(this, view);
        MenuInflater inf = stMenu.getMenuInflater();
        inf.inflate(R.menu.settings_menu, stMenu.getMenu());
        stMenu.show();
    }
}