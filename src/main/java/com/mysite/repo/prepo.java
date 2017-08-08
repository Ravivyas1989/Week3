package com.mysite.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mysite.model.person;
public interface prepo extends MongoRepository<person, String> {

//    public person findByFirstName(String firstName);
//    public List<person> findByLastName(String lastName);

}