package com.br.fiap.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionManager {
	
	private static ConnectionManager connectionManager;
	
	private ConnectionManager() {
		
	}
	
	public static ConnectionManager getInstance() {
		if(connectionManager == null) {
			connectionManager = new ConnectionManager();
		}
		return connectionManager;
	}
	
	public Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			connection = DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL", "86627", "100297");
		}catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
}