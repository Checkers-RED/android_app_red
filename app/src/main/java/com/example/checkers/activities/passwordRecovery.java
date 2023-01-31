package com.example.checkers.activities;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
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
import com.example.checkers.requests.user.Restore;

public class passwordRecovery extends AppCompatActivity {

    private void asyncReqNick(String nick) {
        Intent intent = new Intent(passwordRecovery.this, ControlQuestion.class);

        AsyncTask.execute(() -> {
            try {
                Restore.restore(Restore.stringRestore(nick));
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
        setContentView(R.layout.activity_password_recovery);
        Button continueButton = (Button) findViewById(R.id.continueButton);
        Button backButton = (Button) findViewById(R.id.goBack);
        EditText usernameInput = (EditText) findViewById(R.id.editTextPersonName);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(passwordRecovery.this, MainActivity.class);
                startActivity(intent);
            }
        });

        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nick = usernameInput.getText().toString();
                asyncReqNick(nick);
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