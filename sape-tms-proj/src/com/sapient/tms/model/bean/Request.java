package com.sapient.tms.model.bean;

public class Request {
	private static final String REQUEST_REJECTED = "REJECTED";
	private static final String REQUEST_PENDING = "PENDING";

	int id;
	int employeeId;
	String vehicleId;
	String status;

	public Request(int id, int empid, String vehicleId, String status) {
		this.id = id;
		this.employeeId = empid;
		this.vehicleId = vehicleId;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getRideId() {
		return vehicleId;
	}

	public void setRideId(String vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + employeeId;
		result = prime * result + id;
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
		Request other = (Request) obj;
		if (employeeId != other.employeeId)
			return false;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Request: \nrequestid=" + id + "\tempid=" + employeeId + "\trideid=" + vehicleId + "\tstatus=" + status
				+ "\n";
	}

	public void reject() {
		this.setStatus(REQUEST_REJECTED);
	}

	public void initiate() {
		this.setStatus(REQUEST_PENDING);
	}

	public boolean isPending() {
		return this.status.equals(REQUEST_PENDING);
	}

	public boolean isRejected() {
		return this.status.equals(REQUEST_REJECTED);
	}

}
