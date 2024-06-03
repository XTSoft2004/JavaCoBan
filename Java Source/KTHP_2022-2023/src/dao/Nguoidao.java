package dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.security.GuardedObject;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.annotation.processing.Filer;

import bean.Giangvienbean;
import bean.Nguoibean;
import bean.Nhanvienbean;

public class Nguoidao {
	public ArrayList<Nguoibean> ds = new ArrayList<Nguoibean>();
	public void SaveKetQua(ArrayList<String> ds) throws Exception {
		FileWriter fw = new FileWriter("ketqua.txt",false);
		PrintWriter pw = new PrintWriter(fw);
		for(String s : ds) {
			pw.println(s);
		}
		fw.close();
	}
	public void KiemTraDuLieuHopLe() throws Exception{
		ArrayList<String> ds = new ArrayList<String>();
		FileReader fr = new FileReader("ds.txt");
		BufferedReader br = new BufferedReader(fr);
		while(true) {
			String st = br.readLine();
			if(st == null || st == "")
				break;
			String tach[] = st.split("[;]");
			if(tach.length == 4 || tach.length == 5 || tach[2].equals("chinhthuc") || tach[2].equals("hopdong"))
			{
				System.out.println(st);
				ds.add(st);
			}
		}
		br.close();
		SaveKetQua(ds);
	}
	public ArrayList<Nguoibean> NapDuLieu() throws Exception{
		ds.clear();
		FileReader fr = new FileReader("ketqua.txt");
		BufferedReader br = new BufferedReader(fr);
		while(true) {
			String st = br.readLine();
			if(st == null || st == "")
				break;
			String[] tach = st.split("[;]");
			if(tach.length == 4)
				ds.add(new Nhanvienbean(tach[0], tach[1], tach[2], Double.parseDouble(tach[3])));
			else if(tach.length == 5)
				ds.add(new Giangvienbean(tach[0], tach[1], tach[2], Double.parseDouble(tach[3]), Double.parseDouble(tach[4])));
		}
		br.close();
		return ds;
	}
	public boolean NapNV(Nhanvienbean nv) throws Exception {
		String sqlCommand = "Insert into Nhanvien (maNV,HovaTen,LoaiHopDong,HeSoLuong) values (?,?,?,?)";
		PreparedStatement cmd = Ketnoidao.cn.prepareStatement(sqlCommand);
		cmd.setString(1, nv.getMaNV());
		cmd.setString(2, nv.getHovaTen());
		cmd.setString(3, nv.getLoaiHopDong());
		cmd.setDouble(4, nv.getHeSoLuong());
		int kq = cmd.executeUpdate();
		return kq == 1 ? true : false;
	}
	public boolean NapGV(Giangvienbean nv) throws Exception {
		String sqlCommand = "Insert into Giangvien (maGV,HovaTen,LoaiHopDong,HeSoLuong,PhuCap) values (?,?,?,?,?)";
		PreparedStatement cmd = Ketnoidao.cn.prepareStatement(sqlCommand);
		cmd.setString(1, nv.getMaGV());
		cmd.setString(2, nv.getHovaTen());
		cmd.setString(3, nv.getLoaiHopDong());
		cmd.setDouble(4, nv.getHeSoLuong());
		cmd.setDouble(5, nv.getPhuCap());
		int kq = cmd.executeUpdate();
		return kq == 1 ? true : false;
	}
	public ArrayList<Nhanvienbean> getDsNV() throws Exception {
		ArrayList<Nhanvienbean> ds = new ArrayList<Nhanvienbean>();
		String sqlCommand = "select * from Nhanvien";
		PreparedStatement cmd = Ketnoidao.cn.prepareStatement(sqlCommand);
		ResultSet rs = cmd.executeQuery();
		while(rs.next())
		{
			String maNV = rs.getString("maNV");
			String HovaTen = rs.getString("HovaTen");
			String LoaiHopDong = rs.getString("LoaiHopDong");
			double HeSoLuong = rs.getDouble("HeSoLuong");
			ds.add(new Nhanvienbean(maNV, HovaTen, LoaiHopDong, HeSoLuong));
		}
		return ds;
	}
	public ArrayList<Giangvienbean> getDsGV() throws Exception {
		ArrayList<Giangvienbean> ds = new ArrayList<Giangvienbean>();
		String sqlCommand = "select * from GiangVien";
		PreparedStatement cmd = Ketnoidao.cn.prepareStatement(sqlCommand);
		ResultSet rs = cmd.executeQuery();
		while(rs.next())
		{
			String maNV = rs.getString("maGV");
			String HovaTen = rs.getString("HovaTen");
			String LoaiHopDong = rs.getString("LoaiHopDong");
			double HeSoLuong = rs.getDouble("HeSoLuong");
			double PhuCap = rs.getDouble("PhuCap");
			ds.add(new Giangvienbean(maNV, HovaTen, LoaiHopDong, HeSoLuong, PhuCap));
		}
		return ds;
	}
}
