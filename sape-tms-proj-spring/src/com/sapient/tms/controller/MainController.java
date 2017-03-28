package com.sapient.tms.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.sapient.tms.model.bean.Employee;
import com.sapient.tms.model.bl.CentralLogic;

@Controller
@RequestMapping("/")
@SessionAttributes("userId")

public class MainController {
	

	@RequestMapping(method = RequestMethod.GET)
	public String myHome()
	{
		return "HomeView";		
		
	}
	
	@RequestMapping(value="/signIn")
	public ModelAndView signInForm(@ModelAttribute ("employee")Employee employee)
	{
		ModelAndView mv=new ModelAndView("accounts/SignInForm","employee",new Employee());
		mv.setViewName("accounts/SignInForm");
		mv.addObject("employee", new Employee());
		return mv;
		
	}
	
	

	
	
	@RequestMapping(value = "/signUp")
	public ModelAndView mySignUp(@ModelAttribute("employee") Employee employee, Model model) throws ClassNotFoundException, IOException, SQLException {
		CentralLogic centralLogic = new CentralLogic();
		model.addAttribute("rides", centralLogic.displayAllAvailableRides());
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("accounts/SignUpForm");
		mv.addObject("employee", new Employee());
		return mv;
	}
	
	@RequestMapping(value="/goBack")
	public String goHome()
	{
		return "HomeView";		
		
	}
	
	
	 @RequestMapping("/signOut")
	      public String logout(HttpSession session) {
	        session.invalidate();
	        return "HomeView";
	      }

	
	
	
	
	

}
