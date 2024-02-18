
public class vidu7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {3,2,6,2,5};
		for(int i = 0;i < a.length;i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println("");
		int cmax = a[0];
		for(int i : a) {
			if(cmax < i) {
				cmax = i;
			}
		}
		System.out.println("So lon nhat: " + cmax);
	}

}
