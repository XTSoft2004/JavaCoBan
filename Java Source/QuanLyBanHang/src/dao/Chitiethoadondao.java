package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import bean.ChiTietHoaDonbean;

public class Chitiethoadondao {
	public Connection cn;
	public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	public Chitiethoadondao() {
		super();
		cn = Ketnoidao.ConnectSQL(Ketnoidao.serverName,Ketnoidao.nameDatabase,Ketnoidao.username,Ketnoidao.password);	
	}
	public ArrayList<ChiTietHoaDonbean> dsChitiet = new ArrayList<ChiTietHoaDonbean>();
	
	public Boolean ThemChiTiet(int mahoadon, String mahang, int soluongmua) throws Exception {
		
		String sql = "INSERT INTO chitiethoadon (mahoadon,mahang,soluongmua)\r\n"
				+ "VALUES (?,?,?)";	
		PreparedStatement cmd = cn.prepareStatement(sql);
		cmd.setInt(1, mahoadon);
		cmd.setString(2,mahang);
		cmd.setInt(3, soluongmua);
		int kq = cmd.executeUpdate();
		return kq == 1 ? true : false;
	}
	public Boolean XoaChiTiet(int mahoadon) throws Exception {
		String sql = "delete chitiethoadon "
				+ "where mahoadon = ?";	
		PreparedStatement cmd = cn.prepareStatement(sql);
		cmd.setInt(1, mahoadon);
		int kq = cmd.executeUpdate();
		return kq == 1 ? true : false;
	}
	public Boolean XoaChiTiet_mahang(String mahang) throws Exception {
		String sql = "delete chitiethoadon "
				+ "where mahang = ?";	
		PreparedStatement cmd = cn.prepareStatement(sql);
		cmd.setString(1, mahang);
		int kq = cmd.executeUpdate();
		return kq == 1 ? true : false;
	}
	public ArrayList<String> GetMaHoaDon_Mahang(String mahang) throws Exception{
		ArrayList<String> listID = new ArrayList<String>();
		String sql = "select * from chitiethoadon "
				+ "where mahang = ?";
		PreparedStatement cmd = cn.prepareStatement(sql);
		cmd.setString(1, mahang);
		ResultSet rs = cmd.executeQuery();
		while(rs.next()) {
			String mahoadon = rs.getString("mahoadon");
			listID.add(mahoadon);
		}
		return listID;
	}
	public ArrayList<ChiTietHoaDonbean> getDs_mahoadon(int mahoadon) throws Exception{
		dsChitiet.clear();
		String sql = "select * from chitiethoadon "
				+ "where mahoadon = ?";
		PreparedStatement cmd = cn.prepareStatement(sql);
		cmd.setInt(1, mahoadon);
		ResultSet rs = cmd.executeQuery();
		while(rs.next()) {
			int machitiet = rs.getInt("machitiet");
			int mahoadon_int = rs.getInt("mahoadon"); 
			String mahang = rs.getString("mahang");
			int soluong = rs.getInt("soluongmua");
			dsChitiet.add(new ChiTietHoaDonbean(machitiet, mahoadon_int, mahang, soluong));
		}
		return dsChitiet;
	}
}
