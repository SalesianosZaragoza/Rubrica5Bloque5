package rubrica5.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import rubrica5.model.Book;

@Repository
public class BookRepository extends AbstractRepository {
	
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
	
	public List<Book> search(Book book) {
		List<Book> listBooks = new ArrayList<Book>();
		Connection conn = createConnection();
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		try {
			if (book.getTitle() != "") {
				prepareStatement = conn.prepareStatement("SELECT Books.*, Authors.name WHERE Authors.id=Books.authorId AND title = ?");
				prepareStatement.setString(1, book.getTitle());
			}
			else if(book.getIsbn()!= "") {
				prepareStatement = conn.prepareStatement("SELECT Books.*, Authors.name WHERE Authors.id=Books.authorId AND isbn = ?");
				prepareStatement.setString(1, book.getIsbn());
			}else {
				prepareStatement = conn.prepareStatement("SELECT Books.*, Authors.name WHERE Authors.id=Books.authorId AND Authors.name = ?");
				prepareStatement.setString(1, book.getAuthorName());
			}
			
			resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				Integer id = resultSet.getInt(1);
				String title = resultSet.getString(2);
				String isbn = resultSet.getString(3); 
				String authorName = resultSet.getString(5);
				Integer authorId = resultSet.getInt(4);
				
				Book _book = new Book(id, title, isbn, authorName, authorId);
				listBooks.add(_book);
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

	public List<Book> searchAll() {
		List<Book> listBooks = new ArrayList<Book>();
		Connection conn = createConnection();
		ResultSet resultSet = null;
		
		PreparedStatement prepareStatement = null;
		try {
			prepareStatement = conn.prepareStatement("SELECT Books.*, Authors.name WHERE Authors.id=Books.authorId");
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
	

	
}