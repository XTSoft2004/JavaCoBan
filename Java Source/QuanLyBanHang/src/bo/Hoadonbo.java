package bo;

import java.util.ArrayList;

import bean.ChiTietHoaDonbean;
import bean.HoaDonbean;
import dao.Hoadondao;

public class Hoadonbo {
	public Hoadondao hddao = new Hoadondao();
	public Boolean TaoHoaDon(int idUser,ArrayList<ChiTietHoaDonbean> dsMathang) throws Exception {
		return hddao.TaoHoaDon(idUser, dsMathang);
	}
	public int GetIdHoaDon() throws Exception {
		return hddao.GetIdHoaDon();
	}
	public ArrayList<HoaDonbean> getDS() throws Exception{
		return hddao.getDS();
	}
	public ArrayList<String> getDate() throws Exception{
		return hddao.getDate();
	}
	public ArrayList<HoaDonbean> getDS_Date(String Date) throws Exception{
		return hddao.getDS_Date(Date);
	}
}
