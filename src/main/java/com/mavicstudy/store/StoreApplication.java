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
//        var orderService = context.getBean(OrderService.class);
//        orderService.placeOrder();
//        var orderService  = context.getBean(OrderService.class);
//        orderService.placeOrder();
          var userService = context.getBean(UserService.class);
          userService.registerUser(new User(203,"hervendzye@gmail.com","1234567","Herve Ndizeye"));
        var userService2 = context.getBean(UserService.class);
          userService2.registerUser(new User(201,"hervendizeye0@gmail.com","124567","Herve Mavic Ndizeye"));
    }

}
