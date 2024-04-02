package view;

import java.util.ArrayList;
import java.util.Scanner;

import bean.NhanVienBean;
import bo.nhanvienbo;

public class nhanvienview {
	public static void main(String[] args) {
		try {
			nhanvienbo nvbo = new nhanvienbo();
			System.out.println("Danh sach nhan vien:");
			ArrayList<NhanVienBean> ds =nvbo.getnv();
			for(NhanVienBean nv : ds) {
				System.out.println(nv.toString());
			}
			System.out.println("Import du lieu tu file");
			nvbo.ThemDS("ds.txt");
			System.out.println("Nhap ma nv can xoa: ");
			Scanner sc = new Scanner(System.in);
			String manv = sc.nextLine();
			nvbo.DeleteMemeber(manv);
			System.out.println("Da xoa");
			sc.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
