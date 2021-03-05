package com.AuthorsBooks.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.AuthorsBooks.connection.ConnectionManager;
import com.AuthorsBooks.connection.H2Connection;
import com.AuthorsBooks.Model.AuthorModel;
import com.AuthorsBooks.Model.BooksModel;

@Repository
public class BookRepository {
	private static final String jdbcUrl = "jdbc:h2:file:./src/main/resources/test";
	ConnectionManager manager = new H2Connection();

	private void close(PreparedStatement prepareStatement) {
		try {
			prepareStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	private void close(ResultSet resultSet) {
		try {
			resultSet.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	// books
	public BooksModel searchB(BooksModel BooksFormulario) {
		BooksModel BooksInDatabase = null;
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		Connection conn = manager.open(jdbcUrl);
		try {
			prepareStatement = conn.prepareStatement("SELECT * FROM Books WHERE BookID = ?");
			prepareStatement.setInt(1, BooksFormulario.getBookID());
			resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				BooksInDatabase = new BooksModel();
				BooksInDatabase.setBookID(resultSet.getInt(1));
				BooksInDatabase.setTitule(resultSet.getString(2));
				BooksInDatabase.setIsbn(resultSet.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(resultSet);
			close(prepareStatement);

		}
		manager.close(conn);
		return BooksInDatabase;
	}

	public void insertB(BooksModel BooksFormulario) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement("INSERT INTO Book (Title,Isbn)" + "VALUES (?, ?)");
			preparedStatement.setString(1, BooksFormulario.getTitule());
			preparedStatement.setString(2, BooksFormulario.getIsbn());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(preparedStatement);
		}

		manager.close(conn);
	}

	public void updateB(BooksModel BooksFormulario) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement("UPDATE Books SET getTitule = ?,getIsbn = ? WHERE getBookID = ?");
			preparedStatement.setString(2, BooksFormulario.getTitule());
			preparedStatement.setString(3, BooksFormulario.getIsbn());

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(preparedStatement);
			manager.close(conn);
		}

	}

	public void deleteB(int BookID) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = deleteBook(BookID, conn);

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(preparedStatement);
			manager.close(conn);
		}

	}

	private PreparedStatement deleteBook(int BookID, Connection conn) throws SQLException {
		PreparedStatement preparedStatement;
		preparedStatement = conn.prepareStatement("DELETE FROM Books WHERE BookID = ?");
		preparedStatement.setInt(1, BookID);
		preparedStatement.executeUpdate();
		return preparedStatement;
	}
	
	public BooksModel searchByBooksID(Integer BookID) {
		BooksModel bookInDatabase = null;
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		Connection conn = manager.open(jdbcUrl);
		try {
			prepareStatement = conn.prepareStatement("SELECT * FROM Books WHERE BookID = ?");
			prepareStatement.setInt(1, BookID);
			resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				bookInDatabase = new BooksModel();
				bookInDatabase.setBookID(resultSet.getInt(1));
				bookInDatabase.setTitule(resultSet.getString(2));
				bookInDatabase.setIsbn(resultSet.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(resultSet);
			close(prepareStatement);
		}
		manager.close(conn);
		return bookInDatabase;
	}

	public List<BooksModel> searchAllB() {
		List<BooksModel> listBooks = new ArrayList<BooksModel>();
		Connection conn = manager.open(jdbcUrl);
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		try {
			prepareStatement = conn.prepareStatement("SELECT * FROM Books");
			resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				BooksModel bookInDatabase = new BooksModel();

				bookInDatabase.setBookID(resultSet.getInt(1));
				bookInDatabase.setTitule(resultSet.getString(2));
				bookInDatabase.setIsbn(resultSet.getString(3));

				listBooks.add(bookInDatabase);
			}
			for (BooksModel book : listBooks) {

				prepareStatement = conn.prepareStatement("SELECT * FROM Books where BookID=" + book.getBookID());
				resultSet = prepareStatement.executeQuery();
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(resultSet);
			close(prepareStatement);
			manager.close(conn);
		}

		return listBooks;
	}

}