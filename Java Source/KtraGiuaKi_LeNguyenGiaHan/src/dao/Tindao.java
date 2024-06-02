package dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import bean.TinAbean;
import bean.TinBbean;
import bean.Tinbean;

public class Tindao {
	public ArrayList<Tinbean> dsTin = new ArrayList<Tinbean>();

	public ArrayList<Tinbean> getDS(String pathFile) throws Exception {
		dsTin.clear();
		FileReader fr = new FileReader(pathFile);
		BufferedReader br = new BufferedReader(fr);
		while (true) {
			String st = br.readLine();
			if (st == null || st == "")
				break;
			String[] tach = st.split("[;]");
			if (tach.length == 4)
				dsTin.add(new TinAbean(tach[0], tach[1], Double.parseDouble(tach[2]), Double.parseDouble(tach[3])));
			else if (tach.length == 5)
				dsTin.add(new TinBbean(tach[0], tach[1], Double.parseDouble(tach[2]), Double.parseDouble(tach[3]),
						Double.parseDouble(tach[4])));
		}
		br.close();
		return dsTin;
	}

	public void SaveFile(String pathFile,ArrayList<String> dsTin) throws Exception {
		FileWriter fw = new FileWriter(pathFile,true);
		PrintWriter pw = new PrintWriter(fw);
		for(String st : dsTin) {
			pw.println(st);
		}
		fw.close();
	}
}
