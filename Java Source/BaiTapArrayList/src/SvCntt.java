
public class SvCntt {
	private String Masv;
	private String Hoten;
	private double Dm1;
	private double Dm2;
	public SvCntt(String masv, String hoten, double dm1, double dm2) {
		super();
		Masv = masv;
		Hoten = hoten;
		Dm1 = dm1;
		Dm2 = dm2;
	}
	public double getDtb() {
		return (Dm1 + Dm2) / 2;
	}
	public String getKetQua() {
		return getDtb() >= 5 ? "Dau" : "Rot";
 	}
	public void HienThi() {
		System.out.println(Masv + "|" + Hoten + "|" + Dm1 + "|" + "|" + Dm2 + "|" + getDtb() + "|" + getKetQua());
	}
	public String getThongTin() {
		return Masv + "|" + Hoten + "|" + Dm1 + "|" + "|" + Dm2 + "|" + getDtb() + "|" + getKetQua();
	}
}
