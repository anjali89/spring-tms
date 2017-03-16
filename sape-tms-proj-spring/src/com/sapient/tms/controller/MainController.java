package com.sapient.tms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sapient.tms.model.bean.Employee;
import com.sapient.tms.model.bl.CentralLogic;

@Controller
@RequestMapping("/")

public class MainController {
	

	@RequestMapping(method = RequestMethod.GET)
	public String myHome()
	{
		return "HomeView";		
		
	}
	
	@RequestMapping(value="/signIn")
	public ModelAndView signInForm(@ModelAttribute ("employee")Employee employee)
	{
		ModelAndView mv=new ModelAndView();
		mv.setViewName("accounts/SignInForm");
		mv.addObject("employee", new Employee());
		return mv;
		
	}
	
	
	@RequestMapping(value="/signUp")
	public ModelAndView signUpForm(@ModelAttribute ("employee")Employee employee)
	{
		ModelAndView mv=new ModelAndView();
		mv.setViewName("accounts/SignUpForm");
		mv.addObject("employee", new Employee());
		return mv;
		
	}
	
	
	
	
	

}
