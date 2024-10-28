package application;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDAO;
import model.entities.Departament;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {

		SellerDAO sellerDao = DaoFactory.createSellerDao();

		System.out.println("===   TESTE 1: seller findById");
		Seller sl = sellerDao.findById(3);

		System.out.println(sl);

		System.out.println("===   TESTE 2: seller findByDepartament");
		Departament departament = new Departament(2, null);
		List<Seller> list = sellerDao.findByDepartment(departament);

		for (Seller obj : list) {
			System.out.println(obj);
		}
		System.out.println("===   TESTE 3: seller findByDepartament");
		list = sellerDao.findAll();
		for (Seller obj : list) {
			System.out.println(obj);
		}

	}

}
