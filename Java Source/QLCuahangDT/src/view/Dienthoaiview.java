package view;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import bean.DTCDbean;
import bean.DTDTbean;
import bean.Dienthoaibean;
import bo.Dienthoaibo;

public class Dienthoaiview {

	public static void main(String[] args) {
		try {
			SimpleDateFormat dt = new SimpleDateFormat("dd/MM/yyyy");
            // Ngày hiện tại
            String dt1 = dt.format(new Date());
            Date d1 = dt.parse(dt1);
            // Ngày mục tiêu
            Date d2 = dt.parse("13/06/2024");
            // Tính số mili giây giữa hai ngày
            long getMilliSeconds = d2.getTime() - d1.getTime();
            // Chuyển đổi số mili giây thành số ngày
            long getDays = TimeUnit.MILLISECONDS.toDays(getMilliSeconds);
            // In ra số ngày
            System.out.println("Số ngày từ ngày hiện tại đến ngày 13/06/2024 là: " + getDays + " ngày.");
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		// TODO Auto-generated method stub
//		Ketnoidao.ConnectSQL("TRUONGDESKTOP\\SQLEXPRESS", "QLCuaHangDT", "sa", "123");
//		Cau1();
//		Cau2();
//		Cau3();
	}
	public static void Cau1() {
		try {
			Dienthoaibo dtbo = new Dienthoaibo();
			dtbo.KiemtraHopLe();
			System.out.println("Đã tạo file ketqua.txt vào folder");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public static void Cau2() {
		try {
			Dienthoaibo dtbo = new Dienthoaibo();
			ArrayList<Dienthoaibean> ds = dtbo.NapKetQua();
			System.out.println("Các điện thoại di động: ");
			for(Dienthoaibean dt : ds) {
				if(dt instanceof DTDTbean)
					System.out.println(((DTDTbean)dt).toString());
			}
			System.out.println("Các điện thoại cố định: ");
			for(Dienthoaibean dt : ds) {
				if(dt instanceof DTCDbean)
					System.out.println(((DTCDbean)dt).toString());
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public static void Cau3() {
		try {
			Dienthoaibo dtbo = new Dienthoaibo();
			ArrayList<Dienthoaibean> ds = dtbo.NapKetQua();
			for(Dienthoaibean dt : ds) {
				if(dt instanceof DTDTbean)
					dtbo.NapDiDong(((DTDTbean)dt));	
			}			
			System.out.println("Đã thêm thành công vào database");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
