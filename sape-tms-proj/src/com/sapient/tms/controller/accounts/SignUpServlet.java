package com.sapient.tms.controller.accounts;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sapient.tms.helper.EmployeeData;
import com.sapient.tms.model.bean.Employee;
import com.sapient.tms.model.bean.Ride;
import com.sapient.tms.model.bl.CentralLogic;
import com.sapient.tms.model.bl.EmployeeLogic;

/**
 * Servlet implementation class SignUpServlet
 */
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmployeeData employeeData;
	private CentralLogic centralLogic;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUpServlet() {
        super();
        employeeData = new EmployeeData();
        centralLogic = new CentralLogic();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			employeeData.createEmployee(request);
			Employee employee = employeeData.getEmployee();
			boolean isSuccessful = centralLogic.createNewRequest(employee);
			if(!isSuccessful) {
				request.setAttribute("status", "Sign Up failed");
				request.getRequestDispatcher("./HomeView.jsp").forward(request, response);
			}
			else {
				isSuccessful = centralLogic.insertEmployee(employee);
				if(!isSuccessful) {
					centralLogic.deleteRequestByEmployeeId(employee.getId());
					request.setAttribute("status", "Sign Up failed");
					request.getRequestDispatcher("./HomeView.jsp").forward(request, response);
				}
				else {
					Ride ride = employee.getRide();
					ride.setSeatsAllocated(ride.getSeatsAllocated() + 1);
					request.setAttribute("status", "Your request is pending.");
					request.getRequestDispatcher("./HomeView.jsp").forward(request, response);
				}
			}
		} catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			request.setAttribute("status", "Error.");
			request.getRequestDispatcher("./HomeView.jsp").forward(request, response);
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
