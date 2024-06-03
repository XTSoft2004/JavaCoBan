package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import bean.DienThoaiDiDongBean;

public class DienThoaiDiDongDao {
Database db = new Database();
	
	public ArrayList<DienThoaiDiDongBean> findAll() throws Exception {
		ArrayList<DienThoaiDiDongBean> DTDDs = new ArrayList<DienThoaiDiDongBean>();
		db.connect();
		
		String sql = "select * from DienThoaiDiDong";
		PreparedStatement cmd = db.getConnection().prepareStatement(sql);
		ResultSet rs = cmd.executeQuery();
		
		while(rs.next()) {
			String maDT = rs.getString("maDT");
			String tenDT = rs.getString("tenDT");
			String hangSanXuat = rs.getString("hangSanXuat");
			Double giaBan = rs.getDouble("giaBan");
			Date ngayHetHanBaoHanh = rs.getDate("ngayHetHanBaoHanh");
			Integer dungLuongBoNho = rs.getInt("dungLuongBoNho");
			DTDDs.add(new DienThoaiDiDongBean(maDT, tenDT, hangSanXuat, giaBan, ngayHetHanBaoHanh, dungLuongBoNho));
		}
		
		db.disconnect();
		return DTDDs;
	}
	
	public DienThoaiDiDongBean findElementByMaDTDD(String maDT) throws Exception {
		db.connect();
		
		String sql = "select * from DienThoaiDiDong where maDT = ?";
		PreparedStatement cmd = db.getConnection().prepareStatement(sql);
		cmd.setString(1, maDT);
		ResultSet rs = cmd.executeQuery();
		
		if(rs.next()) {
			String tenDT = rs.getString("tenDT");
			String hangSanXuat = rs.getString("hangSanXuat");
			Double giaBan = rs.getDouble("giaBan");
			Date ngayHetHanBaoHanh = rs.getDate("ngayHetHanBaoHanh");
			Integer dungLuongBoNho = rs.getInt("dungLuongBoNho");
			
			db.disconnect();
			return (new DienThoaiDiDongBean(maDT, tenDT, hangSanXuat, giaBan, ngayHetHanBaoHanh, dungLuongBoNho));
		}
		db.disconnect();
		return null;
	}
	
	public void insert(DienThoaiDiDongBean dienthoaididong) throws Exception {
		db.connect();
		
		String sql = "insert into DienThoaiDiDong(maDT, tenDT, hangSanXuat, giaBan, ngayHetHanBaoHanh, dungLuongBoNho) "
				+ "values(?,?,?,?,?,?)";
		PreparedStatement cmd = db.getConnection().prepareStatement(sql);
		cmd.setString(1, dienthoaididong.getMaDT());
		cmd.setString(2, dienthoaididong.getTenDT());
		cmd.setString(3, dienthoaididong.getHangSanXuat());
		cmd.setDouble(4, dienthoaididong.getGiaBan());
		cmd.setDate(5, new java.sql.Date(dienthoaididong.getNgayHetHanBaoHanh().getTime()));
		cmd.setInt(6, dienthoaididong.getDungLuongBoNho());
		
		cmd.executeUpdate();
		db.disconnect();
	}
}
