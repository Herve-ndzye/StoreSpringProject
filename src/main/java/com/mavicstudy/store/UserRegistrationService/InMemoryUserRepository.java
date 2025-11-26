package com.mavicstudy.store.UserRegistrationService;

import java.util.HashMap;
import java.util.Map;

public class InMemoryUserRepository implements UserRepository{
    @Override
    public void save(User user) {
        data.put(user.getEmail(),user);
    }
    Map<String,User> data = new HashMap<>();
}
