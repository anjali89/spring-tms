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

	public RouteData() {
		centralLogic = new CentralLogic();
	}

	public void input(HttpServletRequest request) throws ClassNotFoundException, IOException, SQLException {
		String dropName, routeName;
		int dropId, capacity, routeId;
		Drop drop;
		DropList dropList = new DropList();
		Scanner scanner = new java.util.Scanner(System.in);
		routeId = centralLogic.getMaxRouteId() + 1;
		/*
		 * System.out.println("Enter the route id"); routeId = scanner
		 * .nextInt();
		 */
		System.out.println("Enter the route name: ");
		routeName = scanner.nextLine();
		System.out.println("Enter the route capacity:");
		capacity = scanner.nextInt();
		System.out.println("Enter the no. of drop points:");
		int dropPointCount = scanner.nextInt();
		for (int i = 0; i < dropPointCount; i++) {
			System.out.println("Enter the drop place name " + i + " on the route ");
			dropName = scanner.nextLine();
			System.out.println("Enter the drop id");
			dropId = scanner.nextInt();
			drop = new Drop(dropId, dropName);
			dropList.add(drop);
		}
		route = new Route(routeId, routeName, dropList);
	}

	public Route getRoute() {
		return route;
	}

}
