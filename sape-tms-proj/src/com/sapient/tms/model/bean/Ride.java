package com.sapient.tms.model.bean;

import java.time.LocalTime;

public class Ride {
	Vehicle vehicle;
	Route route;
	LocalTime pickupTime;
	LocalTime dropTime;
	int seatsAllocated;

	public Route getRoute() {
		return route;
	}

	public void setRoute(Route route) {
		this.route = route;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public LocalTime getPickupTime() {
		return pickupTime;
	}

	public void setPickupTime(LocalTime pickupTime) {
		this.pickupTime = pickupTime;
	}

	public LocalTime getDropTime() {
		return dropTime;
	}

	public void setDropTime(LocalTime dropTime) {
		this.dropTime = dropTime;
	}

	public int getSeatsAllocated() {
		return seatsAllocated;
	}

	public void setSeatsAllocated(int seatsAllocated) {
		this.seatsAllocated = seatsAllocated;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((vehicle == null) ? 0 : vehicle.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ride other = (Ride) obj;
		if (vehicle == null) {
			if (other.vehicle != null)
				return false;
		} else if (!vehicle.equals(other.vehicle))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Ride [route=" + route + ", vehicle=" + vehicle + ", pickupTime=" + pickupTime + ", dropTime=" + dropTime
				+ ", seatsAllocated=" + seatsAllocated + "]";
	}

	public Ride(Vehicle vehicle, Route route, LocalTime pickupTime, LocalTime dropTime, int seatsAllocated) {
		super();
		this.route = route;
		this.vehicle = vehicle;
		this.pickupTime = pickupTime;
		this.dropTime = dropTime;
		this.seatsAllocated = seatsAllocated;
	}

}
