package com.sapient.tms.model.bl;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.List;

import com.sapient.tms.model.bean.Ride;
import com.sapient.tms.model.dao.RideDao;
import com.sapient.tms.model.dao.RideDaoImpl;

public class RideLogic {
	private RideDao rideDao;

	public RideLogic() {
		rideDao = new RideDaoImpl();
	}

	public boolean insert(Ride ride) throws IOException, ClassNotFoundException, SQLException {
		return rideDao.insert(ride);
	}

	public boolean deleteByVehicleId(String vehicleId) throws IOException, ClassNotFoundException, SQLException {
		return rideDao.deleteByVehicleId(vehicleId);
	}

	public boolean update(String vehicleId, Ride newRide) throws IOException, ClassNotFoundException, SQLException {
		return rideDao.update(vehicleId, newRide);
	}

	public Ride searchByVehicleId(String vehicleId) throws IOException, ClassNotFoundException, SQLException {
		return rideDao.searchByVehicleId(vehicleId);
	}

	public List<Ride> searchByRouteId(int routeId) throws IOException, ClassNotFoundException, SQLException {
		return rideDao.searchByRouteId(routeId);
	}

	public List<Ride> searchByPickupTime(LocalTime pickupTime)
			throws IOException, ClassNotFoundException, SQLException {
		return rideDao.searchByPickupTime(pickupTime);
	}

	public List<Ride> searchByDropTime(LocalTime dropTime) throws IOException, ClassNotFoundException, SQLException {
		return rideDao.searchByDropTime(dropTime);
	}

	public List<Ride> displayAll() throws IOException, ClassNotFoundException, SQLException {
		return rideDao.displayAll();
	}
}
