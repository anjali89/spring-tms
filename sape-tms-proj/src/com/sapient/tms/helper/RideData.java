package com.sapient.tms.helper;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalTime;

import javax.servlet.http.HttpServletRequest;

import com.sapient.tms.model.bean.Ride;
import com.sapient.tms.model.bean.Route;
import com.sapient.tms.model.bean.Vehicle;
import com.sapient.tms.model.bl.CentralLogic;

public class RideData {
	private Ride ride;
	private CentralLogic centralLogic;

	public RideData() {
		centralLogic = new CentralLogic();
	}

	public void createRide(HttpServletRequest request) throws ClassNotFoundException, IOException, SQLException {
		String vehicleId = request.getParameter("vehicleId");
		int routeId = Integer.parseInt(request.getParameter("routeId"));
		LocalTime pickupTime = LocalTime.parse(request.getParameter("pickupTime"));
		LocalTime dropTime = LocalTime.parse(request.getParameter("dropTime"));
		int seatsAllocated = Integer.parseInt(request.getParameter("seatsAllocated"));
		Vehicle vehicle = centralLogic.searchVehicle(vehicleId);
		Route route = centralLogic.searchRoute(routeId);
		ride = new Ride(vehicle, route, pickupTime, dropTime, seatsAllocated);
	}
	
	public void updateRide(HttpServletRequest request) throws ClassNotFoundException, IOException, SQLException{
		
	}

	public Ride getRide() {
		return ride;
	}
}
