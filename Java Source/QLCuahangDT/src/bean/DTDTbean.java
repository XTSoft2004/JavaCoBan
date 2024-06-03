package bean;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DTDTbean extends Dienthoaibean {
	private Date NgayHetHan;
	private String DLBoNho;
	public DTDTbean(String maDT, String tenDT, String hangSX, double gia, Date ngayHetHan, String dLBoNho) {
		super(maDT, tenDT, hangSX, gia);
		NgayHetHan = ngayHetHan;
		DLBoNho = dLBoNho;
	}
	
	public Date getNgayHetHan() {
		return NgayHetHan;
	}

	public void setNgayHetHan(Date ngayHetHan) {
		NgayHetHan = ngayHetHan;
	}

	public String getDLBoNho() {
		return DLBoNho;
	}

	public void setDLBoNho(String dLBoNho) {
		DLBoNho = dLBoNho;
	}

	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return super.toString() + ";" + sdf.format(NgayHetHan) + ";" + DLBoNho;
	}
	
}
