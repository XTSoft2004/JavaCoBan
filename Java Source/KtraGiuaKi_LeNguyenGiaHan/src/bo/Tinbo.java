package bo;

import java.util.ArrayList;

import bean.TinAbean;
import bean.TinBbean;
import bean.Tinbean;
import dao.Tindao;

public class Tinbo {
	public ArrayList<Tinbean> dsTin = new ArrayList<Tinbean>();
	public Tindao tdao = new Tindao();
	public ArrayList<Tinbean> getDS(String pathFile) throws Exception{
		dsTin = tdao.getDS(pathFile);
		return dsTin;
	}
	public ArrayList<Tinbean> SearchHovaTen(String name) {
		 ArrayList<Tinbean> dsSearch = new ArrayList<Tinbean>();
		for(Tinbean td : dsTin) {
			if(td.getHovaTen().trim().toLowerCase().contains(name.trim().toLowerCase()))
				dsSearch.add(td);
		}
		return dsSearch;
	}	
	public void SaveTinATinB() throws Exception {
		ArrayList<String> dsTinA = new ArrayList<String>();
		ArrayList<String> dsTinB = new ArrayList<String>();
		for(Tinbean tbean : dsTin) {
			if(tbean instanceof TinAbean)
				dsTinA.add(((TinAbean)tbean).toString());
			else if(tbean instanceof TinBbean)
				dsTinB.add(((TinBbean)tbean).toString());
		}
		tdao.SaveFile("f1.txt", dsTinA);
		tdao.SaveFile("f2.txt", dsTinB);
	}
}
