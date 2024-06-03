package util;

import java.text.SimpleDateFormat;

public class Validate {
	public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public static boolean CheckDate(String date) {		
		try {
			sdf.setLenient(false);
			sdf.parse(date);
			return true;
		} catch (Exception e) {
			return false;
			// TODO: handle exception
		}
	}
}
