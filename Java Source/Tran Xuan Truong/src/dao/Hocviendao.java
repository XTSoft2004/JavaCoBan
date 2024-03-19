package dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;

import bean.TinA;
import bean.TinB;

public class Hocviendao {
	public ArrayList<Object> ds = new ArrayList<Object>();
	public ArrayList<TinA> dsA = new ArrayList<TinA>();
	public ArrayList<TinB> dsB = new ArrayList<TinB>();
	
	public ArrayList<Object> getDanhsach(){
		try {
			FileReader fr = new FileReader("ds.txt");
			BufferedReader br = new BufferedReader(fr);
			while(true) {
				String st = br.readLine();
				if(st == null || st == "")
					break;
				String[] che = st.split("[|]");
				if(che.length == 4)
					ds.add(new TinA(che[0], che[1], Double.parseDouble(che[2]), Double.parseDouble(che[3])));
				else if(che.length == 5)
					ds.add(new TinB(che[0], che[1], Double.parseDouble(che[2]), Double.parseDouble(che[3]), Double.parseDouble(che[4])));
			}
			br.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}	
		return ds;
	}
	public ArrayList<TinA> getDSTinA(){
		dsA = new ArrayList<TinA>();
		for(Object object : ds) {
			if(object instanceof TinA)
				dsA.add((TinA)object);
		}
		return dsA;
	}
	public ArrayList<TinB> getDSTinB(){
		dsB = new ArrayList<TinB>();
		for(Object object : ds) {
			if(object instanceof TinB)
				dsB.add((TinB)object);
		}
		return dsB;
	}
	public ArrayList<TinA> SearchTinA(String namesearch){
		ArrayList<TinA> dsSearch = new ArrayList<TinA>();
		for(Object object : ds) {
			if(object instanceof TinA) {
				String name = ((TinA) object).getHovaten();
				if(name.trim().toLowerCase().contains(namesearch.trim().toLowerCase())) {
					dsSearch.add(((TinA) object));
				}
			}
		}
		return dsSearch;
	}
	public ArrayList<TinB> SearchTinB(String namesearch){
		ArrayList<TinB> dsSearch = new ArrayList<TinB>();
		for(Object object : ds) {
			if(object instanceof TinB) {
				String name = ((TinB) object).getHovaten();
				if(name.trim().toLowerCase().contains(namesearch.trim().toLowerCase())) {
					dsSearch.add(((TinB) object));
				}
			}
		}
		return dsSearch;
	}
	public void CreateFileDs() {
		CreateTinA();
		CreateTinB();
	}
	public void CreateTinA() {
		try {
			FileWriter fw = new FileWriter("f1.txt");
			PrintWriter pw = new PrintWriter(fw);
			for(TinA member : dsA) {
				pw.println(member.toString());
			}
			fw.close();
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
	public void CreateTinB() {
		try {
			FileWriter fw = new FileWriter("f2.txt");
			PrintWriter pw = new PrintWriter(fw);
			for(TinB member : dsB) {
				pw.println(member.toString());
			}
			fw.close();
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
}
