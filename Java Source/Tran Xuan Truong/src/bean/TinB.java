package bean;

public class TinB {
	public String masv;
	public String hovaten;
	public double DiemExcel;
	public double DiemPP;
	public double DiemWeb;
	public double Diemtrungbinh;
	public TinB(String masv, String hovaten, double diemExcel, double diemPP, double diemWeb) {
		super();
		this.masv = masv;
		this.hovaten = hovaten;
		DiemExcel = diemExcel;
		DiemPP = diemPP;
		DiemWeb = diemWeb;
		TinhDTB();
	}
	public String getMasv() {
		return masv;
	}
	public void setMasv(String masv) {
		this.masv = masv;
	}
	public String getHovaten() {
		return hovaten;
	}
	public void setHovaten(String hovaten) {
		this.hovaten = hovaten;
	}
	public double getDiemExcel() {
		return DiemExcel;
	}
	public void setDiemExcel(double diemExcel) {
		DiemExcel = diemExcel;
	}
	public double getDiemPP() {
		return DiemPP;
	}
	public void setDiemPP(double diemPP) {
		DiemPP = diemPP;
	}
	public double getDiemWeb() {
		return DiemWeb;
	}
	public void setDiemWeb(double diemWeb) {
		DiemWeb = diemWeb;
	}
	public double TinhDTB() {
		Diemtrungbinh = (DiemExcel + DiemPP + DiemWeb) / 3;
		Diemtrungbinh = Math.ceil(Diemtrungbinh * 100) / 100;
		return Diemtrungbinh;
	}
	@Override
	public String toString() {
		return masv + "|" + hovaten + "|" + DiemExcel + "|" + DiemPP + "|" + DiemWeb + "|" + Diemtrungbinh;
	}
}
