package com.sapient.tms.model.bean;

public class Request {
	private static final String REQUEST_REJECTED = "REJECTED";
	private static final String REQUEST_PENDING = "PENDING";
	private static final String REQUEST_ACCEPTED = "ACCEPTED";
	
	private Employee employee;
	private String status;

	public Request(Employee employee, String status) {
		this.employee = employee;
		this.status = status;
	}

	public Employee getEmployee() {
		return employee;
	}
	
	public String getStatus() {
		return status;
	}

	private void setStatus(String status) {
		this.status = status;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((employee == null) ? 0 : employee.hashCode());
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
		if (employee == null) {
			if (other.employee != null)
				return false;
		} else if (!employee.equals(other.employee))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Request [employee=" + employee + ", status=" + status + "]";
	}

	public void reject() {
		this.setStatus(REQUEST_REJECTED);
	}

	public void initiate() {
		this.setStatus(REQUEST_PENDING);
	}
	
	public void accept() {
		this.setStatus(REQUEST_ACCEPTED);
	}

	public boolean isPending() {
		return this.status.equals(REQUEST_PENDING);
	}

	public boolean isRejected() {
		return this.status.equals(REQUEST_REJECTED);
	}
	
	public boolean isAccepted() {
		return this.status.equals(REQUEST_ACCEPTED);
	}

}
