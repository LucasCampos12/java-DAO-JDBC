package application;

import java.util.Date;

import model.entities.Departament;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		Departament obj = new Departament(1, "Books");
		Seller sl = new Seller(1, "Lucas","lucas@gmail.com", new Date(), 3000, obj);
		System.out.println(sl);

	}

}
