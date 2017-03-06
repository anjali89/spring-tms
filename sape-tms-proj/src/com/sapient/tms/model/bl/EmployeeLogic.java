package com.sapient.tms.model.bl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.sapient.tms.model.bean.Employee;
import com.sapient.tms.model.dao.EmployeeDao;
import com.sapient.tms.model.dao.EmployeeDaoImpl;

public class EmployeeLogic {
	private EmployeeDao employeeDao;

	public EmployeeLogic() {
		employeeDao = new EmployeeDaoImpl();
	}

	public Employee search(int employeeId) throws ClassNotFoundException, IOException, SQLException {
		return employeeDao.search(employeeId);
	}

	public boolean insert(Employee employee) throws ClassNotFoundException, IOException, SQLException {
		return employeeDao.insert(employee);
	}

	public boolean update(int id, Employee loggedEmployee) throws ClassNotFoundException, IOException, SQLException {
		return employeeDao.update(id, loggedEmployee);
	}

	public boolean delete(int id) throws IOException, ClassNotFoundException, SQLException {
		return employeeDao.delete(id);
	}

	public boolean isAnyEmployeeAssignedToRide(int rideId) throws ClassNotFoundException, SQLException {
		return employeeDao.getEmployeeCountForRide(rideId) > 0;
	}

	public List<Employee> displayAll() throws IOException, ClassNotFoundException, SQLException {
		return employeeDao.displayAll();
	}

	public List<Employee> displayAllByRide(int rideId) throws ClassNotFoundException, SQLException {
		return employeeDao.displayAllByRide(rideId);
	}

}
