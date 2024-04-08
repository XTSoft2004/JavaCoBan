package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Ketnoidao {
	public static String serverName = "LAB405-14";
	public static String nameDatabase = "Nhom4";
	public static String username = "sa";
	public static String password = "123";
	public static Connection ConnectSQL(String serverName,String username,String password){
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			System.out.println("Da xac dinh HQTCSDL");
			Connection cn = DriverManager.getConnection("jdbc:sqlserver://" + serverName + ":1433;databaseName=" + nameDatabase + ";user=" + username + ";password=" + password);
			System.out.println("Da ket noi");
			return cn;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}	
	}
}
