package dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import bean.Hocvienbean;
import bean.TinAbean;
import bean.TinBbean;

public class Hocviendao {
	public ArrayList<Hocvienbean> ds = new ArrayList<Hocvienbean>();
	public ArrayList<Hocvienbean> getDanhSach() {
		try {
			FileReader fr = new FileReader("ds.txt");
			BufferedReader br = new BufferedReader(fr);
			while(true) {
				String st = br.readLine();
				if(st == null || st == "")
					break;
				String[] che = st.split("[;]");
				if(che.length == 4)
					ds.add(new TinAbean(che[0], che[1], Double.parseDouble(che[2]), Double.parseDouble(che[3])));
				else if(che.length == 5)
					ds.add(new TinBbean(che[0], che[1], Double.parseDouble(che[2]), Double.parseDouble(che[3]), Double.parseDouble(che[4])));
			}
			br.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ds;
	}
}
