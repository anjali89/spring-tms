package com.sapient.tms.controller.db.ride;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sapient.tms.helper.EmployeeData;
import com.sapient.tms.helper.RideData;
import com.sapient.tms.model.bean.Employee;
import com.sapient.tms.model.bean.Ride;
import com.sapient.tms.model.bl.CentralLogic;
import com.sapient.tms.model.bl.EmployeeLogic;
import com.sapient.tms.model.bl.RideLogic;

/**
 * Servlet implementation class UpdateRideServlet
 */
public class UpdateRideServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CentralLogic rideLogic;
	private RideData rideData;
	//private CentralLogic rideLogic;

	public UpdateRideServlet() {
		super();
		rideData = new RideData();
		rideLogic = new CentralLogic();
	//rideLogic=new CentralLogic();
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
			String vehicleId = request.getParameter("id");
			rideData.createRide(request);
			Ride newRide = rideData.getRide();
			check = rideLogic.updateRide(vehicleId, newRide);
			if (check) {
				request.getRequestDispatcher("./db/ride/UpdateRideSuccessful.jsp").forward(request, response);
			} else {
				request.setAttribute("err", "Entry Not Found");
				request.getRequestDispatcher("./db/ride/UpdateRideFailed.jsp").forward(request, response);
			}
		} catch (ClassNotFoundException | SQLException e) {
			request.setAttribute("err", e.toString());
			request.getRequestDispatcher("./db/ride/UpdateRideFailed.jsp").forward(request, response);
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
