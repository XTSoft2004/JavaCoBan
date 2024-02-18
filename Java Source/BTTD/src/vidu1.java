import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class vidu1 {

	public static ArrayList<String> AddDS(String pathFile){
		ArrayList<String> DanhSach = new ArrayList<String>();
		try {
			FileReader fr = new FileReader(pathFile);
			BufferedReader br = new BufferedReader(fr);
			while(true) {
				String st = br.readLine();
				if(st == null || st == "")
					break;
				DanhSach.add(st);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return DanhSach;
	}
	public static void main(String[] args) {
		System.out.println("Dang xu ly");
		ArrayList<String> DsVaoBai = AddDS("input1.txt");
		ArrayList<String> DsRaBai = AddDS("input2.txt");
		
		try {
			FileWriter f2 = new FileWriter("output.txt");
			PrintWriter pr = new PrintWriter(f2);
			for(int i = 0;i < DsVaoBai.size();i++) {
				
				String[] DataVB = DsVaoBai.get(i).split("[;]");
				String[] DataRB = DsRaBai.get(i).split("[;]");
				String TinhTrang = DataVB[4];
				if(TinhTrang.equals("Binh thuong") || TinhTrang.equals("Not Available")) {
					TinhTrang = TinhTienThueBai(DataVB[0],DataVB[3],DataRB[3]);
				}else {
					TinhTrang = "Chua xac dinh - Dang xu ly boi thuong";
				}
				pr.println(DataRB[0] + ";" + DataRB[1] + ";" + DataVB[3] + ";" + DataRB[3] + ";" + TinhTrang);
			}
			pr.close();
			System.out.println("Da xong");
		} catch (Exception e) {
			System.out.println("Loi o file output: " + e.getMessage());
			// TODO: handle exception
		}
		
	}
	public static String TinhTienThueBai(String idXe, String date1, String date2) {
		double total = 0.0;
	    try {
	        SimpleDateFormat f = new SimpleDateFormat("HH:mm dd/MM/yyyy");
	        Date dt1 = f.parse(date1);
	        Date dt2 = f.parse(date2);
	        long time = dt2.getTime() - dt1.getTime();
	        double Hour = (double) time / 1000 / 60 / 60;
	        System.out.println(Hour);
	        //Hour = Math.ceil(Hour);
	        System.out.print(idXe + "; " + date1 + "; " + date2 + "; " + Hour);
	        if (idXe.equals("0")) {
	        	Hour = Hour / 24;
	        	Hour = Math.ceil(Hour);
	        	total = 1000 * Hour;	            
	        } 
	        else if (idXe.equals("2")) {
	        	Hour = Hour / 24;
	        	Hour = Math.ceil(Hour);
	            total = 3000 * Hour;	        
	        } 
	        else if (idXe.equals("4")) {
	            double soNgay = Hour * 2;
	            total = 5000 * soNgay;	         
	        }
	    } catch (Exception e) {
	        // TODO: handle exception
	    	System.out.println("Loi tinh tien thue bai: " + e.getMessage());
	    }
	    System.out.println("; "+ total);
	    return String.valueOf(total);
	}

}
