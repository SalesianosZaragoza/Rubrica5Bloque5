package es.salesianos.repository;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import es.salesianos.model.Author;

@Repository
public class AuthorRepository extends MyRepository {
	
	public void insert(Author author) {
		Connection conn = createConnection();
		
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement("INSERT INTO Authors (name, dayOfBirth) VALUES (?, ?)");
			preparedStatement.setString(1, author.getName());
			preparedStatement.setString(2, author.getDayOfBirth());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(preparedStatement);
		}

		closeConnection(conn);
	}

	public List<Author> searchAll() {
		List<Author> listAuthors = new ArrayList<Author>();
		Connection conn = createConnection();
		ResultSet resultSet = null;
		
		PreparedStatement prepareStatement = null;
		try {
			prepareStatement = conn.prepareStatement("SELECT * FROM Authors");
			resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				Integer id = resultSet.getInt(1);
				String name = resultSet.getString(2);
				String dayOfBirth = resultSet.getString(3); 
				
				Author author = new Author(id, name, dayOfBirth);
				listAuthors.add(author);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(resultSet);
			close(prepareStatement);
			closeConnection(conn);
		}
		return listAuthors;
	}
	
	public List<Author> searchByName(String nomAuthor) {
		List<Author> listAuthors = search(nomAuthor, "name");
		return listAuthors;
	}
	
	public List<Author> searchByDayOfBirth(String dayOfBirthAuthor) {
		List<Author> listAuthors = search(dayOfBirthAuthor, "dayOfBirth");
		return listAuthors;
	}
	
	public List<Author> search(String parameter, String attribute) {
		List<Author> listAuthors = new ArrayList<Author>();
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		Connection conn = createConnection();
		try {
			prepareStatement = conn.prepareStatement("SELECT * FROM Authors WHERE " + attribute + " = ?");
			prepareStatement.setString(1, parameter);
			resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				Integer id = resultSet.getInt(1);
				String name = resultSet.getString(2);
				String dayOfBirth = resultSet.getString(3); 
				Author authorFound = new Author(id, name, dayOfBirth);
				listAuthors.add(authorFound);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(resultSet);
			close(prepareStatement);
			closeConnection(conn);
		}
		return listAuthors;
	}
	
}