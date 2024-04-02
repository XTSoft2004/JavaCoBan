package dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import bean.Hocsinhbean;
import bean.NguoiBean;
import bean.NhanVienBean;

public class Nguoidao {
	public ArrayList<NguoiBean> ds = new ArrayList<NguoiBean>();
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	public ArrayList<NguoiBean> getsinhvien() throws Exception {
		try {
			int cnt = 1;
			FileReader fr = new FileReader("sv.txt");
			BufferedReader br = new BufferedReader(fr);
			while(true) {
				String st = br.readLine();
				if(st == null || st == "")
					break;
				String[] tach = st.split("[,]");
				String dtime = tach[2];
				// Kiểm tra hợp lệ thời gian
				if(!isDate(dtime))
					continue;
				
				if(tach.length == 3) {
					ds.add(new NguoiBean(tach[0],Boolean.parseBoolean(tach[1]),sdf.parse(tach[2])));
				}
				else if(tach.length == 7) {	
					// Kiểm tra tính hợp lệ của email và phone
					String email = tach[5];
					String phone = tach[6];
					if(!isEmail(tach[5]) || !isPhone(tach[6]))
						continue;
					
					ds.add(new NhanVienBean(tach[0], Boolean.parseBoolean(tach[1]), sdf.parse(tach[2]), tach[3], Double.parseDouble(tach[4]),email,phone));
				}else if(tach.length == 6) {
					ds.add(new Hocsinhbean(tach[0], Boolean.parseBoolean(tach[1]), sdf.parse(tach[2]), tach[3],tach[4], Double.parseDouble(tach[5])));
				}else {
					SaveError("Dòng thứ " + cnt + " không thêm được vào danh sách");
				}
				cnt += 1;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return ds;
	}
	//1.Mở lớp NhanVienBean: bổ sung 2 truogừ email và số điện thoại -> cập nhật lại hàm get,set và hàm tạo. HocSinhBean bỏ tên trường
			//2.Tại gói dao
				//Đọc file ds.txt (file này chứa người, học sinh, nhân viên)
				//Nếu dòng nào hợp lệ thì lưu vào 1 ArrayList, dòng hợp lệ là dòng:
				// - Nếu người có 3 thông tin, nếu lưu nhanvien có 7 thông tin, nếu học sinh có 6 thông tin
				// - Email theo định dạng: tên@domain.subdomain => vd: nhha@gmail.com (dùng biểu thức chính quy)
				// - Số điện thoại 10 số, bắt đầu bởi số 0 (dùng biểu thức chính quy)
				// - Ngày sinh phải theo định dạng ngày tháng năm => dd/MM/yyyy
				//Nếu dòng không hợp lệ thì lưu dòng số và thông báo sang file loi.txt
			//3.Tại bo: viết các chức năng
				//- Lấy về all thông tin từ hàm getds của dao
				//- Hiện thị danh sách riêng cho nhân viên và học sinh
				//- Cho biết mỗi lớp có bao nhiêu sinh viên đuậ ( đtb >= 5 ), bao nhiêu sinh viên rớt
			//4.Tại view -> hiển thị các chức năng của bo
	
	public boolean isEmail(String Email) {
		Pattern pt = Pattern.compile("(\\w+)@(\\w+.)(\\w+.){2,}");
		Matcher mcher = pt.matcher(Email);
		return mcher.find();
	}
	
	public boolean isPhone(String Phone) {
		Pattern pt = Pattern.compile("((\\+84)|0)\\d{9}");
		Matcher mcher = pt.matcher(Phone);
		return mcher.find();
	}
	public boolean isDate(String dt) {
		// Kiểm tra biểu thức chính quy
		Pattern pt = Pattern.compile("\\d{1,2}/\\d{1,2}/\\d{4}");
		Matcher mc = pt.matcher(dt);
		if(mc.find() == false)
			return false;
		
		// Kiểm tra ngày tháng hợp lệ
		try {
			sdf.setLenient(false);
			sdf.parse(dt);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	public void SaveError(String str) {
		try {
			FileWriter fw = new FileWriter("loi.txt",true);
			PrintWriter pw = new PrintWriter(fw);
			pw.println(str);
			fw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public String CountDauRot() {
		int dau = 0,rot = 0;
		for(NguoiBean sv : ds) {
			if(sv instanceof Hocsinhbean) {
				if(((Hocsinhbean) sv).getDtb() >= 5)
					dau += 1;
				else
					rot += 1;
			}
		}
		return "So sinh vien dau: " + dau + " rot: " + rot;
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
	public ArrayList<NguoiBean> TimkiemNhanVien(String NameSearch) {
		ArrayList<NguoiBean> dsSearch = new ArrayList<NguoiBean>();
		for( NguoiBean nb : ds) {
			if(nb instanceof NhanVienBean && nb.getHoten().toLowerCase().trim().contains(NameSearch.toLowerCase().trim())) {
				dsSearch.add(nb);
			}
		}
		return dsSearch;
	}
}
