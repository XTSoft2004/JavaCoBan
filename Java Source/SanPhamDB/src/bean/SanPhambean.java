package bean;

public class SanPhambean {
	private int IdSanPham;
	private String TenSanPham;
	private String DonViTinh;
	private double DonGia;
	public int IdTheLoai;
	public SanPhambean(int idSanPham, String tenSanPham, String donViTinh, double donGia, int idTheLoai) {
		super();
		IdSanPham = idSanPham;
		TenSanPham = tenSanPham;
		DonViTinh = donViTinh;
		DonGia = donGia;
		IdTheLoai = idTheLoai;
	}
	public int getIdSanPham() {
		return IdSanPham;
	}
	public void setIdSanPham(int idSanPham) {
		IdSanPham = idSanPham;
	}
	public String getTenSanPham() {
		return TenSanPham;
	}
	public void setTenSanPham(String tenSanPham) {
		TenSanPham = tenSanPham;
	}
	public String getDonViTinh() {
		return DonViTinh;
	}
	public void setDonViTinh(String donViTinh) {
		DonViTinh = donViTinh;
	}
	public double getDonGia() {
		return DonGia;
	}
	public void setDonGia(double donGia) {
		DonGia = donGia;
	}
	public int getIdTheLoai() {
		return IdTheLoai;
	}
	public void setIdTheLoai(int idTheLoai) {
		IdTheLoai = idTheLoai;
	}
	@Override
	public String toString() {
		return IdSanPham + ";" + TenSanPham + ";" + DonViTinh + ";" + DonGia + ";" + IdTheLoai;
	}
	
}
