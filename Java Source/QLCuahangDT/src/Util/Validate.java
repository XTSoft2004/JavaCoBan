package Util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {
	public static boolean CheckMaDT(String maDT) {		
		Pattern pt = Pattern.compile("(CD|DD)/\\d{4}");
		Matcher m = pt.matcher(maDT);
		return m.find();
	}
}
