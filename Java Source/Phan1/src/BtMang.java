import java.util.Date;
import java.util.Random;
import java.text.SimpleDateFormat;
	
public class BtMang {
	public String TaoNgay(String ngay1,String ngay2) {
		try {
			SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
			Date n1 = f.parse(ngay1);
			Date n2 = f.parse(ngay2);
			Random r = new Random();
			while(true) {
				Long t = r.nextLong();
				//getTime() Get milliseconds DateTime
				if(t >= n1.getTime() && t <= n2.getTime()) {
					Date n = new Date(t);
					return f.format(n);
				}
			}
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
			return null;
		}
	}
	public String TaoHoTen(){
		String[] ho = {"Tran", "Le","Nguyen"};
		String[] chulot ={"Thanh", "Hoang","Trung", "Van","Hy"};
		String[] ten=  {"Hung", "Nga","Tien","Tam","Ton","Giang","Sy"};
		Random r = new Random();
		String h = ho[r.nextInt(ho.length)];
		String c1 = chulot[r.nextInt(chulot.length)];
		String t = ten[r.nextInt(ten.length)];
		return h + " " + c1 + " " + t;
	}
	public String get_xeploai(double dtb) {
		String xeploai = "";
		if(dtb >= 8.0) {
			xeploai = "Giỏi";
		}
		else if(dtb >= 6.5) {
			xeploai = "Khá";
		}else if(dtb >= 5) {
			xeploai = "Trung bình";
		}else if(dtb >= 3.1) {
			xeploai = "Yếu";
		}else {
			xeploai = "Kém";
		}
		return xeploai;
	}
	public void HienThi(int n) {
		Random r = new Random();
		for(int i =0 ;i < n;i++) {
			double dtb = r.nextDouble() * 10;
			String ketqua = (dtb >= 5 ?  "đậu" : "rớt");
			String[] listGT = {"Nam","Nữ"};
			String gioitinh = listGT[r.nextInt(listGT.length)];
			System.out.println(TaoHoTen() + "; " +
			TaoNgay("01/01/1060","01/01/2000") + "; " + 
			gioitinh + "; " + dtb + "; " + ketqua + "; " + 
			get_xeploai(dtb));
		}
	}
}