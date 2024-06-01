package dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.SanPhambean;
import bo.SanPhambo;

public class SanPhamdao {
	public boolean AddSanPham(SanPhambean sp) throws Exception {
		String sqlCommand = "insert into SanPham (IdSanPham,TenSanPham,DonViTinh,DonGia,IdTheLoai) VALUES (?,?,?,?,?)";
		PreparedStatement cmd = Ketnoidao.cn.prepareStatement(sqlCommand);
		cmd.setInt(1, sp.getIdSanPham());
		cmd.setString(2, sp.getTenSanPham());
		cmd.setString(3, sp.getDonViTinh());
		cmd.setDouble(4, sp.getDonGia());
		cmd.setInt(5, sp.getIdTheLoai());
		int kq = cmd.executeUpdate();
		if(kq == 1) {
			System.out.println("Da them thanh cong");
		}
		else {
			System.out.println("Them that bai");
		}
		return kq == 1 ? true : false;
	}

	public ArrayList<SanPhambean> ds = new ArrayList<SanPhambean>();
	public ArrayList<SanPhambean> getSPham() throws Exception {
		ds.clear();
		String sqlCommand = "select * from SanPham";
		PreparedStatement cmd = Ketnoidao.cn.prepareStatement(sqlCommand);
		ResultSet rs = cmd.executeQuery();
		while (rs.next()) {
			int IdSanPham = rs.getInt("IdSanPham");
			String TenSanPham = rs.getString("TenSanPham");
			String DonViTinh = rs.getString("DonViTinh");
			double DonGia = rs.getDouble("DonGia");
			int IdTheLoai = rs.getInt("IdTheLoai");
			ds.add(new SanPhambean(IdSanPham, TenSanPham, DonViTinh, DonGia, IdTheLoai));
		}
		return ds;
	}
	public void AddFileSP(String pathFile) throws Exception {
		FileReader fr = new FileReader(pathFile);
		BufferedReader br = new BufferedReader(fr);
		while(true) {
			String st = br.readLine();
			if(st == null || st == "")
				break;
			String[] tach = st.split("[|]");
			if(tach.length == 5) 
			{
				SanPhambo spbo = new SanPhambo();
				spbo.AddSanPham(new SanPhambean(Integer.parseInt(tach[0]), tach[1], tach[2], Double.parseDouble(tach[3]) , Integer.parseInt(tach[4])));
			}
		}
		br.close();
	}
}
