package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
	private Connection cn;
	private static String serverName;
	private static  String dbName;
	private static String user;
	private static String password;
	private static Integer port;
	
	public Database() {
		
	}
	
	public Database(String serverName, String dbName, String user, String password, Integer port) {
		Database.serverName = serverName;
		Database.dbName = dbName;
		Database.user = user;
		Database.password = password;
		Database.port = port;
	}
	
	public void connect() throws Exception {
		//buoc 1: Xac dinh HQTCSDL:
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		//buoc 2: Ket noi vao co so du lieu:
		String url = "jdbc:sqlserver://" + Database.serverName + ":" + Database.port.toString()
				+ ";databaseName=" + Database.dbName
				+ ";user=" + Database.user
				+ ";password=" + Database.password;
		this.cn = DriverManager.getConnection(url);
	}

	public String getServerName() {
		return serverName;
	}

	public void setServerName(String serverName) {
		Database.serverName = serverName;
	}

	public String getDbName() {
		return dbName;
	}

	public void setDbName(String dbName) {
		Database.dbName = dbName;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		Database.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		Database.password = password;
	}

	public Integer getPort() {
		return port;
	}

	public void setPort(Integer port) {
		Database.port = port;
	}
	
	public Connection getConnection() {
		return this.cn;
	}
	
	public void disconnect() throws SQLException {
		if(this.cn != null) {
			this.cn.close();
		}
	}
}
