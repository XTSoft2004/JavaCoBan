package bo;

import java.util.ArrayList;

import bean.DienThoaiBean;
import dao.DienThoaiDao;

public class DienThoaiBo {
	DienThoaiDao dao = new DienThoaiDao();
	public ArrayList<DienThoaiBean> findAllFromFile() throws Exception {
		return dao.findAllFromFile();
	}
}
