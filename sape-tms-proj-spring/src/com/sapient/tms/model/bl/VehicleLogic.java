package com.sapient.tms.model.bl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.sapient.tms.model.bean.Vehicle;
import com.sapient.tms.model.dao.VehicleDao;
import com.sapient.tms.model.dao.VehicleDaoImpl;

public class VehicleLogic {
	private VehicleDao vehicleDao = new VehicleDaoImpl();

	public boolean insert(Vehicle vehicle) throws IOException, ClassNotFoundException, SQLException {
		return vehicleDao.insert(vehicle);
	}

	public boolean delete(String id) throws IOException, ClassNotFoundException, SQLException {
		return vehicleDao.delete(id);
	}

	public boolean update(String id, Vehicle newVehicle) throws IOException, ClassNotFoundException, SQLException {
		return vehicleDao.update(id, newVehicle);
	}

	public Vehicle search(String id) throws IOException, ClassNotFoundException, SQLException {
		return vehicleDao.search(id);
	}

	public List<Vehicle> displayAll() throws IOException, ClassNotFoundException, SQLException {
		return vehicleDao.displayAll();
	}
}
