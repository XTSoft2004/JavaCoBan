package bo;

import java.util.ArrayList;

import bean.NguoiBean;
import dao.Nguoidao;

public class Nguoibo {
	Nguoidao svdao = new Nguoidao();
	public ArrayList<NguoiBean> ds = new ArrayList<NguoiBean>();
	public ArrayList<NguoiBean> getsinhvien() throws Exception {
		ds = svdao.getsinhvien();
		return ds;
	}
	public void Hienthi() {
		for(NguoiBean sv : ds) {
			System.out.println(sv.toString());
		}
	}
}
