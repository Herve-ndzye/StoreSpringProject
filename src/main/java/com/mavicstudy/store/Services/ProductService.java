package com.mavicstudy.store.Services;

import com.mavicstudy.store.Repositories.CategoryRepository;
import com.mavicstudy.store.Repositories.ProductRepository;
import com.mavicstudy.store.entities.Category;
import com.mavicstudy.store.entities.Product;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Example;
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
//    public void createCategory(){
//        Category category = new Category("Shoes");
//        categoryRepository.save(category);
//    }

    @Transactional
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
    @Transactional
    public void updateProductsPrice(){
        productRepository.updatePrice(BigDecimal.valueOf(200),  (byte)1);
    }

    public void fetchProducts(){
        var product = new Product();
        product.setName("Airmax 270");
        var example = Example.of(product);
        var products = productRepository.findAll(example);
        products.forEach(System.out::println);
    }
    @Transactional
    public void fetchProductsByPrice(BigDecimal priceMin, BigDecimal priceMax){
        var products = productRepository.findByPriceBetweenOrderByName(priceMin,priceMax);
        products.forEach(System.out::println);
    }
}
