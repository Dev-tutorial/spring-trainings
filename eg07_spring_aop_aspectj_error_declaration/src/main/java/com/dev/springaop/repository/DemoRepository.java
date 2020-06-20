package com.dev.springaop.repository;

import java.sql.Connection;
import java.sql.SQLException;

public class DemoRepository {

	public void example() throws SQLException {
		Connection connection = null;
		connection.close();
	}
}
