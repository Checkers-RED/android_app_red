package com.example.checkers.json;

import java.util.ArrayList;
import java.util.List;

public class BoxOfNotifications {
    List<Notifications> notifications;

    public BoxOfNotifications(){
        notifications = new ArrayList<Notifications>();
    }

    public List<Notifications> getNotifications() {
        return notifications;
    }

}
