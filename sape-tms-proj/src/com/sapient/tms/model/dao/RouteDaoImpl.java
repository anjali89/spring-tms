package com.sapient.tms.model.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sapient.tms.model.bean.Route;
import com.sapient.tms.helper.JDBCConnection;

public class RouteDaoImpl implements RouteDao {

	private static final String INSERT_QUERY = "INSERT INTO route(id, name) VALUES(?,?)";
	private static final String SELECT_ALL_QUERY = "SELECT * FROM route";
	private static final String SELECT_QUERY = "SELECT * FROM route WHERE id = ?";
	private static final String DELETE_QUERY = "DELETE FROM route WHERE id = ?";
	private static final String UPDATE_QUERY = "UPDATE route SET name = ? WHERE id = ?";
	private static final String GET_MAX_ID_QUERY = "SELECT COALESCE(MAX(id), 0) AS count FROM route";

	@Override
	public Route search(int id) throws IOException, ClassNotFoundException, SQLException {
		Route route = null;
		List<Route> routeList = new ArrayList<>();
		try (Connection connection = JDBCConnection.getConnection()) {
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_QUERY);
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
				String name = rs.getString("name");
				route = new Route(id, name, null);
				routeList.add(route);
			}
			rs.close();
			preparedStatement.close();
			connection.close();
			return route;
		}

	}

	@Override
	public boolean delete(int employeeId) throws IOException, ClassNotFoundException, SQLException {
		int updateCount;
		try (Connection connection = JDBCConnection.getConnection()) {
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
	public boolean update(int employeeId, Route newEmployee) throws IOException, ClassNotFoundException, SQLException {
		int updateCount;
		try (Connection connection = JDBCConnection.getConnection()) {
			PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_QUERY);
			preparedStatement.setString(1, newEmployee.getName());
			preparedStatement.setInt(2, newEmployee.getId());
			preparedStatement.execute();
			updateCount = preparedStatement.getUpdateCount();
			preparedStatement.close();
			connection.close();
			return updateCount > 0;
		}
	}

	@Override
	public boolean insert(Route employee) throws IOException, ClassNotFoundException, SQLException {
		int numAffectedRows;
		try (Connection connection = JDBCConnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_QUERY);) {
			preparedStatement.setInt(1, employee.getId());
			preparedStatement.setString(2, employee.getName());
			numAffectedRows = preparedStatement.executeUpdate();
			preparedStatement.close();
			connection.close();
			return numAffectedRows > 0;
		}
	}

	@Override
	public List<Route> displayAll() throws IOException, ClassNotFoundException, SQLException {
		List<Route> routeList = new ArrayList<>();
		try (Connection connection = JDBCConnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_QUERY);) {
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				int routeId = rs.getInt("id");
				String routeName = rs.getString("name");
				Route route = new Route(routeId, routeName, null);
				routeList.add(route);
			}
			rs.close();
			return routeList;
		}
	}

	@Override
	public int getMaxId() throws SQLException, ClassNotFoundException {
		try (Connection connection = JDBCConnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(GET_MAX_ID_QUERY);) {
			ResultSet rs = preparedStatement.executeQuery();
			rs.next();
			int result = rs.getInt("count");
			rs.close();
			return result;
		}
	}

}
