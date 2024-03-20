package bean;

public class TinAbean extends Hocvienbean{
	private double DiemWin;
	private double DiemWord;
	private double DiemTB;
	
	public TinAbean(String maSv, String hovaTen, double diemWin, double diemWord) {
		super(maSv, hovaTen);
		DiemWin = diemWin;
		DiemWord = diemWord;
		TinhDTB();
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

	public double getDiemTB() {
		return DiemTB;
	}

	public void setDiemTB(double diemTB) {
		DiemTB = diemTB;
	}
	public double TinhDTB() {
		DiemTB = (DiemWin + DiemWord) / 2;
		DiemTB = Math.ceil(DiemTB * 100) / 100;
		return DiemTB;
	}
	@Override
	public String toString() {
		return super.toString() + ";" + DiemWin + ";" + DiemWord + ";" + DiemTB;
	}
	
}
