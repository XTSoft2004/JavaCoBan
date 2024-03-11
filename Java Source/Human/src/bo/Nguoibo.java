package bo;

import java.util.ArrayList;

import bean.Hocsinhbean;
import bean.NguoiBean;
import bean.NhanVienBean;
import dao.Nguoidao;

public class Nguoibo {
	Nguoidao svdao = new Nguoidao();
	public ArrayList<NguoiBean> ds = new ArrayList<NguoiBean>();
	public ArrayList<NguoiBean> getsinhvien() throws Exception {
		ds = svdao.getsinhvien();
		return ds;
	}
	public void Hienthi() {
		System.out.println("Danh sách học sinh:");
		for(NguoiBean sv : ds) {
			if(sv instanceof Hocsinhbean)
				System.out.println(sv.toString());
		}
		
		System.out.println("Danh sách nhân viên:");
		for(NguoiBean sv : ds) {
			if(sv instanceof NhanVienBean)
				System.out.println(sv.toString());
		}
	}
	public String DemDauRot() {
		return svdao.CountDauRot();
	}
	public ArrayList<NguoiBean> SearchNhanVien(String nameNhanVien){
		return svdao.TimkiemNhanVien(nameNhanVien);
	}
}
