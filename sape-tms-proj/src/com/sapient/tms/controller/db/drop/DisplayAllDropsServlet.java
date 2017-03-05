package com.sapient.tms.controller.db.drop;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sapient.tms.model.bean.Drop;
import com.sapient.tms.model.bl.DropLogic;

/**
 * Servlet implementation class DisplayAllDropsServlet
 */
public class DisplayAllDropsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private DropLogic dropLogic;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayAllDropsServlet() {
        super();
        dropLogic = new DropLogic();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			List<Drop> drops = dropLogic.displayAll();
			if (drops != null) {
				request.setAttribute("drops", drops);
				request.getRequestDispatcher("./db/drop/DisplayAllDropsSuccessful.jsp").forward(request, response);
			} else {
				request.setAttribute("err", "Operation failed");
				request.getRequestDispatcher("./db/drop/DisplayAllDropsFailed.jsp").forward(request, response);
			}
		}
		catch (ClassNotFoundException | SQLException e) {
			request.setAttribute("err", e.toString());
			request.getRequestDispatcher("./DisplayAllDropsFailed.jsp").forward(request, response);
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
