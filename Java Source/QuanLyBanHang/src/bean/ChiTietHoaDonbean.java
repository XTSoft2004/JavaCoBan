package bean;

public class ChiTietHoaDonbean {
	public int machitiet;
	public int mahoadon;
	public String mahang;
	public int soluongmua;
	
	public ChiTietHoaDonbean(int machitiet, int mahoadon, String mahang, int soluongmua) {
		super();
		this.machitiet = machitiet;
		this.mahoadon = mahoadon;
		this.mahang = mahang;
		this.soluongmua = soluongmua;
	}
	public int getMachitiet() {
		return machitiet;
	}
	public void setMachitiet(int machitiet) {
		this.machitiet = machitiet;
	}
	public int getMahoadon() {
		return mahoadon;
	}
	public void setMahoadon(int mahoadon) {
		this.mahoadon = mahoadon;
	}
	public String getMahang() {
		return mahang;
	}
	public void setMahang(String mahang) {
		this.mahang = mahang;
	}
	public int getSoluongmua() {
		return soluongmua;
	}
	public void setSoluongmua(int soluongmua) {
		this.soluongmua = soluongmua;
	}
	@Override
	public String toString() {
		return mahang + ";" + soluongmua;
	}
}
