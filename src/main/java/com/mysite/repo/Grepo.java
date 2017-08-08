package com.mysite.repo;

import org.springframework.data.repository.CrudRepository;

import com.mysite.model.Greeting;

public interface Grepo extends CrudRepository<Greeting, Long>{

}



