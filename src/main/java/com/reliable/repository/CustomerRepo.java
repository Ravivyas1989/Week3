package com.reliable.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.reliable.model.*;

@Repository
public interface CustomerRepo extends MongoRepository<Customer, Integer> {

}
