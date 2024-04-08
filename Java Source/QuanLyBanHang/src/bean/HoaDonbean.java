package bean;

import java.text.SimpleDateFormat;
import java.util.Date;

public class HoaDonbean {
	public int mahoadon;
	public Date ngaytaohoadon;
	public int idUser;
	
	public HoaDonbean(int mahoadon, Date ngaytaohoadon, int idUser) {
		super();
		this.mahoadon = mahoadon;
		this.ngaytaohoadon = ngaytaohoadon;
		this.idUser = idUser;
	}

	public int getMahoadon() {
		return mahoadon;
	}

	public void setMahoadon(int mahoadon) {
		this.mahoadon = mahoadon;
	}

	public Date getNgaytaohoadon() {
		return ngaytaohoadon;
	}

	public void setNgaytaohoadon(Date ngaytaohoadon) {
		this.ngaytaohoadon = ngaytaohoadon;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return mahoadon + ";" + sdf.format(ngaytaohoadon);
	}
	
}
