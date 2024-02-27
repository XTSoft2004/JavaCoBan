package bean;

public class Hangbeen {
	private String Hang;
	private Double Gia;
	
	@Override
	public String toString() {
		return "Hang=" + Hang + ", Gia=" + Gia;
	}
	
	public Hangbeen(String hang, Double gia) {
		super();
		Hang = hang;
		Gia = gia;
	}
	public Hangbeen() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getHang() {
		return Hang;
	}
	public void setHang(String hang) {
		Hang = hang;
	}
	public Double getGia() {
		return Gia;
	}
	public void setGia(Double gia) {
		Gia = gia;
	}
	
}
