package Bloque5.Rubrica5.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import Bloque5.Rubrica5.model.Book;

@Repository
public class BookRepository extends RepositoryBase {

	public void insert(Book book) {
		Connection connection = createConnection();

		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection
					.prepareStatement("INSERT INTO BOOK (title, isbn, authorId) VALUES (?, ?, ?)");
			preparedStatement.setString(1, book.getTitle());
			preparedStatement.setString(2, book.getIsbn());
			preparedStatement.setInt(3, book.getAuthorId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(preparedStatement);
		}

		closeConnection(connection);
	}

	public List<Book> searchAll() {
		List<Book> listBook = new ArrayList<Book>();
		//Connection connection = createConnection();
		//ResultSet resultSet = null;

		//PreparedStatement prepareStatement = null;
		

		return listBook;
	}

	public List<Book> search(Book book) {
		List<Book> listBook = new ArrayList<Book>();
		//Connection connection = createConnection();
		//ResultSet resultSet = null;

		//PreparedStatement prepareStatement = null;
		

		return listBook;
	}
}