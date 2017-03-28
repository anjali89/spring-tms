package com.sapient.tms.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.HttpSessionRequiredException;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.sapient.tms.helper.EmployeeAuthenticator;
import com.sapient.tms.model.bean.Employee;
import com.sapient.tms.model.bean.Request;
import com.sapient.tms.model.bean.Ride;
import com.sapient.tms.model.bl.CentralLogic;


@Controller
@SessionAttributes("userId")

public class SignInController extends HttpServlet{


	private CentralLogic centralLogic=new CentralLogic();
	
	
	boolean isValidEmployee;


			@RequestMapping("/signInCheck")
			public ModelAndView signInCheck(@ModelAttribute("employee") Employee employee, ModelMap model) throws IOException
			{
				ModelAndView mv = new ModelAndView("accounts/SignInForm");
				try {
					// Get parameters from request object
					System.out.println(employee.getId());
					// Attempt to authenticate user details
					EmployeeAuthenticator authenticator = new EmployeeAuthenticator();
					Map.Entry<Employee, Boolean> authenticationResult = authenticator.authenticate(employee.getId(),employee.getPassword());
					isValidEmployee = authenticationResult.getValue();
					// If authentication fails
					if (!isValidEmployee) {
						mv.addObject("status", "Invalid UserID Or Password");
						return mv;
					}
					// If authentication is successful
					else {
						Employee employeeKey = authenticationResult.getKey();
						employee = employeeKey;
						Request tempRequest = centralLogic.searchRequestByEmployeeId(employee.getId());
						if(tempRequest != null) {
							//Request has been rejected
							if(tempRequest.isRejected()) {
								Ride ride = tempRequest.getEmployee().getRide();
								ride.setSeatsAllocated(ride.getSeatsAllocated() - 1);
								centralLogic.updateRide(ride.getVehicle().getId(), ride);
								mv.addObject("status", "Your request has been rejected");
								
								centralLogic.deleteRequestByEmployeeId(tempRequest.getEmployee().getId());
								centralLogic.deleteEmployee(tempRequest.getEmployee().getId());
								return mv;
							}
							//Request is still pending
							else if(tempRequest.isPending()) {
								mv.addObject("status", "Your request is still pending");
								return mv;
							}
							//Request has been accepted
							else {
								mv.addObject("status", "Your request has been accepted");
								centralLogic.deleteRequestByEmployeeId(tempRequest.getEmployee().getId());
								
								mv.addObject("ses", employee);
								if(!employee.isAdmin()) {
									return (new ModelAndView("EmployeeHomeView"));
								}
								else {
									return (new ModelAndView("AdminHomeView"));
								}
							}
						}
						else {
							
							mv.addObject("ses", employee);
							model.addAttribute("userId", employee.getId());
							if(!employee.isAdmin()) {
								;
								return (new ModelAndView("EmployeeHomeView"));
							}
							else {
								return (new ModelAndView("AdminHomeView"));
							}
						}
					}
				} catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				}
				return mv;
			}
			
			
			@RequestMapping(value="rideInfo")
			public ModelAndView viewRideInfo(@ModelAttribute("employee") Employee employee, HttpSession session) throws IOException
			{
				ModelAndView mv = new ModelAndView("db/");
				
				return mv;
				
			}
			
			
		}


