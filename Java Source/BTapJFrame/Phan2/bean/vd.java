package bean;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import dao.sinhviendao;

public class vd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		sinhvienbean sv = new sinhvienbean("SV2","Bac","assf",5.5);
//		sv.setMasv("Sv1");
//		System.out.println(sv.toString());
		
//		ArrayList<Hangbeen> dsHang = new ArrayList<Hangbeen>();
//		try {
//			FileReader fr = new FileReader("hang.txt");
//			BufferedReader br = new BufferedReader(fr);
//			while(true) {
//				String st = br.readLine();
//				if(st == null || st == "")
//					break;
//				String[] tach = st.split("[;]");
//				dsHang.add(new Hangbeen(tach[0],Double.parseDouble(tach[1])));
//			}
//			br.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//			// TODO: handle exception
//		}
//		for(Hangbeen hb : dsHang) {
//			System.out.println(hb.toString());
//		}
		
		sinhviendao svd = new sinhviendao();
		try {
			svd.getsinhvien();
			svd.Hienthi();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
