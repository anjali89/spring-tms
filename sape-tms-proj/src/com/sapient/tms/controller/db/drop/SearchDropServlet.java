package com.sapient.tms.controller.db.drop;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sapient.tms.model.bean.Drop;
import com.sapient.tms.model.bl.DropLogic;

/**
 * Servlet implementation class SearchDropServlet
 */
public class SearchDropServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private DropLogic dropLogic;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchDropServlet() {
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
			Drop drop = dropLogic.search(dropId);
			if (drop != null) {
				request.setAttribute("drop", drop);
				request.getRequestDispatcher("./db/drop/SearchDropSuccessful.jsp").forward(request, response);
			} else {
				request.setAttribute("err", "Entry Not Found");
				request.getRequestDispatcher("./db/drop/SearchDropFailed.jsp").forward(request, response);
			}
		}
		catch (ClassNotFoundException | SQLException e) {
			request.setAttribute("err", e.toString());
			request.getRequestDispatcher("./db/drop/SearchDropFailed.jsp").forward(request, response);
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
