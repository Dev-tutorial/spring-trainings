package com.dev.springaop.service;

import java.sql.Connection;
import java.sql.SQLException;

public class DemoService {
	private Connection connection;

	  public void example() {
	    try {
	      connection.close();
	    } catch (SQLException e) {
	      // e.printStackTrace();
	    }
	  }

}
