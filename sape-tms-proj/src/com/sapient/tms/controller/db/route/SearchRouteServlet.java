package com.sapient.tms.controller.db.route;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sapient.tms.model.bean.Route;
import com.sapient.tms.model.bl.CentralLogic;

/**
 * Servlet implementation class SearchRouteServlet
 */
public class SearchRouteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CentralLogic centralLogic;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchRouteServlet() {
        super();
        centralLogic = new CentralLogic();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int routeId = Integer.parseInt(request.getParameter("id"));
			Route check = centralLogic.searchRoute(routeId);
			if (check != null){
				request.setAttribute("route", check);
				response.sendRedirect("./db/route/SearchRouteSuccessful").forward(request, response);
			}
				
			else
			{
				request.setAttribute("err", "Operation failed");
				response.sendRedirect("./db/route/SearchRouteFailed").forward(request, response);;
				
			}
				response.sendRedirect("./db/route/SearchRouteFailed").forward(request, response);;
		} catch (Exception e) {
			request.setAttribute("err", e.toString());
			request.getRequestDispatcher("./SearchRouteFailed.jsp").forward(request, response);
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
