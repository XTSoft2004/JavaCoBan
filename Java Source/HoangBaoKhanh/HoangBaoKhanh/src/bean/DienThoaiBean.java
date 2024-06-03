package bean;

public class DienThoaiBean {
	private String maDT;
	private String tenDT;
	private String hangSanXuat;
	private Double giaBan;
	
	public DienThoaiBean() {
		
	}

	public DienThoaiBean(String maDT, String tenDT, String hangSanXuat, Double giaBan) {
		super();
		this.maDT = maDT;
		this.tenDT = tenDT;
		this.hangSanXuat = hangSanXuat;
		this.giaBan = giaBan;
	}

	public String getMaDT() {
		return maDT;
	}

	public void setMaDT(String maDT) {
		this.maDT = maDT;
	}

	public String getTenDT() {
		return tenDT;
	}

	public void setTenDT(String tenDT) {
		this.tenDT = tenDT;
	}

	public String getHangSanXuat() {
		return hangSanXuat;
	}

	public void setHangSanXuat(String hangSanXuat) {
		this.hangSanXuat = hangSanXuat;
	}

	public Double getGiaBan() {
		return giaBan;
	}

	public void setGiaBan(Double giaBan) {
		this.giaBan = giaBan;
	}
	
	
}
