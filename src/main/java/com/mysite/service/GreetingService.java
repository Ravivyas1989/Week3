package com.mysite.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysite.model.Greeting;
import com.mysite.repo.Grepo;

@Service
public class GreetingService {
	@Autowired
	Grepo gp;
	
	

	public Iterable<Greeting> getmymethod(){
		
     
     return gp.findAll();


}
	
	
	
	public void putmymethod(Greeting g){
		gp.save(g);
 }

 
}
