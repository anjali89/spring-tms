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
 * Servlet implementation class UpdateVehicleServlet
 */
public class UpdateVehicleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private VehicleLogic vehicleLogic;
    private VehicleData vehicleData;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateVehicleServlet() {
        super();
        vehicleData = new VehicleData();
        vehicleLogic = new VehicleLogic();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			PrintWriter pw = response.getWriter();
			boolean check = false;
			String vehicleId = request.getParameter("id");
			vehicleData.createVehicle(request);
			Vehicle newVehicle = vehicleData.getVehicle();
			check = vehicleLogic.update(vehicleId, newVehicle);
			if (check) {
				request.getRequestDispatcher("./db/vehicle/UpdateVehicleSuccessful.jsp").forward(request, response);
			} else {
				request.setAttribute("err", "Operation Failed");
				request.getRequestDispatcher("./db/vehicle/UpdateVehicleFailed.jsp").forward(request, response);
			}
		}
		catch (ClassNotFoundException | SQLException e) {
			request.setAttribute("err", e.toString());
			request.getRequestDispatcher("./UpdateVehicleFailed.jsp").forward(request, response);
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
