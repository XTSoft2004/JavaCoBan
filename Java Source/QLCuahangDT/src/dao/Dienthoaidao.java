package dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import Util.Validate;
import bean.DTCDbean;
import bean.DTDTbean;
import bean.Dienthoaibean;

public class Dienthoaidao {
	public ArrayList<Dienthoaibean> ds = new ArrayList<Dienthoaibean>();
	public SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	public void KiemtraHopLe() throws Exception {
		ArrayList<Dienthoaibean> ds = new ArrayList<Dienthoaibean>();
		FileReader fr = new FileReader("Trần Xuân Trường.txt");
		BufferedReader br = new BufferedReader(fr);
		while (true) {
			String st = br.readLine();
			if (st == null || st == "")
				break;
			String[] tach = st.split("[;]");
			if(!Validate.CheckMaDT(tach[0]))
			{
				if(tach.length == 5) 
					ds.add(new DTCDbean(tach[0], tach[1], tach[2], Double.parseDouble(tach[3]), tach[4]));
				else if(tach.length == 6)
					ds.add(new DTDTbean(tach[0], tach[1], tach[2], Double.parseDouble(tach[3]), sdf.parse(tach[4]), tach[5]));
			}
		}
		br.close();
		SaveKetQua(ds);
	}
	public void SaveKetQua(ArrayList<Dienthoaibean> ds) throws Exception {
		FileWriter fw = new FileWriter("ketqua.txt");	
		PrintWriter pw = new PrintWriter(fw);
		for(Dienthoaibean dt : ds) {
			pw.println(dt.toString());
		}
		fw.close();
	}
	public ArrayList<Dienthoaibean> NapKetQua() throws Exception{
		ds.clear();
		FileReader fr = new FileReader("ketqua.txt");
		BufferedReader br = new BufferedReader(fr);
		while (true) {
			String st = br.readLine();
			if (st == null || st == "")
				break;
			String[] tach = st.split("[;]");
			if(!Validate.CheckMaDT(tach[0]))
			{
				if(tach.length == 5) 
					ds.add(new DTCDbean(tach[0], tach[1], tach[2], Double.parseDouble(tach[3]), tach[4]));
				else if(tach.length == 6)
					ds.add(new DTDTbean(tach[0], tach[1], tach[2], Double.parseDouble(tach[3]), sdf.parse(tach[4]), tach[5]));
			}
		}
		br.close();
		return ds;
	}
	public ArrayList<DTDTbean> getDsDidong() throws Exception{
		ArrayList<DTDTbean> ds = new ArrayList<DTDTbean>();
		String sqlCommand = "select * from Didong";
		PreparedStatement cmd = Ketnoidao.cn.prepareStatement(sqlCommand);
		ResultSet rs = cmd.executeQuery();
		while(rs.next()) {
			String maDT = rs.getString("maDT");
			String tenDT = rs.getString("tenDT");
			String HangSanXuat = rs.getString("HangSanXuat");
			double Gia = rs.getDouble("Gia");
			Date NgayHetHan = rs.getDate("NgayHetHan");
			String DLBoNho = rs.getString("DLBoNho");
			ds.add(new DTDTbean(maDT, tenDT, HangSanXuat, Gia, NgayHetHan, DLBoNho));
		}
		return ds;
	}
	public boolean NapDiDong(DTDTbean dtDiDong) throws Exception {
		String sqlCommand = "insert into Didong (maDT,tenDT,HangSanXuat,Gia,NgayHetHan,DLBoNho) values (?,?,?,?,?,?)";
		PreparedStatement cmd = Ketnoidao.cn.prepareStatement(sqlCommand);
		cmd.setString(1,dtDiDong.getMaDT());
		cmd.setString(2, dtDiDong.getTenDT());
		cmd.setString(3, dtDiDong.getHangSX());
		cmd.setDouble(4, dtDiDong.getGia());
		cmd.setDate(5, new java.sql.Date(dtDiDong.getNgayHetHan().getTime()));
		cmd.setString(6, dtDiDong.getDLBoNho());
		int kq = cmd.executeUpdate();
		return kq == 1 ? true : false;
	}
}
