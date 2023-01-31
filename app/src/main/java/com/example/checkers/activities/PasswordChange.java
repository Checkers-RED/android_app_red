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
import com.example.checkers.MainActivity;
import com.example.checkers.R;
import com.example.checkers.requests.user.Authorization;
import com.example.checkers.requests.user.NewPass;
import com.example.checkers.requests.user.Score;

public class PasswordChange extends AppCompatActivity {

    private void asyncNewPass(String token, String newPass) {
        Intent intent = new Intent(PasswordChange.this, MainMenu.class);

        AsyncTask.execute(() -> {
            try {
                NewPass.acceptPass(NewPass.stringNewPass(token, newPass));
                Score.setScore(Score.stringCurrentSession(Globals.getCurrentSession()));
                if (!Globals.getCurrentSession().equals("")) {
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
        setContentView(R.layout.activity_password_change);

        ImageButton eyeBtn = (ImageButton) findViewById(R.id.eyeBtn);
        ImageButton eyeBtn2 = (ImageButton) findViewById(R.id.eyeBtn2);
        EditText passNew = (EditText) findViewById(R.id.passNew);
        EditText passRepeat = (EditText) findViewById(R.id.passRepeat);
        Button backButton = (Button) findViewById(R.id.goBack);
        Button changePass = (Button) findViewById(R.id.changePass);

        changePass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newPass = passNew.getText().toString();
                String newPass2 = passRepeat.getText().toString();
                if (newPass2.equals(newPass2)){
                    String token = Globals.getToken();
                    asyncNewPass(token, newPass);
                }

            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PasswordChange.this, MainActivity.class);
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