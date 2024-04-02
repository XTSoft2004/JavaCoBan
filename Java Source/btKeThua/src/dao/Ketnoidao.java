package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Ketnoidao {
	public Connection cn;
	public void ketnoi() throws Exception{
		//b1:xac dinh he QTCSDL
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//		System.out.println("Da xac dinh HQTCSDL");
		//b2: ket noi vao csdl: Nhom1, sa, pass, server:...
		cn = DriverManager.getConnection("jdbc:sqlserver://TRUONGDESKTOP\\SQLEXPRESS:1433;databaseName=Nhom1;user=sa;password=123");
//		System.out.println("Co the qua mon lmao");
	}
	public void TimKiem(String key) {
		try {
			Ketnoidao kn=new Ketnoidao();
			kn.ketnoi();
			//b2: tao cau lenh sql
			String sql="select * from nhanvien where hoten like ?";
			//b3: tao cau lenh PreparedStatement
			PreparedStatement cmd=kn.cn.prepareStatement(sql);
			//b4: truyen tham so neu co
			cmd.setString(1, "%" + key + "%");
			//b5: thuc hien cau lenh
			ResultSet rs=cmd.executeQuery();
			//b6: duyet qua cac dong trong rs
			while(rs.next()) {
				System.out.println(rs.getString("manv"));
				System.out.println(rs.getString("hoten"));
				System.out.println(rs.getDouble("hsl"));
				System.out.println("-----------------");
			}
			rs.close();
			kn.cn.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public int Xoa(String manv) {
		try {
			Ketnoidao kn=new Ketnoidao();
			kn.ketnoi();
			String sql="delete from nhanvien where manv=?";
			PreparedStatement ps= kn.cn.prepareStatement(sql);
			ps.setString(1,manv);
			int rs=ps.executeUpdate();
			ps.close(); kn.cn.close();
			return rs;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return 0;
		}
	}
	public void HienThi() {
		try {
			Ketnoidao kn=new Ketnoidao();
			kn.ketnoi();
			//b2: tao cau lenh sql
			String sql="select * from nhanvien";
			//b3: tao cau lenh PreparedStatement
			PreparedStatement cmd=kn.cn.prepareStatement(sql);
			//b4: truyen tham so neu co
			//b5: thuc hien cau lenh
			ResultSet rs=cmd.executeQuery();
			//b6: duyet qua cac dong trong rs
			while(rs.next()) {
				System.out.println(rs.getString("manv"));
				System.out.println(rs.getString("hoten"));
				System.out.println(rs.getBoolean("gioitinh"));
				System.out.println(rs.getDouble("hsl"));
				System.out.println("-----------------");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		try {
			Ketnoidao kn=new Ketnoidao();
			kn.ketnoi();
			System.out.println("ket qua hien thi");
//			kn.HienThi();
//			kn.TimKiem("Le");
			kn.Xoa("nv01");
			System.out.println("ket qua sau khi xoa: ");
			kn.HienThi();
			kn.cn.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
