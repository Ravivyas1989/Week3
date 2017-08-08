package com.mysite.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysite.model.person;
import com.mysite.repo.prepo;

@Service
public class PersonService {
	@Autowired
	prepo pr;
	    
	

	public Iterable<person> getmymethod(){
		
	     
	     return pr.findAll();
	}
		
		public void putmymethod(person g){
			pr.save(g);
	 }

	 
	}