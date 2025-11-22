package com.mavicstudy.store.NotificationService;

import org.springframework.stereotype.Component;

@Component
public class NotificationManager {
    private NotificationService notificationService;

    public NotificationManager(NotificationService notificationService){
        this.notificationService = notificationService;
    }
    public void sendNotification(String message){
        notificationService.send(message);
    }
}
