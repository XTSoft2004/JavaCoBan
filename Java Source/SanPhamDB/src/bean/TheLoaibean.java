package bean;

public class TheLoaibean {
	private int IdTheLoai;
	private String TenTheLoai;
	private boolean ConSuDung;
	public TheLoaibean(int idTheLoai, String tenTheLoai, boolean conSuDung) {
		super();
		IdTheLoai = idTheLoai;
		TenTheLoai = tenTheLoai;
		ConSuDung = conSuDung;
	}
	public int getIdTheLoai() {
		return IdTheLoai;
	}
	public void setIdTheLoai(int idTheLoai) {
		IdTheLoai = idTheLoai;
	}
	public String getTenTheLoai() {
		return TenTheLoai;
	}
	public void setTenTheLoai(String tenTheLoai) {
		TenTheLoai = tenTheLoai;
	}
	public boolean isConSuDung() {
		return ConSuDung;
	}
	public void setConSuDung(boolean conSuDung) {
		ConSuDung = conSuDung;
	}
	@Override
	public String toString() {
		return IdTheLoai + ";" + TenTheLoai + ";" + ConSuDung;
	}
	
}
