package com.sapient.tms.controller.accounts;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sapient.tms.helper.EmployeeAuthenticator;
import com.sapient.tms.model.bean.Employee;
import com.sapient.tms.model.bean.Request;
import com.sapient.tms.model.bl.CentralLogic;

/**
 * Servlet implementation class SignInServlet
 */
public class SignInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CentralLogic centralLogic;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SignInServlet() {
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
		boolean isValidEmployee;
		try {
			// Get parameters from request object
			int username = Integer.parseInt(request.getParameter("id"));
			String password = request.getParameter("password");
			// Attempt to authenticate user details
			EmployeeAuthenticator authenticator = new EmployeeAuthenticator();
			Map.Entry<Employee, Boolean> authenticationResult = authenticator.authenticate(username, password);
			isValidEmployee = authenticationResult.getValue();
			// If authentication fails
			if (!isValidEmployee) {
				request.setAttribute("err", "Invalid UserID Or Password");
				request.getRequestDispatcher("accounts/SignInForm.jsp").forward(request, response);
			}
			// If authentication is successful
			else {
				Employee employee = authenticationResult.getKey();
				Request tempRequest = centralLogic.searchRequestByEmployeeId(employee.getId());
				if(tempRequest != null) {
					//Request is still pending
					if(tempRequest.isRejected()) {
						request.setAttribute("err", "Your request has been rejected");
						request.getRequestDispatcher("./accounts/SignInForm.jsp").forward(request, response);
						centralLogic.deleteRequestByEmployeeId(tempRequest.getEmployee().getId());
					}
					//Request is still pending
					else if(tempRequest.isPending()) {
						request.setAttribute("status", "Your request is still pending");
						request.getRequestDispatcher("./accounts/HomeView.jsp").forward(request, response);
					}
					//Request has been accepted
					else {
						request.setAttribute("status", "Your request has been accepted");
						request.getRequestDispatcher("./accounts/HomeView.jsp").forward(request, response);
						centralLogic.deleteRequestByEmployeeId(tempRequest.getEmployee().getId());
						HttpSession session = request.getSession();
						session.setAttribute("user", employee);
						if(!employee.isAdmin()) {
							response.sendRedirect("./EmployeeHomeView.jsp");
						}
						else {
							response.sendRedirect("./AdminHomeView.jsp");
						}
					}
					request.getRequestDispatcher("./HomeView.jsp").forward(request, response);
				}
				else {
					HttpSession session = request.getSession();
					session.setAttribute("user", employee);
					if(!employee.isAdmin()) {
						response.sendRedirect("./EmployeeHomeView.jsp");
					}
					else {
						response.sendRedirect("./AdminHomeView.jsp");
					}
				}
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
