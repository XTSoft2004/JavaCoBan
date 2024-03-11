package bt3Khoa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;


public class hienThi {
	static ArrayList<Object>ds=new ArrayList<Object>();
	public static void hienThiSVCNTT() {
		System.out.println("Thong tin cac sinh vien khoa CNTT: ");
		for (Object sv:ds) {
			if (sv instanceof svCNTT) {
				System.out.println(sv.toString());
			}
		}
	}
	public static void hienThiSVToan() {
		System.out.println("Thong tin cac sinh vien khoa Toan: ");
		for (Object sv:ds) {
			if (sv instanceof svToan) {
				System.out.println(sv.toString());
			}
		}
	}
	public static void hienThiSVLy() {
		System.out.println("Thong tin cac sinh vien khoa Ly: ");
		for (Object sv:ds) {
			if (sv instanceof svLy) {
				System.out.println(sv.toString());
			}
		}
	}
	public static void getSinhVien() {
		try {
			FileReader f=new FileReader("sv.txt");
			BufferedReader br=new BufferedReader(f);
			while(true) {
				String st=br.readLine();
				if (st==null||st=="")break;
				String[] tach=st.split("[|]");
				if (tach.length==4) {
					ds.add(new svCNTT(tach[0], tach[1], Double.parseDouble(tach[2]), Double.parseDouble(tach[3])));
				}
				else if (tach.length==5) {
					ds.add(new svToan(tach[0], tach[1], Double.parseDouble(tach[2]), Double.parseDouble(tach[3]), Double.parseDouble(tach[4])));
				}
				else if (tach.length==6) {
					ds.add(new svLy(tach[0], tach[1], Double.parseDouble(tach[2]), Double.parseDouble(tach[3]), Double.parseDouble(tach[4]), Double.parseDouble(tach[5])));
				}
			}
			f.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public static void inDTB() {
		double tongCNTT=0, tongToan=0, tongLy=0;
		double soCNTT=0, soToan=0, soLy=0;
		for (Object sv:ds) {
			if(sv instanceof svCNTT) {
				tongCNTT+=((svCNTT) sv).getDTB();
				soCNTT++;
			}
			else if (sv instanceof svToan) {
				tongToan+=((svToan) sv).getDTB();
				soToan++;
			}
			else if (sv instanceof svLy) {
				tongLy+=((svLy) sv).getDTB();
				soLy++;
			}
		}
		System.out.println("DTB cua khoa CNTT: "+(tongCNTT/soCNTT));
		System.out.println("DTB cua khoa Toan: "+(tongToan/soToan));
		System.out.println("DTB cua khoa Ly: "+(tongLy/soLy));
	}
	public static void luuData(String namefile, ArrayList<Object>obj) {
		try {
			FileWriter f1=new FileWriter(namefile);
			PrintWriter g=new PrintWriter(f1);
			for (Object sv:obj) {
				g.println(sv.toString());
			}
			f1.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void luuSV() {
		ArrayList<Object>obj=new ArrayList<Object>();
		for (Object sv:ds) {
			if (sv instanceof svCNTT) {
				obj.add(sv);
			}
		}
		luuData("f1.txt",obj);
		System.out.println("Luu f1 thanh cong");
		obj=new ArrayList<Object>();
		for (Object sv:ds) {
			if (sv instanceof svToan) {
				obj.add(sv);
			}
		}
		luuData("f2.txt",obj);
		System.out.println("Luu f2 thanh cong");
		obj=new ArrayList<Object>();
		for (Object sv:ds) {
			if (sv instanceof svLy) {
				obj.add(sv);
			}
		}
		luuData("f3.txt",obj);
		System.out.println("Luu f3 thanh cong");
	}
	public static void timKiemSV(String namesearch, String facsearch) {
		for (Object sv:ds) {
			if(facsearch.toLowerCase().trim().equals("cntt") 
					&& sv instanceof svCNTT 
					&& ((svCNTT) sv).getHovaten().trim().toLowerCase().contains(namesearch.trim().toLowerCase())) {
				System.out.println(sv.toString());
			}
			else if(facsearch.toLowerCase().trim().equals("ly") 
					&& sv instanceof svLy 
					&& ((svLy) sv).getHovaten().trim().toLowerCase().contains(namesearch.trim().toLowerCase())) {
				System.out.println(sv.toString());
			}
			else if(facsearch.toLowerCase().trim().equals("toan") 
					&& sv instanceof svToan 
					&& ((svToan) sv).getHovaten().trim().toLowerCase().contains(namesearch.trim().toLowerCase())) {
				System.out.println(sv.toString());
			}
		}
	}
	public static void main(String[] args) {
		getSinhVien();
		System.out.println("Nhap Khoa:");
		Scanner s=new Scanner(System.in);
		String khoa=s.nextLine();
		if (khoa.toLowerCase().trim().equals("cntt")) {
			hienThiSVCNTT();
		}
		else if(khoa.toLowerCase().trim().equals("toan")) {
			hienThiSVToan();
		}
		else if(khoa.toLowerCase().trim().equals("ly")) {
			hienThiSVLy();
		}
		inDTB();
		luuSV();
		
		System.out.println("Nhap ten tim kiem:");
		String namesearch=s.nextLine();
		System.out.println("Nhap khoa tim kiem:");
		String facsearch=s.nextLine();
		timKiemSV(namesearch,facsearch);
		System.out.println("Hoan thanh");
		s.close();
	}

}
