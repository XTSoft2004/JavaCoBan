package bean;

import java.text.SimpleDateFormat;
import java.util.Date;

public class NguoiBean {
	public String Hoten;
	public Boolean GioiTinh;
	public Date NgaySinh;
	
	public NguoiBean(String hoten, Boolean gioiTinh, Date ngaySinh) {
		super();
		Hoten = hoten;
		GioiTinh = gioiTinh;
		NgaySinh = ngaySinh;
	}

	public NguoiBean() {
		
	}

	public String getHoten() {
		return Hoten;
	}

	public void setHoten(String hoten) {
		Hoten = hoten;
	}

	public Boolean getGioiTinh() {
		return GioiTinh;
	}

	public void setGioiTinh(Boolean gioiTinh) {
		GioiTinh = gioiTinh;
	}

	public Date getNgaySinh() {
		return NgaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		NgaySinh = ngaySinh;
	}
	
	@Override
	public String toString() {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			String dt = sdf.format(NgaySinh);
			return "NguoiBean [Hoten=" + Hoten + ", GioiTinh=" + GioiTinh + ", NgaySinh=" + dt + ", " + "Tuoi=" + getTuoi() + "]";
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}	
	}
	
	public int getTuoi() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String dt = sdf.format(NgaySinh);
		int year = Integer.parseInt(dt.split("[/]")[2]);
		Date d = new Date(); // Ngay thang nam hien tai
		int year_now = Integer.parseInt(sdf.format(d).split("[/]")[2]);
		return year_now - year;
	}
	
}
