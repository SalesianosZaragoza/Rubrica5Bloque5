package com.kerjox.rubrica5bloque5.repos;

import com.kerjox.rubrica5bloque5.connection.AbstractConnection;
import com.kerjox.rubrica5bloque5.entities.Autor;
import com.kerjox.rubrica5bloque5.entities.Libro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LibroRepo implements RepoService<Libro> {

	@Autowired
	private AbstractConnection manager;

	@Value("${app.jdbcurl}")
	private String jdbcurl;

	@Override
	public void insert(Libro libro) {

		Connection conn = manager.open(jdbcurl);
		PreparedStatement statement = null;
		try {
			statement = conn.prepareStatement("INSERT INTO Libros (titulo, isbn, autorID) VALUES (?, ?, ?)");
			statement.setString(1, libro.getTitulo());
			statement.setString(2, libro.getIsbn());
			statement.setInt(3, libro.getAutor().getID());
			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			manager.close(statement);
			manager.close(conn);
		}
	}

	@Override
	public void delete(Libro libro) {

		Connection conn = manager.open(jdbcurl);
		PreparedStatement statement = null;
		try {
			statement = conn.prepareStatement("DELETE FROM Libros WHERE ID = ?");
			statement.setInt(1, libro.getID());
			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			manager.close(statement);
			manager.close(conn);
		}
	}

	@Override
	public List<Libro> findAll() {

		List<Libro> libros = new ArrayList<>();

		Connection conn = manager.open(jdbcurl);
		PreparedStatement statement = null;
		try {
			statement = conn.prepareStatement("SELECT l.ID, l.titulo, l.isbn FROM Libros l");

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {

				Libro libro = new Libro();
				libro.setID(rs.findColumn("ID"));
				libro.setTitulo(rs.getString("titulo"));
				libro.setIsbn(rs.getString("isbn"));

				libros.add(libro);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			manager.close(statement);
			manager.close(conn);
		}

		return libros;
	}

	public List<Libro> getLibrosAutor(int autorID) {

		List<Libro> libros = new ArrayList<>();

		Connection conn = manager.open(jdbcurl);
		PreparedStatement statement = null;
		try {
			statement = conn.prepareStatement("SELECT l.ID, l.titulo, l.isbn FROM Libros l, WHERE l.ID = ?");

			statement.setInt(1, autorID);
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {

				Libro libro = new Libro();
				libro.setID(rs.findColumn("ID"));
				libro.setTitulo(rs.getString("titulo"));
				libro.setIsbn(rs.getString("isbn"));

				libros.add(libro);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			manager.close(statement);
			manager.close(conn);
		}

		return libros;
	}
}
