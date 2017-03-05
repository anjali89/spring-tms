package com.sapient.tms.controller.db.route;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sapient.tms.model.bean.Drop;
import com.sapient.tms.model.bean.Route;
import com.sapient.tms.model.bl.RouteLogic;

/**
 * Servlet implementation class DisplayAllRoutesServlet
 */
public class DisplayAllRoutesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private RouteLogic routeLogic;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayAllRoutesServlet() {
        super();
        routeLogic=new RouteLogic();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			List<Route> route = routeLogic.displayAll();
			if (route != null) {
				request.setAttribute("routes", route);
				request.getRequestDispatcher("./db/route/DisplayAllRoutesSuccessful.jsp").forward(request, response);
			} else {
				request.setAttribute("err", "Operation failed");
				request.getRequestDispatcher("./db/route/DisplayAllRoutesFailed.jsp").forward(request, response);
			}
		}
		catch (ClassNotFoundException | SQLException e) {
			request.setAttribute("err", e.toString());
			request.getRequestDispatcher("./DisplayAllRoutesFailed.jsp").forward(request, response);
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
