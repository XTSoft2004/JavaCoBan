package view;

import bean.KHInternet;
import bean.KHSIM;
import bo.Khachhangbo;
import dao.Ketnoidao;


public class Khachhangview {

	public static void main(String[] args) {
		Ketnoidao.ConnectSQL("XTSOFT\\SQLEXPRESS", "QLKHACHHANG", "sa", "123");
		Cau2();	
	}
	public static void Cau2() {
		try {
			Khachhangbo khbo = new Khachhangbo();
			khbo.NapDuLieu();
			System.out.println("Thông tin của khách hàng Internet");
			for(KHInternet kh : khbo.GetDataInternet())
				System.out.println(kh.toString());
			
			System.out.println("Thông tin của khách hàng SIM");
			for(KHSIM kh : khbo.GetDataSIM())
				System.out.println(kh.toString());
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

}
