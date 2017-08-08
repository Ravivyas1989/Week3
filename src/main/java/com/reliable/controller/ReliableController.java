package com.reliable.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.xml.ws.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.reliable.model.Customer;
import com.reliable.repository.CustomerRepo;

@RestController
public class ReliableController extends HttpServlet {

	@Autowired
	CustomerRepo rp;

	@RequestMapping(method = RequestMethod.GET, value = "/findall")
	@ResponseBody
	public ModelAndView findall() {
		List<Customer> list = (List<Customer>) rp.findAll();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("display");
		mv.addObject("list", list);
		for (Customer element : list) {
			System.out.println("Element usernane: " + element.getUserName());
			System.out.println("Element password: " + element.getUserPassword());
		}
		mv.addObject("list", list);
		return mv;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/write")
	@ResponseBody
	public ModelAndView write(@RequestParam("username") String username, @RequestParam("password") String password) {
		System.out.println("called write");
		Customer customer = new Customer(username, password);
		System.out.println("saving username" + customer.getUserName());
		System.out.println("saving password" + customer.getUserPassword());
		rp.save(customer);
		/*
		 * ModelAndView mv = new ModelAndView("home"); mv.addObject("home");
		 */
		return new ModelAndView("home");
		// return "redirect:finalPage";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/display")
	@ResponseBody
	public List<Customer> display() {
		return (List<Customer>) rp.findAll();
	}

	@RequestMapping("/")
	public ModelAndView home() {
		System.out.println("display home");
		ModelAndView mv = new ModelAndView("home");
		return mv;
	}

	@RequestMapping("/home")
	public ModelAndView homes() {
		System.out.println("display home");
		ModelAndView mv = new ModelAndView("home");
		return mv;
	}

	@RequestMapping("/delete/home")
	public RedirectView dhome() {
		System.out.println("display home delete/home method");
		// ModelAndView mv = new ModelAndView("home");
		return new RedirectView("/findall");
	}

	@RequestMapping(method = RequestMethod.GET, value = "/register")
	@ResponseBody
	public ModelAndView register(String username, String password) {
		System.out.println("display registration");
		ModelAndView mv = new ModelAndView("register");
		return mv;
	}

	/*
	 * HttpResponse response;
	 * 
	 * @RequestMapping("/delete/.") public ModelAndView homeredirect() {
	 * System.out.println("redirecting to home"); ModelAndView mv = new
	 * ModelAndView("home"); return mv; }
	 */

	@RequestMapping(method = RequestMethod.POST, value = "/delete/{id}")
	public ModelAndView deleteCourse(@PathVariable int id) {
		System.out.println("deleting" + id);
		rp.delete(id);
		ModelAndView mv = new ModelAndView("redirect:home");
		return new ModelAndView("redirect:home");
	}

	@RequestMapping(method = RequestMethod.GET, value = "/login")
	@ResponseBody
	public ModelAndView login() {
		System.out.println("display registration");
		ModelAndView mv = new ModelAndView("login");
		return mv;
	}

}
