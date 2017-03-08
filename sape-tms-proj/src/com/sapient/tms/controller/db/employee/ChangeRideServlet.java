package com.sapient.tms.controller.db.employee;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sapient.tms.helper.EmployeeData;
import com.sapient.tms.model.bean.Employee;
import com.sapient.tms.model.bean.Ride;
import com.sapient.tms.model.bl.CentralLogic;


public class ChangeRideServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CentralLogic centralLogic;
	EmployeeData employeeData;

    
    public ChangeRideServlet() {
        super();
        centralLogic=new CentralLogic();
        employeeData=new EmployeeData();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			boolean check = false;
			//int employeeId = Integer.parseInt(request.getParameter("id"));
			HttpSession session = request.getSession(false);
			Employee emp=(Employee)session.getAttribute("user");
			String vehicleId=request.getParameter("vehicleId");
			Ride rideObj=centralLogic.searchRideByVehicleId(vehicleId);
			emp.setRide(rideObj);
			check = centralLogic.updateEmployee(emp.getId(), emp);
			if(check)
			{
				request.setAttribute("status", "Operation successful");
				request.getRequestDispatcher("./AdminHomeView.jsp").forward(request, response);
			}
			else{
				request.setAttribute("status", "Operation failed");
			request.getRequestDispatcher("./AdminHomeView.jsp").forward(request, response);
			}
		}
		catch (ClassNotFoundException | SQLException e) {
			request.setAttribute("status", "Operation failed");
			request.getRequestDispatcher("./AdminHomeView.jsp").forward(request, response);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		doGet(request, response);
	}

}
