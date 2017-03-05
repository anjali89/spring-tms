package com.sapient.tms.model.bl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.sapient.tms.model.bean.Drop;
import com.sapient.tms.model.dao.DropPointDao;
import com.sapient.tms.model.dao.DropPointDaoImpl;

public class DropLogic {

	private DropPointDao dropDao = new DropPointDaoImpl();

	public Drop search(int id) throws IOException, ClassNotFoundException, SQLException {
		return dropDao.search(id);
	}

	public boolean insert(Drop drop) throws IOException, ClassNotFoundException, SQLException {
		return dropDao.insert(drop);
	}

	public List<Drop> displayAll() throws IOException, ClassNotFoundException, SQLException {
		return dropDao.displayAll();
	}

	public boolean delete(int id) throws IOException, ClassNotFoundException, SQLException {
		return dropDao.delete(id);
	}
	
	public boolean update(int id, Drop newDrop) throws ClassNotFoundException, IOException, SQLException{
		return dropDao.update(id, newDrop);
	}

	public int getMaxId() throws ClassNotFoundException, SQLException {
		return dropDao.getMaxId();
	}
}
