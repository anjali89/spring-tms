package com.sapient.tms.model.bl;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import com.sapient.tms.model.bean.Drop;
import com.sapient.tms.model.bean.Employee;
import com.sapient.tms.model.bean.Request;
import com.sapient.tms.model.bean.Ride;
import com.sapient.tms.model.bean.Route;
import com.sapient.tms.model.bean.Vehicle;
import com.sapient.tms.helper.DropList;

public class CentralLogic {

	private EmployeeLogic employeeLogic;
	private RequestLogic requestLogic;
	private RouteLogic routeLogic;
	private RouteMappingLogic routeMappingLogic;
	private DropLogic dropLogic;
	private VehicleLogic vehicleLogic;
	private RideLogic rideLogic;

	public CentralLogic() {
		employeeLogic = new EmployeeLogic();
		requestLogic = new RequestLogic();
		routeLogic = new RouteLogic();
		routeMappingLogic = new RouteMappingLogic();
		dropLogic = new DropLogic();
		rideLogic = new RideLogic();
		vehicleLogic = new VehicleLogic();
	}

	public boolean insertRoute(Route route) throws ClassNotFoundException, IOException, SQLException {
		return routeLogic.insert(route) && insertRouteMappings(route);
	}

	public Employee searchEmployee(int employeeId) throws ClassNotFoundException, IOException, SQLException {
		Employee employee = employeeLogic.search(employeeId);
		if(employee != null) {
			Ride ride = employee.getRide();
			ride = searchRideByVehicleId(ride.getVehicle().getId());
			employee.setRide(ride);
		}
		return employee;
	}

	public boolean insertEmployee(Employee employee) throws ClassNotFoundException, IOException, SQLException {
		return employeeLogic.insert(employee);
	}

	public List<Request> displayAllRequests() throws ClassNotFoundException, IOException, SQLException {
		List<Request> requests = requestLogic.displayAll();
		for(int i = 0; i < requests.size(); i++) {
			Request request = requests.get(i);
			requests.set(i, searchRequestByEmployeeId(request.getEmployee().getId()));
		}
		return requests;
	}

//public List<Employee> viewAllRideEmployees(int rideId) throws ClassNotFoundException, IOException, SQLException {
	//		return employeeLogic.displayAllByRide(rideId);
	//}

	public boolean isValidRequestStatus(String requestStatus) {
		return requestLogic.isValidStatus(requestStatus);
	}

	public boolean isValidRequestId(String requestIdString) {
		return requestLogic.isValidId(requestIdString);
	}

	public boolean updateEmployee(int id, Employee loggedEmployee)
			throws ClassNotFoundException, IOException, SQLException {
		return employeeLogic.update(id, loggedEmployee);

	}

	// test
	public Route searchRoute(int routeId) throws ClassNotFoundException, IOException, SQLException {
		Route route = routeLogic.search(routeId);
		route.setDropList(searchRouteMappings(route));
		return route;
	}

	// test
	public boolean updateRoute(int routeId, Route route) throws ClassNotFoundException, IOException, SQLException {

		return routeLogic.update(routeId, route);
	}
	
	public boolean updateRouteMapping(int dropId,int routeId) throws ClassNotFoundException, IOException, SQLException{
		return routeMappingLogic.update(dropId, routeId);
	}
	
	public List<Route> displayAllRoutes() throws ClassNotFoundException, IOException, SQLException {
		List<Route> routes = routeLogic.displayAll();
		for (Route route : routes) {
			DropList dropList = searchRouteMappings(route);
			route.setDropList(dropList);
		}
		return routes;
	}

	public boolean createNewRequest(Employee employee) throws ClassNotFoundException, SQLException, IOException {
		return requestLogic.createNewRequest(employee);
	}

	private boolean insertRouteMappings(Route route) throws ClassNotFoundException, IOException, SQLException {
		int routeId = route.getId();
		DropList dropList = route.getDropList();
		for (Drop drop : dropList.getDrops()) {
			int dropId = drop.getId();
			boolean success = routeMappingLogic.insert(routeId, dropId);
			if (!success)
				return false;
		}
		return true;
	}

