import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Mang {

	public static void main(String[] args) {
		Bai1();
		Bai2();
		Bai3();
	}
	private static void Bai1() {
		BtMang m = new BtMang();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		m.HienThi(n);
		sc.close();
	}
	private static void Bai2() {
		Scanner sc = new Scanner(System.in);	
		System.out.println("Nhap so luong danh sach:");
		int n = sc.nextInt();		
		BtFile bf = new BtFile();
		bf.TaoDanhSach(n);
		
		System.out.println("Nhap ten can tim kiem: ");
		String nameSearch = sc.next();
		boolean isCheckDS = false;
		int NumDau = 0,NumRot = 0;
		Double TBC = 0.0;
		int CountTBC = 0;
		try {
			FileReader fr = new FileReader("sv.txt");
			BufferedReader r = new BufferedReader(fr);
			while(true) {
				String st = r.readLine();
				if(st == null || st == "")
					break;
				String name = st.split("[;]")[1];	
				//Cach 1
				//int index_last = name.trim().lastIndexOf(' ');
				//String LastName = name.substring(index_last + 1);
				//System.out.println(LastName);
				//Cach 2
				if(name.toLowerCase().endsWith(nameSearch.toLowerCase())) {
					isCheckDS = true;
					System.out.println(st);
				}
				Double DTB = Double.parseDouble(st.split("[;]")[3]);
				TBC += DTB;
				CountTBC += 1;
				if(DTB >= 5)
					NumDau += 1;
				else
					NumRot += 1;
			}		
			r.close();
		} catch (Exception e) {
			System.out.println("Loi xay ra o tim kiem ten: " + e.getMessage());
		}
		System.out.println("So sinh vien dau: " + NumDau + "\n" + "So sinh vien rot: " + NumRot);
		System.out.println("Diem trung binh cong: " + (double)(TBC / CountTBC));
		if(!isCheckDS) {
			System.out.println("Khong tim kiem thay thong tin nao ban can tim !!");
		}
		sc.close();
	}
	private static void Bai3() {
		Scanner sc = new Scanner(System.in);	
		System.out.println("Nhap so luong danh sach:");
		int n = sc.nextInt();		
		BtFile bf = new BtFile();
		bf.TaoDanhSach(n);
		
		BtArraylist arl = new BtArraylist();
		arl.TaoDanhSach();
		arl.XuatDanhSach();	
		sc.close();
	}
}
