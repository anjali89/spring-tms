package com.sapient.tms.model.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sapient.tms.model.bean.Employee;
import com.sapient.tms.model.bean.Request;
import com.sapient.tms.model.bean.Ride;
import com.sapient.tms.model.bean.Vehicle;
import com.sapient.tms.helper.JDBCConnection;

public class RequestDaoImpl implements RequestDao {
	private static final String INSERT_QUERY = "INSERT INTO request(employee_id, status) VALUES(?, ?)";
	private static final String SELECT_ALL_QUERY = "SELECT * FROM request";
	private static final String SELECT_QUERY_BY_EMPLOYEE = "SELECT * FROM request WHERE employee_id = ?";
	private static final String DELETE_QUERY_BY_EMPLOYEE = "DELETE FROM request WHERE employee_id = ?";
	private static final String UPDATE_QUERY_BY_EMPLOYEE = "UPDATE request SET status = ? WHERE employee_id = ?";

	@Override
	public boolean insert(Request request) throws IOException, ClassNotFoundException, SQLException {
		int numAffectedRows;
		try (Connection connection = JDBCConnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_QUERY);) {
			System.out.println("inside insert requestdao");
			preparedStatement.setInt(1, request.getEmployee().getId());
			preparedStatement.setString(2, request.getStatus());
			System.out.println(preparedStatement);
			System.out.println(request.getEmployee().getId()+" "+request.getStatus());
			numAffectedRows = preparedStatement.executeUpdate();
			System.out.println(numAffectedRows);
			return numAffectedRows > 0;
		}
	}

	public Request searchByEmployeeId(int employeeId) throws IOException, ClassNotFoundException, SQLException {
		Request request = null;
		try (Connection connection = JDBCConnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_QUERY_BY_EMPLOYEE);) {
			preparedStatement.setInt(1, employeeId);
			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
				String status = rs.getString("status");
				Employee tempEmployee = new Employee(employeeId, null, null, null, false);
				request = new Request(tempEmployee, status);
			}
			rs.close();
			return request;
		}
	}

	public boolean deleteByEmployeeId(int employeeId) throws IOException, ClassNotFoundException, SQLException {
		try (Connection connection = JDBCConnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(DELETE_QUERY_BY_EMPLOYEE);) {
			preparedStatement.setInt(1, employeeId);
			int numRows = preparedStatement.executeUpdate();
			return numRows > 0;
		}
	}

	public List<Request> displayAll() throws ClassNotFoundException, SQLException {
		List<Request> requestList = new ArrayList<>();
		try (Connection connection = JDBCConnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_QUERY);) {
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				int employeeId = rs.getInt("employee_id");
				String status = rs.getString("status");
				Employee tempEmployee = new Employee(employeeId, null, null, null, false);
				Request request = new Request(tempEmployee, status);
				requestList.add(request);
			}
			rs.close();
			return requestList;
		}
	}

	@Override
	public boolean updateByEmployeeId(int employeeId, Request request) throws IOException, ClassNotFoundException, SQLException {
		try (Connection connection = JDBCConnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_QUERY_BY_EMPLOYEE);) {
			preparedStatement.setString(1, request.getStatus());
			preparedStatement.setInt(2, employeeId);
			int numRows = preparedStatement.executeUpdate();
			return numRows > 0;
		}
	}

}
