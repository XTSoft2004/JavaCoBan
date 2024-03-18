package bean;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Sinhvienbean extends NguoiBean {
	private String maHs;
	private String tenLop;
	private Double dtb;
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	public Sinhvienbean(String hoten, Boolean gioiTinh, Date ngaySinh, String maHs, String tenLop, Double dtb) {
		super(hoten, gioiTinh, ngaySinh);
		this.maHs = maHs;
		this.tenLop = tenLop;
		this.dtb = dtb;
	}
	public String getMaHs() {
		return maHs;
	}
	public void setMaHs(String maHs) {
		this.maHs = maHs;
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
		return super.toString() + maHs + ";" + tenLop + ";" + dtb; 
	}
	
	
}
