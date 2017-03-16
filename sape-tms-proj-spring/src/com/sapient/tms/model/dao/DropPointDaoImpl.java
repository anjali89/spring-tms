
package com.sapient.tms.model.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.sapient.tms.model.bean.Drop;
import com.sapient.tms.helper.JDBCConnection;

public class DropPointDaoImpl implements DropPointDao {

	private static final String INSERT_QUERY = "INSERT INTO drop_point(id, name) VALUES(?, ?)";
	private static final String SELECT_ALL_QUERY = "SELECT * FROM drop_point";
	private static final String SELECT_QUERY = "SELECT * FROM drop_point WHERE id = ?";
	private static final String DELETE_QUERY = "DELETE FROM drop_point WHERE id = ?";
	private static final String UPDATE_QUERY = "UPDATE drop_point SET name = ? WHERE id = ?";
	private static final String GET_MAX_ID_QUERY = "SELECT COALESCE(MAX(id), 0) AS count FROM drop_point";

	@Override
	public Drop search(int id) throws IOException, ClassNotFoundException, SQLException {
		Drop drop = null;
		try (Connection connection = JDBCConnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_QUERY);) {
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
				int a = rs.getInt("id");
				String b = rs.getString("name");
				drop = new Drop(a, b);
			}
		}
		return drop;
	}

	@Override
	public boolean insert(Drop drop) throws IOException, ClassNotFoundException, SQLException {
		int numAffectedRows = 0;
		try (Connection connection = JDBCConnection.getConnection()) {
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_QUERY);
			preparedStatement.setInt(1, drop.getId());
			preparedStatement.setString(2, drop.getName());
			numAffectedRows = preparedStatement.executeUpdate();
		}
		return numAffectedRows > 0;
	}

	@Override
	public List<Drop> displayAll() throws IOException, ClassNotFoundException, SQLException {
		List<Drop> dropList = new ArrayList<>();
		try (Connection connection = JDBCConnection.getConnection()) {
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_QUERY);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				int a = rs.getInt("id");
				String b = rs.getString("name");
				Drop drop = new Drop(a, b);
				dropList.add(drop);
			}
		}
		return dropList;
	}

	@Override
	public boolean delete(int id) throws IOException, ClassNotFoundException, SQLException {
		int updateCount = 0;
		try (Connection connection = JDBCConnection.getConnection()) {
			PreparedStatement preparedStatement = connection.prepareStatement(DELETE_QUERY);
			preparedStatement.setInt(1, id);
			preparedStatement.execute();
			updateCount = preparedStatement.getUpdateCount();
		}
		return updateCount > 0;
	}

	@Override
	public int getMaxId() throws SQLException, ClassNotFoundException {
		int result = 0;
		try (Connection connection = JDBCConnection.getConnection()) {
			PreparedStatement preparedStatement = connection.prepareStatement(GET_MAX_ID_QUERY);
			ResultSet rs = preparedStatement.executeQuery();
			rs.next();
			result = rs.getInt("count");
		}
		return result;
	}

	@Override
	public boolean update(int id, Drop newDrop) throws IOException, ClassNotFoundException, SQLException {
		try (Connection connection = JDBCConnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_QUERY);) {
			int updateCount;
			preparedStatement.setString(1, newDrop.getName());
			preparedStatement.setInt(2, id);
			preparedStatement.execute();
			updateCount = preparedStatement.getUpdateCount();
			return updateCount > 0;
		}
	}
}
