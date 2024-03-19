package bo;

import java.lang.reflect.Array;
import java.util.ArrayList;

import bean.TinA;
import bean.TinB;
import dao.Hocviendao;

public class Hocvienbo {
	public ArrayList<Object> dsBo = new ArrayList<Object>();
	public Hocviendao hvd = new Hocviendao();
	public ArrayList<Object> getDanhsach(){
		dsBo = hvd.getDanhsach();
		return dsBo;
	}
	public ArrayList<TinA> getDsTinA(){
		return hvd.getDSTinA();
	}
	public ArrayList<TinB> getDsTinB(){
		return hvd.getDSTinB();
	}
	public ArrayList<TinA> SearchTinA(String nameSearch){
		return hvd.SearchTinA(nameSearch);
	}
	public ArrayList<TinB> SearchTinB(String nameSearch){
		return hvd.SearchTinB(nameSearch);
	}
	public void CreateDanhSachSinhVien() {
		hvd.CreateFileDs();
	}
}
