package bo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import bean.NhanVienBean;
import dao.Ketnoidao;
import dao.NhanVienDao;

public class nhanvienbo {
	public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	NhanVienDao nvdao = new NhanVienDao();
	ArrayList<NhanVienBean> ds;
	public ArrayList<NhanVienBean> getnv() throws Exception{
		ds = nvdao.getnv();
		return ds;
	}
	public int DeleteMemeber(String manv) throws Exception{
		for(NhanVienBean nv : ds) {
			if(nv.getManv().equals(manv)) {
				ds.remove(nv);
				nvdao.DeleteMemeber(manv);
				return 1;
			}
		}
		return 0;
	}
	public int TangHsl(String manv,Double hsl) throws Exception{
		for(NhanVienBean nv : ds) {
			if(nv.getManv().equals(manv)) {
				nv.setHsl(nv.getHsl() + hsl);
				nvdao.TangHSL(manv, hsl);
				return 1;
			}
		}
		return 0;
	}
	public void ThemDS(String pathFile) {
		try {
			FileReader fr = new FileReader(pathFile);
			BufferedReader br = new BufferedReader(fr);
			while(true) {
				String st = br.readLine();
				if(st == null || st == "")
					break;
				String[] che = st.split("[,]");
				nvdao.ThemNhanVien(che[0], che[1], Boolean.parseBoolean(che[2]), sdf.parse(che[3]), Double.parseDouble(che[4]), che[5], che[6]);
			}
			br.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
