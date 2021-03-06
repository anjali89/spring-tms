package com.sapient.tms.controller.db.ride;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

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
 * Servlet implementation class SearchRideServlet
 */
public class SearchRideServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CentralLogic centralLogic;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchRideServlet() {
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
			PrintWriter pw = response.getWriter();
			String vehicleId = request.getParameter("id");
			Ride ride = centralLogic.searchRideByVehicleId(vehicleId);
			if (ride != null) {
				request.setAttribute("ride", ride);
				request.getRequestDispatcher("./db/ride/SearchRideSuccessful.jsp").forward(request, response);
			} else {
				request.setAttribute("err", "Entry Not Found");
				request.getRequestDispatcher("./db/ride/SearchRideFailed.jsp").forward(request, response);
			}
		}

		catch (ClassNotFoundException | SQLException e) {
			request.setAttribute("err", e.toString());
			request.getRequestDispatcher("./db/ride/SearchRideFailed.jsp").forward(request, response);
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
