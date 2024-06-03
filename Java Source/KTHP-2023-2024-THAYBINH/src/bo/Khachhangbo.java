package bo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import bean.KHInternet;
import bean.KHSIM;
import dao.Khachhangdao;

public class Khachhangbo {
	public ArrayList<KHInternet> dsInternet = new ArrayList<KHInternet>();
	public ArrayList<KHSIM> dsSIM = new ArrayList<KHSIM>();
	public SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
	public Khachhangdao khdao = new Khachhangdao();
	public void NapDuLieu() throws Exception{
		khdao.NapDuLieu();
		dsSIM = khdao.dsSIM;
		dsInternet = khdao.dsInternet;
	}
	public ArrayList<KHInternet> GetDataInternet()
	{
		return dsInternet;
	}
	public ArrayList<KHSIM> GetDataSIM()
	{
		return dsSIM;
	}

}
