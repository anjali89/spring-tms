package com.sapient.tms.model.bl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.sapient.tms.model.bean.Route;
import com.sapient.tms.model.dao.RouteDao;
import com.sapient.tms.model.dao.RouteDaoImpl;

public class RouteLogic {

	private RouteDao routeDao;

	public RouteLogic() {
		this.routeDao = new RouteDaoImpl();
	}

	public Route search(int routeId) throws ClassNotFoundException, IOException, SQLException {
		return routeDao.search(routeId);
	}

	public boolean update(int routeId, Route route) throws ClassNotFoundException, IOException, SQLException {
		return routeDao.update(routeId, route);
	}

	public boolean delete(int id) throws IOException, ClassNotFoundException, SQLException {
		return routeDao.delete(id);
	}

	public boolean insert(Route route) throws IOException, ClassNotFoundException, SQLException {
		return routeDao.insert(route);
	}

	public List<Route> displayAll() throws IOException, ClassNotFoundException, SQLException {
		return routeDao.displayAll();
	}

	public int getMaxId() throws ClassNotFoundException, IOException, SQLException {
		return routeDao.getMaxId();
	}

}
