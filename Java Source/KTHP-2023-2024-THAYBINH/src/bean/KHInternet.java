package bean;

import java.util.Date;

public class KHInternet extends Khachhangbean {
	private String BangThong;

	public KHInternet(String maDV, String tenDV, String tenKH, String maKH, Date ngayDangKi, String bangThong) {
		super(maDV, tenDV, tenKH, maKH, ngayDangKi);
		BangThong = bangThong;
	}

	public String getBangThong() {
		return BangThong;
	}

	public void setBangThong(String bangThong) {
		BangThong = bangThong;
	}

	@Override
	public String toString() {
		return super.toString() + ";" + BangThong;
	}
	
}
