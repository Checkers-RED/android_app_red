package com.example.checkers.activities;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.checkers.Globals;
import com.example.checkers.MainActivity;
import com.example.checkers.R;
import com.example.checkers.requests.user.AddingFriend;
import com.example.checkers.requests.user.Authorization;
import com.example.checkers.requests.user.Score;
import com.example.checkers.requests.user.SearchingFriend;

public class AddFriend extends AppCompatActivity {

    private void asyncAdding(String current_session, String f_id) {

        AsyncTask.execute(() -> {
            try {
                AddingFriend.adding(AddingFriend.stringAddFriend(current_session, f_id));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    private void asyncSearching(String nick) {

        AsyncTask.execute(() -> {
            try {
                SearchingFriend.search(SearchingFriend.stringSearching(nick));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_friend);

        Button goBack = (Button) findViewById(R.id.goBack);
        ImageButton search = (ImageButton) findViewById(R.id.searchBtn);
        ImageButton addFriend = (ImageButton) findViewById(R.id.addFriendBtn);

        EditText findUser = (EditText) findViewById(R.id.search_user);
        TextView userName = (TextView) findViewById(R.id.user_name);
        LinearLayout userLayout = (LinearLayout) findViewById(R.id.user_layout);

        addFriend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String current_session = Globals.getCurrentSession();
                String f_id = Globals.getUserUid();
                asyncAdding(current_session,f_id);
            }
        });

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = findUser.getText().toString();
                asyncSearching(user);
                if(!Globals.getUserNick().equals("")){
                    userName.setText(Globals.getUserNick());
                    userLayout.setVisibility(View.VISIBLE);
                }
            }
        });

        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userLayout.setVisibility(View.GONE);
                userName.setText("");
                Intent intent = new Intent(AddFriend.this, MainMenu.class);
                startActivity(intent);
            }
        });
    }
}