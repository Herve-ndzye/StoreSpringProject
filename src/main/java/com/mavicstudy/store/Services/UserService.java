package com.mavicstudy.store.Services;

import com.mavicstudy.store.Repositories.AddressRepository;
import com.mavicstudy.store.Repositories.ProductRepository;
import com.mavicstudy.store.Repositories.ProfileRepository;
import com.mavicstudy.store.Repositories.UserRepository;
import com.mavicstudy.store.entities.Address;
import com.mavicstudy.store.entities.Product;
import com.mavicstudy.store.entities.User;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    UserRepository userRepository ;
    ProfileRepository profileRepository ;
    AddressRepository addressRepository ;
    ProductRepository productRepository ;

    public UserService(UserRepository userRepository,
                       ProfileRepository profileRepository,
                       AddressRepository addressRepository,
                       ProductRepository productRepository
    ) {
        this.userRepository = userRepository;
        this.profileRepository = profileRepository;
        this.addressRepository = addressRepository;
        this.productRepository = productRepository;
    }
    @Transactional
    public void showRelatedEntities(){
        var repository = addressRepository.findById(1L).orElseThrow();
        System.out.println(repository.getCity());
    }
    public void persistRelated(){
        var user = User.builder()
                .name("Nicaise")
                .email("Nicaise@gmail.com")
                .password("Nicaise@123")
                .build();
        var address = Address.builder()
                .zip("002800")
                .state("cyprus")
                .city("Cyprus")
                .street("cy 123")
                .build();
        user.addAddress(address);
        userRepository.save(user);
    }
    public void deleteProduct(){
        productRepository.deleteById(2L);
    }
    public void assignAllProducts(){
        var user = userRepository.findById(2L).orElseThrow();
        var products = productRepository.findAll();
        user.setProducts((List<Product>) products);
        userRepository.save(user);
    }
    public void fetchUser(){
        var user = userRepository.findByEmail("Nicaise@gmail.com").orElseThrow();
        System.out.println(user);
    }
}
