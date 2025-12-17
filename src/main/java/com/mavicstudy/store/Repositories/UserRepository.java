package com.mavicstudy.store.Repositories;

import com.mavicstudy.store.entities.User;
import jakarta.persistence.Entity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {
    @EntityGraph(attributePaths = "tags")
    Optional<User> findByEmail(String email);
}
