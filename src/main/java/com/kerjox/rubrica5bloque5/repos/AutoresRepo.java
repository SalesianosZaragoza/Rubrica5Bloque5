package com.kerjox.rubrica5bloque5.repos;

import com.kerjox.rubrica5bloque5.connection.AbstractConnection;
import com.kerjox.rubrica5bloque5.entities.Autor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class AutoresRepo implements RepoService<Autor> {

	@Autowired
	private AbstractConnection manager;

	@Value("${app.jdbcurl}")
	private String jdbcurl;

	@Override
	public void insert(Autor autor) {

		Connection conn = manager.open(jdbcurl);
		PreparedStatement statement = null;
		try {
			statement = conn.prepareStatement("INSERT INTO Autores (nombre, fNac) VALUES (?, ?)");
			statement.setString(1, autor.getNombre());
			statement.setDate(2, autor.getfNac());
			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			manager.close(statement);
			manager.close(conn);
		}
	}

	@Override
	public void delete(int id) {

		Connection conn = manager.open(jdbcurl);
		PreparedStatement statement = null;
		try {
			statement = conn.prepareStatement("DELETE FROM Autores WHERE ID = ?");
			statement.setInt(1, id);
			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			manager.close(statement);
			manager.close(conn);
		}
	}

	@Override
	public List<Autor> findAll() {

		List<Autor> autores = new ArrayList<>();

		Connection conn = manager.open(jdbcurl);
		PreparedStatement statement = null;
		try {
			statement = conn.prepareStatement("SELECT a.ID, a.nombre, a.fNac FROM Autores a");

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {

				Autor autor = new Autor();
				autor.setID(rs.getInt("ID"));
				autor.setNombre(rs.getString("nombre"));
				autor.setfNac(Date.valueOf(rs.getString("fNac")));

				autores.add(autor);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			manager.close(statement);
			manager.close(conn);
		}

		return autores;
	}

	public List<Autor> findByNombre(String nombreAutor) {

		List<Autor> autores = new ArrayList<>();

		Connection conn = manager.open(jdbcurl);
		PreparedStatement statement = null;
		try {
			statement = conn.prepareStatement("SELECT a.ID, a.nombre, a.fNac FROM Autores a WHERE a.NOMBRE = ?");
			statement.setString(1, nombreAutor);

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {

				Autor autor = new Autor();
				autor.setID(rs.getInt("ID"));
				autor.setNombre(rs.getString("nombre"));
				autor.setfNac(Date.valueOf(rs.getString("fNac")));

				autores.add(autor);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			manager.close(statement);
			manager.close(conn);
		}

		return autores;
	}

	public List<Autor> findByDate(Date fNac) {

		List<Autor> autores = new ArrayList<>();

		Connection conn = manager.open(jdbcurl);
		PreparedStatement statement = null;
		try {
			statement = conn.prepareStatement("SELECT a.ID, a.nombre, a.fNac FROM Autores a WHERE a.FNAC = ?");
			statement.setDate(1, fNac);

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {

				Autor autor = new Autor();
				autor.setID(rs.getInt("ID"));
				autor.setNombre(rs.getString("nombre"));
				autor.setfNac(Date.valueOf(rs.getString("fNac")));

				autores.add(autor);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			manager.close(statement);
			manager.close(conn);
		}

		return autores;
	}
}
