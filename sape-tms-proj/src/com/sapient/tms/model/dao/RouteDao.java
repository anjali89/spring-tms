package com.sapient.tms.model.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.sapient.tms.model.bean.Route;

public interface RouteDao {
	public Route search(int routeId) throws IOException, ClassNotFoundException, SQLException;

	public boolean delete(int employeeId) throws IOException, ClassNotFoundException, SQLException;

	public boolean update(int employeeId, Route newEmployee) throws IOException, ClassNotFoundException, SQLException;

	public boolean insert(Route employee) throws IOException, ClassNotFoundException, SQLException;

	public List<Route> displayAll() throws IOException, ClassNotFoundException, SQLException;

	public int getMaxId() throws IOException, ClassNotFoundException, SQLException;
}
