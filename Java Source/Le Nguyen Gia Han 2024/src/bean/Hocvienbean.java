package bean;

public class Hocvienbean {
	private String MaSv;
	private String HovaTen;
	public Hocvienbean(String maSv, String hovaTen) {
		super();
		MaSv = maSv;
		HovaTen = hovaTen;
	}
	public String getMaSv() {
		return MaSv;
	}
	public void setMaSv(String maSv) {
		MaSv = maSv;
	}
	public String getHovaTen() {
		return HovaTen;
	}
	public void setHovaTen(String hovaTen) {
		HovaTen = hovaTen;
	}
	@Override
	public String toString() {
		return MaSv + ";" + HovaTen;
	}
	
}
