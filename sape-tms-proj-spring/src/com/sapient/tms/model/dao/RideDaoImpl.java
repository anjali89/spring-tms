package com.sapient.tms.model.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.sql.Time;

import com.sapient.tms.helper.JDBCConnection;
import com.sapient.tms.model.bean.Ride;
import com.sapient.tms.model.bean.Route;
import com.sapient.tms.model.bean.Vehicle;

public class RideDaoImpl implements RideDao {

	private static final String INSERT_QUERY = "INSERT INTO ride(vehicle_id, route_id, pickup_time, drop_time, seats_allocated) VALUES(?, ?, ?, ?, ?)";
	private static final String DELETE_QUERY = "DELETE FROM ride WHERE vehicle_id = ?";
	private static final String UPDATE_QUERY = "UPDATE ride SET route_id = ?, pickup_time = ?, drop_time = ?, seats_allocated = ? "
			+ "WHERE vehicle_id = ?";
	private static final String SELECT_QUERY_BY_VEHICLE = "SELECT * FROM ride WHERE vehicle_id = ?";
	private static final String SELECT_QUERY_BY_ROUTE = "SELECT * FROM ride WHERE route_id = ?";
	private static final String SELECT_QUERY_BY_PICKUP = "SELECT * FROM ride WHERE pickup_time = ?";
	private static final String SELECT_QUERY_BY_DROP = "SELECT * FROM ride WHERE drop_time = ?";
	private static final String SELECT_ALL_QUERY = "SELECT * FROM ride";
	private static final String GET_MAX_ID_QUERY = "SELECT COALESCE(MAX(vehicle_id), 0) AS COUNT FROM ride";

