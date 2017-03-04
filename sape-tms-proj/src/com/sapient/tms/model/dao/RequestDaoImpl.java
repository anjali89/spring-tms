package com.sapient.tms.model.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sapient.tms.model.bean.Request;
import com.sapient.tms.helper.JDBCConnection;

public class RequestDaoImpl implements RequestDao {
	private static final String INSERT_QUERY = "INSERT INTO request(id, employee_id, vehicle_id, status) VALUES(?, ?, ?, ?)";
	private static final String SELECT_ALL_QUERY = "SELECT * FROM request";
	private static final String SELECT_QUERY = "SELECT * FROM request WHERE employee_id = ?";
	private static final String SELECT_QUERY_BY_REQUEST = "SELECT * FROM request WHERE id = ?";
	private static final String DELETE_QUERY_BY_EMPLOYEE = "DELETE FROM request WHERE employee_id = ?";
	private static final String DELETE_QUERY_BY_REQUEST = "DELETE FROM request WHERE id = ?";
	private static final String UPDATE_QUERY_BY_REQUEST_ID = "UPDATE request SET status = ? WHERE id = ?";
	private static final String GET_MAX_ID_QUERY = "SELECT COALESCE(MAX(id), 0) AS COUNT FROM request";

	@Override
	public boolean insert(Request request) throws IOException, ClassNotFoundException, SQLException {
		int numAffectedRows;
		try (Connection connection = JDBCConnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_QUERY);) {
			preparedStatement.setInt(1, request.getId());
			preparedStatement.setInt(2, request.getEmployeeId());
			preparedStatement.setString(3, request.getRideId());
			preparedStatement.setString(4, request.getStatus());
			numAffectedRows = preparedStatement.executeUpdate();
			return numAffectedRows > 0;
		}
	}

	public Request searchByEmployeeId(int id) throws IOException, ClassNotFoundException, SQLException {
		Request request = null;
		try (Connection connection = JDBCConnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_QUERY);) {
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
				int a = rs.getInt("employee_id");
				int b = rs.getInt("id");
				String c = rs.getString("vehicle_id");
				String d = rs.getString("status");
				request = new Request(b, a, c, d);
			}
			rs.close();
			return request;
		}
	}

	public Request searchByRequestId(int id) throws IOException, ClassNotFoundException, SQLException {
		Request request = null;
		try (Connection connection = JDBCConnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_QUERY_BY_REQUEST);) {
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
				int employeeId = rs.getInt("employee_id");
				int requestId = rs.getInt("id");
				String vehicleId = rs.getString("vehicle_id");
				String status = rs.getString("status");
				request = new Request(requestId, employeeId, vehicleId, status);
			}
			rs.close();
			return request;
		}
	}

	public boolean deleteByEmployeeId(int id) throws IOException, ClassNotFoundException, SQLException {
		try (Connection connection = JDBCConnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(DELETE_QUERY_BY_EMPLOYEE);) {
			preparedStatement.setInt(1, id);
			int numRows = preparedStatement.executeUpdate();
			return numRows > 0;
		}
	}

	public boolean deleteByRequestId(int id) throws IOException, ClassNotFoundException, SQLException {
		int updateCount;
		try (Connection connection = JDBCConnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(DELETE_QUERY_BY_REQUEST);) {
			preparedStatement.setInt(1, id);
			preparedStatement.execute();
			updateCount = preparedStatement.getUpdateCount();
			return updateCount > 0;
		}
	}

	public List<Request> displayAll() throws ClassNotFoundException, SQLException {
		List<Request> requestList = new ArrayList<>();
		try (Connection connection = JDBCConnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_QUERY);) {
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				int requestId = rs.getInt("id");
				int employeeId = rs.getInt("employee_id");
				String vehicleId = rs.getString("vehicle_id");
				String status = rs.getString("status");
				Request request = new Request(requestId, employeeId, vehicleId, status);
				requestList.add(request);
			}
			rs.close();
			return requestList;
		}
	}

	@Override
	public boolean updateByRequestId(int id, Request request) throws IOException, ClassNotFoundException, SQLException {
		try (Connection connection = JDBCConnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_QUERY_BY_REQUEST_ID);) {
			preparedStatement.setString(1, request.getStatus());
			preparedStatement.setInt(2, id);
			int numRows = preparedStatement.executeUpdate();
			return numRows > 0;
		}
	}

	@Override
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

}
