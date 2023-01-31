package com.example.checkers.requests.user;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.checkers.Globals;
import com.example.checkers.MainActivity;
import com.example.checkers.activities.GameActivity;
import com.example.checkers.activities.MainMenu;
import com.example.checkers.json.Friends;
import com.example.checkers.json.Notifications;
import com.example.checkers.R;

import java.util.List;

public class NotifsAdapter extends RecyclerView.Adapter<NotifsAdapter.ViewHolder>{
    private LayoutInflater inflater;
    private List<Notifications> notifs;
    private static Context parent;
    private static String orgName;

    public NotifsAdapter(Context context, List<Notifications> notifs) {
        this.notifs = notifs;
        this.inflater = LayoutInflater.from(context);
        this.parent = context;
    }

    public Context getParent() {
        return parent;
    }

    @Override
    public NotifsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.invation_notification, parent, false);
        return new NotifsAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(NotifsAdapter.ViewHolder holder, int position) {
        Notifications notif = notifs.get(position);
        NotifsAdapter.orgName = notif.getActEl1();

        if(notif.getType().equals("1")){
            holder.buttons2.setVisibility(View.VISIBLE);
            holder.dot.setImageResource(R.drawable.dot_blue_icon);
            holder.notifText.setText("Предложение дружбы от: " + notif.getActEl1());
        }else if(notif.getType().equals("2")){
            holder.buttons.setVisibility(View.VISIBLE);
            holder.dot.setImageResource(R.drawable.dot_blue_icon);
            holder.notifText.setText("Приглашение сыграть с: " + notif.getActEl1());
        }else if(notif.getType().equals("4")){
            holder.dot.setImageResource(R.drawable.dot_green_icon);
            holder.notifText.setText("Победа против " + notif.getActEl1() + ": +" + notif.getActEl2() + " очков");
        }else if (notif.getType().equals("5")){
            holder.dot.setImageResource(R.drawable.dot_red_icon);
            holder.notifText.setText("Поражение против " + notif.getActEl1() + ": -" + notif.getActEl2() + " очков");
        }else{
            holder.dot.setImageResource(R.drawable.dot_red_icon);
            holder.notifText.setText(notif.getActEl1() + " отклонил приглашение");
        }


    }

    @Override
    public int getItemCount() {
        return notifs.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        final ImageView dot;
        final TextView notifText;
        final LinearLayout buttons;
        final LinearLayout buttons2;
        final ImageButton acceptButton;
        final ImageButton rejectButton;
        final ImageButton acceptButton2;
        final ImageButton rejectButton2;

        private void asyncDeleting(String current_session, String f_id) {

            AsyncTask.execute(() -> {
                try {
                    DeletingFriend.deleting(DeletingFriend.stringDeleteFriend(current_session, f_id));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }

        private void asyncAdding(String current_session, String f_id) {

            AsyncTask.execute(() -> {
                try {
                    AddingFriend.adding(AddingFriend.stringAddFriend(current_session, f_id));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }

        private void asyncRejectMatch(String current_session, String org_nick) {
            AsyncTask.execute(() -> {
                try {
                    RejectingMatch.rejecting(RejectingMatch.stringRejectMatch(current_session, org_nick));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }

        private void asyncAcceptMatch(String current_session, String org_nick) {
            AsyncTask.execute(() -> {
                try {
                    AcceptingMatch.accepting(AcceptingMatch.stringAcceptMatch(current_session, org_nick));

                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }

        ViewHolder(View view) {
            super(view);
            dot = view.findViewById(R.id.dot);
            notifText = view.findViewById(R.id.notif_text);
            buttons = view.findViewById(R.id.buttons);
            acceptButton = view.findViewById(R.id.accept_btn);
            rejectButton = view.findViewById(R.id.rejekt_btn);
            buttons2 = view.findViewById(R.id.buttons2);
            acceptButton2 = view.findViewById(R.id.accept_btn2);
            rejectButton2 = view.findViewById(R.id.rejekt_btn2);

            acceptButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    asyncAcceptMatch(Globals.getCurrentSession(), orgName);
                    Intent intent = new Intent(parent, GameActivity.class);
                    parent.startActivity(intent);
                }
            });

            rejectButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    asyncRejectMatch(Globals.getCurrentSession(), orgName);
                }
            });


        }

    }

}
