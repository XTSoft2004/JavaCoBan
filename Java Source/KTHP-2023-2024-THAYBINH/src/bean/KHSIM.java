package bean;

import java.util.Date;

public class KHSIM extends Khachhangbean {
	private String LoaiSim;

	public KHSIM(String maDV, String tenDV, String tenKH, String maKH, Date ngayDangKi, String loaiSim) {
		super(maDV, tenDV, tenKH, maKH, ngayDangKi);
		LoaiSim = loaiSim;
	}

	public String getLoaiSim() {
		return LoaiSim;
	}

	public void setLoaiSim(String loaiSim) {
		LoaiSim = loaiSim;
	}

	@Override
	public String toString() {
		return super.toString() + ";" + LoaiSim;
	}
	
}
