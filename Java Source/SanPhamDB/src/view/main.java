package view;

import java.io.FileReader;
import java.util.ArrayList;

import bean.TheLoaibean;
import bo.SanPhambo;
import bo.TheLoaibo;
import dao.Ketnoidao;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ketnoidao.ConnectSQL("TRUONGDESKTOP\\SQLEXPRESS", "SanPhamDB", "sa", "123");
		//Bai2();
		Bai3();
	}
	public static void Bai2() {		
		try {
			TheLoaibo tlbo = new TheLoaibo();
			ArrayList<TheLoaibean> dsTheloai = tlbo.getDs();
			for(int i = 0;i < dsTheloai.size();i++) {
				System.out.println((i + 1) + ";" + dsTheloai.get(i).toString());
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} 
	}
	public static void Bai3() {
		try {
			SanPhambo spbo = new SanPhambo();
			spbo.AddFileSP("SanPham.txt");		
			System.out.println("Da them thanh cong");
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}

}
