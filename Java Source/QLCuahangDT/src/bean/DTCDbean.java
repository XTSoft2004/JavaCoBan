package bean;

public class DTCDbean extends Dienthoaibean{
	private String MauSac;

	public DTCDbean(String maDT, String tenDT, String hangSX, double gia, String mauSac) {
		super(maDT, tenDT, hangSX, gia);
		MauSac = mauSac;
	}

	public String getMauSac() {
		return MauSac;
	}

	public void setMauSac(String mauSac) {
		MauSac = mauSac;
	}

	@Override
	public String toString() {
		return super.toString() + ";" + MauSac;
	}
	
}
