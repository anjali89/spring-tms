package com.sapient.tms.controller.db.request;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sapient.tms.model.bean.Request;
import com.sapient.tms.model.bl.CentralLogic;

/**
 * Servlet implementation class ViewRequestsServlet
 */
public class ViewRequestsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CentralLogic centralLogic;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewRequestsServlet() {
        super();
        centralLogic = new CentralLogic();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			List<Request> requests = centralLogic.displayAllRequests();
			if (requests != null) {
				request.setAttribute("requests", requests);
				request.getRequestDispatcher("./db/request/ViewRequestsSuccessful.jsp").forward(request, response);
			} else {
				request.setAttribute("status", "Operation failed");
				request.getRequestDispatcher("./db/request/ViewRequestsFailed.jsp").forward(request, response);
			}
		}
		catch (ClassNotFoundException | SQLException e) {
			request.setAttribute("status", e.toString());
			request.getRequestDispatcher("./db/request/ViewRequestsFailed.jsp").forward(request, response);
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
