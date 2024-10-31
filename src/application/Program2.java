package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartamentDAO;
import model.entities.Departament;

public class Program2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		DepartamentDAO departmentDao = DaoFactory.createDepartamentDao();
		System.out.println("=== TEST 1: findById =======");
		Departament dep = departmentDao.findById(1);
		System.out.println(dep);

		System.out.println("\n=== TEST 2: findAll =======");
		List<Departament> list = departmentDao.findAll();
		for (Departament d : list) {
			System.out.println(d);
		}
		System.out.println("\n=== TEST 3: insert =======");
		Departament newDepartment = new Departament(null, "Music");
		departmentDao.insert(newDepartment);
		System.out.println("Inserted! New id: " + newDepartment.getId());
		System.out.println("\n=== TEST 4: update =======");
		Departament dep2 = departmentDao.findById(1);
		dep2.setName("Food");
		departmentDao.update(dep2);
		System.out.println("Update completed");

		System.out.println("\n=== TEST 5: delete =======");
		System.out.print("Enter id for delete test: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Delete completed");
		sc.close();
	}

}
