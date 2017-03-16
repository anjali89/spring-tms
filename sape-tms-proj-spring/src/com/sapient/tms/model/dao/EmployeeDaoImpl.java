package com.sapient.tms.model.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sapient.tms.helper.JDBCConnection;
import com.sapient.tms.model.bean.Employee;
import com.sapient.tms.model.bean.Ride;
import com.sapient.tms.model.bean.Vehicle;

public class EmployeeDaoImpl implements EmployeeDao {

	private static final String INSERT_QUERY = "INSERT INTO employee(id, password, name, vehicle_id, is_admin) VALUES(?, ?, ?, ?, ?)";
	private static final String UPDATE_QUERY = "UPDATE employee SET password = ?, name = ?, vehicle_id = ?,"
			+ "is_admin = ? WHERE id = ?";
	private static final String DELETE_QUERY = "DELETE FROM employee WHERE id = ?";
	private static final String GET_MAX_ID_QUERY = "SELECT COALESCE(MAX(id), 0) AS COUNT FROM employee";
	private static final String SELECT_QUERY = "SELECT * FROM employee WHERE id = ?";
	private static final String GET_EMPLOYEE_COUNT_FOR_RIDE_QUERY = "SELECT COUNT(*) AS COUNT FROM employee WHERE vehicle_id = ?";
	private static final String SELECT_ALL_QUERY = "SELECT * FROM employee";
	private static final String SELECT_ALL_RIDE_EMPLOYEE_QUERY = "SELECT * FROM employee WHERE vehicle_id=?";

	@Override
	public boolean insert(Employee employee) throws IOException, ClassNotFoundException, SQLException {
		try (Connection connection = JDBCConnection.getConnection()) {
			int numAffectedRows;
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_QUERY);
			preparedStatement.setInt(1, employee.getId());
			preparedStatement.setString(2, employee.getPassword());
			preparedStatement.setString(3, employee.getName());
			preparedStatement.setString(4, employee.getRide().getVehicle().getId());
			preparedStatement.setString(5, employee.isAdmin() ? "Y" : "N");
			numAffectedRows = preparedStatement.executeUpdate();
			preparedStatement.close();
			connection.close();
			return numAffectedRows > 0;
		}
	}

	@Override
	public Employee search(int employeeId) throws IOException, ClassNotFoundException, SQLException {
		try (Connection connection = JDBCConnection.getConnection()) {
			Employee employee = null;
			List<Employee> employeeList = new ArrayList<>();
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_QUERY);
			preparedStatement.setInt(1, employeeId);
			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
				String employeePassword = rs.getString("password");
				String employeeName = rs.getString("name");
				String employeeVehicleId = rs.getString("vehicle_id");
				boolean isEmployeeAdmin = rs.getString("is_admin").equals("Y") ? true : false;
				Vehicle tempVehicle = new Vehicle(employeeVehicleId, null, null, 0);
				Ride employeeRide = new Ride(tempVehicle, null, null, null, 0);
				employee = new Employee(employeeId, employeePassword, employeeName, employeeRide, isEmployeeAdmin);
				employeeList.add(employee);
			}
			rs.close();
			preparedStatement.close();
			connection.close();
			return employee;
		}
	}

	@Override
	public List<Employee> displayAll() throws IOException, ClassNotFoundException, SQLException {
		try (Connection connection = JDBCConnection.getConnection()) {
			List<Employee> employeeList = new ArrayList<>();
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_QUERY);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				int employeeId = rs.getInt("id");
				String employeePassword = rs.getString("password");
				String employeeName = rs.getString("name");
				String employeeVehicleId = rs.getString("vehicle_id");
				boolean isEmployeeAdmin = rs.getString("is_admin").equals("Y") ? true : false;
				Vehicle employeeVehicle = new Vehicle(employeeVehicleId, null, null, 0);
				Ride employeeRide = new Ride(employeeVehicle, null, null, null, 0);
				Employee employee = new Employee(employeeId, employeePassword, employeeName, employeeRide, isEmployeeAdmin);
				employeeList.add(employee);
			}
			rs.close();
			preparedStatement.close();
			connection.close();
			return employeeList;
		}
	}

	@Override
	public boolean delete(int employeeId) throws IOException, ClassNotFoundException, SQLException {
		try (Connection connection = JDBCConnection.getConnection()) {
			int updateCount;
			PreparedStatement preparedStatement = connection.prepareStatement(DELETE_QUERY);
			preparedStatement.setInt(1, employeeId);
			preparedStatement.execute();
			updateCount = preparedStatement.getUpdateCount();
			preparedStatement.close();
			connection.close();
			return updateCount > 0;
		}
	}

	@Override
	public boolean update(int employeeId, Employee newEmployee)
			throws IOException, ClassNotFoundException, SQLException {
		try (Connection connection = JDBCConnection.getConnection()) {
			int updateCount;
			PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_QUERY);
			preparedStatement.setString(1, newEmployee.getPassword());
			preparedStatement.setString(2, newEmployee.getName());
			preparedStatement.setString(3, newEmployee.getRide().getVehicle().getId());
			preparedStatement.setString(4, newEmployee.isAdmin() ? "Y" : "N");
			preparedStatement.setInt(5, newEmployee.getId());
			preparedStatement.execute();
			updateCount = preparedStatement.getUpdateCount();
			preparedStatement.close();
			connection.close();
			return updateCount > 0;
		}
	}

	public int getMaxId() throws SQLException, ClassNotFoundException {
		try (Connection connection = JDBCConnection.getConnection()) {
			PreparedStatement preparedStatement = connection.prepareStatement(GET_MAX_ID_QUERY);
			ResultSet rs = preparedStatement.executeQuery();
			rs.next();
			int result = rs.getInt("COUNT");
			rs.close();
			preparedStatement.close();
			connection.close();
			return result;
		}
	}

	@Override
	public int getEmployeeCountForRide(int rideId) throws SQLException, ClassNotFoundException {
		try (Connection connection = JDBCConnection.getConnection()) {
			PreparedStatement preparedStatement = connection.prepareStatement(GET_EMPLOYEE_COUNT_FOR_RIDE_QUERY);
			preparedStatement.setInt(1, rideId);
			ResultSet rs = preparedStatement.executeQuery();
			rs.next();
			int count = rs.getInt("COUNT");
			rs.close();
			preparedStatement.close();
			connection.close();
			return count;
		}
	}

	@Override
	public List<Employee> displayAllByRide(int rideId) throws SQLException, ClassNotFoundException {
		try (Connection connection = JDBCConnection.getConnection()) {
			List<Employee> employeeList = new ArrayList<>();
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_RIDE_EMPLOYEE_QUERY);
			preparedStatement.setInt(1, rideId);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				int employeeId = rs.getInt("id");
				String employeePassword = rs.getString("password");
				String employeeName = rs.getString("name");
				String employeeVehicleId = rs.getString("vehicle_id");
				boolean isEmployeeAdmin = rs.getString("is_admin").equals("Y") ? true : false;
				Vehicle employeeVehicle = new Vehicle(employeeVehicleId, null, null, 0);
				Ride employeeRide = new Ride(employeeVehicle, null, null, null, 0);
				Employee employee = new Employee(employeeId, employeePassword, employeeName, employeeRide, isEmployeeAdmin);
				employeeList.add(employee);
			}
			rs.close();
			preparedStatement.close();
			connection.close();
			return employeeList;
		}
	}
}
