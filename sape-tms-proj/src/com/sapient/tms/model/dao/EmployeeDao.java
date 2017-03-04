package com.sapient.tms.model.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.sapient.tms.model.bean.Employee;

public interface EmployeeDao {
	public boolean insert(Employee employee) throws IOException, ClassNotFoundException, SQLException;

	public boolean delete(int id) throws IOException, ClassNotFoundException, SQLException;

	public boolean update(int id, Employee newEmployee) throws IOException, ClassNotFoundException, SQLException;

	public Employee search(int id) throws IOException, ClassNotFoundException, SQLException;

	public int getMaxId() throws SQLException, ClassNotFoundException;

	public List<Employee> displayAll() throws IOException, ClassNotFoundException, SQLException;

	public int getEmployeeCountForRide(int rideId) throws SQLException, ClassNotFoundException;

	public List<Employee> displayAllByRide(int routeId) throws SQLException, ClassNotFoundException;
}
