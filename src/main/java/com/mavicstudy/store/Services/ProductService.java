package com.mavicstudy.store.Services;

import com.mavicstudy.store.Repositories.CategoryRepository;
import com.mavicstudy.store.Repositories.ProductRepository;
import com.mavicstudy.store.Repositories.Specifications.ProductSpec;
import com.mavicstudy.store.entities.Category;
import com.mavicstudy.store.entities.Product;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.jpa.domain.PredicateSpecification;
import org.springframework.data.jpa.domain.Specification;
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
        product.setName("Airmax");
        var matcher = ExampleMatcher.matching()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        var example = Example.of(product,matcher);
        var products = productRepository.findAll(example);
        products.forEach(System.out::println);
    }

    public void fetchProductsByCriteria(){
       var products = productRepository.findProductsByCriteria(null,BigDecimal.valueOf(1),BigDecimal.valueOf(500));
       products.forEach(System.out::println);
    }
    @Transactional
    public void fetchProductsByPrice(BigDecimal priceMin, BigDecimal priceMax){
        var products = productRepository.findByPriceBetweenOrderByName(priceMin,priceMax);
        products.forEach(System.out::println);
    }

    public void fetchProductsBySpecifications(String name , BigDecimal priceMin, BigDecimal priceMax){
        Specification<Product> spec = Specification.where();
        if(name != null){
            spec = spec.and(ProductSpec.hasName(name));
        }
        if(priceMin != null){
            spec = spec.and(ProductSpec.hasPriceGreaterThanOrEqualTo(priceMin));
        }
        if(priceMax != null){
            spec = spec.and(ProductSpec.hasPriceLessThanOrEqualTo(priceMax));
        }
        productRepository.findAll(spec).forEach(System.out::println);
    }
}
