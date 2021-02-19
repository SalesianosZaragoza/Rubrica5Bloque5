package Bloque5.Rubrica5.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Bloque5.Rubrica5.connection.AbstractConnection;
import Bloque5.Rubrica5.connection.H2Connection;

public abstract class RepositoryBase {

	private static final String jdbcUrl = "jdbc:h2:file:./src/main/resources/test;INIT=RUNSCRIPT FROM 'classpath:scripts/create.sql'";
	private AbstractConnection manager = new H2Connection();

	protected Connection createConnection() {
		return manager.open(jdbcUrl);
	}

	protected void closeConnection(Connection connection) {
		manager.close(connection);
	}

	protected void close(PreparedStatement prepareStatement) {
		if (null != prepareStatement) {
			try {
				prepareStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
	}

	protected void close(ResultSet resultSet) {
		if (null != resultSet) {

			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
	}

}