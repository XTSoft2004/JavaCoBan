package dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import bean.KHInternet;
import bean.KHSIM;
import util.Validate;

public class Khachhangdao {
	public ArrayList<KHInternet> dsInternet = new ArrayList<KHInternet>();
	public ArrayList<KHSIM> dsSIM = new ArrayList<KHSIM>();
	public SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	public void NapDuLieu() throws Exception{
		dsInternet.clear();
		dsSIM.clear();
		FileReader fr = new FileReader("khachhang.txt");
		BufferedReader br = new BufferedReader(fr);
		while(true) {
			String st = br.readLine();
			if(st == null || st == "")
				break;
			String tach[] = st.split("[,]");
			if(Validate.CheckDate(tach[4])) {
				Date d1 = sdf.parse(tach[4]);
				if(tach[0].equals("IN"))
					dsInternet.add(new KHInternet(tach[0], tach[1], tach[2], tach[3], d1, tach[5]));
				else if(tach[0].equals("DT"))
					dsSIM.add(new KHSIM(tach[0], tach[1], tach[2], tach[3], d1, tach[5]));
			}	
		}
		br.close();
	}
	public int CountInternet() throws Exception {
		String sqlCommand = "select count(*) from Internet";
		PreparedStatement cmd = Ketnoidao.cn.prepareStatement(sqlCommand);
		ResultSet rs = cmd.executeQuery();
		while(rs.next())
		{
			int num = rs.getInt(1);
			return num;
		}
		return -1;	
	}
	public int CountSIM() throws Exception {
		String sqlCommand = "select count(*) from SIM";
		PreparedStatement cmd = Ketnoidao.cn.prepareStatement(sqlCommand);
		ResultSet rs = cmd.executeQuery();
		while(rs.next())
		{
			int num = rs.getInt(1);
			return num;
		}
		return -1;	
	}
	public boolean ThemInternet(KHInternet kh) throws Exception {
		String nameMaKH = "IN" + (CountInternet() + 1);
		String sqlCommand = "insert into KHInternet (MaDV,TenDV,TenKH,MaKH,NgayDangKy,BangThong) values (?,?,?,?,?)";
		PreparedStatement cmd = Ketnoidao.cn.prepareStatement(sqlCommand);
		cmd.setString(1, kh.getMaDV());
		cmd.setString(2, kh.getTenDV());
		cmd.setString(3, kh.getTenKH());
		cmd.setString(4, nameMaKH);
		cmd.setDate(5, new java.sql.Date(kh.getNgayDangKi().getTime()));
		cmd.setString(6,kh.getBangThong());
		int kq = cmd.executeUpdate();
		return kq == 1 ? true : false;
	}
	public boolean ThemSIM(KHSIM kh) throws Exception {	
		String nameMaDT = "DT" + (CountInternet() + 1);
		String sqlCommand = "insert into KHSIM (MaDV,TenDV,TenKH,MaKH,NgayDangKy,LoaiSIM) values (?,?,?,?,?)";
		PreparedStatement cmd = Ketnoidao.cn.prepareStatement(sqlCommand);
		cmd.setString(1, kh.getMaDV());
		cmd.setString(2, kh.getTenDV());
		cmd.setString(3, kh.getTenKH());
		cmd.setString(4, nameMaDT);
		cmd.setDate(5, new java.sql.Date(kh.getNgayDangKi().getTime()));
		cmd.setString(6,kh.getLoaiSim());
		int kq = cmd.executeUpdate();
		return kq == 1 ? true : false;
	}
	public ArrayList<KHInternet> GetDataInternet()
	{
		return dsInternet;
	}
	public ArrayList<KHSIM> GetDataSIM()
	{
		return dsSIM;
	}
}
