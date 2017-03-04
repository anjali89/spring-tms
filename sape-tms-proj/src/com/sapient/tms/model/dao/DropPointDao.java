package com.sapient.tms.model.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import com.sapient.tms.model.bean.Drop;

public interface DropPointDao {

	public Drop search(int id) throws IOException, ClassNotFoundException, SQLException;

	public boolean insert(Drop drop) throws IOException, ClassNotFoundException, SQLException;

	public List<Drop> displayAll() throws IOException, ClassNotFoundException, SQLException;

	public boolean delete(int id) throws IOException, ClassNotFoundException, SQLException;

	public int getMaxId() throws SQLException, ClassNotFoundException;

	public boolean update(int id, Drop newDrop) throws IOException, ClassNotFoundException, SQLException;
}
