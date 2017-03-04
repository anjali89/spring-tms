package com.sapient.tms.helper;

import java.io.IOException;
import java.sql.SQLException;
import java.util.AbstractMap;
import java.util.Map;

import com.sapient.tms.model.bean.Employee;
import com.sapient.tms.model.bl.CentralLogic;

public class EmployeeAuthenticator {

	public Map.Entry<Employee, Boolean> authenticate(int employeeId, String password)
			throws ClassNotFoundException, IOException, SQLException {
		CentralLogic centralLogic = new CentralLogic();
		Employee employee = centralLogic.searchEmployee(employeeId);
		if (employee == null)
			return new AbstractMap.SimpleEntry<>(null, false);
		if (password.equals(employee.getPassword()))
			return new AbstractMap.SimpleEntry<>(employee, true);
		return new AbstractMap.SimpleEntry<>(employee, false);
	}
}