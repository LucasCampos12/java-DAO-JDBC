package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDAO;
import model.entities.Departament;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

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
		
		System.out.println("===   TESTE 4: seller insert");
		Seller newSeller = new Seller(null, "Greg", "greg@live.com", new Date(), 4000.0, departament);
		sellerDao.insert(newSeller);
		System.out.println("Inserted! New ID = " + newSeller.getId());
		
		
		System.out.println("===   TESTE 5: seller update");
		
		sl = sellerDao.findById(1);
		sl.setName("Marta Luzia");
		sellerDao.update(sl);
		System.out.println("Update completed");
		
		System.out.println("===   TESTE 6: seller delete");
		System.out.println("Inform id to be delete: ");
		int id = sc.nextInt();
		sellerDao.deleteById(id);
		System.out.println("Delete completed");
		


		sc.close();

	}

}
