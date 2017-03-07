package com.sapient.tms.controller.db.route;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sapient.tms.helper.RouteData;
import com.sapient.tms.model.bean.Route;
import com.sapient.tms.model.bl.CentralLogic;
import com.sapient.tms.model.bl.DropLogic;

/**
 * Servlet implementation class UpdateRouteServlet
 */
public class UpdateRouteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private RouteData routeData;
	private CentralLogic centralLogic;
	private DropLogic dropLogic;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateRouteServlet() {
        super();
        routeData=new RouteData();
        centralLogic=new CentralLogic();
        dropLogic=new DropLogic();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			routeData.createRoute(request);
		Route route = routeData.getRoute();
			boolean check=centralLogic.updateRoute(id,route);
			//boolean checkMap=centralLogic.updateRouteMapping(dropId, routeId);
			if(!check)
			{
				request.setAttribute("err", "Operation failed");
				request.getRequestDispatcher("./db/route/UpdateRouteFailed.jsp").forward(request, response);
			}
			else
				request.getRequestDispatcher("./db/route/UpdateRouteSuccessful.jsp").forward(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
