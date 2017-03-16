package com.sapient.tms.model.bean;

public class Vehicle {
	private String id;
	private String modelName;
	private String brandName;
	private int capacity;

	public Vehicle() {

	}

	public Vehicle(String id, String modelName, String brandName, int capacity) {
		super();
		this.id = id;
		this.modelName = modelName;
		this.brandName = brandName;
		this.capacity = capacity;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public String getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Vehicle [id=" + id + ", modelName=" + modelName + ", brandName=" + brandName + ", capacity=" + capacity
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Vehicle other = (Vehicle) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
