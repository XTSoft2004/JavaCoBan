package view;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dao.Ketnoidao;

public class Nguoiview {

	public static void main(String[] args) {
		// Kết nối SQL
		Ketnoidao.ConnectSQL("XTSOFT\\SQLEXPRESS", "QuanLyBanHang", "sa", "123");
		
		try {
			String sql = "select * from account";
			// Ketnoidao.cn này đã được kết nối
			PreparedStatement cmd = Ketnoidao.cn.prepareStatement(sql);
			ResultSet rs = cmd.executeQuery();
			while(rs.next()) {
				int idUser = rs.getInt("idUser");
				String taikhoan = rs.getString("username");
				String matkhau = rs.getString("password");
				String hovaten = rs.getString("fullname");
				System.out.println(idUser + ";" + taikhoan + ";" + matkhau + ";" + hovaten);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

}
