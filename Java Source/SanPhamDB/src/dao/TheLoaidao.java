package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.TheLoaibean;

public class TheLoaidao {
	public ArrayList<TheLoaibean> dsTheLoai = new ArrayList<TheLoaibean>();
	public ArrayList<TheLoaibean> getDs() throws Exception{
		String sqlCommand = "select * from theloai";
		PreparedStatement cmd = Ketnoidao.cn.prepareStatement(sqlCommand);
		ResultSet rs = cmd.executeQuery();
		while(rs.next()) {
			int IdTheLoai = rs.getInt("IdTheLoai");
			String TenTheLoai = rs.getString("TenTheLoai");
			Boolean ConSuDung = rs.getBoolean("ConSuDung");
			dsTheLoai.add(new TheLoaibean(IdTheLoai, TenTheLoai, ConSuDung));
		}
		return dsTheLoai;
	}
}
