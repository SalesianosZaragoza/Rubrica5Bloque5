package es.salesianos.repository;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import es.salesianos.model.Book;

@Repository
public class BookRepository extends MyRepository {
	
	public void insert(Book book) {
		Connection conn = createConnection();
		
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement("INSERT INTO Books (title, isbn, authorId) VALUES (?, ?, ?)");
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

		closeConnection(conn);
	}

	public List<Book> searchAll() {
		List<Book> listBooks = new ArrayList<Book>();
		Connection conn = createConnection();
		ResultSet resultSet = null;
		
		PreparedStatement prepareStatement = null;
		try {
			prepareStatement = conn.prepareStatement("SELECT b.*, a.name FROM Books AS b, Authors AS a WHERE a.id=b.authorId");
			resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				Integer id = resultSet.getInt(1);
				String title = resultSet.getString(2);
				String isbn = resultSet.getString(3); 
				String authorName = resultSet.getString(5);
				Integer authorId = resultSet.getInt(4);
				
				Book book = new Book(id, title, isbn, authorName, authorId);
				listBooks.add(book);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(resultSet);
			close(prepareStatement);
			closeConnection(conn);
		}

		return listBooks;
	}
	
	public List<Book> searchByTitle(String titleBook) {
		List<Book> listBooks = search(titleBook, "b.title");
		return listBooks;
	}
	
	public List<Book> searchByIsbn(String isbnBook) {
		List<Book> listBooks = search(isbnBook, "b.isbn");
		return listBooks;
	}
	
	public List<Book> searchByAuthor(String author) {
		List<Book> listBooks = search(author, "a.name");
		return listBooks;
	}
	
	public List<Book> search(String parameter, String attribute) {
		List<Book> listBooks = new ArrayList<Book>();
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		Connection conn = createConnection();
		try {
			prepareStatement = conn.prepareStatement(
					"SELECT b.*, a.name FROM Books as b, Authors as a WHERE a.id = b.authorId AND " + attribute + " = ?"
					);
			prepareStatement.setString(1, parameter);
			resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				Integer id = resultSet.getInt(1);
				String title = resultSet.getString(2);
				String isbn = resultSet.getString(3); 
				String authorName = resultSet.getString(5);
				Integer authorId = resultSet.getInt(4);
				
				Book bookFound = new Book(id, title, isbn, authorName, authorId);
				listBooks.add(bookFound);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(resultSet);
			close(prepareStatement);
			closeConnection(conn);
		}
		return listBooks;
	}
}