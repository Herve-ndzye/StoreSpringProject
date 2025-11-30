package com.mavicstudy.store;

import com.mavicstudy.store.entities.Address;
import com.mavicstudy.store.entities.Profile;
import com.mavicstudy.store.entities.Tag;
import com.mavicstudy.store.entities.User;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StoreApplication {

    public static void main(String[] args) {
        User user = User.builder()
                .name("Herve")
                .email("herve@gmail.com")
                .password("123456")
                .build();
        var profile = Profile.builder()
                        .bio("Robotics Engineering")
                                .dateOfBirth("10/02/2009")
                                        .loyaltyPoint("50")
                                                .phoneNumber("0785858584")
                                                        .build();
        user.setProfile(profile);
        profile.setUser(user);
        System.out.println(user);

    }

}
