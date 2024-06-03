package view;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import bean.DienThoaiBean;
import bean.DienThoaiCoDinhBean;
import bean.DienThoaiDiDongBean;
import bo.DienThoaiBo;
import bo.DienThoaiDiDongBo;
import dao.Database;
import dao.Validator;

public class Main {
	public static Long thoiHanBaoHanh(Date ngayHetHanBaoHanh) {
		Date date = new Date();
		return ngayHetHanBaoHanh.getTime() - date.getTime();
	}
	public static void main(String[] args) throws Exception {
		Validator valid = new Validator();
		// Cau 1: 
		System.out.println("Câu 1: ");
		ArrayList<String> lines = new ArrayList<String>();
		try {
			Scanner sc = new Scanner(new FileReader("HoangBaoKhanh.txt"));
			
			while(sc.hasNextLine()) {
				String line = sc.nextLine();
				if(line == null || line.equals("")) break;
				lines.add(line);
			}
			sc.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println("Noi dung file HoangBaoKhanh.txt la: ");
		for(String line: lines) {
			System.out.println(line);
		}
		System.out.println("\nCac dong hop le la: ");
		try {
			FileWriter fout = new FileWriter("ketqua.txt");
			for(String line: lines) {
				String[] words = line.split("[;]");

				if((words.length == 5  && valid.isValidIdDTCD(words[0]) == true) || 
						(words.length == 6 && valid.isValidIdDTDD(words[0])== true )){
					System.out.println(line);
					fout.write(line + '\n');
				}
			}
			fout.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		// cau 2:
		System.out.println("\nCâu 2:");
		DienThoaiBo DTBo = new DienThoaiBo();
		ArrayList<DienThoaiBean> dienthoais = DTBo.findAllFromFile();
		ArrayList<DienThoaiCoDinhBean> DTCDs = new ArrayList<DienThoaiCoDinhBean>();
		ArrayList<DienThoaiDiDongBean> DTDDs = new ArrayList<DienThoaiDiDongBean>();
		for(DienThoaiBean dt: dienthoais) {
			if(dt instanceof DienThoaiCoDinhBean) {
				DTCDs.add((DienThoaiCoDinhBean) dt);
			} else {
				DTDDs.add((DienThoaiDiDongBean) dt);
			}
		}
		System.out.println("- Danh sách điện thoại cố định: ");
		for(DienThoaiCoDinhBean i: DTCDs) {
			System.out.println(i.toString());
		}
		System.out.println("\n- Danh sách điện thoại di động: ");
		for(DienThoaiDiDongBean i: DTDDs) {
			System.out.println(i.toString());
		}
		
		// Câu 3:
		DienThoaiDiDongBo DTDDBo = new DienThoaiDiDongBo();
		Database db = new Database("LAB401-16", "Ontap5", "sa", "123", 1433);
		db.connect();
		for (DienThoaiDiDongBean dtdd: DTDDs) {
			DTDDBo.insert(dtdd);
		}
		
		// Câu 4:
		System.out.println("\nCâu 4: ");
		System.out.println("- Danh sách các điện thoại di động còn 10 ngày nữa là hết hạn bảo hành:");
		Long thoigianconlai;
		for(DienThoaiDiDongBean i: DTDDs) {
			thoigianconlai =(Long)(thoiHanBaoHanh(i.getNgayHetHanBaoHanh())/86400000);
			if(thoigianconlai == 10) {
				System.out.println(i.toString());
			}
		}
	} 

}
// DD0005;S22Ultra;SamSung;10000000;14/06/2024;2654
