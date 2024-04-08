package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

import bean.Accountbean;

public class Accountdao {
	public Connection cn;
	public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	public Accountdao() {
		super();
		cn = Ketnoidao.ConnectSQL(Ketnoidao.serverName,Ketnoidao.username,Ketnoidao.password);	
	} 
	public Accountbean GetAccount(String username) throws Exception {
		String sql = "select * from account where username = ?";
		PreparedStatement cmd = cn.prepareStatement(sql);
		cmd.setString(1, username);
		ResultSet rs = cmd.executeQuery();
		while(rs.next()) {
			int idUser = rs.getInt("idUser");
			String taikhoan = rs.getString("username");
			String matkhau = rs.getString("password");
			String hovaten = rs.getString("fullname");
			return new Accountbean(idUser, taikhoan, matkhau, hovaten);
		}
		return null;
	}
	public boolean LoginAccount(String username,String password) throws Exception {
		String sql = "select * from account where username = ? and password = ?";
		PreparedStatement cmd = cn.prepareStatement(sql);
		cmd.setString(1, username);
		cmd.setString(2, password);
		ResultSet rs = cmd.executeQuery();
		while(rs.next()) {
			return true;
		}
		return false;
	}
	public boolean TaoTaiKhoan(String username,String password,String fullname) throws Exception{
		if(GetAccount(username) != null)
			return false;
		String sql = "INSERT INTO account (username,password,fullname)"
				+ "VALUES (?,?,?)";
		PreparedStatement cmd = cn.prepareStatement(sql);
		cmd.setString(1,username);
		cmd.setString(2,password);
		cmd.setString(3, fullname);
		int kq = cmd.executeUpdate();
		return kq == 1 ? true : false;
	}
}
