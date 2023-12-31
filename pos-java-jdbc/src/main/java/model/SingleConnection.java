package model;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingleConnection {
	private static String url="jdbc:postgresql://localhost:5432/posjava";
	private static String user="postgres";
	private static String password="MySQL";
	private static Connection connection=null;
	
	static {
		conectar();
	}
	
	public SingleConnection() {
		conectar();
	}
	
	private static void conectar() {
		try {
			if(connection==null) {
				Class.forName("org.postgresql.Driver");
				connection=DriverManager.getConnection(url, user, password);
				connection.setAutoCommit(false);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
	
	public static Connection getConnection() {
		return connection;
	}
}
