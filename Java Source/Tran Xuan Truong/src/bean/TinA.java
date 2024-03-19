package bean;

public class TinA {
	public String masv;
	public String hovaten;
	public double DiemWin;
	public double DiemWord;
	public double Diemtrungbinh;
	public TinA(String masv, String hovaten, double diemWin, double diemWord) {
		super();
		this.masv = masv;
		this.hovaten = hovaten;
		DiemWin = diemWin;
		DiemWord = diemWord;
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
	public double getDiemWin() {
		return DiemWin;
	}
	public void setDiemWin(double diemWin) {
		DiemWin = diemWin;
	}
	public double getDiemWord() {
		return DiemWord;
	}
	public void setDiemWord(double diemWord) {
		DiemWord = diemWord;
	}
	public double TinhDTB() {
		Diemtrungbinh = (DiemWin + DiemWord) / 2;
		Diemtrungbinh = Math.ceil(Diemtrungbinh * 100) / 100;
		return Diemtrungbinh;
	}
	@Override
	public String toString() {
		return masv + "|" + hovaten + "|" + DiemWin + "|" + DiemWord + "|" + Diemtrungbinh;
	}
}
