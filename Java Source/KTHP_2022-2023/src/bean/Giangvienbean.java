package bean;

public class Giangvienbean extends Nguoibean {
	private String maGV;
	private double PhuCap;
	public Giangvienbean(String maGV,String hovaTen, String loaiHopDong, double heSoLuong, double phuCap) {
		super(hovaTen, loaiHopDong, heSoLuong);
		this.maGV = maGV;
		PhuCap = phuCap;
	}
	public String getMaGV() {
		return maGV;
	}
	public void setMaGV(String maGV) {
		this.maGV = maGV;
	}
	public double getPhuCap() {
		return PhuCap;
	}
	public void setPhuCap(double phuCap) {
		PhuCap = phuCap;
	}
	@Override
	public String toString() {
		return maGV + ";" + super.toString() + ";" + PhuCap;
	}
	
}
