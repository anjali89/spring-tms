package com.sapient.tms.controller.db.drop;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sapient.tms.helper.DropData;
import com.sapient.tms.model.bean.Drop;
import com.sapient.tms.model.bl.DropLogic;

/**
 * Servlet implementation class UpdateDropServlet
 */
public class UpdateDropServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DropLogic dropLogic;
	private DropData dropData;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateDropServlet() {
    	super();
    	dropLogic = new DropLogic();
    	dropData = new DropData();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			PrintWriter pw = response.getWriter();
			boolean check = false;
			int dropId = Integer.parseInt(request.getParameter("id"));
			dropData.createDrop(request);
			Drop newDrop = dropData.getDrop();
			check = dropLogic.update(dropId, newDrop);
			if (check) {
				request.getRequestDispatcher("./db/drop/UpdateDropSuccessful.jsp").forward(request, response);
			} else {
				request.setAttribute("err", "Entry Not Found");
				request.getRequestDispatcher("./db/drop/UpdateDropFailed.jsp").forward(request, response);
			}
		}
		catch (ClassNotFoundException | SQLException e) {
			request.setAttribute("err", e.toString());
			request.getRequestDispatcher("./UpdateDropFailed.jsp").forward(request, response);
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
