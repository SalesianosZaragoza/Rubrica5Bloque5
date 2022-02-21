package com.serguipe.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.serguipe.connection.AbstractConnection;
import com.serguipe.entities.Autor;
import com.serguipe.entities.Libro;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LibrosReposImpl implements LibrosReposService{

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
			statement.setString(1, libro.getTitulacion());
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
	public void delete(int id) {

		Connection conn = manager.open(jdbcurl);
		PreparedStatement statement = null;
		try {
			statement = conn.prepareStatement("DELETE FROM Libros WHERE ID = ?");
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
	public List<Libro> findAll() {

		List<Libro> libros = new ArrayList<>();

		Connection conn = manager.open(jdbcurl);
		PreparedStatement statement = null;
		try {
			statement = conn.prepareStatement("SELECT l.ID, l.titulo, l.isbn, A.NOMBRE FROM Libros l INNER JOIN AUTORES A on A.ID = l.AUTORID");

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {

				Libro libro = new Libro();
				libro.setID(rs.getInt("ID"));
				libro.setTitulacion(rs.getString("titulo"));
				libro.setIsbn(rs.getString("isbn"));

				Autor autor = new Autor();
				autor.setNombre(rs.getString("nombre"));
				libro.setAutor(autor);

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

	@Override
	public List<Libro> getLibrosAutor(String nombreAutor) {

		List<Libro> libros = new ArrayList<>();

		Connection conn = manager.open(jdbcurl);
		PreparedStatement statement = null;
		try {
			statement = conn.prepareStatement("SELECT l.ID, l.Titulacion, l.isbn, A.nombre FROM Libros l INNER JOIN AUTORES A on l.AUTORID = A.ID WHERE A.NOMBRE = ?");

			statement.setString(1, nombreAutor);
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {

				Autor autor = new Autor();
				autor.setNombre(rs.getString("nombre"));

				Libro libro = new Libro();
				libro.setID(rs.findColumn("ID"));
				libro.setTitulacion(rs.getString("Titulacion"));
				libro.setIsbn(rs.getString("isbn"));
				libro.setAutor(autor);

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

	@Override
	public List<Libro> getLibroByIsbn(String isbn) {

		List<Libro> libros = new ArrayList<>();

		Connection conn = manager.open(jdbcurl);
		PreparedStatement statement = null;
		try {
			statement = conn.prepareStatement("SELECT l.ID, l.Titulacion, l.isbn, A.NOMBRE FROM Libros l INNER JOIN AUTORES A on A.ID = l.AUTORID WHERE l.isbn = ?");

			statement.setString(1, isbn);
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {

				Autor autor = new Autor();
				autor.setNombre(rs.getString("nombre"));

				Libro libro = new Libro();
				libro.setID(rs.findColumn("ID"));
				libro.setTitulacion(rs.getString("titulo"));
				libro.setIsbn(rs.getString("isbn"));
				libro.setAutor(autor);

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

	@Override
	public List<Libro> getLibroByTitulo(String titulo) {

		List<Libro> libros = new ArrayList<>();

		Connection conn = manager.open(jdbcurl);
		PreparedStatement statement = null;
		try {
			statement = conn.prepareStatement("SELECT l.ID, l.titulo, l.isbn, A.NOMBRE FROM Libros l INNER JOIN AUTORES A on A.ID = l.AUTORID WHERE l.titulo = ?");

			statement.setString(1, titulo);
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {

				Autor autor = new Autor();
				autor.setNombre(rs.getString("nombre"));

				Libro libro = new Libro();
				libro.setID(rs.findColumn("ID"));
				libro.setTitulacion(rs.getString("titulo"));
				libro.setIsbn(rs.getString("isbn"));
				libro.setAutor(autor);

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
