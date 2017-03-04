package com.sapient.tms.model.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sapient.tms.helper.JDBCConnection;
import com.sapient.tms.model.bean.Vehicle;

public class VehicleDaoImpl implements VehicleDao {

	private static final String INSERT_QUERY = "INSERT INTO vehicle(id, model_name, brand_name, capacity) VALUES(?, ?, ?, ?)";
	private static final String DELETE_QUERY = "DELETE FROM vehicle WHERE id = ?";
	private static final String UPDATE_QUERY = "UPDATE vehicle SET model_name = ?, brand_name = ?, capacity = ?"
			+ "WHERE id = ?";
	private static final String SELECT_QUERY = "SELECT * FROM vehicle WHERE id = ?";
	private static final String SELECT_ALL_QUERY = "SELECT * FROM vehicle";
	private static final String GET_MAX_ID_QUERY = "SELECT COALESCE(MAX(id), 0) AS COUNT FROM vehicle";

	@Override
	public boolean insert(Vehicle vehicle) throws IOException, ClassNotFoundException, SQLException {
		try (Connection connection = JDBCConnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_QUERY);) {
			int numAffectedRows;
			preparedStatement.setString(1, vehicle.getId());
			preparedStatement.setString(2, vehicle.getModelName());
			preparedStatement.setString(3, vehicle.getBrandName());
			preparedStatement.setInt(4, vehicle.getCapacity());
			numAffectedRows = preparedStatement.executeUpdate();
			return numAffectedRows > 0;
		}
	}

	@Override
	public boolean delete(String id) throws IOException, ClassNotFoundException, SQLException {
		try (Connection connection = JDBCConnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(DELETE_QUERY);) {
			int updateCount;
			preparedStatement.setString(1, id);
			preparedStatement.execute();
			updateCount = preparedStatement.getUpdateCount();
			return updateCount > 0;
		}
	}

	@Override
	public boolean update(String id, Vehicle newVehicle) throws IOException, ClassNotFoundException, SQLException {
		try (Connection connection = JDBCConnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_QUERY);) {
			int updateCount;
			preparedStatement.setString(1, newVehicle.getModelName());
			preparedStatement.setString(2, newVehicle.getBrandName());
			preparedStatement.setInt(3, newVehicle.getCapacity());
			preparedStatement.setString(4, newVehicle.getId());
			preparedStatement.execute();
			updateCount = preparedStatement.getUpdateCount();
			return updateCount > 0;
		}
	}

	@Override
	public Vehicle search(String id) throws IOException, ClassNotFoundException, SQLException {
		try (Connection connection = JDBCConnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_QUERY);) {
			Vehicle vehicle = null;
			preparedStatement.setString(1, id);
			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
				String vehicleModelName = rs.getString("MODEL_NAME");
				String vehicleBrandName = rs.getString("BRAND_NAME");
				int vehicleCapacity = rs.getInt("CAPACITY");
				vehicle = new Vehicle(id, vehicleModelName, vehicleBrandName, vehicleCapacity);
			}
			rs.close();
			return vehicle;
		}

	}

	@Override
	public int getMaxId() throws SQLException, ClassNotFoundException {
		try (Connection connection = JDBCConnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(GET_MAX_ID_QUERY);) {
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
	public List<Vehicle> displayAll() throws IOException, ClassNotFoundException, SQLException {
		try (Connection connection = JDBCConnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_QUERY);) {
			List<Vehicle> vehicleList = new ArrayList<Vehicle>();
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				String vehicleId = rs.getString("ID");
				String vehicleModelName = rs.getString("MODEL_NAME");
				String vehicleBrandName = rs.getString("BRAND_NAME");
				int vehicleCapacity = rs.getInt("CAPACITY");
				vehicleList.add(new Vehicle(vehicleId, vehicleModelName, vehicleBrandName, vehicleCapacity));
			}
			rs.close();
			return vehicleList;
		}
	}

}
