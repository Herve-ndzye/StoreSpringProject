package com.mavicstudy.store.NotificationService;

import org.springframework.stereotype.Component;


public class EmailNotificationService implements NotificationService{

    @Override
    public void send(String message) {
        System.out.println("Sending Email : Hello there, " + message);
    }
}
