package dao;
import java.io.BufferedReader;
import java.io.FileReader;
import java.security.GuardedObject;
import java.util.ArrayList;

import bean.sinhvienbean;
public class sinhviendao {
	public ArrayList<sinhvienbean> ds = new ArrayList<sinhvienbean>();
	public ArrayList<sinhvienbean> getsinhvien() throws Exception {
		try {
			FileReader fr = new FileReader("sinhvien.txt");
			BufferedReader br = new BufferedReader(fr);
			while(true) {
				String st = br.readLine();
				if(st == null || st == "")
					break;
				String[] tach = st.split("[;]");
				ds.add(new sinhvienbean(tach[0],tach[1],tach[2],Double.parseDouble(tach[3])));
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return ds;
	}
}
