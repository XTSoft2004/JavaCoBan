package dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.security.GuardedObject;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import javax.annotation.processing.Filer;

import bean.Giangvienbean;
import bean.Nguoibean;
import bean.Nhanvienbean;

public class Nguoidao {
	public ArrayList<Nguoibean> ds = new ArrayList<Nguoibean>();
	public void SaveKetQua(ArrayList<String> ds) throws Exception {
		FileWriter fw = new FileWriter("ds.txt",false);
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
				ds.add(st);
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
		String sqlCommand = "Insert into Nhanvien (maNV,HovaTen,LoaiHopDong,HeSoLuong) values (?,?,?,?,?)";
		PreparedStatement cmd = 
	}
}
