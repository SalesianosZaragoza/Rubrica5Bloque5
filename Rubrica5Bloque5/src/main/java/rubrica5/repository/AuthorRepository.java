package rubrica5.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import rubrica5.model.Author;

@Repository
public class AuthorRepository extends AbstractRepository {
	
	public void insert(Author author) {
		Connection conn = createConnection();
		
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement("INSERT INTO Authors (name, birthday) VALUES (?, ?)");
			preparedStatement.setString(1, author.getName());
			preparedStatement.setDate(2, new java.sql.Date(author.getBirthday().getTime()));
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(preparedStatement);
		}

		closeConnection(conn);
	}
	
	public List<Author> search(Author author) {
		List<Author> listAuthors = new ArrayList<Author>();
		Connection conn = createConnection();
		ResultSet resultSet = null;
		
		PreparedStatement prepareStatement = null;
		try {
			if (author.getName() != "") {
				prepareStatement = conn.prepareStatement("SELECT * FROM Authors WHERE name = ?");
				prepareStatement.setString(1, author.getName());
			}
			else {
				prepareStatement = conn.prepareStatement("SELECT * FROM Authors WHERE birthday = ?");
				prepareStatement.setDate(1, new java.sql.Date(author.getBirthday().getTime()));
			}
			
			resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				Integer id = resultSet.getInt(1);
				String name = resultSet.getString(2);
				String birthday = resultSet.getString(3); 
				Author author2 = new Author(id, name, birthday);
				listAuthors.add(author2);
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
				String birthday = resultSet.getString(3); 
				
				Author author = new Author(id, name, birthday);
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
	
	
}