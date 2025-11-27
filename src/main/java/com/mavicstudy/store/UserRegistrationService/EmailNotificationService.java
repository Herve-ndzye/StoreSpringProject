package com.mavicstudy.store.UserRegistrationService;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class EmailNotificationService implements NotificationService{
    @Override
    public void send(String message, String recipientEmail) {
        System.out.println(message + " sent to " + recipientEmail + " from "+host+":"+port);
    }
    @Value("${server.host}")
    private String host;
    @Value("${server.port}")
    private int port;
}
