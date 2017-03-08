package com.sapient.tms.controller.db.employee;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sapient.tms.model.bean.Employee;
import com.sapient.tms.model.bean.Vehicle;
import com.sapient.tms.model.bl.CentralLogic;

/**
 * Servlet implementation class DisplayAllEmployeesServlet
 */
public class DisplayAllEmployeesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CentralLogic centralLogic;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DisplayAllEmployeesServlet() {
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
			List<Employee> employees = centralLogic.displayAllEmployees();
			if (employees != null) {
				request.setAttribute("employees", employees);
				request.getRequestDispatcher("./db/employee/DisplayAllEmployeeSuccessful.jsp").forward(request,
						response);
			} else {
				request.setAttribute("err", "Operation failed");
				request.getRequestDispatcher("./db/employee/DisplayAllEmployeeFailed.jsp").forward(request, response);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			request.setAttribute("err", e.toString());
			request.getRequestDispatcher("./db/employee/DisplayAllEmployeeFailed.jsp").forward(request, response);
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
