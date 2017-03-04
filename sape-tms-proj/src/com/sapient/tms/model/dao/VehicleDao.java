package com.sapient.tms.model.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.sapient.tms.model.bean.Vehicle;

public interface VehicleDao {
	public boolean insert(Vehicle vehicle) throws IOException, ClassNotFoundException, SQLException;

	public boolean delete(String id) throws IOException, ClassNotFoundException, SQLException;

	public boolean update(String id, Vehicle newVehicle) throws IOException, ClassNotFoundException, SQLException;

	public Vehicle search(String id) throws IOException, ClassNotFoundException, SQLException;

	public int getMaxId() throws SQLException, ClassNotFoundException;

	public List<Vehicle> displayAll() throws IOException, ClassNotFoundException, SQLException;
}
