package com.sapient.tms.controller.db.vehicle;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sapient.tms.helper.VehicleData;
import com.sapient.tms.model.bean.Vehicle;
import com.sapient.tms.model.bl.VehicleLogic;

/**
 * Servlet implementation class InsertVehicleServlet
 */
public class InsertVehicleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private VehicleLogic vehicleLogic;
	private VehicleData vehicleData;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InsertVehicleServlet() {
		super();
		vehicleData = new VehicleData();
		vehicleLogic = new VehicleLogic();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			PrintWriter pw = response.getWriter();
			boolean check = false;
			vehicleData.createVehicle(request);
			Vehicle vehicle = vehicleData.getVehicle();
			check = vehicleLogic.insert(vehicle);
			if (check) {
				request.getRequestDispatcher("./db/vehicle/InsertVehicleSuccessful.jsp").forward(request, response);
			} else {
				request.setAttribute("err", "Operation Failed");
				request.getRequestDispatcher("./db/vehicle/InsertVehicleFailed.jsp").forward(request, response);
			}
		}
		catch (ClassNotFoundException | SQLException e) {
			request.setAttribute("err", e.toString());
			request.getRequestDispatcher("./InsertVehicleFailed.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}