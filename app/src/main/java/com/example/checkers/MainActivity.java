package com.example.checkers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //____________Values____________//
        Button registerButton = (Button) findViewById(R.id.registerButton);
        Button forgotPassword = (Button) findViewById(R.id.forgotPassword);
        ImageButton logButton = (ImageButton) findViewById(R.id.exitBtn);
        ImageButton eyeBtn = (ImageButton) findViewById(R.id.eyeBtn);
        EditText passInput = (EditText) findViewById(R.id.passInput);




        //___________Buttons____________//
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

        logButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainMenu.class);
                startActivity(intent);
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

       IventGet getIvent = new IventGet();

       getIvent.getIvent();

       text = getIvent.getTextView1();
       textView2.setText(text);

    }
}