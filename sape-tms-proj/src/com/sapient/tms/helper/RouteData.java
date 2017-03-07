package com.sapient.tms.helper;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import javax.servlet.http.HttpServletRequest;

import com.sapient.tms.model.bean.Drop;
import com.sapient.tms.model.bean.Route;
import com.sapient.tms.model.bl.CentralLogic;

public class RouteData {

	private Route route;
	private CentralLogic centralLogic;
	private Drop drop;

	private DropList dropList;
	private int routeId, id, seats, capacity, dropId;
	private String name, dropName;

	public RouteData() {
		centralLogic = new CentralLogic();
		dropList = new DropList();

	}


	public void createRoute(HttpServletRequest request) throws ClassNotFoundException, IOException, SQLException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("routeName");
		String[] checkBox = request.getParameterValues("check");
		DropList dropList = new DropList();
		for (String str : checkBox) {
			int dropId = Integer.parseInt(str);
			Drop drop =centralLogic.searchDrop(dropId);
			dropList.add(drop);
			boolean checkMap=centralLogic.updateRouteMapping(dropId, id);
		}
		System.out.println(dropList);
		route = new Route(id, name, dropList);
	}

	public Route getRoute() {
		return route;
	}

}
