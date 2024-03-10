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
	public void CountDauRot() {
		int dau = 0,rot = 0;
		for(NguoiBean sv : ds) {
			if(sv instanceof Hocsinhbean) {
				if(((Hocsinhbean) sv).getDtb() >= 5)
					dau += 1;
				else
					rot += 1;
			}
		}
		System.out.println("So sinh vien dau: " + dau + " rot: " + rot);
	}
}
