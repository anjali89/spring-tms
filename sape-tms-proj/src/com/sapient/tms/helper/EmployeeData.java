package com.sapient.tms.helper;

import java.util.Scanner;
import javax.servlet.http.HttpServletRequest;

import com.sapient.tms.model.bean.Employee;

public class EmployeeData {
	private Employee employee;

	public void createEmployee(HttpServletRequest request) {
		int employeeId = Integer.parseInt(request.getParameter("id"));
		String employeePassword = request.getParameter("password");
		String employeeName = request.getParameter("name");
		String employeeVehicleId = request.getParameter("vehicleId");
		employee = new Employee(employeeId, employeePassword, employeeName, employeeVehicleId, false);
	}

	public Employee getEmployee() {
		return employee;
	}
}