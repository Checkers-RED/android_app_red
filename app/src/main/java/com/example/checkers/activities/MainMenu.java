package com.example.checkers.activities;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.ScrollView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.checkers.Globals;
import com.example.checkers.MainActivity;
import com.example.checkers.R;
import com.example.checkers.requests.user.Authorization;
import com.example.checkers.requests.user.DeletingFriend;
import com.example.checkers.requests.user.FriendsAdapter;
import com.example.checkers.requests.user.GettingFriends;
import com.example.checkers.requests.user.InRankedMatch;
import com.example.checkers.requests.user.IsMatch;
import com.example.checkers.requests.user.IsNotRankedMatch;
import com.example.checkers.requests.user.IsRankedMatch;
import com.example.checkers.requests.user.NotifsAdapter;
import com.example.checkers.requests.user.OutRankedMatch;
import com.example.checkers.requests.user.Score;

public class MainMenu extends AppCompatActivity {

    Boolean flagBell = false;
    Boolean flagRanked = false;
    Boolean flagBot = false;
    Boolean flagSearchBot = false;
    Boolean flagSearchRanked = false;
    Boolean flagFriend = false;
    Boolean flagInvite = false;
    Boolean flagPlayTour = false;
    Boolean flagCreateTour = false;
    String[] countries = { "Русские шашки",  "Английские шашк", "Турецкие шашки"};
    String rulesId = "1";

    public void go(){
        int a = 1+1;
    }


    private void asyncIsInRankedMatch(String current_session) {

        AsyncTask.execute(() -> {
            try {
                IsRankedMatch.check(IsRankedMatch.stringIsRankedMatch(current_session));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    private void asyncIsNotInMatch(String current_session) {

        AsyncTask.execute(() -> {
            try {
                IsNotRankedMatch.check(IsNotRankedMatch.stringIsNotMatch(current_session));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    private void asyncIsInMatch(String current_session) {

        AsyncTask.execute(() -> {
            try {
                IsMatch.check(IsMatch.stringIsMatch(current_session));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    private void asyncInRanked(String current_session, String rules_id) {

        AsyncTask.execute(() -> {
            try {
                InRankedMatch.starting(InRankedMatch.stringRanked(current_session, rules_id));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
    private void asyncOutRanked(String current_session) {

        AsyncTask.execute(() -> {
            try {
                OutRankedMatch.stopping(OutRankedMatch.stringOutRanked(current_session));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        ImageButton bellBtn = (ImageButton) findViewById(R.id.bell);
        Button playRankedBtn = (Button) findViewById(R.id.playRankedBtn);
        Button playTourBtn = (Button) findViewById(R.id.playTourBtn);
        Button createTourBtn = (Button) findViewById(R.id.createTourBtn);
        Button playBotBtn = (Button) findViewById(R.id.playBotBtn);
        Button startSearchBot = (Button) findViewById(R.id.startSearchBot);
        Button startSearchRanked = (Button) findViewById(R.id.startSearch);
        //ImageButton infoBtn = (ImageButton)  findViewById(R.id.infoBtn);
        //Button inviteBtn = (Button) findViewById(R.id.inviteBtn);
        Button addFriendBtn = (Button) findViewById(R.id.addFriendBtn);
        Button nickname = (Button) findViewById(R.id.nick);
        Button score = (Button) findViewById(R.id.score);

        ScrollView mainMenuList = (ScrollView) findViewById(R.id.main_menu_list);
        LinearLayout rankedMenu = (LinearLayout) findViewById(R.id.rankedMenu);
        LinearLayout botMenu = (LinearLayout) findViewById(R.id.botMenu);
        //LinearLayout friendMenu = (LinearLayout) findViewById(R.id.friendMenu);
        //LinearLayout friend = (LinearLayout) findViewById(R.id.listfriend);
        LinearLayout friendView = (LinearLayout) View.inflate(this, R.layout.friend_element, null);
        ImageView searchIcon = (ImageView) findViewById(R.id.searchIcon);
        ImageView searchIcon2 = (ImageView) findViewById(R.id.searchIcon2);
        //ImageView searchIcon3 = (ImageView) findViewById(R.id.searchIcon3);

        nickname.setText(Globals.getNick());
        score.setText(Globals.getScore());
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.list_of_friends);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        FriendsAdapter adapterFriends = new FriendsAdapter(this, Globals.getFriends());
        recyclerView.setAdapter(adapterFriends);

        RecyclerView recyclerView1 = findViewById(R.id.notifs_list);
        LinearLayoutManager layoutManager2 = new LinearLayoutManager(this);
        recyclerView1.setLayoutManager(layoutManager2);
        NotifsAdapter adapterNotifs = new NotifsAdapter(this, Globals.getNotifications());
        recyclerView1.setAdapter(adapterNotifs);


        addFriendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainMenu.this, AddFriend.class);
                startActivity(intent );
            }
        });

        startSearchRanked.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flagSearchRanked = !flagSearchRanked;
                if(flagSearchRanked){
                    searchIcon.setVisibility(View.VISIBLE);
                    startSearchRanked.setText(R.string.stop_search);
                    playTourBtn.setBackgroundResource(R.drawable.other_btn_default);
                    createTourBtn.setBackgroundResource(R.drawable.other_btn_default);
                    asyncInRanked(Globals.getCurrentSession(), rulesId);
                }
                else{
                    searchIcon.setVisibility(View.GONE);
                    startSearchRanked.setText(R.string.start_search);
                    asyncOutRanked(Globals.getCurrentSession());
                }
            }
        });

        startSearchBot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flagSearchBot = !flagSearchBot;
                if(flagSearchBot){
                    searchIcon2.setVisibility(View.VISIBLE);
                    startSearchBot.setText(R.string.stop_search);
                }
                else{
                    searchIcon2.setVisibility(View.INVISIBLE);
                    startSearchBot.setText(R.string.start_search);
                }
            }
        });

        playTourBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flagPlayTour = !flagPlayTour;
                if(flagPlayTour){
                    playTourBtn.setBackgroundResource(R.drawable.other_btn_pressed);
                }
                else{
                    playTourBtn.setBackgroundResource(R.drawable.other_btn_default);
                }
            }
        });

        createTourBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flagCreateTour = !flagCreateTour;
                if(flagCreateTour){
                    createTourBtn.setBackgroundResource(R.drawable.other_btn_pressed);
                }
                else{
                    createTourBtn.setBackgroundResource((R.drawable.other_btn_default));
                }
            }
        });

        playBotBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flagBot = !flagBot;
                if(flagBot){
                    playBotBtn.setBackgroundResource(R.drawable.other_btn_pressed);
                    botMenu.setVisibility(View.VISIBLE);
                    flagRanked = false;
                    playRankedBtn.setBackgroundResource(R.drawable.other_btn_default);
                    playRankedBtn.setVisibility(View.GONE);
                    playTourBtn.setVisibility(View.GONE);
                    createTourBtn.setVisibility(View.GONE);
                    rankedMenu.setVisibility(View.GONE);
                    searchIcon.setVisibility(View.GONE);
                    startSearchRanked.setText(R.string.start_search);
                }
                else{
                    playBotBtn.setBackgroundResource(R.drawable.other_btn_default);
                    botMenu.setVisibility(View.GONE);
                    searchIcon2.setVisibility(View.INVISIBLE);
                    startSearchBot.setText(R.string.start_search);
                    flagSearchBot = false;
                    playRankedBtn.setVisibility(View.VISIBLE);
                    playTourBtn.setVisibility(View.VISIBLE);
                    createTourBtn.setVisibility(View.VISIBLE);
                }
            }
        });

        bellBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flagBell = !flagBell;
                if(flagBell){
                    mainMenuList.setVisibility(View.GONE);
                    recyclerView1.setVisibility(View.VISIBLE);
                    bellBtn.setBackgroundResource(R.drawable.notifications_btn_active);
                }
                else{
                    mainMenuList.setVisibility(View.VISIBLE);
                    recyclerView1.setVisibility(View.GONE);
                    bellBtn.setBackgroundResource(R.drawable.notifications_btn_default);
                }
            }
        });

        playRankedBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flagRanked = !flagRanked;
                if(flagRanked){
                    playRankedBtn.setBackgroundResource(R.drawable.other_btn_pressed);
                    rankedMenu.setVisibility(View.VISIBLE);
                }
                else{
                    playRankedBtn.setBackgroundResource(R.drawable.other_btn_default);
                    rankedMenu.setVisibility(View.GONE);
                }
            }
        });

        Spinner spinner = findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, countries);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        rulesId = "1";
                        break;
                    case 1:
                        rulesId = "2";
                        break;
                    case 2:
                        rulesId = "3";
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Spinner spinner2 = findViewById(R.id.spinner2);
        ArrayAdapter<String> adapter2 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, countries);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter);

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        rulesId = "1";
                        break;
                    case 1:
                        rulesId = "2";
                        break;
                    case 2:
                        rulesId = "3";
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //Spinner spinner3 = findViewById(R.id.spinner3);
        //ArrayAdapter<String> adapter3 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, countries);
        //adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //spinner3.setAdapter(adapter);

    }
    public void showSettingsMenu(View view) {
        PopupMenu stMenu = new PopupMenu(this, view);
        MenuInflater inf = stMenu.getMenuInflater();
        inf.inflate(R.menu.settings_menu, stMenu.getMenu());
        stMenu.show();
    }
}