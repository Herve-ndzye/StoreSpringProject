package com.mavicstudy.store;

import com.mavicstudy.store.entities.User;
import com.mavicstudy.store.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class StoreApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(StoreApplication.class, args);

        var repository = context.getBean(UserRepository.class);
        var user = User.builder()
                .name("admin")
                .email("admin@gmail.com")
                .password("admin@123")
                .build();
        repository.save(user);
    }

}
