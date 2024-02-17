import java.util.Scanner;

public class vidu4 {

	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("Nhap ho ten: ");
			String ht = sc.nextLine(); // ht = "Le Hoang Van Nam";
			if(ht.isEmpty()) {
				System.out.println("Ban chua nhap ho ten !!");
				return;
			}
			ht = ht.trim();
			int index_first = ht.indexOf(' ');
			int index_last = ht.lastIndexOf(' ');
			//System.out.println(index_last + " " + index_first);
			if(index_first == -1) {
				System.out.println(ht);
			}
			else {
				System.out.println(ht.substring(0,index_first));
			}
			
			if(index_last - index_first > 0) {
				System.out.println(ht.substring(index_first + 1,index_last));
			}
			
			if(index_last != -1) {
				System.out.println(ht.substring(index_last + 1,ht.length()));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
	}

}
