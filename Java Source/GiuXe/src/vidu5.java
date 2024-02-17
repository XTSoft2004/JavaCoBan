import java.util.Scanner;

public class vidu5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] ds = { "sv1;Le van Nam;K45",
				"sv2;Ho van Tu;K45",
				"sv3;Ho van Tu;K46",
				"sv4;Do van Hung Dung;K47" };
		// Nhap vao 1 key
		Scanner sc = new Scanner(System.in);
		String key = sc.nextLine();
		// In ra cac ho ten giong nhu key ( tim tuong toi )
		Boolean isCheck = false;
		for (String item : ds) {

			if (item.split("[;]")[2].equalsIgnoreCase(key)) {
				System.out.println(item);
				isCheck = true;
			}
		}
		if (!isCheck) {
			System.out.println("Khong co ai trung ca");
		}
	}

}