package bean;

import java.util.Date;

public class Hocsinhbean extends NguoiBean {
	private String maHs;
	private String tenTruong;
	private String tenLop;
	private Double dtb;
	public Hocsinhbean(String hoten, Boolean gioiTinh, Date ngaySinh, String maHs, String tenTruong, String tenLop,
			Double dtb) {
		super(hoten, gioiTinh, ngaySinh);
		this.maHs = maHs;
		this.tenTruong = tenTruong;
		this.tenLop = tenLop;
		this.dtb = dtb;
	}
	public String getMaHs() {
		return maHs;
	}
	public void setMaHs(String maHs) {
		this.maHs = maHs;
	}
	public String getTenTruong() {
		return tenTruong;
	}
	public void setTenTruong(String tenTruong) {
		this.tenTruong = tenTruong;
	}
	public String getTenLop() {
		return tenLop;
	}
	public void setTenLop(String tenLop) {
		this.tenLop = tenLop;
	}
	public Double getDtb() {
		return dtb;
	}
	public void setDtb(Double dtb) {
		this.dtb = dtb;
	}
	@Override
	public String toString() {
		return "Hocsinhbean [maHs=" + maHs + ", tenTruong=" + tenTruong + ", tenLop=" + tenLop + ", dtb=" + dtb + "]";
	}
	
	
}
