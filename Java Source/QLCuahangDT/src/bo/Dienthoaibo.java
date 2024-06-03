package bo;

import java.util.ArrayList;

import bean.DTDTbean;
import bean.Dienthoaibean;
import dao.Dienthoaidao;

public class Dienthoaibo {
	public ArrayList<Dienthoaibean> ds = new ArrayList<Dienthoaibean>();
	public Dienthoaidao dtdao = new Dienthoaidao();

	public void KiemtraHopLe() throws Exception {
		dtdao.KiemtraHopLe();
	}

	public ArrayList<Dienthoaibean> NapKetQua() throws Exception {
		return dtdao.NapKetQua();
	}

	public boolean NapDiDong(DTDTbean dtDiDong) throws Exception {
		for (DTDTbean dt : dtdao.getDsDidong())
			if(dt.getMaDT().trim().toLowerCase().contains(dtDiDong.getMaDT().trim().toLowerCase()))
				return false;
		return dtdao.NapDiDong(dtDiDong);
	}
	public void GetDsTop10() throws Exception  {
		ArrayList<DTDTbean> ds = dtdao.getDsDidong();
		
	}
}
