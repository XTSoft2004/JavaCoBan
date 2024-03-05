package dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import bean.NguoiBean;

public class Nguoidao {
	public ArrayList<NguoiBean> ds = new ArrayList<NguoiBean>();
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	public ArrayList<NguoiBean> getsinhvien() throws Exception {
		try {
			FileReader fr = new FileReader("sinhvien.txt");
			BufferedReader br = new BufferedReader(fr);
			while(true) {
				String st = br.readLine();
				if(st == null || st == "")
					break;
				String[] tach = st.split("[;]");
				ds.add(new NguoiBean(tach[0],Boolean.parseBoolean(tach[1]),sdf.parse(tach[2])));
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return ds;
	}
	public void Hienthi() {
		for(NguoiBean sv : ds) {
			System.out.println(sv.toString());
		}
	}
}
