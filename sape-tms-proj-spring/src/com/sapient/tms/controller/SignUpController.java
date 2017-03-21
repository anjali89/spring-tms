package com.sapient.tms.controller;

import java.io.IOException;
import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sapient.tms.helper.EmployeeData;
import com.sapient.tms.model.bean.Employee;
import com.sapient.tms.model.bean.Ride;
import com.sapient.tms.model.bl.CentralLogic;

@Controller
public class SignUpController {
	
	private CentralLogic centralLogic = new CentralLogic();
	private EmployeeData employeeData;


	@RequestMapping("/signUp1")
	public ModelAndView signUp1(@ModelAttribute("employee") Employee employee) throws IOException {
		ModelAndView mv = new ModelAndView("accounts/SignUpForm");
		
		try {
	//		employeeData.createEmployee(request);
		//	Employee employee1 = employeeData.getEmployee();
			boolean isSuccessful = centralLogic.createNewRequest(employee);
			if(!isSuccessful) {
				mv.addObject("status", "Sign Up failed");
				mv.setViewName("EmployeeHomeView");
			    return mv;
			}
			
			else {
				isSuccessful = centralLogic.insertEmployee(employee);
				if(!isSuccessful) {
					centralLogic.deleteRequestByEmployeeId(employee.getId());
					mv.addObject("status", "Sign Up failed");
					mv.setViewName("EmployeeHomeView");
					return mv;
				}
				else {
					Ride ride = employee.getRide();
					ride = centralLogic.searchRideByVehicleId(ride.getVehicle().getId());
					ride.setSeatsAllocated(ride.getSeatsAllocated() + 1);
					centralLogic.updateRide(ride.getVehicle().getId(), ride);
					mv.addObject("status", "Your request is pending.");
					mv.setViewName("EmployeeHomeView");
					return mv;
				}
			}
		} catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			mv.addObject("status", "Error");
			mv.setViewName("EmployeeHomeView");
			return mv;
		}

	}
}