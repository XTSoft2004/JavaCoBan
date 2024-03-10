package view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import bean.Hocsinhbean;
import bean.NguoiBean;
import bean.NhanVienBean;
import bo.Nguoibo;
import dao.Nguoidao;

public class HienThiHuman {
	static ArrayList<NguoiBean> ds = new ArrayList<NguoiBean>();
	public static void main(String[] args) {
		Nguoibo nb = new Nguoibo();
		try {
			nb.getsinhvien();
		} catch (Exception e) {
			// TODO: handle exception
		}
		nb.Hienthi();	
		nb.CountDauRot();
	}
	
	
	//1.Mở lớp NhanVienBean: bổ sung 2 truogừ email và số điện thoại -> cập nhật lại hàm get,set và hàm tạo
		//2.Tại gói dao
			//Đọc file ds.txt (file này chứa người, học sinh, nhân viên)
			//Nếu dòng nào hợp lệ thì lưu vào 1 ArrayList, dòng hợp lệ là dòng:
			// - Nếu người có 3 thông tin, nếu lưu nhanvien có 7 thông tin, nếu thông tin có 6 thông tin
			// - Email theo định dạng: tên@domain.subdomain => vd: nhha@gmail.com (dùng biểu thức chính quy)
			// - Số điện thoại 10 số, bắt đầu bởi số 0 (dùng biểu thức chính quy)
			// - Ngày sinh phải theo định dạng ngày tháng năm => dd/MM/yyyy
			//Nếu dòng không hợp lệ thì lưu dòng số và thông báo sang file loi.txt
		//3.Tại bo: viết các chức năng
			//- Lấy về all thông tin từ hàm getds của dao
			//- Hiện thị danh sách riêng cho nhân viên và học sinh
			//- Cho biết mỗi lớp có bao nhiêu sinh viên đuậ ( đtb >= 5 ), bao nhiêu sinh viên rớt
		//4.Tại view -> hiển thị các chức năng của bo
	}
	
	
	
//	public static void main(String[] args) throws ParseException {
//		// TODO Auto-generated method stub
//		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//		NguoiBean nb1 = new NguoiBean("Xuan Truong",true,sdf.parse("22/12/2004"));
//		System.out.println(nb1.toString());
//		NguoiBean nb2 = new NguoiBean("Dao Thuan",true,sdf.parse("22/12/2004"));
//		System.out.	println(nb2.toString());
//		
//		
//		
//		//System.out.println("So tuoi la: " + nb.getTuoi());
//		
//		
//		NhanVienBean nvb = new NhanVienBean("Tran Xuan Truong", true,sdf.parse("22/12/2004"),"SV01",0.5);
//		System.out.println(nvb.toString()); 
//		Hocsinhbean hsb = new Hocsinhbean("Tran Xuan Mai", true, sdf.parse("1/1/2024"), "SV01", "DHKH", "K46B", 7.0);
//		System.out.println(hsb.toString());
//		
//		ds.add(nb2);
//		ds.add(nvb);
//		ds.add(hsb);
//		System.out.println();
//		for(NguoiBean n : ds) {
//			if(n instanceof NhanVienBean)
//				System.out.println(n.toString());
//		}
//		
//		for(NguoiBean n : ds) {
//			if(n instanceof Hocsinhbean)
//				System.out.println(n.toString());
//		}
//		
//		double sum = 0,total = 0;
//		
//		for(NguoiBean n : ds) {
//			if(n instanceof NhanVienBean)
//			{
//				sum += ((NhanVienBean) n).getHsl();
//				total += 1;
//			}
//		}
//		System.out.println("Trung binh cong cua nhan vien la:" + sum / total);
//	}

	
	
	
