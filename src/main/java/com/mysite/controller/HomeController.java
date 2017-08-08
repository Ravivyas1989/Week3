package com.mysite.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.mysite.model.Greeting;
import com.mysite.model.person;
import com.mysite.service.GreetingService;
import com.mysite.service.PersonService;




@Controller

public class HomeController {

	@Autowired
	PersonService p;

	public PersonService setperson(PersonService p) {
		this.p = p;
		return p;
	}
	
	
	@Autowired
	GreetingService g;

	public GreetingService setGreeting(GreetingService g) {
		this.g = g;
		return g;
	}

	@Value("${home.message}")
	private String message;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String api_fn0(Model model) {

		model.addAttribute("message", this.message);
		System.out.println("*********************home api*****************");
		return "hapi";
	}

//	@RequestMapping(value = "/api1")
//	public String api_fn1(Model model) throws Exception {
//		
//		
//		System.out.println("*******************api 1*******************");
//		return "api1";
//	}
	
	
    @GetMapping("/api1")
    public String greetingForm(Model model) {
        model.addAttribute("greeting", new Greeting());
        return "api1";
    }

    @PostMapping("/api1")
    public String greetingSubmit(  @ModelAttribute Greeting greeting ) {
    	g.putmymethod( greeting);
        return "apiR";
    }

	@RequestMapping(value = "/api2")
	public String api_fn2(Model model) {

		System.out.println("********************api 2******************");
		model.addAttribute("greetings", g.getmymethod());
		return "api2";
	}

	 @GetMapping("/apipr")
	    public String perForm(Model model) {
		 model.addAttribute("pr", new person());
	         return "apipr";
	    }

	    @PostMapping("/apipr")
	    public String perSubmit(@ModelAttribute person pr) {
	    	p.putmymethod(pr);
	        return "apiper";
	    }
	
	
	@RequestMapping("/api3")
	public String api_fn3(Model model) {
		System.out.println("********************api 3******************");

		model.addAttribute("persons", p.getmymethod());

		return "api3";
	}


}