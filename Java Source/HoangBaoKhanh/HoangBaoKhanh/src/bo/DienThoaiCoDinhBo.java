package bo;

import java.util.ArrayList;

import bean.DienThoaiCoDinhBean;
import dao.DienThoaiCoDinhDao;

public class DienThoaiCoDinhBo {
	DienThoaiCoDinhDao dao = new DienThoaiCoDinhDao();
	
	public ArrayList<DienThoaiCoDinhBean> findAll() throws Exception {
		return dao.findAll();
	}
	
	public DienThoaiCoDinhBean findElementByMaDTCD(String maDT) throws Exception {
		return dao.findElementByMaDTCD(maDT);
	}
	
	public void insert(DienThoaiCoDinhBean dienthoaicodinh) throws Exception {
		if(dao.findElementByMaDTCD(dienthoaicodinh.getMaDT()) == null) {
			dao.insert(dienthoaicodinh);
		}
	}
}
