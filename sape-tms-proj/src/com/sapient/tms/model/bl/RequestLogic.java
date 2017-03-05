package com.sapient.tms.model.bl;

import com.sapient.tms.model.dao.RequestDaoImpl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.sapient.tms.model.bean.Request;
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

	public boolean contains(int requestId) throws ClassNotFoundException, IOException, SQLException {
		return requestDao.searchByRequestId(requestId) != null;
	}

	public Request searchByRequestId(int requestId) throws ClassNotFoundException, IOException, SQLException {
		return requestDao.searchByRequestId(requestId);
	}

	public boolean deleteByRequestId(int requestId) throws ClassNotFoundException, IOException, SQLException {
		return requestDao.deleteByRequestId(requestId);
	}

	public boolean updateByRequestId(int requestId, Request request)
			throws ClassNotFoundException, IOException, SQLException {
		return requestDao.updateByRequestId(requestId, request);
	}

	public boolean createNewRequest(int employeeId, String vehicleId)
			throws ClassNotFoundException, SQLException, IOException {
		int id = requestDao.getMaxId() + 1;
		Request request = new Request(id, employeeId, vehicleId, null);
		request.initiate();
		return requestDao.insert(request);
	}

	public Request searchByEmployeeId(int employeeId) throws ClassNotFoundException, IOException, SQLException {
		return requestDao.searchByEmployeeId(employeeId);
	}

	public int getMaxId() throws ClassNotFoundException, SQLException {
		return requestDao.getMaxId();
	}

	public boolean deleteByEmployeeId(int employeeId) throws ClassNotFoundException, IOException, SQLException {
		return requestDao.deleteByEmployeeId(employeeId);
	}

}
