package com.sapient.tms.controller.db.ride;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sapient.tms.model.bl.CentralLogic;
import com.sapient.tms.model.bl.RideLogic;

/**
 * Servlet implementation class DeleteRideServlet
 */
public class DeleteRideServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CentralLogic rideLogic;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteRideServlet() {
        super();
         rideLogic = new CentralLogic(); 
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		try {
			PrintWriter pw = response.getWriter();
			String vehicleId = request.getParameter("vehicleId");
			boolean success = rideLogic.deleteRideByVehicleId(vehicleId);
			if (success) {
				request.getRequestDispatcher("./db/ride/DeleteRideSuccessful.jsp").forward(request, response);
			} else {
				request.setAttribute("err", "Entry Not Found");
				request.getRequestDispatcher("./db/ride/DeleteRideFailed.jsp").forward(request, response);
			}
		}
		catch (ClassNotFoundException | SQLException e) {
			request.setAttribute("err", e.toString());
			request.getRequestDispatcher("./db/ride/DeleteRideFailed.jsp").forward(request, response);
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
