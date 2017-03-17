package com.sapient.tms.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sapient.tms.helper.EmployeeAuthenticator;
import com.sapient.tms.model.bean.Employee;
import com.sapient.tms.model.bean.Request;
import com.sapient.tms.model.bean.Ride;
import com.sapient.tms.model.bl.CentralLogic;

@Controller
public class SignInController {


	private CentralLogic centralLogic;
	
	boolean isValidEmployee;


			@RequestMapping("/SignInCheck")
			public ModelAndView signInCheck(@ModelAttribute("employee") Employee employee) throws IOException
			{
				ModelAndView mv = new ModelAndView("accounts/SignInForm");
				System.out.println(employee);
				
				try {
					// Get parameters from request object
					//ModelAndView mv = new ModelAndView("accounts/SignIn");
					// Attempt to authenticate user details
					EmployeeAuthenticator authenticator = new EmployeeAuthenticator();
					System.out.println(employee.getId());
					Map.Entry<Employee, Boolean> authenticationResult = authenticator.authenticate(employee.getId(), employee.getPassword());
					isValidEmployee = authenticationResult.getValue();
					// If authentication fails
					if (!isValidEmployee) {
						System.out.println(employee);
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
							if(!employee.isAdmin()) {
								return (new ModelAndView("EmployeeHomeView"));
							}
							else {
								return (new ModelAndView("AdminHomeView"));
							}
						}
					}
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return mv;
			}
			
		}


