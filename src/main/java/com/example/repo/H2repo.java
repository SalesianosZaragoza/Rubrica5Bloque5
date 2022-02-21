package com.example.repo;

import java.sql.Connection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.example.connection.ConnectionInterface;
import com.example.models.Author;

@Repository
public class H2repo {

	@Autowired
	ConnectionInterface ci;

	@Value("${app.jdbcurl}")
	private String jdbcurl;

	public void insert(Author author) {
		final String insertionSql = "INSERT INTO Authors (name) VALUES (" + "'" + author.getName() + "'" + ")";
		// ("INSERT INTO Autores (nombre, fNac) VALUES (?, ?)");
		Connection connection = ci.open(jdbcurl);
		System.out.println("Saving in H2");
		ci.executeSql(connection, insertionSql);
		ci.close(connection);
	}

}
