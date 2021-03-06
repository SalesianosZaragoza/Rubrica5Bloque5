package es.salesianos.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import es.salesianos.model.Autor;

public class AutorRepository extends MyRepository {
	public void Insert(Autor autor) {
		Connection conn = createConnection();

		PreparedStatement preparedStatement = null;

		try {
			preparedStatement = conn.prepareStatement("INSERT INTO Autores (nombre, fechaNac) VALUES (?, ?)");
			preparedStatement.setString(1, autor.getNombre());
			preparedStatement.setString(2, autor.getFechaNac());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(preparedStatement);
		}

		closeConnection(conn);
	}

	public List<Autor> buscarTodo() {
		List<Autor> autores = new ArrayList<Autor>();
		Connection conn = createConnection();
		ResultSet resultSet = null;

		PreparedStatement prepareStatement = null;
		try {
			prepareStatement = conn.prepareStatement("SELECT * FROM Authors");
			resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				Integer codAutor = resultSet.getInt(1);
				String nombre = resultSet.getString(2);
				String fechaNac = resultSet.getString(3);

				Autor autor = new Autor(codAutor, nombre, fechaNac);
				autores.add(autor);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(resultSet);
			close(prepareStatement);
			closeConnection(conn);
		}
		return autores;
	}

	public List<Autor> buscarPorNombre(String nomAutor) {
		List<Autor> autores = buscar(nomAutor, "nombre");
		return autores;
	}

	public List<Autor> buscarPorFecha(String fechaNac) {
		List<Autor> autores = buscar(fechaNac, "fechaNac");
		return autores;
	}

	public List<Autor> buscar(String parameter, String attribute) {
		List<Autor> autores = new ArrayList<Autor>();
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		Connection conn = createConnection();
		try {
			prepareStatement = conn.prepareStatement("SELECT * FROM Autores WHERE " + attribute + " = ?");
			prepareStatement.setString(1, parameter);
			resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				Integer codAutor = resultSet.getInt(1);
				String nombre = resultSet.getString(2);
				String fechaNac = resultSet.getString(3);
				Autor autorEncontrado = new Autor(codAutor, nombre, fechaNac);
				autores.add(autorEncontrado);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(resultSet);
			close(prepareStatement);
			closeConnection(conn);
		}
		return autores;
	}
}
