package bean;

import java.util.Date;

public class NhanVienBean extends NguoiBean {
	private String manv;
	private Double hsl;
	public NhanVienBean(String hoten, Boolean gioiTinh, Date ngaySinh, String manv, Double hsl) {
		super(hoten, gioiTinh, ngaySinh);
		this.manv = manv;
		this.hsl = hsl;
	}
	public String getManv() {
		return manv;
	}
	public void setManv(String manv) {
		this.manv = manv;
	}
	public Double getHsl() {
		return hsl;
	}
	public void setHsl(Double hsl) {
		this.hsl = hsl;
	}
	@Override
	public String toString() {
		return manv +"; "+ super.toString() +"; " + hsl;
	}

}
