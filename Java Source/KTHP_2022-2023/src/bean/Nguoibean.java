package bean;

public class Nguoibean {
	private String HovaTen;
	private String LoaiHopDong;
	private double HeSoLuong;
	public Nguoibean(String hovaTen, String loaiHopDong, double heSoLuong) {
		super();
		HovaTen = hovaTen;
		LoaiHopDong = loaiHopDong;
		HeSoLuong = heSoLuong;
	}
	
	public Nguoibean() {
		super();
	}

	public String getHovaTen() {
		return HovaTen;
	}
	public void setHovaTen(String hovaTen) {
		HovaTen = hovaTen;
	}
	public String getLoaiHopDong() {
		return LoaiHopDong;
	}
	public void setLoaiHopDong(String loaiHopDong) {
		LoaiHopDong = loaiHopDong;
	}
	public double getHeSoLuong() {
		return HeSoLuong;
	}
	public void setHeSoLuong(double heSoLuong) {
		HeSoLuong = heSoLuong;
	}
	@Override
	public String toString() {
		return HovaTen + ";" + LoaiHopDong + ";" + HeSoLuong;
	}
	
}
