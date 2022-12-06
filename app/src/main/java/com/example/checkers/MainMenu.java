package com.example.checkers;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainMenu extends AppCompatActivity {

    Boolean flagBell = false;
    Boolean flagRanked = false;
    Boolean flagBot = false;
    Boolean flagSearchBot = false;
    Boolean flagSearchRanked = false;
    Boolean flagFriend = false;
    Boolean flagInvite = false;
    String[] countries = { "Русские шашки", "Ублюдские шашки", "Мудацкие шашки", "Я ща твоей матери ебало разобью"};

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
        ImageButton infoBtn = (ImageButton)  findViewById(R.id.infoBtn);
        Button inviteBtn = (Button) findViewById(R.id.inviteBtn);

        ScrollView notifications = (ScrollView) findViewById(R.id.notifications);
        ScrollView mainMenuList = (ScrollView) findViewById(R.id.main_menu_list);
        LinearLayout rankedMenu = (LinearLayout) findViewById(R.id.rankedMenu);
        LinearLayout botMenu = (LinearLayout) findViewById(R.id.botMenu);
        LinearLayout friendMenu = (LinearLayout) findViewById(R.id.friendMenu);
        ImageView searchIcon = (ImageView) findViewById(R.id.searchIcon);
        ImageView searchIcon2 = (ImageView) findViewById(R.id.searchIcon2);
        ImageView searchIcon3 = (ImageView) findViewById(R.id.searchIcon3);

        inviteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inviteBtn.setVisibility(View.GONE);
                searchIcon3.setVisibility(View.VISIBLE);
            }
        });

        infoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flagFriend = !flagFriend;
                if(flagFriend){
                    friendMenu.setVisibility(View.VISIBLE);
                }
                else{
                    friendMenu.setVisibility(View.GONE);
                    searchIcon3.setVisibility(View.INVISIBLE);
                    inviteBtn.setVisibility(View.VISIBLE);
                }
            }
        });

        startSearchRanked.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flagSearchRanked = !flagSearchRanked;
                if(flagSearchRanked){
                    searchIcon.setVisibility(View.VISIBLE);
                    startSearchRanked.setText(R.string.stop_search);
                }
                else{
                    searchIcon.setVisibility(View.GONE);
                    startSearchRanked.setText(R.string.start_search);
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
                    notifications.setVisibility(View.VISIBLE);
                    bellBtn.setBackgroundResource(R.drawable.notifications_btn_active);
                }
                else{
                    mainMenuList.setVisibility(View.VISIBLE);
                    notifications.setVisibility(View.GONE);
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

        Spinner spinner2 = findViewById(R.id.spinner2);
        ArrayAdapter<String> adapter2 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, countries);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter);

        Spinner spinner3 = findViewById(R.id.spinner3);
        ArrayAdapter<String> adapter3 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, countries);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner3.setAdapter(adapter);

    }
    public void showSettingsMenu(View view) {
        PopupMenu stMenu = new PopupMenu(this, view);
        MenuInflater inf = stMenu.getMenuInflater();
        inf.inflate(R.menu.settings_menu, stMenu.getMenu());
        stMenu.show();
    }
}