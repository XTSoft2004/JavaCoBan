package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import bean.Nhanvienbean;

public class Nhanviendao {
	ArrayList<Nhanvienbean> ds = new ArrayList<Nhanvienbean>();
	public ArrayList<Nhanvienbean> getDs() throws Exception{ 
		// Xóa để khi chạy getDs lại để không bị ghi đè
		ds.clear();
		Ketnoidao kn = new Ketnoidao();
		kn.ketnoi();
		String sql="select * from nhanvien";
		//b3: tao cau lenh PreparedStatement
		PreparedStatement cmd =kn.cn.prepareStatement(sql);
		ResultSet rs=cmd.executeQuery();
		while(rs.next()) {
			ds.add(new Nhanvienbean(rs.getString("manv"), rs.getString("hoten"), rs.getBoolean("gioitinh"), rs.getDate("ngaysinh"), rs.getDouble("hsl"), rs.getString("email"), rs.getString("sodt")));
		}
		rs.close();
		return ds;
	}
	//Date ở trên tham số truyền vào này theo thư viện java.util.Date
	public int ThemNV(String manv, String hoten, Boolean gioitinh, Date ngaysinh, Double hsl, String email, String phone) throws Exception {
		Ketnoidao kn = new Ketnoidao();
		kn.ketnoi();
		String sqlCommand = "insert into Nhanvien (manv,hoten,gioitinh,ngaysinh,hsl,email,sodt)"
				+ "Values (?,?,?,?,?,?,?)";
		PreparedStatement cmd =kn.cn.prepareStatement(sqlCommand);
		cmd.setString(1, manv);
		cmd.setString(2, hoten);
		cmd.setBoolean(3, gioitinh);
		// sửa lại java.sql.Date để nhập vào csdl 
		cmd.setDate(4, new java.sql.Date(ngaysinh.getTime()));
		cmd.setDouble(5, hsl);
		cmd.setString(6, email);
		cmd.setString(7, phone);
		int kq = cmd.executeUpdate();
		kn.cn.close();
		return kq;
	}
	public int XoaNV(String manv) throws Exception{
		Ketnoidao kn = new Ketnoidao();
		kn.ketnoi();
		String sqlCommand = "delete from nhanvien where manv = ?";
		PreparedStatement cmd =kn.cn.prepareStatement(sqlCommand);
		cmd.setString(1, manv);
		int kq = cmd.executeUpdate();
		kn.cn.close();
		return kq;
	}
	public int TangHSL(String manv,Double hsl) throws Exception {
		Ketnoidao kn = new Ketnoidao();
		kn.ketnoi();
		String sqlCommand = "update Nhanvien set hsl = hsl + ? where manv = ?";
		PreparedStatement cmd =kn.cn.prepareStatement(sqlCommand);
		cmd.setDouble(1, hsl);
		cmd.setString(2, manv);
		int kq = cmd.executeUpdate();
		kn.cn.close();
		return kq;
	}
}

//vao csdl lay ve all nhanvien
//gio lam qua huong doi tuong, luu vao ds
//viet 3 ham: them, xoa, sua 