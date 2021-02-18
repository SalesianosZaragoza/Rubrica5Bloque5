package com.B5R5.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.B5R5.connection.ConnectionH2;
import com.B5R5.connection.ConnectionManager;
import com.B5R5.model.Book;

@Repository
public class BookRepository {
	
	private static final String jdbcUrl = "jdbc:h2:file:./src/main/resources/test";
	ConnectionManager manager = new ConnectionH2();

	public void insert(Book book) {
		Connection conn = manager.open(jdbcUrl);

		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement("INSERT INTO Books (title, isbn, authorID) VALUES (?, ?, ?)");
			preparedStatement.setString(1, book.getTitle());
			preparedStatement.setString(2, book.getIsbn());
			preparedStatement.setInt(3, book.getAuthorID());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
		}
		manager.close(conn);
	}

	public List<Book> searchAll() {
		List<Book> listBooks = new ArrayList<Book>();
		Connection conn = manager.open(jdbcUrl);
		ResultSet resultSet = null;

		PreparedStatement prepareStatement = null;
		try {
			prepareStatement = conn.prepareStatement("SELECT b.*, a.name FROM Books AS b, Authors AS a WHERE a.id=b.authorID");
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
			manager.close(resultSet);
			manager.close(prepareStatement);
		}
		manager.close(conn);
		return listBooks;
	}


	public List<Book> search(Book book) {
		List<Book> listBooks = new ArrayList<Book>();
		Connection conn = manager.open(jdbcUrl);
		ResultSet resultSet = null;

		PreparedStatement prepareStatement = null;
		try {
			boolean nullTitle = book.getTitle() == "";
			boolean nullIsbn = book.getIsbn() == "";
			boolean nullAuthorName = book.getAuthor() == "";
			String where = "";
			if (!nullTitle) {
				where = where.concat("LOWER(title) LIKE ?");
			}
			if (!nullIsbn) {
				if (where.length() > 0) {
					where = where.concat(" OR ");
				}
				where = where.concat("LOWER(isbn) LIKE ?");
			}
			if (!nullAuthorName) {
				if (where.length() > 0) {
					where = where.concat(" OR ");
				}
				where = where.concat("LOWER(a.name) LIKE ?");
			}
			String query = "SELECT b.*, a.name FROM Books AS b, Authors AS a WHERE a.id=b.authorID";
			if (where.length() > 0) {
				query = query.concat(" AND ".concat(where));
			}
			prepareStatement = conn.prepareStatement(query);

			Integer parameterId = 1;
			if (!nullTitle) {
				prepareStatement.setString(parameterId, "%".concat(book.getTitle()).concat("%"));
				parameterId++;
			}
			if (!nullIsbn) {
				prepareStatement.setString(parameterId, "%".concat(book.getIsbn()).concat("%"));
				parameterId++;
			}
			if (!nullAuthorName) {
				prepareStatement.setString(parameterId, "%".concat(book.getAuthor()).concat("%"));
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
			manager.close(resultSet);
			manager.close(prepareStatement);
		}
		manager.close(conn);
		return listBooks;
	}
} 