package bo;

import java.util.ArrayList;

import bean.ChiTietHoaDonbean;
import dao.Hoadondao;

public class Hoadonbo {
	public Hoadondao hddao = new Hoadondao();
	public Boolean TaoHoaDon(int idUser,ArrayList<ChiTietHoaDonbean> dsMathang) throws Exception {
		return hddao.TaoHoaDon(idUser, dsMathang);
	}
}
