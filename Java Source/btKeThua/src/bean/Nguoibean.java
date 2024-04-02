package bean;

import java.util.Date;

public class Nguoibean {
	public String Hoten;
	public Boolean Gioitinh;
	public Date Ngaysinh;
	public Nguoibean(String hoten, Boolean gioitinh, Date ngaysinh) {
		super();
		Hoten = hoten;
		Gioitinh = gioitinh;
		Ngaysinh = ngaysinh;
	}
	public String getHoten() {
		return Hoten;
	}
	public void setHoten(String hoten) {
		Hoten = hoten;
	}
	public Boolean getGioitinh() {
		return Gioitinh;
	}
	public void setGioitinh(Boolean gioitinh) {
		Gioitinh = gioitinh;
	}
	public Date getNgaysinh() {
		return Ngaysinh;
	}
	public void setNgaysinh(Date ngaysinh) {
		Ngaysinh = ngaysinh;
	}
	@Override
	public String toString() {
		return Hoten+";"+Gioitinh+";"+Ngaysinh;
	}
}
