package com.sapient.tms.controller.db.employee;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.sapient.tms.helper.EmployeeData;
import com.sapient.tms.model.bean.Employee;
import com.sapient.tms.model.bl.CentralLogic;


/**
 * Servlet implementation class UpdateEmployeeServlet
 */
public class UpdateEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CentralLogic centralLogic;
    private EmployeeData employeeData;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateEmployeeServlet() {
        super();
       employeeData=new EmployeeData();
       centralLogic=new CentralLogic();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			boolean check = false;
			int employeeId = Integer.parseInt(request.getParameter("id"));
			employeeData.createEmployee(request);
			Employee newEmployee = employeeData.getEmployee();
			check = centralLogic.updateEmployee(employeeId, newEmployee);
			if (check) {
				request.getRequestDispatcher("./db/employee/UpdateEmployeeSuccessful.jsp").forward(request, response);
			} else {
				request.setAttribute("err", "Entry Not Found");
				request.getRequestDispatcher("./db/employee/UpdateEmployeeFailed.jsp").forward(request, response);
			}
		}
		catch (ClassNotFoundException | SQLException e) {
			request.setAttribute("err", e.toString());
			request.getRequestDispatcher("./db/employee/UpdateEmployeeFailed.jsp").forward(request, response);
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
