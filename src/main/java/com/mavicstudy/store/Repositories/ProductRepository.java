package com.mavicstudy.store.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<com.mavicstudy.store.entities.Product, Long> {
}
