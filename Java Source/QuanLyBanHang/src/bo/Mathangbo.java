package bo;

import java.util.ArrayList;
import java.util.Date;

import bean.MatHangbean;
import dao.Mathangdao;

public class Mathangbo {
	public Mathangdao mhdao = new Mathangdao();
	public ArrayList<MatHangbean> dsMathang = new ArrayList<MatHangbean>();
	public ArrayList<MatHangbean> getDs() throws Exception{
		dsMathang = mhdao.getDs();
		return dsMathang;
	}
	public Boolean Themmathang(String mahang, String tenhang, Date ngaynhaphang, int soluong, double gia) throws Exception{
		return mhdao.Themmathang(mahang, tenhang, ngaynhaphang, soluong, gia);	
	}
	public Boolean Xoamathang(String mahang) throws Exception{
		return mhdao.Xoamathang(mahang);
	}
	public Boolean Chinhsuamathang(String mahang, String tenhang, Date ngaynhaphang, int soluong, double gia) throws Exception {
		return mhdao.Chinhsuamathang(mahang, tenhang, ngaynhaphang, soluong, gia);
	}
	public ArrayList<MatHangbean> Timkiem(String keyword){
		return mhdao.Timkiem(keyword);
	}
	public MatHangbean TimkiemOneMatHang(String keyword){
		return mhdao.TimkiemOneMatHang(keyword);
	}
	public void LoadDataFile(String path) throws Exception {
		mhdao.LoadDataFile(path);
	}
}
