package bo;

import java.util.ArrayList;

import bean.Giangvienbean;
import bean.Nguoibean;
import bean.Nhanvienbean;
import dao.Nguoidao;

public class Nguoibo {
	public ArrayList<Nguoibean> ds = new ArrayList<Nguoibean>();
	public Nguoidao ndao = new Nguoidao();
	public void KiemTraDuLieuHopLe() throws Exception{
		ndao.KiemTraDuLieuHopLe();
	}
	public ArrayList<Nguoibean> NapDuLieu() throws Exception{
		ds = ndao.NapDuLieu();
		return ds;
	}
	public boolean NapNV(Nhanvienbean nv) throws Exception {
		for(Nhanvienbean nvien : ndao.getDsNV())
			if(nvien.getMaNV().equals(nv.getMaNV()))
				return false;
		return ndao.NapNV(nv);
	}
	public boolean NapGV(Giangvienbean gv) throws Exception {
		for(Giangvienbean gvien : ndao.getDsGV())
			if(gvien.getMaGV().equals(gv.getMaGV()))
				return false;
		return ndao.NapGV(gv);
	}
	public ArrayList<Nhanvienbean> getDsNV() throws Exception {
		return ndao.getDsNV();
	}
	public ArrayList<Giangvienbean> getDsGV() throws Exception {
		return ndao.getDsGV();
	}
}
