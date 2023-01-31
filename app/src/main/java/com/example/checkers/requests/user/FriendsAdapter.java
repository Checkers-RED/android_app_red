package com.example.checkers.requests.user;

import android.content.Context;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.checkers.Globals;
import com.example.checkers.MainActivity;
import com.example.checkers.R;

import androidx.recyclerview.widget.RecyclerView;

import com.example.checkers.json.Friends;

import java.util.List;

public class FriendsAdapter extends RecyclerView.Adapter<FriendsAdapter.ViewHolder> {
    private LayoutInflater inflater;
    private  List<Friends> friends;
    private static Context parent;
    private static Boolean flag = true;
    private static String rulesId = "1";




    public FriendsAdapter(Context context, List<Friends> friends){
        this.friends = friends;
        this.inflater = LayoutInflater.from(context);
        this.parent = context;
    }
    @Override
    public FriendsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.friend_element, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FriendsAdapter.ViewHolder holder, int position) {
        Friends friend = friends.get(position);
        holder.name.setText(friend.getNick());;

    }

    @Override
    public int getItemCount() {
        return friends.size();
    }



    public static class ViewHolder extends RecyclerView.ViewHolder{
        final TextView name;
        final TextView time;
        final LinearLayout button;
        final LinearLayout inviteMenu;
        final Button inviteBtn;
        final ImageButton deleteBtn;
        final ImageButton minusBtn;
        final ImageButton plusBtn;
        final Spinner spinner;


        private void asyncDeleting(String current_session, String f_id) {

            AsyncTask.execute(() -> {
                try {
                    DeletingFriend.deleting(DeletingFriend.stringDeleteFriend(current_session, f_id));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }

        private void asyncInviting(String current_session, String f_id, String move_time, String rules_id) {

            AsyncTask.execute(() -> {
                try {
                    InvitingFriend.inviting(InvitingFriend.stringInviteFriend(current_session, f_id, move_time, rules_id));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }

        ViewHolder(View view){
            super(view);
            Boolean flag = true;
            String rulesId;
            name = (TextView) view.findViewById(R.id.nick);
            time = view.findViewById(R.id.time);
            button = (LinearLayout) view.findViewById(R.id.button);
            inviteMenu = (LinearLayout) view.findViewById(R.id.invite_menu);
            inviteBtn = view.findViewById(R.id.inviteBtn);
            deleteBtn = view.findViewById(R.id.delete_btn);
            minusBtn = view.findViewById(R.id.minus_btn);
            plusBtn = view.findViewById(R.id.plus_btn);
            spinner = view.findViewById(R.id.spinner);

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(flag){
                        inviteMenu.setVisibility(View.VISIBLE);
                        FriendsAdapter.flag = false;
                    }
                    else{
                        inviteMenu.setVisibility(View.GONE);
                        FriendsAdapter.flag = true;
                    }
                }
            });

            deleteBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int itemCount = getAdapterPosition();
                    String uId = Globals.getFriends().get(itemCount).getUid();
                    asyncDeleting(Globals.getCurrentSession(), uId);

                }
            });

            minusBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int timeInt = Integer.parseInt(time.getText().toString());
                    if(timeInt > 20){
                        timeInt -= 5;
                    }
                    time.setText(String.valueOf(timeInt));
                }
            });

            plusBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int timeInt = Integer.parseInt(time.getText().toString());
                    if(timeInt < 60){
                        timeInt += 5;
                    }
                    time.setText(String.valueOf(timeInt));
                }
            });

            String[] countries = { "Русские шашки",  "Английские шашк", "Турецкие шашки"};
            ArrayAdapter<String> adapter = new ArrayAdapter(parent, android.R.layout.simple_spinner_item, countries);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);

            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    switch (position){
                        case 0:
                            FriendsAdapter.rulesId = "1";
                            break;
                        case 1:
                            FriendsAdapter.rulesId = "2";
                            break;
                        case 2:
                            FriendsAdapter.rulesId = "3";
                            break;
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });

            inviteBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int itemCount = getAdapterPosition();
                    String uId = Globals.getFriends().get(itemCount).getUid();
                    asyncInviting(Globals.getCurrentSession(), uId, time.getText().toString(), FriendsAdapter.rulesId);
                }
            });

        }
    }

}
