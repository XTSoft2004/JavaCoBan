package bo;

import java.util.ArrayList;

import bean.Nguoibean;
import bean.Nhanvienbean;
import bean.Sinhvienbean;
import dao.Nguoidao;

public class Nguoibo {
	Nguoidao nd=new Nguoidao();
	public ArrayList<Nguoibean> dsBo =new ArrayList<Nguoibean>();
//	public ArrayList<Nguoibean> getDanhSach() throws Exception{
//		dsBo = nd.getDanhSach();
//		return dsBo;
//	}
//	public void hienThi() {
//		nd.hienThi();
//	}
//	public void timKiem(String namesearch) {
//		nd.timKiemTuongDoi(namesearch);
//	}
//	public void thongKe() {
//		nd.thongKe();
//	}
	//ArrayList<Nguoibean>ds;
	public ArrayList<Nguoibean> Tim(String key) throws Exception{
		ArrayList<Nguoibean> tam= new ArrayList<Nguoibean>();
		for (Nguoibean n:dsBo) {
			if (n.getHoten().contains(key))
				tam.add(n);
		}
		return dsBo;
	}
	public ArrayList<Nhanvienbean> getNV() throws Exception{
		ArrayList<Nhanvienbean> tam=new ArrayList<Nhanvienbean>();
		for (Nguoibean n : dsBo) {
			if (n instanceof Nhanvienbean) {
				tam.add((Nhanvienbean)n);
			}
		}
		return tam;
	}	
	public ArrayList<Sinhvienbean> getSV() throws Exception{
		ArrayList<Sinhvienbean> tam=new ArrayList<Sinhvienbean>();
		for (Nguoibean n:dsBo) {
			if (n instanceof Sinhvienbean) {
				tam.add((Sinhvienbean)n);
			}
		}
		return tam;
	}
	
}
