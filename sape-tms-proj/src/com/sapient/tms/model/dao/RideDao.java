package com.sapient.tms.model.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.List;

import com.sapient.tms.model.bean.Ride;

public interface RideDao {
	public boolean insert(Ride ride) throws IOException, ClassNotFoundException, SQLException;

	public boolean deleteByVehicleId(String vehicleId) throws IOException, ClassNotFoundException, SQLException;

	public boolean update(String vehicleId, Ride newRide) throws IOException, ClassNotFoundException, SQLException;

	public Ride searchByVehicleId(String vehicleId) throws IOException, ClassNotFoundException, SQLException;

	public List<Ride> searchByRouteId(int routeId) throws IOException, ClassNotFoundException, SQLException;

	public List<Ride> searchByPickupTime(LocalTime pickupTime) throws IOException, ClassNotFoundException, SQLException;

	public List<Ride> searchByDropTime(LocalTime dropTime) throws IOException, ClassNotFoundException, SQLException;

	public int getMaxId() throws SQLException, ClassNotFoundException;

	public List<Ride> displayAll() throws IOException, ClassNotFoundException, SQLException;

}
