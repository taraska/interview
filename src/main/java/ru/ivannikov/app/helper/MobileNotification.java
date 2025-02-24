package ru.ivannikov.app.helper;

public class MobileNotification implements Notification {

    @Override
    public void notify(String message) {
        System.out.println("Mobile: " + message);;
    }
}
