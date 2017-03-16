package com.sapient.tms.helper;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;
import javax.servlet.http.HttpServletRequest;

import com.sapient.tms.model.bean.Employee;
import com.sapient.tms.model.bean.Ride;
import com.sapient.tms.model.bean.Vehicle;
import com.sapient.tms.model.bl.CentralLogic;

public class EmployeeData {
	private Employee employee;
	private CentralLogic centralLogic;
	
	public EmployeeData(){
		centralLogic = new CentralLogic();
	}

	public void createEmployee(HttpServletRequest request) throws ClassNotFoundException, IOException, SQLException {
		int employeeId = Integer.parseInt(request.getParameter("id"));
		String employeePassword = request.getParameter("password");
		String employeeName = request.getParameter("name");
		String employeeVehicleId = request.getParameter("vehicleId");
		Ride employeeRide = centralLogic.searchRideByVehicleId(employeeVehicleId);
		employee = new Employee(employeeId, employeePassword, employeeName, employeeRide, false);
	}

	public Employee getEmployee() {
		return employee;
	}
}