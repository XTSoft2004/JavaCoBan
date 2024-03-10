import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class LopHoc {
	public ArrayList<Object> ds1 = new ArrayList<Object>();
	public void TaoLop(String namefile) {
		try {
			FileReader fr = new FileReader(namefile);
			BufferedReader br = new BufferedReader(fr);
			while(true) {
				String st = br.readLine();
				if(st == null || st == "")
					break;
				
				String[] tach = st.split("[|]");
				if(tach.length == 4) {
					SvCntt sv = new SvCntt(tach[0],tach[1],Double.parseDouble(tach[2]),Double.parseDouble(tach[3]));
					ds1.add(sv);
				}else if(tach.length == 5) {
					SvToan sv = new SvToan(tach[0],tach[1],Double.parseDouble(tach[2]),Double.parseDouble(tach[3]),Double.parseDouble(tach[4]));
					ds1.add(sv);
				}
				else if(tach.length == 6) {
					SvLy sv = new SvLy(tach[0],tach[1],Double.parseDouble(tach[2]),Double.parseDouble(tach[3]),Double.parseDouble(tach[4]),Double.parseDouble(tach[5]));
					ds1.add(sv);
				}
			}
			br.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}	
	}
	public void HienThi() {
		System.out.println("Danh sach sv Khoa CNTT: ");
		for(Object sv : ds1) {
			if(sv instanceof SvCntt) {
				((SvCntt) sv).HienThi();
			}
		}
		System.out.println("Danh sach sv Khoa Toan: ");
		for(Object sv : ds1) {
			if(sv instanceof SvToan) {
				((SvToan) sv).HienThi();
			}
		}
		System.out.println("Danh sach sv Khoa Ly: ");
		for(Object sv : ds1) {
			if(sv instanceof SvLy) {
				((SvLy) sv).HienThi();
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LopHoc lh = new LopHoc();
		lh.TaoLop("sv.txt");
		lh.HienThi();
	}

}
