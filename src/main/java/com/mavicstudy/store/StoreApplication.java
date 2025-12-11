package com.mavicstudy.store;

import com.mavicstudy.store.entities.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;

@SpringBootApplication
public class StoreApplication {

    public static void main(String[] args) {
        Products iphone = new Products(11L,"Iphone 17 Pro", BigDecimal.valueOf(1500.00));
        Category telephone = new Category(1,"telephone");
        telephone.getProducts().add(iphone);
        System.out.println(telephone);

    }

}
