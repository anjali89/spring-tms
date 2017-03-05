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
import com.sapient.tms.model.bl.EmployeeLogic;

/**
 * Servlet implementation class DisplayAllEmployeesServlet
 */
public class DisplayAllEmployeesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmployeeLogic employeeLogic;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DisplayAllEmployeesServlet() {
		super();
		employeeLogic = new EmployeeLogic();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			List<Employee> employees = employeeLogic.displayAll();
			if (employees != null) {
				request.setAttribute("employees", employees);
				request.getRequestDispatcher("./db/employee/DisplayAllEmployeesSuccessful.jsp").forward(request,
						response);
			} else {
				request.setAttribute("err", "Operation failed");
				request.getRequestDispatcher("./db/employee/DisplayAllEmployeesFailed.jsp").forward(request, response);
			}
		} catch (ClassNotFoundException | SQLException e) {
			request.setAttribute("err", e.toString());
			request.getRequestDispatcher("./DisplayAllEmployeesFailed.jsp").forward(request, response);
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
