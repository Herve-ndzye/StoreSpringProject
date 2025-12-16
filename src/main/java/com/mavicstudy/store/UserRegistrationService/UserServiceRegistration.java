package com.mavicstudy.store.UserRegistrationService;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("prototype")
public class UserServiceRegistration {
   public void registerUser(User user){
        registerUsers.save(user);
        service.send("How are you my friend?","hervendizeye0@gmail.com");
   }
    private UserRepository registerUsers;
    private NotificationService service;

    public UserServiceRegistration(NotificationService notifyService, UserRepository registerUsers){
        this.service = notifyService;
        this.registerUsers = registerUsers;
        System.out.println("User service created!");
    }
}
