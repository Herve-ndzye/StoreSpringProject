package com.mavicstudy.store.Repositories;

import com.mavicstudy.store.entities.Product;

import java.math.BigDecimal;
import java.util.List;

public interface ProductCriteriaRepository {
    List<Product> findProductsByCriteria(String name,BigDecimal min, BigDecimal max);
}
