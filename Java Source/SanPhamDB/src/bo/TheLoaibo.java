package bo;

import java.util.ArrayList;

import bean.TheLoaibean;
import dao.TheLoaidao;

public class TheLoaibo {
	public ArrayList<TheLoaibean> dsTheLoai = new ArrayList<TheLoaibean>();
	public TheLoaidao tldao = new TheLoaidao();
	public ArrayList<TheLoaibean> getDs() throws Exception{
		dsTheLoai = tldao.getDs();
		return dsTheLoai;
	}
	public boolean isCheckTL(int IdTheLoai)  throws Exception{
		ArrayList<TheLoaibean> ds = getDs();
		for(TheLoaibean tl : ds) {
			if(tl.getIdTheLoai() == IdTheLoai)
				return true;
		}
		return false;
	}
}
