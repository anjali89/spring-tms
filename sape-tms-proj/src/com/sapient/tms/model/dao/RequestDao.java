package com.sapient.tms.model.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.sapient.tms.model.bean.Request;

public interface RequestDao {
	Request searchByEmployeeId(int id) throws IOException, ClassNotFoundException, SQLException;

	List<Request> displayAll() throws IOException, ClassNotFoundException, SQLException;

	boolean deleteByEmployeeId(int id) throws IOException, ClassNotFoundException, SQLException;

	boolean insert(Request request) throws IOException, ClassNotFoundException, SQLException;

	boolean updateByEmployeeId(int requestId, Request request) throws IOException, ClassNotFoundException, SQLException;

}
