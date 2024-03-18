package util;

import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {
	public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	public static boolean isEmail(String email) {
		Pattern pt = Pattern.compile("^\\w+@(\\w+.)(\\w+.){2,}",Pattern.CASE_INSENSITIVE);
		Matcher matcher = pt.matcher(email);
		if(matcher.find())
			return true;
		else 
			return false;
	}
	public static boolean isPhone(String phone) {
		Pattern pt = Pattern.compile("0\\d{9,10}",Pattern.CASE_INSENSITIVE);
		Matcher matcher = pt.matcher(phone);
		if(matcher.find())
			return true;
		else 
			return false;
	}
	public static boolean isDate(String date) {
		Pattern pt = Pattern.compile("\\d{1,2}/\\d{1,2}/\\d{1,4}",Pattern.CASE_INSENSITIVE);
		Matcher matcher = pt.matcher(date);
		if(!matcher.find())
			return false;
		try {
			sdf.setLenient(false);
			sdf.parse(date);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	public static boolean isMsv(String msv) {
		Pattern pt = Pattern.compile("^\\w{1}",Pattern.CASE_INSENSITIVE);
		Matcher matcher = pt.matcher(msv);
		if(matcher.find())
			return true;
		else
			return false;
	}
}
