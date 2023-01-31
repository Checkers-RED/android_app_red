package com.example.checkers.json;

import java.util.ArrayList;
import java.util.List;

public class BoxOfFriendsResponse {
    List<Friends> friends;

    public BoxOfFriendsResponse(){
        friends = new ArrayList<Friends>();
    }

    public List<Friends> getFriends() {
        return friends;
    }
}
