package com.sapient.tms.model.bl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import com.sapient.tms.model.dao.RouteMappingDao;
import com.sapient.tms.model.dao.RouteMappingDaoImpl;

public class RouteMappingLogic {

	private RouteMappingDao routeMappingDao = new RouteMappingDaoImpl();

	public List<Integer> search(int routeId) throws IOException, ClassNotFoundException, SQLException {
		return routeMappingDao.search(routeId);
	}

	public boolean insert(int routeId, int dropId) throws IOException, ClassNotFoundException, SQLException {
		return routeMappingDao.insert(routeId, dropId);
	}

	public HashMap<Integer, List<Integer>> displayAll() throws IOException, ClassNotFoundException, SQLException {
		return routeMappingDao.displayAll();
	}

	public boolean delete(int id) throws IOException, ClassNotFoundException, SQLException {
		return routeMappingDao.delete(id);
	}

	public boolean deleteByDrop(int dropId) throws ClassNotFoundException, SQLException {
		return routeMappingDao.deleteByDrop(dropId);
	}
	public boolean update(int dropId, int routeId) throws IOException, ClassNotFoundException, SQLException{
		return routeMappingDao.update(dropId, routeId);
	}
}
