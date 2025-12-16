package com.mavicstudy.store.Repositories;

import com.mavicstudy.store.entities.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Byte> {
}
