package bo;

import java.util.ArrayList;

import bean.ChiTietHoaDonbean;
import dao.Chitiethoadondao;

public class Chitiethoadonbo {
	public Chitiethoadondao cthddao = new Chitiethoadondao();
	public Boolean ThemChiTiet(int mahoadon, String mahang, int soluongmua) throws Exception {
		return cthddao.ThemChiTiet(mahoadon, mahang, soluongmua);
	}
	public Boolean XoaChiTiet(int mahoadon) throws Exception {
		return cthddao.XoaChiTiet(mahoadon);
	}
	public ArrayList<String> GetMaHoaDon_Mahang(String mahang) throws Exception{
		return cthddao.GetMaHoaDon_Mahang(mahang);
	}
	public Boolean XoaChiTiet_mahang(String mahang) throws Exception {
		return cthddao.XoaChiTiet_mahang(mahang);
	}
	public ArrayList<ChiTietHoaDonbean> getDs_mahoadon(int mahoadon) throws Exception{
		return cthddao.getDs_mahoadon(mahoadon);
	}
}
