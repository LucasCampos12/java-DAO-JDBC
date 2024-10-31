package model.dao;

import db.DB;
import model.dao.impl.DepartamentDaoJDBC;
import model.dao.impl.SellerDaoJDBC;

public class DaoFactory {

	public static SellerDAO createSellerDao() {
		return new SellerDaoJDBC(DB.getConnection());
	}

	public static DepartamentDAO createDepartamentDao() {
		return new DepartamentDaoJDBC(DB.getConnection());
	}
}
