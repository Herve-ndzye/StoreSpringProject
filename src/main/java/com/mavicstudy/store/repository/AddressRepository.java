package com.mavicstudy.store.repository;

import com.mavicstudy.store.entities.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Long> {
}