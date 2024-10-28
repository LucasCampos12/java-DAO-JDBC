package model.dao;

import java.util.List;

import model.entities.Departament;

public interface DepartamentDAO {
	
	void insert(Departament obj);
	void update(Departament obj);
	void deleteById(Departament obj);
	Departament findById(Integer id);
	List<Departament>findAll();

}
