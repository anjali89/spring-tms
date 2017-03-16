package com.sapient.tms.helper;

import javax.servlet.http.HttpServletRequest;

import com.sapient.tms.model.bean.Vehicle;

public class VehicleData {
	private Vehicle vehicle;

	public void createVehicle(HttpServletRequest request) {
		int capacity = Integer.parseInt(request.getParameter("capacity"));
		String modelName = request.getParameter("modelName");
		String brandName = request.getParameter("brandName");
		String id = request.getParameter("id");
		vehicle = new Vehicle(id, modelName, brandName, capacity);
	}

	public Vehicle getVehicle() {
		return vehicle;
	}
}
