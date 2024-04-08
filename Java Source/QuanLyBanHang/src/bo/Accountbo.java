package bo;

import bean.Accountbean;
import dao.Accountdao;

public class Accountbo {
	public Accountdao accdao = new Accountdao();
	
	public Accountbean GetAccount(String username) throws Exception {
		return accdao.GetAccount(username);
	}
	public boolean LoginAccount(String username,String password) throws Exception {
		return accdao.LoginAccount(username, password);
	}
	public boolean TaoTaiKhoan(String username,String password,String fullname) throws Exception{
		return accdao.TaoTaiKhoan(username, password, fullname);
	}
}
