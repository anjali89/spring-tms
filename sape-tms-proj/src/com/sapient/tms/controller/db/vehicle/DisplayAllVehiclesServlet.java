package com.sapient.tms.controller.db.vehicle;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sapient.tms.model.bean.Vehicle;
import com.sapient.tms.model.bl.VehicleLogic;

/**
 * Servlet implementation class DisplayAllVehiclesServlet
 */
public class DisplayAllVehiclesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private VehicleLogic vehicleLogic;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayAllVehiclesServlet() {
        super();
        vehicleLogic = new VehicleLogic();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			List<Vehicle> vehicles = vehicleLogic.displayAll();
			if (vehicles != null) {
				request.setAttribute("vehicles", vehicles);
				request.getRequestDispatcher("./db/vehicle/DisplayAllVehiclesSuccessful.jsp").forward(request, response);
			} else {
				request.setAttribute("err", "Operation failed");
				request.getRequestDispatcher("./db/vehicle/DisplayAllVehiclesFailed.jsp").forward(request, response);
			}
		}
		catch (ClassNotFoundException | SQLException e) {
			request.setAttribute("err", e.toString());
			request.getRequestDispatcher("./DisplayAllVehiclesFailed.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
