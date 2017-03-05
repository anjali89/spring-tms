package com.sapient.tms.controller.db.drop;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sapient.tms.model.bl.DropLogic;

/**
 * Servlet implementation class DeleteDropServlet
 */
public class DeleteDropServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DropLogic dropLogic;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteDropServlet() {
        super();
        dropLogic = new DropLogic();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			PrintWriter pw = response.getWriter();
			int dropId = Integer.parseInt(request.getParameter("id"));
			boolean success = dropLogic.delete(dropId);
			if (success) {
				request.getRequestDispatcher("./db/drop/DeleteDropSuccessful.jsp").forward(request, response);
			} else {
				request.setAttribute("err", "Entry Not Found");
				request.getRequestDispatcher("./db/drop/DeleteDropFailed.jsp").forward(request, response);
			}
		}
		catch (ClassNotFoundException | SQLException e) {
			request.setAttribute("err", e.toString());
			request.getRequestDispatcher("./DeleteDropFailed.jsp").forward(request, response);
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
