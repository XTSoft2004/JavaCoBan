package bo;

import java.util.ArrayList;

import bean.SanPhambean;
import dao.SanPhamdao;

public class SanPhambo {
	public ArrayList<SanPhambean> ds = new ArrayList<SanPhambean>();
	public SanPhamdao spdao = new SanPhamdao();
	public boolean isCheckSP(int IdSanPham)  throws Exception{
		ArrayList<SanPhambean> ds = getSPham();
		for(SanPhambean sp : ds) {
			if(sp.getIdSanPham() == IdSanPham)
				return true;
		}
		return false;
	}
	public ArrayList<SanPhambean> getSPham() throws Exception {
		ds = spdao.getSPham();
		return ds;
	}
	public boolean AddSanPham(SanPhambean sp) throws Exception {
		boolean isCheckSP = isCheckSP(sp.getIdSanPham());
		TheLoaibo tlbo = new TheLoaibo();
		boolean isCheckTL = tlbo.isCheckTL(sp.getIdTheLoai());
		if(isCheckSP || !isCheckTL)
			return false;
		if(sp.getTenSanPham() == null || sp.getTenSanPham() == ""
				|| sp.getDonViTinh() == null || sp.getDonViTinh() == "" || sp.getDonGia() <= 0)
			return false;
		
		return spdao.AddSanPham(sp);	
	}
	public void AddFileSP(String pathFile) throws Exception {
		spdao.AddFileSP(pathFile);
	}
}
