package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Ketnoidao {
	public static Connection cn;
	public static Connection ConnectSQL(String nameDatabase,String serverName,String username,String password){
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			System.out.println("Da xac dinh HQTCSDL");
			cn = DriverManager.getConnection("jdbc:sqlserver://" + serverName + ":1433;databaseName=" + nameDatabase + ";user=" + username + ";password=" + password);
			System.out.println("Da ket noi");
			return cn;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}	
	}
}
