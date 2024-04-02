package dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import bean.NhanVienBean;

public class NhanVienDao {
	public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	public ArrayList<NhanVienBean> getnv(){
		ArrayList<NhanVienBean> nhanVienBeans = new ArrayList<NhanVienBean>();
		try {
			Ketnoidao kn = new Ketnoidao();
			kn.ketnoi();
			
			// b2 tao cau lenh sql
			String sql = "select * from NhanVien";
			// b3 chay cau lenh PreparedStatement
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			
			ResultSet rs = cmd.executeQuery();
			while(rs.next()) {
				nhanVienBeans.add(new NhanVienBean(rs.getString("hoten"), rs.getBoolean("gioitinh"), rs.getDate("ngaysinh"), rs.getString("manv"), rs.getDouble("hsl"), rs.getString("email"), rs.getString("sodt")));
			}
			rs.close();	
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return nhanVienBeans;
	}
	public int DeleteMemeber(String masv) throws Exception {
		Ketnoidao kn = new Ketnoidao();
		kn.ketnoi();
		String sqlCommand = "delete from NhanVien where manv = ?";
		PreparedStatement cmd = kn.cn.prepareStatement(sqlCommand);
		cmd.setString(1, masv);
		int kq = cmd.executeUpdate();
		kn.cn.close();
		return kq;
	}
	public int TangHSL(String masv,Double hsl) throws Exception {
		Ketnoidao kn = new Ketnoidao();
		kn.ketnoi();
		String sqlCommand = "update nhanvien set hsl = hsl + ? where manv = ?";
		PreparedStatement cmd = kn.cn.prepareStatement(sqlCommand);
		cmd.setDouble(1, hsl);
		cmd.setString(2, masv);
		int kq = cmd.executeUpdate();
		kn.cn.close();
		return kq;
	}
	public int ThemNhanVien(String manv,String hoten, Boolean gioiTinh, Date ngaySinh, Double hsl, String email,
			String phone) throws Exception {
		Ketnoidao kn = new Ketnoidao();
		kn.ketnoi();
		String sqlCommand = "insert into Nhanvien (manv,hoten,gioitinh,ngaysinh,hsl,email,sodt)\r\n"
				+ "Values(?,?,?,?,?,?,?)";
		PreparedStatement cmd = kn.cn.prepareStatement(sqlCommand);
		cmd.setString(1, manv);
		cmd.setString(2, hoten);
		cmd.setBoolean(3, gioiTinh);
		cmd.setDate(4, new java.sql.Date(ngaySinh.getTime()));
		cmd.setDouble(5, hsl);
		cmd.setString(6, email);
		cmd.setString(7, phone);
		int kq = cmd.executeUpdate();
		kn.cn.close();
		return kq;
	}
}
