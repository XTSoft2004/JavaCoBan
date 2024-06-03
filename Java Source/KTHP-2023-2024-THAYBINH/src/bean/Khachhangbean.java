package bean;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Khachhangbean {
	private String maDV;
	private String TenDV;
	private String TenKH;
	private String MaKH;
	private Date NgayDangKi;
	public Khachhangbean(String maDV, String tenDV, String tenKH, String maKH, Date ngayDangKi) {
		super();
		this.maDV = maDV;
		TenDV = tenDV;
		TenKH = tenKH;
		MaKH = maKH;
		NgayDangKi = ngayDangKi;
	}
	public String getMaDV() {
		return maDV;
	}
	public void setMaDV(String maDV) {
		this.maDV = maDV;
	}
	public String getTenDV() {
		return TenDV;
	}
	public void setTenDV(String tenDV) {
		TenDV = tenDV;
	}
	public String getTenKH() {
		return TenKH;
	}
	public void setTenKH(String tenKH) {
		TenKH = tenKH;
	}
	public String getMaKH() {
		return MaKH;
	}
	public void setMaKH(String maKH) {
		MaKH = maKH;
	}
	public Date getNgayDangKi() {
		return NgayDangKi;
	}
	public void setNgayDangKi(Date ngayDangKi) {
		NgayDangKi = ngayDangKi;
	}
	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return maDV + ";" + TenDV + ";" + TenKH + ";" + MaKH + ";" + sdf.format(NgayDangKi);
	}
	
	
}
