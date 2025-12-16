package com.mavicstudy.store.Services;

import com.mavicstudy.store.Repositories.CategoryRepository;
import com.mavicstudy.store.Repositories.ProductRepository;
import com.mavicstudy.store.entities.Category;
import com.mavicstudy.store.entities.Product;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    public void createProduct(){
        var product = Product.builder()
                .name("Airmax 270")
                .price(BigDecimal.valueOf(2000))
                .description("Airmax 270 the ultimate shoe!")
                .build();
        var category = categoryRepository.findById((byte) 1).orElseThrow();
        product.setCategory(category);
        productRepository.save(product);
    }
}
