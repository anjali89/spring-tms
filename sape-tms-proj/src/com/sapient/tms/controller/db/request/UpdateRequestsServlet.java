package com.sapient.tms.controller.db.request;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sapient.tms.model.bean.Request;
import com.sapient.tms.model.bean.Ride;
import com.sapient.tms.model.bl.CentralLogic;

/**
 * Servlet implementation class UpdateRequestsServlet
 */
public class UpdateRequestsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CentralLogic centralLogic;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateRequestsServlet() {
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
			List<Request> requests = centralLogic.displayAllRequests();
			for (Request tempRequest : requests) {
				int employeeId = tempRequest.getEmployee().getId();
				String status = request.getParameter(Integer.toString(employeeId));
				boolean check = false;
				if(status.equalsIgnoreCase("ACCEPTED")) {
					tempRequest.accept();
					check = centralLogic.updateRequestByEmployeeId(employeeId, tempRequest);
					if(!check) {
						request.setAttribute("status", "Update failed");
						request.getRequestDispatcher("./AdminHomeView.jsp").forward(request, response);
						return;
					}
					
				}
				else if(status.equalsIgnoreCase("REJECTED")) {
					tempRequest.reject();
					check = centralLogic.updateRequestByEmployeeId(employeeId, tempRequest);
					if(!check) {
						request.setAttribute("status", "Update failed");
						request.getRequestDispatcher("./AdminHomeView").forward(request, response);
						return;
					}
				}
				else if(status.equalsIgnoreCase("PENDING")) {
					tempRequest.initiate();
					check = centralLogic.updateRequestByEmployeeId(employeeId, tempRequest);
					if(!check) {
						request.setAttribute("status", "Update failed");
						request.getRequestDispatcher("./AdminHomeView.jsp").forward(request, response);
						return;
					}
				}
				else {
					request.setAttribute("status", "Update failed");
					request.getRequestDispatcher("./AdminHomeView.jsp").forward(request, response);
					return;
				}
			}
			request.setAttribute("status", "Updates successful");
			request.getRequestDispatcher("./AdminHomeView.jsp").forward(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			request.setAttribute("status", "Update failed");
			request.getRequestDispatcher("./AdminHomeView.jsp").forward(request, response);
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
