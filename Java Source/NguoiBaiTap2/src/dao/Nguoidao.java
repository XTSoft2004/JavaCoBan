package dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.validation.Validator;

import bean.NguoiBean;
import bean.NhanVienBean;
import bean.Sinhvienbean;
import util.Validate;

public class Nguoidao {
	public ArrayList<NguoiBean> dsNguoi = new ArrayList<NguoiBean>();
	public SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	public ArrayList<NguoiBean> getDanhSach(){
		try {
			FileReader fr = new FileReader("ds.txt");
			BufferedReader br = new BufferedReader(fr);
			int pos = 1;
			while(true) {
				String st = br.readLine();
				if(st == null || st == "")
					break;
				String[] che = st.split("[;]");
				
				String datetime = che[2];
				if(!Validate.isDate(datetime))
				{
					SaveLogError(String.valueOf(pos));
					continue;
				}
					
				if(che.length == 3) {
					dsNguoi.add(new NguoiBean(che[0], Boolean.parseBoolean(che[1]), sdf.parse(che[2])));
				}else if(che.length == 6) {
					dsNguoi.add(new Sinhvienbean(che[0], Boolean.parseBoolean(che[1]), sdf.parse(che[2]), che[3], che[4], Double.parseDouble(che[5])));
				}else if(che.length == 7) {
					String email = che[5];
					String phone = che[6];
					
					if(!Validate.isEmail(email) || !Validate.isPhone(phone)) {
						SaveLogError(String.valueOf(pos));
						continue;
					}
					
					dsNguoi.add(new NhanVienBean(che[0], Boolean.parseBoolean(che[1]), sdf.parse(che[2]), che[3], Double.parseDouble(che[4]), email, phone));
				}
				else {
					SaveLogError(String.valueOf(pos));
				}
				pos += 1;
			}
			fr.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return dsNguoi;
	}
	public void SaveLogError(String pos) {
		try {
			FileWriter fw = new FileWriter("log.txt",true);
			PrintWriter pw = new PrintWriter(fw);
			String st = "Dong thu " + pos + " khong hop le";
			System.out.println(st);
			pw.println(st);
			pw.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}	
	}
	public void ShowInfo() {
		for(NguoiBean nb : dsNguoi) {
			System.out.println(nb.toString());
		}
	}
}
