package com.sapient.tms.model.bean;

public class Employee {
	private int id;
	private String password;
	private String name;
	private Ride ride;
	private boolean isAdmin;

	public Employee(int id, String pass, String name, Ride ride, boolean isAdmin) {
		super();
		this.id = id;
		this.password = pass;
		this.name = name;
		this.ride = ride;
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

	public Ride getRide() {
		return ride;
	}

	public void setRide(Ride ride) {
		this.ride = ride;
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
		return "Employee [id=" + id + ", password=" + password + ", name=" + name + ", ride=" + ride + ", isAdmin="
				+ isAdmin + "]";
	}

}
