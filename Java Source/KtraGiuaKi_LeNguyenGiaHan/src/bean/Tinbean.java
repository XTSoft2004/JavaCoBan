package bean;

public abstract class Tinbean {
	private String maSV;
	private String HovaTen;
	private double DiemTB;
	public Tinbean(String maSV, String hovaTen) {
		super();
		this.maSV = maSV;
		HovaTen = hovaTen;
	}
	public String getMaSV() {
		return maSV;
	}
	public void setMaSV(String maSV) {
		this.maSV = maSV;
	}
	public String getHovaTen() {
		return HovaTen;
	}
	public void setHovaTen(String hovaTen) {
		HovaTen = hovaTen;
	}
	public double getDiemTB() {
		return DiemTB;
	}
	public void setDiemTB(double diemTB) {
		DiemTB = diemTB;
	}
	@Override
	public String toString() {
		return maSV + ";" + HovaTen;
	}
	public abstract double DTB();
	
}
