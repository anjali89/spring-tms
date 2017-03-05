package com.sapient.tms.controller.db.vehicle;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sapient.tms.model.bean.Vehicle;
import com.sapient.tms.model.bl.VehicleLogic;

/**
 * Servlet implementation class SearchVehicleServlet
 */
public class SearchVehicleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private VehicleLogic vehicleLogic;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchVehicleServlet() {
        super();
        vehicleLogic = new VehicleLogic();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			PrintWriter pw = response.getWriter();
			String vehicleId = request.getParameter("id");
			Vehicle vehicle = vehicleLogic.search(vehicleId);
			if (vehicle != null) {
				request.setAttribute("vehicle", vehicle);
				request.getRequestDispatcher("./db/vehicle/SearchVehicleSuccessful.jsp").forward(request, response);
			} else {
				request.setAttribute("err", "Entry Not Found");
				request.getRequestDispatcher("./db/vehicle/SearchVehicleFailed.jsp").forward(request, response);
			}
		}
		catch (ClassNotFoundException | SQLException e) {
			request.setAttribute("err", e.toString());
			request.getRequestDispatcher("./SearchVehicleFailed.jsp").forward(request, response);
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
