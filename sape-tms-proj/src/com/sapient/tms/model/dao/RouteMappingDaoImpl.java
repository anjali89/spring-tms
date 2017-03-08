package com.sapient.tms.model.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.sapient.tms.helper.JDBCConnection;
import com.sapient.tms.model.bean.Route;

public class RouteMappingDaoImpl implements RouteMappingDao {

	private static final String INSERT_QUERY = "INSERT INTO ROUTEMAPPING(ROUTE_ID, DROP_POINT_ID) VALUES(?, ?)";
	private static final String DELETE_QUERY = "DELETE FROM ROUTEMAPPING WHERE ROUTE_ID = ?";
	private static final String DELETE_QUERY_BY_DROP = "DELETE FROM ROUTEMAPPING WHERE DROP_POINT_ID = ?";
	private static final String SELECT_QUERY = "SELECT * FROM ROUTEMAPPING WHERE ROUTE_ID = ?";
	private static final String SELECT_ALL_QUERY = "SELECT * FROM ROUTEMAPPING";
	private static final String UPDATE_QUERY = "UPDATE routemapping set drop_point_id=? where route_id=?";

	@Override
	public boolean insert(int routeId, int dropPointId) throws IOException, ClassNotFoundException, SQLException {
		int numAffectedRows;
		try (Connection connection = JDBCConnection.getConnection()) {
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_QUERY);
			preparedStatement.setInt(1, routeId);
			preparedStatement.setInt(2, dropPointId);
			numAffectedRows = preparedStatement.executeUpdate();
			preparedStatement.close();
			connection.close();
			return numAffectedRows > 0;
		}
	}

	@Override
	public boolean delete(int routeId) throws IOException, ClassNotFoundException, SQLException {
		int updateCount;
		try (Connection connection = JDBCConnection.getConnection()) {
			PreparedStatement preparedStatement = connection.prepareStatement(DELETE_QUERY);
			preparedStatement.setInt(1, routeId);
			preparedStatement.execute();
			updateCount = preparedStatement.getUpdateCount();
			preparedStatement.close();
			connection.close();
			return updateCount > 0;
		}
	}

	@Override
	public List<Integer> search(int routeId) throws IOException, ClassNotFoundException, SQLException {
		List<Integer> dropList = new ArrayList<>();
		try (Connection connection = JDBCConnection.getConnection()) {
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_QUERY);
			preparedStatement.setInt(1, routeId);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				int dropId = rs.getInt("DROP_POINT_ID");
				dropList.add(dropId);
			}
			rs.close();
			preparedStatement.close();
			connection.close();
			return dropList;
		}
	}

	@Override
	public HashMap<Integer, List<Integer>> displayAll() throws IOException, ClassNotFoundException, SQLException {
		HashMap<Integer, List<Integer>> routeMap = new HashMap<>();
		try (Connection connection = JDBCConnection.getConnection()) {
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_QUERY);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				int routeId = rs.getInt("ROUTE_ID");
				int dropId = rs.getInt("DROP_POINT_ID");
				List<Integer> dropList = routeMap.get(routeId);
				if (dropList == null)
					dropList = new ArrayList<>();
				dropList.add(dropId);
				routeMap.put(routeId, dropList);
			}
			rs.close();
			preparedStatement.close();
			connection.close();
			return routeMap;
		}
	}

	@Override
	public boolean deleteByDrop(int dropId) throws SQLException, ClassNotFoundException {
		int updateCount;
		try (Connection connection = JDBCConnection.getConnection()) {
			PreparedStatement preparedStatement = connection.prepareStatement(DELETE_QUERY_BY_DROP);
			preparedStatement.setInt(1, dropId);
			preparedStatement.execute();
			updateCount = preparedStatement.getUpdateCount();
			preparedStatement.close();
			connection.close();
			return updateCount > 0;
		}
	}

	public boolean update(int dropId, int routeId) throws IOException, ClassNotFoundException, SQLException {
		int updateCount;
		try (Connection connection = JDBCConnection.getConnection()) {
			PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_QUERY);
			preparedStatement.setInt(1, dropId);
			preparedStatement.setInt(2, routeId);
			preparedStatement.execute();
			updateCount = preparedStatement.getUpdateCount();
			preparedStatement.close();
			connection.close();
			return updateCount > 0;
		}
	}
}
