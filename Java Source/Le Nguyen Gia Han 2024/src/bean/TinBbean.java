package bean;

public class TinBbean extends Hocvienbean {
	private double DiemExcel;
	private double DiemPowerpoint;
	private double DiemWeb;
	private double DiemTB;
	public TinBbean(String maSv, String hovaTen, double diemExcel, double diemPowerpoint, double diemWeb) {
		super(maSv, hovaTen);
		DiemExcel = diemExcel;
		DiemPowerpoint = diemPowerpoint;
		DiemWeb = diemWeb;
		TinhDTB();
	}
	public double getDiemExcel() {
		return DiemExcel;
	}
	public void setDiemExcel(double diemExcel) {
		DiemExcel = diemExcel;
	}
	public double getDiemPowerpoint() {
		return DiemPowerpoint;
	}
	public void setDiemPowerpoint(double diemPowerpoint) {
		DiemPowerpoint = diemPowerpoint;
	}
	public double getDiemWeb() {
		return DiemWeb;
	}
	public void setDiemWeb(double diemWeb) {
		DiemWeb = diemWeb;
	}
	public double getDiemTB() {
		return DiemTB;
	}
	public void setDiemTB(double diemTB) {
		DiemTB = diemTB;
	}
	public double TinhDTB() {
		DiemTB = (DiemExcel + DiemPowerpoint + DiemWeb) / 3;
		DiemTB = Math.ceil(DiemTB * 100) / 100;
		return DiemTB;
	}
	@Override
	public String toString() {
		return super.toString() + ";" + DiemExcel + ";" + DiemPowerpoint + ";" + DiemWeb + ";" + DiemTB;
	}
	
}
