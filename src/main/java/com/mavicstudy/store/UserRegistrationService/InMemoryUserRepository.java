package com.mavicstudy.store.UserRegistrationService;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


@Service
public class InMemoryUserRepository implements UserRepository{
    @Override
    public void save(User user) {
        data.put(user.getEmail(),user);
    }
    Map<String,User> data = new HashMap<>();
}
