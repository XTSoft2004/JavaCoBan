package bean;

import java.util.Date;

public class Nhanvienbean extends Nguoibean {
	private String manv;
	private Double hsl;
	private String email;
	private String phone;
	public Nhanvienbean(String manv, String hoten, Boolean gioitinh, Date ngaysinh, Double hsl, String email,
			String phone) {
		super(hoten, gioitinh, ngaysinh);
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
//		return "Nhanvienbean [manv=" + manv + ", hsl=" + hsl + ", email=" + email + ", phone=" + phone + ", toString()="
//				+ super.toString() + "]";
		return manv+";"+super.toString()+";"+hsl+";"+email+";"+phone;
	}
	
	
}
