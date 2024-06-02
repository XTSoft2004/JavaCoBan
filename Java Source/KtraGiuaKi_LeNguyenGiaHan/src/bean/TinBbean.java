package bean;

public class TinBbean extends Tinbean {
	private double DiemExcel;
	private double DiemPowerPoint;
	private double DiemWeb;

	public TinBbean(String maSV, String hovaTen, double diemExcel, double diemPowerPoint, double diemWeb) {
		super(maSV, hovaTen);
		DiemExcel = diemExcel;
		DiemPowerPoint = diemPowerPoint;
		DiemWeb = diemWeb;
		DTB();
	}

	public double getDiemExcel() {
		return DiemExcel;
	}

	public void setDiemExcel(double diemExcel) {
		DiemExcel = diemExcel;
	}

	public double getDiemPowerPoint() {
		return DiemPowerPoint;
	}

	public void setDiemPowerPoint(double diemPowerPoint) {
		DiemPowerPoint = diemPowerPoint;
	}

	public double getDiemWeb() {
		return DiemWeb;
	}

	public void setDiemWeb(double diemWeb) {
		DiemWeb = diemWeb;
	}

	public double DTB() {
		return (DiemExcel + DiemPowerPoint + DiemWeb) / 3;
	}

	@Override
	public String toString() {
		return super.toString() + ";" + DiemExcel + ";" + DiemPowerPoint + ";" + DiemWeb + ";" + super.getDiemTB();
	}

}
