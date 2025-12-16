package com.mavicstudy.store;

import com.mavicstudy.store.Services.ProductService;
import com.mavicstudy.store.Services.UserService;
import com.mavicstudy.store.entities.Category;
import com.mavicstudy.store.entities.Product;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.math.BigDecimal;

@SpringBootApplication
public class StoreApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(StoreApplication.class, args);
        var userService = context.getBean(UserService.class);
        userService.deleteProduct();
    }

}
