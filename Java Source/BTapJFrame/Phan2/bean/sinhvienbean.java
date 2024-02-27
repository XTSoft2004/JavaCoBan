package bean;

public class sinhvienbean {
	private String masv;
	private String hoten;
	private String khoa;
	private Double dtb;
	
	public sinhvienbean(String masv, String hoten, String khoa, Double dtb) {
		super();
		this.masv = masv;
		this.hoten = hoten;
		this.khoa = khoa;
		this.dtb = dtb;
	}
	public sinhvienbean() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "masv=" + masv + ", hoten=" + hoten + ", khoa=" + khoa + ", dtb=" + dtb;
	}
	public String getMasv() {
		return masv;
	}
	public void setMasv(String masv) {
		this.masv = masv;
	}
	public String getHoten() {
		return hoten;
	}
	public void setHoten(String hoten) {
		this.hoten = hoten;
	}
	public String getKhoa() {
		return khoa;
	}
	public void setKhoa(String khoa) {
		this.khoa = khoa;
	}
	public Double getDtb() {
		return dtb;
	}
	public void setDtb(Double dtb) {
		this.dtb = dtb;
	}
}
