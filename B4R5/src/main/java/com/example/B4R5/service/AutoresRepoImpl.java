package com.example.B4R5.service;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.amqp.RabbitProperties.Cache.Connection;

import com.example.B4R5.connection.AbstractConnection;
import com.example.B4R5.entities.Autor;

public class AutoresRepoImpl implements AutoresRepo{

	@Autowired
	private AbstractConnection manager;

	@Value("${app.jdbcurl}")
	private String jdbcurl;

	@Override
	public void insert(Autor autor) {

		Connection conn = (Connection) manager.open(jdbcurl);
		PreparedStatement statement = null;
		try {
			statement = ((java.sql.Connection) conn).prepareStatement("INSERT INTO Autores (nombre, fNac) VALUES (?, ?)");
			statement.setString(1, autor.getNombre());
			statement.setDate(2, autor.getfNac());
			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			manager.close(statement);
			manager.close((java.sql.Connection) conn);
		}
	}
}
