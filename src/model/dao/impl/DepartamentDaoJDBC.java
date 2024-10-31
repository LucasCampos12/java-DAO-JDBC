package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import db.DB;
import db.DbException;
import model.dao.DepartamentDAO;
import model.entities.Departament;

public class DepartamentDaoJDBC implements DepartamentDAO {

	private Connection conn;

	public DepartamentDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Departament obj) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("INSERT INTO departament" + "name" + "VALUES" + "(?)",
					Statement.RETURN_GENERATED_KEYS);

			st.setString(1, obj.getName());

			int rows = st.executeUpdate();

			if (rows > 0) {
				ResultSet rs = st.getGeneratedKeys();

				if (rs.next()) {
					int id = rs.getInt(1);
					obj.setId(id);
				}

				DB.closeResultSet(rs);

			} else {
				throw new DbException("unexpected error! No rows affected");
			}

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
		}
	}

	@Override
	public void update(Departament obj) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("UPDATE departament" + "SET id = ?, Name = ?" + "WHERE id = ?");

			st.setString(1, obj.getName());
			st.setInt(2, obj.getId());

			st.executeUpdate();

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
		}

	}

	@Override
	public void deleteById(Integer id) {
		PreparedStatement st = null;
		try {
//Codigo SQL para excluir dados em uma tabela			
			st = conn.prepareStatement("DELETE FROM departament" + "WHERE Id = ?");

			st.setInt(1, id);
			int rows = st.executeUpdate();
			if (rows == 0) {
				throw new DbException("No rows affeted");
			}

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
		}
	}

	@Override
	public Departament findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			st = conn.prepareStatement("SELECT * FROM department WHERE Id = ?");

			st.setInt(1, id);
			rs = st.executeQuery();
			if (rs.next()) {

				Departament obj = new Departament();
				obj.setId(rs.getInt("id"));
				obj.setName(rs.getString("name"));
				return obj;

			}
			return null;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}

	}

	@Override
	public List<Departament> findAll() {
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			st = conn.prepareStatement("SELECT * FROM department ORDER BY Name");
			rs = st.executeQuery();

			List<Departament> list = new ArrayList<>();

			while (rs.next()) {
				Departament obj = new Departament();
				obj.setId(obj.getId());
				obj.setName(obj.getName());
				list.add(obj);
			}
			return list;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

}
