package com.spring.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WelcomeController {

	/*
	 * @RequestMapping("/welcome") public String sayWelcome() {
	 * 
	 * return "welcome";
	 * 
	 * }
	 */
	
	/*
	 * @RequestMapping("/welcome/{fname}/{lname}") public String
	 * sayWelcome(@PathVariable("fname") String fname,@PathVariable("lname") String
	 * lname) { System.out.println(fname+"-"+lname); return "welcome";
	 * 
	 * }
	 */
	
	@RequestMapping("/welcome/{fname}/{lname}")
	public ModelAndView sayWelcome(@PathVariable("fname") String fname,@PathVariable("lname") String lname) {
		System.out.println(fname+"-"+lname);
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.addObject("fname", fname);
		modelAndView.addObject("lname", lname);
		modelAndView.setViewName("welcome");
		return modelAndView;
		
	}
	@RequestMapping("/hi")
	public String sayHi() {
		return "hi";
	}
}
