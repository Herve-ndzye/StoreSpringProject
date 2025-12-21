package com.mavicstudy.store.Repositories;

import com.mavicstudy.store.DTO.UserSummary;
import com.mavicstudy.store.entities.User;
import jakarta.persistence.Entity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {
    @EntityGraph(attributePaths = "tags")
    Optional<User> findByEmail(String email);

    @EntityGraph(attributePaths = "addresses")
    @Query("select u from User u")
    List<User> findAllWithAddresses();

    @Query("select u.id as id , u.email as email from User u where u.profile.loyaltyPoint > ?1 order by u.email")
    @EntityGraph(attributePaths = "profile")
    List<UserSummary> findLoyalUsers(int  loyaltyPoint);
}
