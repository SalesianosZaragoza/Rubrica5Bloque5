package com.example.connection;

import java.sql.Connection;

public interface ConnectionInterface {

	public Connection open(String jdbcUrl);

	public Connection executeSql(Connection conn, String sql);

	public void close(Connection conn);

}
