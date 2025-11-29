package com.mavicstudy.store;

import com.mavicstudy.store.PaymentService.HeavyResource;
import com.mavicstudy.store.PaymentService.OrderService;
import com.mavicstudy.store.UserRegistrationService.User;
import com.mavicstudy.store.UserRegistrationService.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class StoreApplication {

    public static void main(String[] args) {
       ApplicationContext context = SpringApplication.run(StoreApplication.class, args);
//
    }

}
