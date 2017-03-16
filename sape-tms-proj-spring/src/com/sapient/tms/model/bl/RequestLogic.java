package com.sapient.tms.model.bl;

import com.sapient.tms.model.dao.RequestDaoImpl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.sapient.tms.model.bean.Employee;
import com.sapient.tms.model.bean.Request;
import com.sapient.tms.model.bean.Ride;
import com.sapient.tms.model.bean.Vehicle;
import com.sapient.tms.model.dao.RequestDao;

public class RequestLogic {

	private RequestDao requestDao;

	public RequestLogic() {
		this.requestDao = new RequestDaoImpl();
	}

	public List<Request> displayAll() throws ClassNotFoundException, IOException, SQLException {
		return requestDao.displayAll();
	}

	public boolean isValidStatus(String requestStatus) {
		requestStatus = requestStatus.toUpperCase();
		if (requestStatus.equals("A") || requestStatus.equals("R"))
			return true;
		return false;
	}

	public boolean isValidId(String requestIdString) {
		return requestIdString.matches("\\d+");
	}

	public boolean createNewRequest(Employee employee)
			throws ClassNotFoundException, SQLException, IOException {
		Request request = new Request(employee, null);
		request.initiate();
		System.out.println(request);
		return requestDao.insert(request);
	}

	public Request searchByEmployeeId(int employeeId) throws ClassNotFoundException, IOException, SQLException {
		return requestDao.searchByEmployeeId(employeeId);
	}

	public boolean deleteByEmployeeId(int employeeId) throws ClassNotFoundException, IOException, SQLException {
		return requestDao.deleteByEmployeeId(employeeId);
	}
	
	public boolean updateByEmployeeId(int id, Request request) throws ClassNotFoundException, IOException, SQLException {
		return requestDao.updateByEmployeeId(id, request);
	}

}
