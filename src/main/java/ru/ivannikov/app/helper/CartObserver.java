package ru.ivannikov.app.helper;

import java.util.ArrayList;
import java.util.List;

public class CartObserver {

    private List<Notification> notificationList;

    public CartObserver() {

    }

    public CartObserver(List<Notification> notificationList) {
        this.notificationList = notificationList;
    }

    public void addObserver(Notification notification) {
        if (notificationList == null) {
            this.notificationList = new ArrayList<>();
        }
        this.notificationList.add(notification);
    }

    public void update(String message) {
        for (Notification notification : notificationList) {
            notification.notify(message);
        }
    }
}
