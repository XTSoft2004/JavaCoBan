package bean;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NhanVienBean extends NguoiBean {
	private String manv;
	private Double hsl;
	private String email;
	private String phone;
	
	
	public NhanVienBean(String hoten, Boolean gioiTinh, Date ngaySinh, String manv, Double hsl, String email,
			String phone) {
		super(hoten, gioiTinh, ngaySinh);
		this.manv = manv;
		this.hsl = hsl;
		this.email = email;
		this.phone = phone;
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


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return super.toString() + manv + ";" + hsl + ";" + email + ";" + phone + ";";
	}

}
