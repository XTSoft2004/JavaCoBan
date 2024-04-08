package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import bean.ChiTietHoaDonbean;
import bean.MatHangbean;

public class Hoadondao {
	public Connection cn;
	public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	public Chitiethoadondao cthoadondao = new Chitiethoadondao();
	public Hoadondao() {
		super();
		cn = Ketnoidao.ConnectSQL(Ketnoidao.serverName,Ketnoidao.nameDatabase,Ketnoidao.username,Ketnoidao.password);	
	}
	public Boolean TaoHoaDon(int idUser,ArrayList<ChiTietHoaDonbean> dsMathang) throws Exception {
		String sql = "INSERT INTO hoadon (ngaytaohoadon,idUser)\r\n"
				+ "VALUES (?,?)";
		// b3 chay cau lenh PreparedStatement
		String DateNow = sdf.format(Calendar.getInstance().getTime());
		Date dNow = sdf.parse(DateNow);
		PreparedStatement cmd = cn.prepareStatement(sql);
		cmd.setDate(1,new java.sql.Date(dNow.getTime()));
		cmd.setInt(2,idUser);
		int kq = cmd.executeUpdate();
		if(kq == 1) {
			int mahoadon = GetIdHoaDon();
			TaoDanhSachMatHang(mahoadon,dsMathang);
			return true;
		}
		return false;		
	}
	public int GetIdHoaDon() throws Exception {
		String sql = "select * from hoadon";
		PreparedStatement cmd = cn.prepareStatement(sql);
		ResultSet rs = cmd.executeQuery();
		int id = -1;
		while(rs.next()) {
			id = rs.getInt("mahoadon");
		}
		return id;
	}
	public void TaoDanhSachMatHang(int mahoadon,ArrayList<ChiTietHoaDonbean> dsChitiet) throws Exception {
		for(ChiTietHoaDonbean mh : dsChitiet) {
			cthoadondao.ThemChiTiet(mahoadon, mh.getMahang(), mh.getSoluongmua());	
		}
	}
}
