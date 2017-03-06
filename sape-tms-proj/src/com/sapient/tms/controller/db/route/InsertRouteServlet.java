package com.sapient.tms.controller.db.route;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sapient.tms.helper.DropList;
import com.sapient.tms.helper.RouteData;
import com.sapient.tms.model.bean.Drop;
import com.sapient.tms.model.bean.Route;
import com.sapient.tms.model.bean.Vehicle;
import com.sapient.tms.model.bl.CentralLogic;
import com.sapient.tms.model.bl.DropLogic;

public class InsertRouteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RouteData routeData;
	private CentralLogic centralLogic;
	private DropLogic dropLogic;
	private Drop dropIns;
       
	private Route route;
    public InsertRouteServlet() {
        super();
        routeData=new RouteData();
        centralLogic=new CentralLogic();
        dropLogic=new DropLogic();
        
        // TODO Auto-generated constructor stub
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		Enumeration<String> drop = request.getParameterNames();
		int Id=Integer.parseInt(drop.nextElement());
		String name=drop.nextElement();
		DropList dropList = new DropList();
						while (drop.hasMoreElements()) {
							int dropId=Integer.parseInt(drop.nextElement());
							//System.out.println(dropId);
						 try {
							Drop dropElement=dropLogic.search(dropId);
							dropIns = new Drop(dropId,dropElement.getName());
							dropList.add(dropIns);
						 
						} catch (ClassNotFoundException | SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
								 
						}
						route = new Route(Id, name, dropList);
						System.out.println(route);
}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
