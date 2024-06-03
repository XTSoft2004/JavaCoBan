package bean;

public class DienThoaiCoDinhBean extends DienThoaiBean {
	private String mauSac;

	public DienThoaiCoDinhBean() {
		
	}
	
	public DienThoaiCoDinhBean(String maDT, String tenDT, String hangSanXuat, Double giaBan, String mauSac) {
		super(maDT, tenDT, hangSanXuat, giaBan);
		this.mauSac = mauSac;
	}

	public String getMauSac() {
		return mauSac;
	}

	public void setMauSac(String mauSac) {
		this.mauSac = mauSac;
	}

	@Override
	public String toString() {
		return getMaDT() + ";" + getTenDT() + ";" + getHangSanXuat() + ";" + getGiaBan()
			   + ";" + getMauSac();
	}
	
}
