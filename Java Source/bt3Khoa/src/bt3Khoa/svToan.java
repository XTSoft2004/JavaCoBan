package bt3Khoa;

public class svToan {
	public String masv;
	public String hovaten;
	public double dm1;
	public double dm2;
	public double dm3;
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
	public svToan(String masv, String hovaten, double dm1, double dm2, double dm3) {
		super();
		this.masv = masv;
		this.hovaten = hovaten;
		this.dm1 = dm1;
		this.dm2 = dm2;
		this.dm3 = dm3;
	}
	@Override
	public String toString() {
		return "svToan [masv=" + masv + ", hovaten=" + hovaten + ", dm1=" + dm1 + ", dm2=" + dm2 + ", dm3=" + dm3 + "]";
	}
	public Double getDTB() {
		return (dm1+dm2+dm3)/3;
	}
}
