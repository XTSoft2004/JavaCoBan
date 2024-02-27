package bo;

import java.util.ArrayList;

import bean.sinhvienbean;
import dao.sinhviendao;

public class sinhvienbo {
	sinhviendao svdao = new sinhviendao();
	public ArrayList<sinhvienbean> ds = new ArrayList<sinhvienbean>();
	public ArrayList<sinhvienbean> getsinhvien() throws Exception {
		ds = svdao.getsinhvien();
		return ds;
	}
	public void Hienthi() {
		for(sinhvienbean sv : ds) {
			System.out.println(sv.toString());
		}
	}
	//Tìm sinh viên theo mã hoặc họ tên
	//THêm, xóa, sửa, sinh viên
	//Thông kê sinh viên đậu rớt theo khóa
}
