package com.sapient.tms.controller.db.ride;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sapient.tms.helper.RideData;
import com.sapient.tms.model.bean.Ride;
import com.sapient.tms.model.bean.Vehicle;
import com.sapient.tms.model.bl.CentralLogic;
import com.sapient.tms.model.bl.RideLogic;

/**
 * Servlet implementation class InsertRideServlet
 */
public class InsertRideServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CentralLogic rideLogic;
	private RideData rideData;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertRideServlet() {
        super();
        rideLogic = new CentralLogic(); 
        rideData= new RideData();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			PrintWriter pw = response.getWriter();
			boolean check = false;
			rideData.createRide(request);
			Ride ride = rideData.getRide();
			check = rideLogic.insertRide(ride);
			if (check) {
				request.getRequestDispatcher("./db/ride/InsertRideSuccessful.jsp").forward(request, response);
			} else {
				request.setAttribute("err", "Operation Failed");
				request.getRequestDispatcher("./db/ride/InsertRideFailed.jsp").forward(request, response);
			}
		}
		catch (ClassNotFoundException | SQLException e) {
			request.setAttribute("err", e.toString());
			request.getRequestDispatcher("./db/ride/InsertRideFailed.jsp").forward(request, response);
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
