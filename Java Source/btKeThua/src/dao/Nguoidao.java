package dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.regex.Pattern;

import bean.Nguoibean;
import bean.Nhanvienbean;
import bean.Sinhvienbean;

public class Nguoidao {
	
	public ArrayList<Nguoibean>dsDao=new ArrayList<Nguoibean>();
	SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
	public void getDanhSach() throws Exception{
		ArrayList<Nguoibean>ds=new ArrayList<Nguoibean>();

//		Nguoibean n1=new Nguoibean("Hung", true, sdf.parse("10/05/2004"));
//		System.out.println(n1.toString());
//		Nguoibean n2=new Nguoibean("Tam", false, sdf.parse("11/10/2000"));
//		System.out.println(n2.toString());
//		Nhanvienbean nv1=new Nhanvienbean("nv1", "Nga", false, sdf.parse("10/12/1985"), 4.5,"nga@gmail.com", "091234567");
//		Nhanvienbean nv2=new Nhanvienbean("nv2", "Tien", true, sdf.parse("10/12/1985"), 4.5,"tien@gmail.com", "091234567");
//		System.out.println(nv1.toString());
//		System.out.println(nv2.toString());
//		Sinhvienbean sv1=new Sinhvienbean("sv1", "Hoang", true, sdf.parse("9/9/2000"), 4.5);
//		Sinhvienbean sv2=new Sinhvienbean("sv2", "Nhi", false, sdf.parse("9/9/2000"), 4.5);
//		dsDao.add(n1);
//		dsDao.add(n2);
//		dsDao.add(nv1);
//		dsDao.add(nv2);
//		dsDao.add(sv1);
//		dsDao.add(sv2);
//		return dsDao;
	}
	

	public void hienThi() {
		System.out.println("Danh sach nhan vien: ");
		for (Nguoibean nb:dsDao) {
			if (nb instanceof Nhanvienbean) {
				System.out.println(nb.toString());
			}
		}
		System.out.println("Danh sach sinh vien: ");
		for (Nguoibean nb:dsDao) {
			if (nb instanceof Sinhvienbean) {
				System.out.println(nb.toString());
			}
		}
	}
	public void timKiemTuongDoi(String namesearch) {
		for (Nguoibean nb:dsDao) {
			if(nb instanceof Nhanvienbean && nb.getHoten().trim().toLowerCase().contains(namesearch.trim().toLowerCase())) {
				System.out.println(nb.getHoten());
			}
		}
	}
	public void thongKe() {
		int countNV=0, countSV=0;
		for (Nguoibean nb:dsDao) {
			if(nb instanceof Nhanvienbean)
				countNV++;
			if(nb instanceof Sinhvienbean)
				countSV++;
		}
		System.out.println("So luong nhan vien: "+ countNV);
		System.out.println("So luong sinh vien: "+ countSV);
		System.out.println("So luong nguoi: "+dsDao.size());
	}
	static Boolean checkSDT(String phone){
		String bt="[0][0-9]{9,10}";
		return Pattern.matches(bt, phone);
	}
	static Boolean checkEmail(String email) {
		String bt="[\\w]{1,}@[\\w]{1,}.[\\w]{1,}.[\\w]{0,}";
		return Pattern.matches(bt, email);
	}
	static Boolean checkDOB(String ngaysinh){
		try {
			String bt="/^(0?[1-9]|1[012])[- /.](0?[1-9]|[12][0-9]|3[01])[- /.](19|20)?[0-9]{2}$/\r";
			if (Pattern.matches(bt, ngaysinh)) {
				SimpleDateFormat dd=new SimpleDateFormat("dd/MM/yyyy");
				dd.setLenient(false); //neu ngay sai thi ko cho doi
				dd.parse(ngaysinh);
				return true;
			}
			return false;
		} catch (Exception e) {
			return false;
		}
	}
	static Boolean checkMa(String ma) {
		String bt="[^0-9]{2}[\\d\\w]";
		return Pattern.matches(bt, ma);
	}
//	public ArrayList<Nguoibean> getDanhSach()throws Exception{
//		FileReader f=new FileReader("data.txt");
//		BufferedReader br=new BufferedReader(f);
//		while(true) {
//			String st=br.readLine();
//			if (st==null||st=="") break;
//			String[] tach=st.split("[;]");
//			if (tach.length==3) {
//				if (checkDOB(tach[2])) {
//					dsDao.add(new Nguoibean(tach[0], Boolean.parseBoolean(tach[1]), sdf.parse(tach[2])));
//				}
//			}
//			else if (tach.length==5) {
//				if (checkMa(tach[0]) && checkDOB(tach[3])) {
//					dsDao.add(new Sinhvienbean(tach[0], tach[1], Boolean.parseBoolean(tach[2]), sdf.parse(tach[3]),  Double.parseDouble(tach[4])));
//				}
//			}
//			else if (tach.length==7) {
//				if (checkMa(tach[0]) && checkDOB(tach[3]) && checkEmail(tach[5]) && checkSDT(tach[6])) {
//					dsDao.add(new Nhanvienbean(tach[0], tach[1], Boolean.parseBoolean(tach[2]), sdf.parse(tach[3]), Double.parseDouble(tach[4]), tach[5], tach[6]));
//				}
//			}
//			else {
//				FileWriter fw=new FileWriter("loi.txt");
//				PrintWriter g=new PrintWriter(fw);
//				g.println(st);
//				fw.close();
//			}
			
//			if (tach.length==3) {
//				Nguoibean nb = new Nguoibean(tach[0], Boolean.parseBoolean(tach[1]), sdf.parse(tach[2]));
//				dsDao.add(nb);				
////					dsDao.add(new Nguoibean(tach[0], Boolean.parseBoolean(tach[1]), sdf.parse(tach[2])));
//			}
//			else if (tach.length==5) {
//				dsDao.add(new Sinhvienbean(tach[0], tach[1], Boolean.parseBoolean(tach[2]), sdf.parse(tach[3]),  Double.parseDouble(tach[4])));
//			}
//			else if (tach.length==7) {
//				dsDao.add(new Nhanvienbean(tach[0], tach[1], Boolean.parseBoolean(tach[2]), sdf.parse(tach[3]), Double.parseDouble(tach[4]), tach[5], tach[6]));
//			}
//		}
//		f.close();
//		return dsDao;
//	}
	public static void main(String[] args) {
		
	}
}
//bài 1: tạo lớp SinhVienbean kế thừa từ lớp Nguoi: masv, dtb 
//phát sinh get, set, toString`
//tạo ra 2 người, 2 nhân viên, 2 sinh viên, tất cả lưu vào 1 arraylist
//- hiển thị danh sách từng loại từ mảng (gợi ý : dùng instanceOf())
//- nhập vào 1 họ tên nhân viên, tìm nhân viên tương ứng (tìm tương đối)
//- thống kê có bao nhiêu người, bao nhiêu sinh viên, bao nhiêu nhân viên
//- tạo ra 1 file ds.txt lưu người, sinh viên, nhân viên 
//- tại package dao, viết hàm getDanhSach để nạp toàn bộ các thông tin trong file ds.txt ra 1 arraylist
//- tại package bo, gọi lại hàm getDanhSach từ dao
//- tại view, hiển thị các danh sách 
//bài 2: làm bài tập arraylist & hướng đối tượng trong thư mục BaiTap