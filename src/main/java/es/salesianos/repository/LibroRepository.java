package es.salesianos.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import es.salesianos.model.Libros;

@Repository
public class LibroRepository extends MyRepository {

	public void insert(Libros libro) {
		Connection conn = createConnection();

		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement("INSERT INTO Libros (titulo, isbn, codAutor) VALUES (?, ?, ?)");
			preparedStatement.setString(1, libro.getTitulo());
			preparedStatement.setString(2, libro.getIsbn());
			preparedStatement.setInt(3, libro.getCodAutor());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(preparedStatement);
		}

		closeConnection(conn);
	}

	public List<Libros> buscarTodo() {
		List<Libros> libros = new ArrayList<Libros>();
		Connection conn = createConnection();
		ResultSet resultSet = null;

		PreparedStatement prepareStatement = null;
		try {
			prepareStatement = conn
					.prepareStatement("SELECT b.*, a.nombre FROM Libros AS l, Autores AS a WHERE a.id=l.codAutor");
			resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				Integer id = resultSet.getInt(1);
				String titulo = resultSet.getString(2);
				String isbn = resultSet.getString(3);
				String nomAutor = resultSet.getString(5);
				Integer codAutor = resultSet.getInt(4);

				Libros libro = new Libros(id, titulo, isbn, nomAutor, codAutor);
				libros.add(libro);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(resultSet);
			close(prepareStatement);
			closeConnection(conn);
		}

		return libros;
	}

	public List<Libros> buscarPorTitulo(String titulo) {
		List<Libros> libros = buscar(titulo, "l.titulo");
		return libros;
	}

	public List<Libros> buscarPorIsbn(String isbn) {
		List<Libros> libros = buscar(isbn, "l.isbn");
		return libros;
	}

	public List<Libros> buscarPorAutor(String autor) {
		List<Libros> libros = buscar(autor, "a.nombre");
		return libros;
	}

	public List<Libros> buscar(String parameter, String attribute) {
		List<Libros> libros = new ArrayList<Libros>();
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		Connection conn = createConnection();
		try {
			prepareStatement = conn
					.prepareStatement("SELECT l.*, a.name FROM Libros as l, Authors as a WHERE a.id = l.codAutor AND "
							+ attribute + " = ?");
			prepareStatement.setString(1, parameter);
			resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				Integer id = resultSet.getInt(1);
				String titulo = resultSet.getString(2);
				String isbn = resultSet.getString(3);
				String nomAutor = resultSet.getString(5);
				Integer codAutor = resultSet.getInt(4);

				Libros libroEncontrado = new Libros(id, titulo, isbn, nomAutor, codAutor);
				libros.add(libroEncontrado);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(resultSet);
			close(prepareStatement);
			closeConnection(conn);
		}
		return libros;
	}
}
