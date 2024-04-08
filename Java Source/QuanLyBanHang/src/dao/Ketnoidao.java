package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Ketnoidao {
	//public static Connection cn;
	public static Connection ConnectSQL(String serverName,String nameDatabase,String username,String password){
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
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		try {
//			// b1 ket noi
//			Ketnoidao kn = new Ketnoidao();
//			kn.ConnectSQL("TRUONGDESKTOP\\SQLEXPRESS","QuanLyBanHang","sa","123");
//			// b2 tao cau lenh sql
//			String sql = "delete NhanVien where manv = ?";
//			// b3 chay cau lenh PreparedStatement
//			PreparedStatement cmd = kn.cn.prepareStatement(sql);
//			cmd.setString(1, "nv5");
//			// b4 thuc ti cau lenh
//			ResultSet rs = cmd.executeQuery();
//			while(rs.next()) {
//				System.out.println(rs.getString("manv"));
//				System.out.println(rs.getString("hoten"));
//				System.out.println(rs.getBoolean("gioitinh"));
//				System.out.println(rs.getDouble("hsl"));
//			}
//			rs.close();
//			
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//	}

}
