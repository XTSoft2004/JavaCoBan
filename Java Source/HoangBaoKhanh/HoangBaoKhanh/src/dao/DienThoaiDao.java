package dao;

import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import bean.DienThoaiBean;
import bean.DienThoaiCoDinhBean;
import bean.DienThoaiDiDongBean;

public class DienThoaiDao {
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	public ArrayList<DienThoaiBean> findAllFromFile() throws Exception {
		ArrayList<DienThoaiBean> dienthoais = new ArrayList<DienThoaiBean>();
		Scanner sc = new Scanner(new FileReader("ketqua.txt"));
		
		while(sc.hasNextLine()) {
			String line = sc.nextLine();
			if(line == null || line.equals("")) break;
			
			String[] tokens = line.split("[;]");
			String maDT = tokens[0];
			String tenDT = tokens[1];
			String hangSanxuat = tokens[2];
			Double giaBan = Double.parseDouble(tokens[3]);
		
			if(tokens.length == 5) {
				String mauSac = tokens[4];
				dienthoais.add(new DienThoaiCoDinhBean(maDT, tenDT, hangSanxuat, giaBan, mauSac));
			} else if(tokens.length == 6) {
				Date ngayHetHanBaoHanh = sdf.parse(tokens[4]);
				Integer dungLuongBoNho = Integer.parseInt(tokens[5]);
				dienthoais.add(new DienThoaiDiDongBean(maDT, tenDT, hangSanxuat, giaBan, ngayHetHanBaoHanh, dungLuongBoNho));
			}
		}
		sc.close();
		return dienthoais;
	}
}
