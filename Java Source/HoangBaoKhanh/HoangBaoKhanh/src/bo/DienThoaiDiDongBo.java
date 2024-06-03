package bo;

import java.util.ArrayList;

import bean.DienThoaiDiDongBean;
import dao.DienThoaiDiDongDao;

public class DienThoaiDiDongBo {
	DienThoaiDiDongDao dao = new DienThoaiDiDongDao();
	
	public ArrayList<DienThoaiDiDongBean> findAll() throws Exception {
		return dao.findAll();
	}
	
	public DienThoaiDiDongBean findElementByMaDTDD(String maDT) throws Exception {
		return dao.findElementByMaDTDD(maDT);
	}
	
	public void insert(DienThoaiDiDongBean dienthoaididong) throws Exception {
		if(dao.findElementByMaDTDD(dienthoaididong.getMaDT()) == null) {
			dao.insert(dienthoaididong);
		}
	}
}
