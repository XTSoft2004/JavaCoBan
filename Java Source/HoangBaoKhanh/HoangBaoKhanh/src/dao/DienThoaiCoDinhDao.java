package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.DienThoaiCoDinhBean;

public class DienThoaiCoDinhDao {
Database db = new Database();
	
	public ArrayList<DienThoaiCoDinhBean> findAll() throws Exception {
		ArrayList<DienThoaiCoDinhBean> DTCDs = new ArrayList<DienThoaiCoDinhBean>();
		db.connect();
		
		String sql = "select * from DienThoaiCoDinh";
		PreparedStatement cmd = db.getConnection().prepareStatement(sql);
		ResultSet rs = cmd.executeQuery();
		
		while(rs.next()) {
			String maDT = rs.getString("maDT");
			String tenDT = rs.getString("tenDT");
			String hangSanXuat = rs.getString("hangSanXuat");
			Double giaBan = rs.getDouble("giaBan");
			String mauSac = rs.getString("mauSac");
			DTCDs.add(new DienThoaiCoDinhBean(maDT, tenDT, hangSanXuat, giaBan, mauSac));
		}
		
		db.disconnect();
		return DTCDs;
	}
	
	public DienThoaiCoDinhBean findElementByMaDTCD(String maDT) throws Exception {
		db.connect();
		
		String sql = "select * from DienThoaiCoDinh where maDT = ?";
		PreparedStatement cmd = db.getConnection().prepareStatement(sql);
		cmd.setString(1, maDT);
		ResultSet rs = cmd.executeQuery();
		
		if(rs.next()) {
			String tenDT = rs.getString("tenDT");
			String hangSanXuat = rs.getString("hangSanXuat");
			Double giaBan = rs.getDouble("giaBan");
			String mauSac = rs.getString("mauSac");
			
			db.disconnect();
			return (new DienThoaiCoDinhBean(maDT, tenDT, hangSanXuat, giaBan, mauSac));
		}
		db.disconnect();
		return null;
	}
	
	public void insert(DienThoaiCoDinhBean dienthoaicodinh) throws Exception {
		db.connect();
		
		String sql = "insert into DienThoaiCoDinh(maDT, tenDT, hangSanXuat, giaBan, mauSac) "
				+ "values(?,?,?,?,?)";
		PreparedStatement cmd = db.getConnection().prepareStatement(sql);
		cmd.setString(1, dienthoaicodinh.getMaDT());
		cmd.setString(2, dienthoaicodinh.getTenDT());
		cmd.setString(3, dienthoaicodinh.getHangSanXuat());
		cmd.setDouble(4, dienthoaicodinh.getGiaBan());
		cmd.setString(5, dienthoaicodinh.getMauSac());
		
		cmd.executeUpdate();
		db.disconnect();
	}
}
