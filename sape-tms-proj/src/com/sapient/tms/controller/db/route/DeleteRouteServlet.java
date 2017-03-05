package com.sapient.tms.controller.db.route;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sapient.tms.model.bean.Route;
import com.sapient.tms.model.bl.CentralLogic;
import com.sapient.tms.model.bl.DropLogic;
import com.sapient.tms.model.bl.RouteLogic;

/**
 * Servlet implementation class DeleteRouteServlet
 */
public class DeleteRouteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CentralLogic centralLogic;
	private RouteLogic routeLogic;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteRouteServlet() {
        super();
        centralLogic = new CentralLogic();
		routeLogic = new RouteLogic();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int routeId = Integer.parseInt(request.getParameter("id"));
		
		try {
			Route route = centralLogic.searchRoute(routeId);
			if (route != null) {
				boolean check = routeLogic.delete(routeId);
				if (check)
					response.sendRedirect("./db/route/DeleteRouteSuccessful.jsp").forward(request, response);
				else
				{
					request.setAttribute("err", "Operation failed");
					response.sendRedirect("./db/route/DeleteRouteFailed.jsp").forward(request, response);
				}
				} else{
					request.setAttribute("err", "Operation failed");
			response.sendRedirect("./db/route/DeleteRouteFailed.jsp").forward(request, response);}
		} catch (ClassNotFoundException|SQLException e) {
			request.setAttribute("err", e.toString());
			request.getRequestDispatcher("./DeleteRouteFailed.jsp").forward(request, response);
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
