package bean;

import java.util.Date;

public class Sinhvienbean extends Nguoibean {
	private String Masv;
	private Double Diemtb;
	public Sinhvienbean( String masv, String hoten, Boolean gioitinh, Date ngaysinh, Double diemtb) {
		super(hoten, gioitinh, ngaysinh);
		Masv = masv;
		Diemtb = diemtb;
	}
	public String getMasv() {
		return Masv;
	}
	public void setMasv(String masv) {
		Masv = masv;
	}
	public Double getDiemtb() {
		return Diemtb;
	}
	public void setDiemtb(Double diemtb) {
		Diemtb = diemtb;
	}
	@Override
	public String toString() {
		return super.toString() + "Sinhvienbean [Masv=" + Masv + ", Diemtb=" + Diemtb + "]";
	}
}
