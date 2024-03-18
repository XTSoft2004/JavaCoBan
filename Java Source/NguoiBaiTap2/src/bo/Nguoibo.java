package bo;

import java.util.ArrayList;

import bean.NguoiBean;
import dao.Nguoidao;

public class Nguoibo {
	public ArrayList<NguoiBean> dsBo = new ArrayList<NguoiBean>();
	public Nguoidao nd = new Nguoidao();
	public ArrayList<NguoiBean> getDs(){
		dsBo = nd.getDanhSach();
		return dsBo;
	}
	public void ShowDS() {
		nd.ShowInfo();
	}
}
