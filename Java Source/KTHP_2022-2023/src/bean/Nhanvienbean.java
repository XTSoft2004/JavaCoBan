package bean;

public class Nhanvienbean extends Nguoibean {
	private String maNV;

	public Nhanvienbean(String maNV,String hovaTen, String loaiHopDong, double heSoLuong) {
		super(hovaTen, loaiHopDong, heSoLuong);
		this.maNV = maNV;
	}

	public String getMaNV() {
		return maNV;
	}

	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}

	@Override
	public String toString() {
		return maNV + ";" + super.toString();
	}
	
}
