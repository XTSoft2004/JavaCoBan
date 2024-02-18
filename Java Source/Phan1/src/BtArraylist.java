import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class BtArraylist {
	public ArrayList<String> DsHoten = new ArrayList<String>();
	public ArrayList<Double> DsDtb = new ArrayList<Double>();
	public void TaoDanhSach() {
		try {
			FileReader fr = new FileReader("sv.txt");
			BufferedReader r = new BufferedReader(fr);
			while(true) {
				String st = r.readLine();
				if(st == null || st == "")
					break;
				String[] ds = st.split("[;]");
				DsHoten.add(ds[1]);
				DsDtb.add(Double.parseDouble(ds[3]));
			}
			r.close();
		} catch (Exception tt) {
			// TODO: handle exception
			System.out.println("Loi o ham XuatDanh sach: " + tt.getMessage());
		}
	}
	public void XuatDanhSach() {
		int ss = DsHoten.size();
		for(int i = 0;i < ss;i++) {
			System.out.println(DsHoten.get(i) + ":" + DsDtb.get(i));
		}
	}
}
