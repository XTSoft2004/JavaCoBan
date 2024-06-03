package bean;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DienThoaiDiDongBean extends DienThoaiBean {
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private Date ngayHetHanBaoHanh;
	private Integer dungLuongBoNho;
	
	public DienThoaiDiDongBean(String maDT, String tenDT, String hangSanXuat, Double giaBan, Date ngayHetHanBaoHanh,
			Integer dungLuongBoNho) {
		super(maDT, tenDT, hangSanXuat, giaBan);
		this.ngayHetHanBaoHanh = ngayHetHanBaoHanh;
		this.dungLuongBoNho = dungLuongBoNho;
	}
	
	public DienThoaiDiDongBean() {
		
	}

	public Date getNgayHetHanBaoHanh() {
		return ngayHetHanBaoHanh;
	}

	public void setNgayHetHanBaoHanh(Date ngayHetHanBaoHanh) {
		this.ngayHetHanBaoHanh = ngayHetHanBaoHanh;
	}

	public Integer getDungLuongBoNho() {
		return dungLuongBoNho;
	}

	public void setDungLuongBoNho(Integer dungLuongBoNho) {
		this.dungLuongBoNho = dungLuongBoNho;
	}

	@Override
	public String toString() {
		return getMaDT() + ";" + getTenDT() + ";" + getHangSanXuat() + ";" + getGiaBan() + ";" + sdf.format(getNgayHetHanBaoHanh()) + ";" + getDungLuongBoNho();
	}
	
	
	
}
