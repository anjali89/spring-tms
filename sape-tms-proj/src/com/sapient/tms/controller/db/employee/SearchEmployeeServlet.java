package com.sapient.tms.controller.db.employee;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sapient.tms.model.bean.Employee;
import com.sapient.tms.model.bean.Vehicle;
import com.sapient.tms.model.bl.EmployeeLogic;
import com.sapient.tms.model.bl.VehicleLogic;

/**
 * Servlet implementation class SearchEmployeeServlet
 */
public class SearchEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmployeeLogic employeeLogic;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchEmployeeServlet() {
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
			PrintWriter pw = response.getWriter();
			int employeeId = Integer.parseInt(request.getParameter("id"));
			Employee employee = employeeLogic.search(employeeId);
			if (employee != null) {
				request.setAttribute("employee", employee);
				request.getRequestDispatcher("./db/employee/SearchEmployeeSuccessful.jsp").forward(request, response);
			} else {
				request.setAttribute("err", "Entry Not Found");
				request.getRequestDispatcher("./db/employee/SearchEmployeeFailed.jsp").forward(request, response);
			}
		}

		catch (ClassNotFoundException | SQLException e) {
			request.setAttribute("err", e.toString());
			request.getRequestDispatcher("./SearchEmployeeFailed.jsp").forward(request, response);
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