	public DropList searchRouteMappings(Route route) throws ClassNotFoundException, IOException, SQLException {
		int routeId = route.getId();
		List<Integer> drops = routeMappingLogic.search(routeId);
		DropList dropList = new DropList();
		for (Integer dropId : drops) {
			Drop drop = searchDrop(dropId);
			dropList.add(drop);
		}
		return dropList;
	}

	public Request searchRequestByEmployeeId(int employeeId) throws ClassNotFoundException, IOException, SQLException {
		Request request = requestLogic.searchByEmployeeId(employeeId);
		if(request != null) {
			request.setEmployee(searchEmployee(request.getEmployee().getId()));
		}
		return request;
	}

	public boolean deleteRouteMappings(Route route) throws ClassNotFoundException, IOException, SQLException {
		return routeMappingLogic.delete(route.getId());
	}

	public boolean deleteRouteMappingsByDrop(Drop drop) throws ClassNotFoundException, IOException, SQLException {
		return routeMappingLogic.deleteByDrop(drop.getId());
	}

	public Drop searchDrop(int dropId) throws ClassNotFoundException, IOException, SQLException {
		return dropLogic.search(dropId);
	}

	public int getMaxRouteId() throws ClassNotFoundException, IOException, SQLException {
		return routeLogic.getMaxId();
	}

	public int getMaxRequestId() throws ClassNotFoundException, IOException, SQLException {
		return routeLogic.getMaxId();
	}

	public int getMaxDropId() throws ClassNotFoundException, SQLException {
		return dropLogic.getMaxId();
	}

	public boolean isRideNotEmpty(int routeId) throws ClassNotFoundException, SQLException {
		return employeeLogic.isAnyEmployeeAssignedToRide(routeId);
	}

	public boolean insertRide(Ride ride) throws IOException, ClassNotFoundException, SQLException {
		return rideLogic.insert(ride);
	}

	public boolean deleteRideByVehicleId(String vehicleId) throws IOException, ClassNotFoundException, SQLException {
		return rideLogic.deleteByVehicleId(vehicleId);
	}

	public boolean updateRide(String vehicleId, Ride newRide) throws IOException, ClassNotFoundException, SQLException {
		return rideLogic.update(vehicleId, newRide);
	}

	public Ride searchRideByVehicleId(String vehicleId) throws IOException, ClassNotFoundException, SQLException {
		Ride ride = rideLogic.searchByVehicleId(vehicleId);
		if(ride != null) {
			Route route = ride.getRoute();
			route = searchRoute(route.getId());
			Vehicle vehicle = ride.getVehicle();
			vehicle = searchVehicle(vehicle.getId());
			ride.setRoute(route);
			ride.setVehicle(vehicle);
		}
		return ride;
	}

	public List<Ride> searchRideByRouteId(int routeId) throws IOException, ClassNotFoundException, SQLException {
		List<Ride> rides = rideLogic.searchByRouteId(routeId);
		for (Ride ride : rides) {
			Route route = ride.getRoute();
			route = searchRoute(route.getId());
			Vehicle vehicle = ride.getVehicle();
			vehicle = searchVehicle(vehicle.getId());
			ride.setRoute(route);
			ride.setVehicle(vehicle);
		}
		return rides;
	}

	public List<Ride> searchRideByPickupTime(LocalTime pickupTime)
			throws IOException, ClassNotFoundException, SQLException {
		List<Ride> rides = rideLogic.searchByPickupTime(pickupTime);
		for (Ride ride : rides) {
			Route route = ride.getRoute();
			route = searchRoute(route.getId());
			Vehicle vehicle = ride.getVehicle();
			vehicle = searchVehicle(vehicle.getId());
			ride.setRoute(route);
			ride.setVehicle(vehicle);
		}
		return rides;
	}

	public List<Ride> searchRideByDropTime(LocalTime dropTime)
			throws IOException, ClassNotFoundException, SQLException {
		List<Ride> rides = rideLogic.searchByDropTime(dropTime);
		for (Ride ride : rides) {
			Route route = ride.getRoute();
			route = searchRoute(route.getId());
			Vehicle vehicle = ride.getVehicle();
			vehicle = searchVehicle(vehicle.getId());
			ride.setRoute(route);
			ride.setVehicle(vehicle);
		}
		return rides;
	}

