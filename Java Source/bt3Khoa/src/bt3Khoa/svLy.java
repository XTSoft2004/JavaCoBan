package bt3Khoa;

public class svLy {
	public String masv;
	public String hovaten;
	public double dm1;
	public double dm2;
	public double dm3;
	public double dm4;
	public svLy(String masv, String hovaten, double dm1, double dm2, double dm3, double dm4) {
		super();
		this.masv = masv;
		this.hovaten = hovaten;
		this.dm1 = dm1;
		this.dm2 = dm2;
		this.dm3 = dm3;
		this.dm4 = dm4;
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
	public double getDm3() {
		return dm3;
	}
	public void setDm3(double dm3) {
		this.dm3 = dm3;
	}
	public double getDm4() {
		return dm4;
	}
	public void setDm4(double dm4) {
		this.dm4 = dm4;
	}
	@Override
	public String toString() {
		return "svLy [masv=" + masv + ", hovaten=" + hovaten + ", dm1=" + dm1 + ", dm2=" + dm2 + ", dm3=" + dm3
				+ ", dm4=" + dm4 + "]";
	}
	public Double getDTB() {
		return (dm1+dm2+dm3+dm4)/4;
	}
}
