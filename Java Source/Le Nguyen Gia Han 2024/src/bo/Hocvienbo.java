package bo;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import bean.Hocvienbean;
import bean.TinAbean;
import bean.TinBbean;
import dao.Hocviendao;

public class Hocvienbo {
	public ArrayList<TinAbean> dsA = new ArrayList<TinAbean>();
	public ArrayList<TinBbean> dsB = new ArrayList<TinBbean>();
	public ArrayList<Hocvienbean> ds = new ArrayList<Hocvienbean>();
	public Hocviendao hvdao = new Hocviendao();
	public void getDS() {
		ds = hvdao.getDanhSach();
		for(Hocvienbean hv : ds) {
			if(hv instanceof TinAbean) {
				dsA.add((TinAbean)hv);
			}else if(hv instanceof TinBbean) {
				dsB.add((TinBbean)hv);
			}
		}
	}
	public ArrayList<TinAbean> getDSA(){
		return dsA;
	}
	public ArrayList<TinBbean> getDSB(){
		return dsB;
	}
	public ArrayList<TinAbean> searchDSA(String namesearch){
		ArrayList<TinAbean> search = new ArrayList<TinAbean>();
		for(TinAbean hvA : dsA) {
			String name = hvA.getHovaTen();
			if(name.trim().toLowerCase().contains(namesearch.trim().toLowerCase())) {
				search.add(hvA);
			}
		}
		return search;
	}
	public ArrayList<TinBbean> searchDSB(String namesearch){
		ArrayList<TinBbean> search = new ArrayList<TinBbean>();
		for(TinBbean hvA : dsB) {
			String name = hvA.getHovaTen();
			if(name.trim().toLowerCase().contains(namesearch.trim().toLowerCase())) {
				search.add(hvA);
			}
		}
		return search;
	}
	public void CreateInfoA() {
		try {
			FileWriter fw = new FileWriter("f1.txt");
			PrintWriter pw = new PrintWriter(fw);
			for(TinAbean hv : dsA) {
				pw.println(hv.toString());
			}
			fw.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public void CreateInfoB() {
		try {
			FileWriter fw = new FileWriter("f2.txt");
			PrintWriter pw = new PrintWriter(fw);
			for(TinBbean hv : dsB) {
				pw.println(hv.toString());
			}
			fw.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