	public List<Ride> displayAllRides() throws IOException, ClassNotFoundException, SQLException {
		List<Ride> rides = rideLogic.displayAll();
		for (Ride ride : rides) {
			Route route = ride.getRoute();
			route = searchRoute(route.getId());
			Vehicle vehicle = ride.getVehicle();
			vehicle = searchVehicle(vehicle.getId());
			ride.setRoute(route);
			ride.setVehicle(vehicle);
		}
		return rides;
	}

	public boolean insertDrop(Drop drop) throws IOException, ClassNotFoundException, SQLException {
		return dropLogic.insert(drop);
	}

	public List<Drop> displayAllDrops() throws IOException, ClassNotFoundException, SQLException {
		return dropLogic.displayAll();
	}

	public boolean deleteDrop(int dropId) throws IOException, ClassNotFoundException, SQLException {
		return dropLogic.delete(dropId);
	}

	public boolean deleteEmployee(int employeeId) throws IOException, ClassNotFoundException, SQLException {
		return employeeLogic.delete(employeeId);
	}

	public boolean isAnyEmployeeAssignedToRide(int rideId) throws ClassNotFoundException, SQLException {
		return employeeLogic.isAnyEmployeeAssignedToRide(rideId);
	}

	public List<Employee> displayAllEmployeesByRide(int rideId)
			throws IOException, ClassNotFoundException, SQLException {
		List<Employee> employees = employeeLogic.displayAllByRide(rideId);
		for(int i = 0; i < employees.size(); i++) {
			Employee oldEmployee = employees.get(i);
			Employee newEmployee = searchEmployee(oldEmployee.getId());
			employees.set(i, newEmployee);
		}
		return employees;
	}
	
	public List<Employee> displayAllEmployees()
			throws IOException, ClassNotFoundException, SQLException {
		List<Employee> employees = employeeLogic.displayAll();
		for(int i = 0; i < employees.size(); i++) {
			Employee oldEmployee = employees.get(i);
			Employee newEmployee = searchEmployee(oldEmployee.getId());
			employees.set(i, newEmployee);
		}
		return employees;
	}

	public boolean deleteRequestByEmployeeId(int employeeId) throws IOException, ClassNotFoundException, SQLException {
		return requestLogic.deleteByEmployeeId(employeeId);
	}

	public boolean insertVehicle(Vehicle vehicle) throws IOException, ClassNotFoundException, SQLException {
		return vehicleLogic.insert(vehicle);
	}

	public boolean deleteVehicle(String vehicleId) throws IOException, ClassNotFoundException, SQLException {
		return vehicleLogic.delete(vehicleId);
	}

	public boolean updateVehicle(String vehicleId, Vehicle newVehicle)
			throws IOException, ClassNotFoundException, SQLException {
		return vehicleLogic.update(vehicleId, newVehicle);
	}

	public Vehicle searchVehicle(String vehicleId) throws IOException, ClassNotFoundException, SQLException {
		return vehicleLogic.search(vehicleId);
	}

	public List<Vehicle> displayAllVehicles() throws IOException, ClassNotFoundException, SQLException {
		return vehicleLogic.displayAll();
	}

	public List<Ride> displayAllAvailableRides() throws ClassNotFoundException, IOException, SQLException {
		List<Ride> rides = new ArrayList<>();
		for (Ride ride : rideLogic.displayAll()) {
			ride.setVehicle(searchVehicle(ride.getVehicle().getId()));
			ride.setRoute(searchRoute(ride.getRoute().getId()));
			if (ride.getSeatsAllocated() < ride.getVehicle().getCapacity()) {
				rides.add(ride);
			}
		}
		return rides;
	}
	
	public boolean updateRequestByEmployeeId(int employeeId, Request request) throws ClassNotFoundException, IOException, SQLException {
		return requestLogic.updateByEmployeeId(employeeId, request);
	}

}
