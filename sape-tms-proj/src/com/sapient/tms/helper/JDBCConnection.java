package com.sapient.tms.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class JDBCConnection {
	private static Connection connection = null;

	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static synchronized Connection getConnection() throws ClassNotFoundException, SQLException {
		if (connection == null || connection.isClosed()) {
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "sapient@123");
		}
		return connection;
	}
}