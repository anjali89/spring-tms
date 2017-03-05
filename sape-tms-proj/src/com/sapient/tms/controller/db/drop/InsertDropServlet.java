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
 * Servlet implementation class InsertDropServlet
 */
public class InsertDropServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DropData dropData;
	private DropLogic dropLogic;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertDropServlet() {
        super();
        dropData = new DropData();
        dropLogic = new DropLogic();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			PrintWriter pw = response.getWriter();
			boolean check = false;
			dropData.createDrop(request);
			Drop drop = dropData.getDrop();
			check = dropLogic.insert(drop);
			if (check) {
				request.getRequestDispatcher("./db/drop/InsertDropSuccessful.jsp").forward(request, response);
			} else {
				request.setAttribute("err", "Operation Failed");
				request.getRequestDispatcher("./db/drop/InsertDropFailed.jsp").forward(request, response);
			}
		}
		catch (ClassNotFoundException | SQLException e) {
			request.setAttribute("err", e.toString());
			request.getRequestDispatcher("./InsertDropFailed.jsp").forward(request, response);
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
