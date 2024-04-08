package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Chitiethoadondao {
	public Connection cn;
	public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	public Chitiethoadondao() {
		super();
		cn = Ketnoidao.ConnectSQL(Ketnoidao.serverName,Ketnoidao.nameDatabase,Ketnoidao.username,Ketnoidao.password);	
	}
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
	
}
