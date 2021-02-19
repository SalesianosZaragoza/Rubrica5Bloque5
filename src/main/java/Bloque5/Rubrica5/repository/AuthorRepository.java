package Bloque5.Rubrica5.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import Bloque5.Rubrica5.model.Author;

@Repository
public class AuthorRepository extends RepositoryBase {

	public void insert(Author author) {
		Connection connection = createConnection();

		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement("INSERT INTO AUTHOR (name, birthday) VALUES (?, ?)");
			preparedStatement.setString(1, author.getName());
			preparedStatement.setDate(2, new java.sql.Date(author.getBirthday().getTime()));
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(preparedStatement);
		}

		closeConnection(connection);
	}

	public List<Author> searchAll() {
		List<Author> listAuthor = new ArrayList<Author>();
		Connection connection = createConnection();
		ResultSet resultSet = null;

		PreparedStatement prepareStatement = null;
		try {
			prepareStatement = connection.prepareStatement("SELECT * FROM AUTHOR");
			resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				Integer id = resultSet.getInt(1);
				String name = resultSet.getString(2);
				String birthday = resultSet.getString(3);

				Author author = new Author(id, name, birthday);
				listAuthor.add(author);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(resultSet);
			close(prepareStatement);
			closeConnection(connection);
		}

		return listAuthor;
	}

	public List<Author> search(Author author) {
		List<Author> listAuthor = new ArrayList<Author>();
		//Connection connection = createConnection();
		//ResultSet resultSet = null;

		//PreparedStatement prepareStatement = null;
		

		return listAuthor;
	}

	public Author search(Integer searchId) {
		Author author = null;
		//ResultSet resultSet = null;
		//PreparedStatement prepareStatement = null;
		//Connection connection = createConnection();
		
		return author;
	}
}