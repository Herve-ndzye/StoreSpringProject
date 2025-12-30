package com.mavicstudy.store.Services;

import com.mavicstudy.store.Repositories.CategoryRepository;
import com.mavicstudy.store.Repositories.ProductRepository;
import com.mavicstudy.store.Repositories.Specifications.ProductSpec;
import com.mavicstudy.store.entities.Category;
import com.mavicstudy.store.entities.Product;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.PredicateSpecification;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

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

    public void fetchProductsBySpecifications(String name, BigDecimal priceMin, BigDecimal priceMax) {

        Specification<Product> spec = null;

        if (name != null && !name.isBlank()) {
            spec = ProductSpec.hasName(name);
        }

        if (priceMin != null) {
            spec = (spec == null)
                    ? ProductSpec.hasPriceGreaterThanOrEqualTo(priceMin)
                    : spec.and(ProductSpec.hasPriceGreaterThanOrEqualTo(priceMin));
        }

        if (priceMax != null) {
            spec = (spec == null)
                    ? ProductSpec.hasPriceLessThanOrEqualTo(priceMax)
                    : spec.and(ProductSpec.hasPriceLessThanOrEqualTo(priceMax));
        }

        System.out.println("Searching with - Name: " + name + ", Min: " + priceMin + ", Max: " + priceMax);

        List<Product> products = (spec == null)
                ? productRepository.findAll()
                : productRepository.findAll(spec);

        System.out.println("Found " + products.size() + " products");
        products.forEach(System.out::println);
    }

    public void fetchSortedProducts(){
        var sort = Sort.by("name").and(
                Sort.by("price").descending()
        );

        productRepository.findAll(sort).forEach(System.out::println);
    }

    public void fetchPaginatedProducts(int page, int pageSize){
        PageRequest pageRequest = PageRequest.of(page, pageSize);
        var pages = productRepository.findAll(pageRequest);
        var products = pages.getContent();
        var totalPages =  pages.getTotalPages();
        var totalElements = pages.getTotalElements();
        System.out.println("Total elements: " + totalElements);
        System.out.println("Total pages: " + totalPages);

    }

}
