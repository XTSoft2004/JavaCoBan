package view;

import java.sql.Connection;
//import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import dao.Ketnoidao;
import dao.Mathangdao;

public class Demo {
	public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			//Connection cn = Ketnoidao.ConnectSQL("TRUONGDESKTOP\\SQLEXPRESS","QuanLyBanHang","sa","123");
			
			//Mathangdao mhd = new Mathangdao();
			//System.out.println(mhd.Themmathang("mh9", "Xuan mai", sdf.parse("22/12/2004"), 10, 20));
			
						
//			String sql = "delete mathang where mahang = 'mh5'";
//			PreparedStatement cmd = cn.prepareStatement(sql);
//			int kq = cmd.executeUpdate();
//			System.out.println(kq);
			
//			ResultSet rs = cmd.executeQuery();
//			System.out.println(rs);
//			while(rs.next()) {
//				System.out.println(rs.getString("mahang"));
//			}
			
			
			//mhd.Themmathang("mh3", "Tra dao", sdf.parse("2004/12/2"), 7, 9);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
