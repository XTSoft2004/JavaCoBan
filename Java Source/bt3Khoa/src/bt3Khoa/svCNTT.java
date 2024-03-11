package bt3Khoa;

public class svCNTT {
	public String masv;
	public String hovaten;
	public double dm1;
	public double dm2;
	public svCNTT(String masv, String hovaten, double dm1, double dm2) {
		super();
		this.masv = masv;
		this.hovaten = hovaten;
		this.dm1 = dm1;
		this.dm2 = dm2;
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
	public double getDm1() {
		return dm1;
	}
	public void setDm1(double dm1) {
		this.dm1 = dm1;
	}
	public double getDm2() {
		return dm2;
	}
	public void setDm2(double dm2) {
		this.dm2 = dm2;
	}
	@Override
	public String toString() {
		return "svCNTT [masv=" + masv + ", hovaten=" + hovaten + ", dm1=" + dm1 + ", dm2=" + dm2 + "]";
	}
	public Double getDTB() {
		return (dm1+dm2)/2;
	}
}
