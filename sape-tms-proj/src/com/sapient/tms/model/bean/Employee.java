package com.sapient.tms.model.bean;

public class Employee {
	private int id;
	private String password;
	private String name;
	private String vehicleId;
	private boolean isAdmin;

	public Employee(int id, String pass, String name, String employeeVehicleId, boolean isAdmin) {
		super();
		this.id = id;
		this.password = pass;
		this.name = name;
		this.vehicleId = employeeVehicleId;
		this.isAdmin = isAdmin;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String pass) {
		this.password = pass;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(String vehicleId) {
		this.vehicleId = vehicleId;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public int getId() {
		return id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		Employee other = (Employee) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", pass=" + password + ", name=" + name + ", rideId=" + vehicleId + ", isAdmin="
				+ isAdmin + "]";
	}

}
