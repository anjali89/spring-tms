package com.sapient.tms.helper;

import java.sql.SQLException;
import java.util.Scanner;

import javax.servlet.http.HttpServletRequest;

import com.sapient.tms.model.bean.Drop;
import com.sapient.tms.model.bl.CentralLogic;

public class DropData {
	private Drop drop;
	private int dropPointId;
	private String dropPointName;

	public void createDrop(HttpServletRequest request) throws ClassNotFoundException, SQLException {
		CentralLogic centralLogic = new CentralLogic();
		// System.out.println("Enter new Drop Point ID: ");
		// dropPointId=sc.nextInt();
		dropPointId = centralLogic.getMaxDropId() + 1;
		dropPointName = request.getParameter("name");
		drop = new Drop(dropPointId, dropPointName);

	}

	public Drop getDrop() {
		return drop;
	}

}
