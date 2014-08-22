package br.com.estagio.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public Connection getConnection(){
		try{
		return DriverManager.getConnection(
				"jdbc:mysql://localhost/estagio", "root", "root");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static void main(String[] args) throws SQLException {
		Connection connection = new ConnectionFactory().getConnection(); 
		System.out.println("Conexão Aberta!");
		connection.close();
	}
}
