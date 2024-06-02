package bean;

public class TinAbean extends Tinbean {
	private double DiemWin;
	private double DiemWord;
	public TinAbean(String maSV, String hovaTen, double diemWin, double diemWord) {
		super(maSV, hovaTen);
		DiemWin = diemWin;
		DiemWord = diemWord;
		DTB();
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
	public double DTB() {
		return (DiemWin + DiemWord) / 2;
	}
	@Override
	public String toString() {
		return super.toString() + ";" + DiemWin + ";" + DiemWord + super.getDiemTB();
	}	
}
