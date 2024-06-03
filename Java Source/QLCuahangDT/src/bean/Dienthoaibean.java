package bean;

public class Dienthoaibean {
	private String maDT;
	private String tenDT;
	private String HangSX;
	private double Gia;
	public Dienthoaibean(String maDT, String tenDT, String hangSX, double gia) {
		super();
		this.maDT = maDT;
		this.tenDT = tenDT;
		HangSX = hangSX;
		Gia = gia;
	}
	public String getMaDT() {
		return maDT;
	}
	public void setMaDT(String maDT) {
		this.maDT = maDT;
	}
	public String getTenDT() {
		return tenDT;
	}
	public void setTenDT(String tenDT) {
		this.tenDT = tenDT;
	}
	public String getHangSX() {
		return HangSX;
	}
	public void setHangSX(String hangSX) {
		HangSX = hangSX;
	}
	public double getGia() {
		return Gia;
	}
	public void setGia(double gia) {
		Gia = gia;
	}
	@Override
	public String toString() {
		return maDT + ";" + tenDT + ";" + HangSX + ";" + Gia;
	}
	
}
