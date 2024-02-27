package view;

import bo.sinhvienbo;

public class HienThiSV {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			sinhvienbo svbo = new sinhvienbo();
			svbo.getsinhvien();
			svbo.Hienthi();
		} catch (Exception e) {
			e.printStackTrace(); 
			// TODO: handle exception
		}
	}

}
