package bo;

import java.util.ArrayList;
import java.util.Date;

import bean.Nhanvienbean;
import dao.Nhanviendao;

public class Nhanvienbo {
	Nhanviendao nvdao = new Nhanviendao();
	ArrayList<Nhanvienbean>ds;
	public ArrayList<Nhanvienbean> getDsNV() throws Exception{
		ds= nvdao.getDs();
		return ds;
	}
	//viet them cac chuc nang lien quan den nhanvien
	public double tbcHSL() throws Exception{
		Double s=0.0;
		for (Nhanvienbean nv:ds) {
			s=s+nv.getHsl();
		}
		return s/ds.size();
	}
	// viet 3 ham them xoa sua (thao tac tren danh sach ds)
	
	public int ThemNV(String manv, String hoten, Boolean gioitinh, Date ngaysinh, Double hsl, String email, String phone) throws Exception {
		// Kiểm tra có trùng nhân viên hay không ?
		for(Nhanvienbean nv : ds) {
			if(nv.getManv().equals(manv))
				return -1;
		}	
		ds.add(new Nhanvienbean(manv, hoten, gioitinh, ngaysinh, hsl, email, phone));
		return nvdao.ThemNV(manv, hoten, gioitinh, ngaysinh, hsl, email, phone);	
	}
	public int XoaNV(String manv) throws Exception{
		// Kiểm tra xem có nhân viên ở trong danh sách không ?
		for(Nhanvienbean nv : ds) {
			if(nv.getManv().equals(manv)) {
				ds.remove(nv);
				return nvdao.XoaNV(manv);
			}
		}	
		return 0;
	}
	public int TangHSL(String manv,Double hsl) throws Exception{
		for(Nhanvienbean nv : ds) {
			if(nv.getManv().equals(manv)) {
				nv.setHsl(nv.getHsl() + hsl);
				return nvdao.TangHSL(manv, hsl);
			}
		}
		return 0;
	}
}
