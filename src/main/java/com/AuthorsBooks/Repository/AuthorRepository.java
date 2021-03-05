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

@Repository
public class AuthorRepository {
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

// author
	public AuthorModel searchA(AuthorModel authorFormulario) {
		AuthorModel authorInDatabase = null;
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		Connection conn = manager.open(jdbcUrl);
		try {
			prepareStatement = conn.prepareStatement("SELECT * FROM Author WHERE AutorID = ?");
			prepareStatement.setInt(1, authorFormulario.getAuthorID());
			resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				authorInDatabase = new AuthorModel();
				authorInDatabase.setAuthorID(resultSet.getInt(1));
				authorInDatabase.setName(resultSet.getString(2));
				authorInDatabase.setBirthDate(resultSet.getDate(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(resultSet);
			close(prepareStatement);

		}
		manager.close(conn);
		return authorInDatabase;
	}

	public void insertA(AuthorModel authorFormulario) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement("INSERT INTO Author (name,FechaNac)" + "VALUES (?, ?)");
			preparedStatement.setString(1, authorFormulario.getName());
			preparedStatement.setDate(2, new java.sql.Date(authorFormulario.getBirthDate().getTime()));
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(preparedStatement);
		}

		manager.close(conn);
	}

	public void updateA(AuthorModel authorFormulario) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement("UPDATE OWNER SET name = ?,BirthDate = ? WHERE AuthorID = ?");
			preparedStatement.setString(1, authorFormulario.getName());
			preparedStatement.setDate(2, new java.sql.Date(authorFormulario.getBirthDate().getTime()));

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(preparedStatement);
			manager.close(conn);
		}

	}

	public void deleteA(int AuthorID) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = deleteAuthor(AuthorID, conn);

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(preparedStatement);
			manager.close(conn);
		}

	}

	private PreparedStatement deleteAuthor(int AuthorID, Connection conn) throws SQLException {
		PreparedStatement preparedStatement;
		preparedStatement = conn.prepareStatement("DELETE FROM Author WHERE AutorID = ?");
		preparedStatement.setInt(1, AuthorID);
		preparedStatement.executeUpdate();
		return preparedStatement;
	}

	public AuthorModel searchByAuthorID(Integer AuthorID) {
		AuthorModel authorInDatabase = null;
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		Connection conn = manager.open(jdbcUrl);
		try {
			prepareStatement = conn.prepareStatement("SELECT * FROM Author WHERE AuthorID = ?");
			prepareStatement.setInt(1, AuthorID);
			resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				authorInDatabase = new AuthorModel();
				authorInDatabase.setAuthorID(resultSet.getInt(1));
				authorInDatabase.setName(resultSet.getString(2));
				authorInDatabase.setBirthDate(resultSet.getDate(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(resultSet);
			close(prepareStatement);
		}
		manager.close(conn);
		return authorInDatabase;
	}

	public List<AuthorModel> searchAllA() {
		List<AuthorModel> listAuthor = new ArrayList<AuthorModel>();
		Connection conn = manager.open(jdbcUrl);
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		try {
			prepareStatement = conn.prepareStatement("SELECT * FROM Author");
			resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				AuthorModel authorInDatabase = new AuthorModel();

				authorInDatabase.setAuthorID(resultSet.getInt(1));
				authorInDatabase.setName(resultSet.getString(2));
				authorInDatabase.setBirthDate(resultSet.getDate(3));

				listAuthor.add(authorInDatabase);
			}
			for (AuthorModel author : listAuthor) {

				prepareStatement = conn.prepareStatement("SELECT * FROM Author where AuthorID=" + author.getAuthorID());
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

		return listAuthor;
	}

}