package com.mavicstudy.store.Repositories;

import com.mavicstudy.store.DTO.ProductSummary;
import com.mavicstudy.store.DTO.ProductSummaryDTO;
import com.mavicstudy.store.entities.Category;
import com.mavicstudy.store.entities.Product;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<com.mavicstudy.store.entities.Product, Long> {
    List<Product> findByPriceBetweenOrderByName(@Param("min") BigDecimal min, @Param("max") BigDecimal max);
    @Modifying
    @Query("update Product p set p.price = :price where p.category.id = :categoryId")
    void updatePrice(@Param("price") BigDecimal price,@Param("categoryId") Byte categoryId);
    @Query("select p from Product p where p.category = :category")
    List<ProductSummaryDTO> findByCategory(@Param("category") Category category);
}