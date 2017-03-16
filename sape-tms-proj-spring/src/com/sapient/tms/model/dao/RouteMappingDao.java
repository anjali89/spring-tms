package com.sapient.tms.model.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

public interface RouteMappingDao {
	public boolean insert(int routeId, int dropPointId) throws IOException, ClassNotFoundException, SQLException;

	public boolean delete(int routeId) throws IOException, ClassNotFoundException, SQLException;

	public List<Integer> search(int id) throws IOException, ClassNotFoundException, SQLException;

	public HashMap<Integer, List<Integer>> displayAll() throws IOException, ClassNotFoundException, SQLException;

	public boolean deleteByDrop(int dropId) throws SQLException, ClassNotFoundException;
	
	public boolean update(int dropId, int routeId) throws IOException, ClassNotFoundException, SQLException;
}
