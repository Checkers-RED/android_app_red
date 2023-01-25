package com.example.checkers;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.checkers.activities.MainMenu;
import com.example.checkers.activities.RegisterWindow;
import com.example.checkers.activities.passwordRecovery;
import com.example.checkers.requests.templates.GetTemplate;
import com.example.checkers.requests.user.Authorization;
import com.example.checkers.requests.user.Score;

public class MainActivity extends AppCompatActivity {

    private void asyncAuthorization(String nick, String pass) {
        Intent intent = new Intent(MainActivity.this, MainMenu.class);

        AsyncTask.execute(() -> {
            try {
                Authorization.authorize(Authorization.stringAuthorize(nick, pass));
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
        setContentView(R.layout.activity_main);

        //____________Values____________//
        Button registerButton = (Button) findViewById(R.id.registerButton);
        Button forgotPassword = (Button) findViewById(R.id.forgotPassword);
        ImageButton logButton = (ImageButton) findViewById(R.id.exitBtn);
        ImageButton eyeBtn = (ImageButton) findViewById(R.id.eyeBtn);
        EditText usernameInput = (EditText) findViewById(R.id.editTextTextPersonName);
        EditText passInput = (EditText) findViewById(R.id.passInput);


        //___________Buttons____________//
        eyeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (passInput.getTransformationMethod().equals(HideReturnsTransformationMethod.getInstance())) {
                    eyeBtn.setBackgroundResource(R.drawable.hide_password);
                    passInput.setTransformationMethod(PasswordTransformationMethod.getInstance());
                } else {
                    eyeBtn.setBackgroundResource(R.drawable.hide_password_active);
                    passInput.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }
            }
        });

        logButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nick = usernameInput.getText().toString();
                String pass = passInput.getText().toString();

                asyncAuthorization(nick, pass);
            }
        });

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RegisterWindow.class);
                startActivity(intent);
            }
        });

        forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, passwordRecovery.class);
                startActivity(intent);
            }
        });


    }

    public void showSettingsMenu(View view) {

        TextView textView2 = (TextView) findViewById(R.id.textView2);

        PopupMenu stMenu = new PopupMenu(this, view);
        MenuInflater inf = stMenu.getMenuInflater();
        inf.inflate(R.menu.settings_menu, stMenu.getMenu());
        stMenu.show();

        String text = "text";
        Log.i(text, "hey");

        GetTemplate getIvent = new GetTemplate();

       /*
       getIvent.getIvent();

       text = getIvent.getTextView1();
       textView2.setText(text);
        */

    }
}