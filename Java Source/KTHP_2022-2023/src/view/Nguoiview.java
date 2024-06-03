package view;


import java.util.ArrayList;

import bean.Giangvienbean;
import bean.Nguoibean;
import bean.Nhanvienbean;
import bo.Nguoibo;
import dao.Ketnoidao;

public class Nguoiview {

	public static void main(String[] args) {
		// Kết nối SQL
		Ketnoidao.ConnectSQL("TRUONGDESKTOP\\SQLEXPRESS", "QL_NVGV", "sa", "123");
		Cau2();	
		Cau3();
		Cau4();
		Cau5();
	}
	public static void Cau2() {
		try {
			Nguoibo nbo = new Nguoibo();
			nbo.KiemTraDuLieuHopLe();
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
	public static void Cau3() {
		try {
			Nguoibo nbo = new Nguoibo();
			ArrayList<Nguoibean> dsNguoi = nbo.NapDuLieu();
			System.out.println("Danh sách nhân viên là: ");
			for(Nguoibean nv : dsNguoi) {
				if(nv instanceof Nhanvienbean) {
					System.out.println(((Nhanvienbean)nv).toString());
				}
			}
			System.out.println("Danh sách giảng viên là: ");
			for(Nguoibean nv : dsNguoi) {
				if(nv instanceof Giangvienbean) {
					System.out.println(((Giangvienbean)nv).toString());
				}
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public static void Cau4() {
		try {
			Nguoibo nbo = new Nguoibo();
			ArrayList<Nguoibean> dsNguoi = nbo.NapDuLieu();			
			for(Nguoibean nv : dsNguoi) {
				if(nv instanceof Nhanvienbean) {
					nbo.NapNV((Nhanvienbean)nv);
				}
			}
			for(Nguoibean nv : dsNguoi) {
				if(nv instanceof Giangvienbean) {
					nbo.NapGV((Giangvienbean)nv);
				}
			}
			System.out.println("Đã lưu Nhân viên và Giảng viên");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public static void Cau5() {
		try {
			Nguoibo nbo = new Nguoibo();
			ArrayList<Nguoibean> dsNguoi = nbo.NapDuLieu();		
			int cntHD = 0,cntCT = 0;
			for(Nguoibean nv : dsNguoi) {
				if(nv instanceof Nhanvienbean) {
					if(nv.getLoaiHopDong().equals("chinhthuc"))
						cntCT += 1;
					else if(nv.getLoaiHopDong().equals("hopdong"))
						cntHD += 1;		
				}
			}		
			System.out.println("Nhân viên thống kê:\n+Hợp đồng: " + cntHD + "\n+Chính thức: " + cntCT);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
