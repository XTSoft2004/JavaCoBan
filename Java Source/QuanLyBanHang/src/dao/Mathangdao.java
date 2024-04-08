package dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import bean.MatHangbean;
import bo.Chitiethoadonbo;

public class Mathangdao {
	public Connection cn;
	public SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	public Mathangdao() {
		super();
		cn = Ketnoidao.ConnectSQL(Ketnoidao.serverName,Ketnoidao.username,Ketnoidao.password);	
	}
	public ArrayList<MatHangbean> dsMathang = new ArrayList<MatHangbean>();
	public Chitiethoadonbo cthdbo = new Chitiethoadonbo();
	public ArrayList<MatHangbean> getDs() throws Exception{
		dsMathang.clear();
		String sql = "select * from Mathang";
		PreparedStatement cmd = cn.prepareStatement(sql);
		ResultSet rs = cmd.executeQuery();
		while(rs.next()) {
			String mahang = rs.getString("mahang");
			String tenhang = rs.getString("tenhang");
			Date ngaynhaphang = rs.getDate("ngaynhaphang");
			int soluong = rs.getInt("soluong");
			double gia = rs.getDouble("gia");
			dsMathang.add(new MatHangbean(mahang, tenhang, ngaynhaphang, soluong, gia));
		}
		return dsMathang;
	}
	public Boolean Themmathang(String mahang, String tenhang, Date ngaynhaphang, int soluong, double gia) throws Exception {
		if(TimkiemOneMatHang(mahang) != null)
		{
			System.out.println("Ma hang nay da ton tai");
			return false;
		}
		String sql = "INSERT INTO MatHang (mahang,tenhang, ngaynhaphang, soluong, gia)\r\n"
				+ "VALUES (?,?, ?, ?, ?)";
		// b3 chay cau lenh PreparedStatement
		//String DateNow = sdf.format(Calendar.getInstance().getTime());
		PreparedStatement cmd = cn.prepareStatement(sql);
		cmd.setString(1,mahang);
		cmd.setString(2,tenhang);
		cmd.setDate(3, new java.sql.Date(ngaynhaphang.getTime()));
		cmd.setInt(4,soluong);
		cmd.setDouble(5, gia);	
		int ans = cmd.executeUpdate();
		System.out.println("Ket qua them ds => " + ans);
		//cn.close();
		return true;
	}
	public Boolean Xoamathang(String mahang) throws Exception{	
		cthdbo.XoaChiTiet_mahang(mahang);
		
		String sql = "delete mathang where mahang = ?";
		PreparedStatement cmd = cn.prepareStatement(sql);
		cmd.setString(1, mahang);
		int kq = cmd.executeUpdate();
		if(kq == 1)
			return true;
		else
			return false;	
	}
	public Boolean Chinhsuamathang(String mahang, String tenhang, Date ngaynhaphang, int soluong, double gia) throws Exception {
		String sql = "update mathang\r\n"
				+ "set tenhang = ?,ngaynhaphang = ?,soluong = ?,gia = ? \r\n"
				+ "where mahang = ?";
		PreparedStatement cmd = cn.prepareStatement(sql);
		
		cmd.setString(1,tenhang);
		cmd.setDate(2, new java.sql.Date(ngaynhaphang.getTime()));
		cmd.setInt(3,soluong);
		cmd.setDouble(4, gia);	
		cmd.setString(5,mahang);
		int kq = cmd.executeUpdate();
		if(kq == 1)
			return true;
		else
			return false;	
	}
	public ArrayList<MatHangbean> Timkiem(String keyword){
		ArrayList<MatHangbean> dsSearch = new ArrayList<MatHangbean>();
		for(MatHangbean mh : dsMathang) {
			if(mh.getTenhang().trim().toLowerCase().contains(keyword.trim().toLowerCase())) {
				dsSearch.add(mh);
			}
		}
		return dsSearch;
	}
	public MatHangbean TimkiemOneMatHang(String keyword){
		for(MatHangbean mh : dsMathang) {
			if(mh.getMahang().trim().toLowerCase().equals(keyword.trim().toLowerCase())) {
				return mh;
			}
		}
		return null;
	}
	public void LoadDataFile(String path) throws Exception {
		FileReader fr = new FileReader(path);
		BufferedReader br = new BufferedReader(fr);
		while(true) {
			String st = br.readLine();
			if(st == null || st == "")
				break;
			String[] tach = st.split("[;]");
			String mahang = tach[0];
			String tenhang = tach[1];
			Date ngaynhaphang = sdf.parse(tach[2]);
			int soluong = Integer.parseInt(tach[3]);
			double gia = Double.parseDouble(tach[4]);
			Themmathang(mahang, tenhang, ngaynhaphang, soluong, gia);
		}
		br.close();
	}
}