	// inserting a ride
	@Override
	public boolean insert(Ride ride) throws IOException, ClassNotFoundException, SQLException {
		try (Connection connection = JDBCConnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_QUERY);) {
			int numAffectedRows;
			preparedStatement.setString(1, ride.getVehicle().getId());
			preparedStatement.setInt(2, ride.getRoute().getId());
			preparedStatement.setString(3, ride.getPickupTime().toString());
			preparedStatement.setString(4, ride.getDropTime().toString());
			preparedStatement.setInt(5, ride.getSeatsAllocated());
			numAffectedRows = preparedStatement.executeUpdate();
			return numAffectedRows > 0;
		}
	}

	// delete using the vehicle id

	@Override
	public boolean deleteByVehicleId(String vehicleId) throws IOException, ClassNotFoundException, SQLException {
		try (Connection connection = JDBCConnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(DELETE_QUERY);) {
			int updateCount;
			preparedStatement.setString(1, vehicleId);
			preparedStatement.execute();
			updateCount = preparedStatement.getUpdateCount();
			return updateCount > 0;
		}
	}

	// updating using the vehicle id
	@Override
	public boolean update(String vehicleId, Ride newRide) throws IOException, ClassNotFoundException, SQLException {
		try (Connection connection = JDBCConnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_QUERY);) {
			int updateCount;
			preparedStatement.setInt(1, newRide.getRoute().getId());
			preparedStatement.setString(2, newRide.getPickupTime().toString());
			preparedStatement.setString(3, newRide.getDropTime().toString());
			preparedStatement.setInt(4, newRide.getSeatsAllocated());
			preparedStatement.setString(5, newRide.getVehicle().getId());
			System.out.println(newRide.getPickupTime());
			System.out.println(newRide.getDropTime());
			preparedStatement.execute();
			updateCount = preparedStatement.getUpdateCount();
			return updateCount > 0;
		}
	}

	// searching using the vehicle id
	@Override
	public Ride searchByVehicleId(String vehicleId) throws IOException, ClassNotFoundException, SQLException {
		try (Connection connection = JDBCConnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_QUERY_BY_VEHICLE);) {
			Ride ride = null;
			preparedStatement.setString(1, vehicleId);
			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
				int routeId = rs.getInt("route_id");
				LocalTime pickupTime = LocalTime.parse(rs.getString("pickup_time"));
				LocalTime dropTime = LocalTime.parse(rs.getString("drop_time"));
				int seatsAllocated = rs.getInt("seats_allocated");
				Route route = new Route(routeId, null, null);
				Vehicle vehicle = new Vehicle(vehicleId, null, null, 0);
				ride = new Ride(vehicle, route, pickupTime, dropTime, seatsAllocated);
			}
			rs.close();
			return ride;
		}
	}

	// searching using the route id
	@Override
	public List<Ride> searchByRouteId(int routeId) throws IOException, ClassNotFoundException, SQLException {

		try (Connection connection = JDBCConnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_QUERY_BY_ROUTE);) {
			List<Ride> rideList = new ArrayList<Ride>();
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				String vehicleId = rs.getString("vehicle_id");
				LocalTime pickupTime = LocalTime.parse(rs.getString("pickup_time"));
				LocalTime dropTime = LocalTime.parse(rs.getString("drop_time"));
				int seatsAllocated = rs.getInt("seats_allocated");
				Route route = new Route(routeId, null, null);
				Vehicle vehicle = new Vehicle(vehicleId, null, null, 0);
				rideList.add(new Ride(vehicle, route, pickupTime, dropTime, seatsAllocated));
			}
			rs.close();
			return rideList;
		}
	}

	// searching using the pickup time
	@Override
	public List<Ride> searchByPickupTime(LocalTime pickupTime)
			throws IOException, ClassNotFoundException, SQLException {
		try (Connection connection = JDBCConnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_QUERY_BY_PICKUP);) {
			List<Ride> rideList = new ArrayList<Ride>();
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {

				String vehicleId = rs.getString("vehicle_id");
				LocalTime dropTime = LocalTime.parse(rs.getString("drop_time"));
				int seatsAllocated = rs.getInt("seats_allocated");
				int routeId = rs.getInt("route_id");
				Route route = new Route(routeId, null, null);
				Vehicle vehicle = new Vehicle(vehicleId, null, null, 0);
				rideList.add(new Ride(vehicle, route, pickupTime, dropTime, seatsAllocated));
			}
			rs.close();
			return rideList;
		}
	}

	@Override
	public List<Ride> searchByDropTime(LocalTime dropTime) throws IOException, ClassNotFoundException, SQLException {
		try (Connection connection = JDBCConnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_QUERY_BY_DROP);) {
			List<Ride> rideList = new ArrayList<Ride>();
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				LocalTime pickupTime = LocalTime.parse(rs.getString("pickup_time"));
				String vehicleId = rs.getString("vehicle_id");
				int seatsAllocated = rs.getInt("seats_allocated");
				int routeId = rs.getInt("route_id");
				Route route = new Route(routeId, null, null);
				Vehicle vehicle = new Vehicle(vehicleId, null, null, 0);
				rideList.add(new Ride(vehicle, route, pickupTime, dropTime, seatsAllocated));
			}
			rs.close();
			return rideList;
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
	public List<Ride> displayAll() throws IOException, ClassNotFoundException, SQLException {
		try (Connection connection = JDBCConnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_QUERY);) {
			List<Ride> rideList = new ArrayList<Ride>();
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				LocalTime pickupTime = LocalTime.parse(rs.getString("pickup_time"));
				String vehicleId = rs.getString("vehicle_id");
				int seatsAllocated = rs.getInt("seats_allocated");
				int routeId = rs.getInt("route_id");
				LocalTime dropTime = LocalTime.parse(rs.getString("drop_time"));
				Route route = new Route(routeId, null, null);
				Vehicle vehicle = new Vehicle(vehicleId, null, null, 0);
				rideList.add(new Ride(vehicle, route, pickupTime, dropTime, seatsAllocated));
			}
			rs.close();
			return rideList;
		}
	}

}
