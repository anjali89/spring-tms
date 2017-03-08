package com.sapient.tms.controller.db.ride;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sapient.tms.model.bean.Employee;
import com.sapient.tms.model.bean.Ride;
import com.sapient.tms.model.bl.CentralLogic;
import com.sapient.tms.model.bl.EmployeeLogic;
import com.sapient.tms.model.bl.RideLogic;

/**
 * Servlet implementation class DisplayAllRidesServlet
 */
public class DisplayAllRidesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CentralLogic centralLogic;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DisplayAllRidesServlet() {
		super();
		centralLogic = new CentralLogic();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			List<Ride> rides = centralLogic.displayAllRides();
			if (rides != null) {
				request.setAttribute("rides", rides);
				request.getRequestDispatcher("./db/ride/DisplayAllRidesSuccessful.jsp").forward(request, response);
			} else {
				request.setAttribute("err", "Operation failed");
				request.getRequestDispatcher("./db/ride/DisplayAllRidesFailed.jsp").forward(request, response);
			}
		} catch (ClassNotFoundException | SQLException e) {
			request.setAttribute("err", e.toString());
			request.getRequestDispatcher("./db/ride/DisplayAllRidesFailed.jsp").forward(request, response);
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
