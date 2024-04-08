package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import bean.ChiTietHoaDonbean;
import bean.MatHangbean;
import bo.Hoadonbo;
import bo.Mathangbo;
import dao.Chitiethoadondao;
import util.Validate;

import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmThanhToan extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable dsMathang;
	private JTable GioHang;
	private JTextField txtTongDonHang;

	/**
	 * Launch the application.
	 */
	public Mathangbo mhb = new Mathangbo();
	public Hoadonbo hdbo = new Hoadonbo();
	public ArrayList<ChiTietHoaDonbean> dsBuy = new ArrayList<ChiTietHoaDonbean>();
	public ArrayList<MatHangbean> dsMH = new ArrayList<MatHangbean>();
	private JButton btnThanhToan;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmThanhToan frame = new frmThanhToan();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public void UpdateMatHang(ArrayList<MatHangbean> ds) {
		Collections.sort(ds, new Comparator<MatHangbean>() {
		      @Override
		      public int compare(MatHangbean matHang1, MatHangbean matHang2) {
		          return matHang1.mahang.compareTo(matHang2.mahang);
		      }
		  });
		
		DefaultTableModel dtm = new DefaultTableModel();
		dtm.addColumn("Ma hang");
		dtm.addColumn("Ten hang");
		dtm.addColumn("Ngay nhap hang");
		dtm.addColumn("So luong");
		dtm.addColumn("Gia");
		
		for(MatHangbean mathang : ds) {
			dtm.addRow(mathang.toString().split("[;]"));
		}
		
		dsMathang.setModel(dtm);
	}
	public void UpdateGioHang() {
		Collections.sort(dsBuy, new Comparator<ChiTietHoaDonbean>() {
		      @Override
		      public int compare(ChiTietHoaDonbean cthd1, ChiTietHoaDonbean cthd2) {
		          return cthd1.getMahang().compareTo(cthd2.getMahang());
		      }
		  });
		
		double total = 0.0;
		DefaultTableModel dtm = new DefaultTableModel();
		dtm.addColumn("Ma hang");
		dtm.addColumn("So luong");
		dtm.addColumn("Gia");
		for(ChiTietHoaDonbean chitiet : dsBuy) {	
			MatHangbean mhbeans = mhb.TimkiemOneMatHang(chitiet.getMahang());
			if(mhbeans != null) {
				double gia = mhbeans.getGia();
				double tonggia = (gia * chitiet.getSoluongmua());
				total += tonggia;
				String full = chitiet.toString() + ";" + (gia * chitiet.getSoluongmua());
				String[] list = full.split("[;]");
				dtm.addRow(list);
			}	
		}
		
		GioHang.setModel(dtm);
		txtTongDonHang.setText(String.valueOf(total));
	}
	public frmThanhToan() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				try {
					setTitle("Thanh toán hóa đơn | Account: " + frmLogin.Account.fullname);
					dsMH = mhb.getDs();
					UpdateMatHang(dsMH);
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1120, 435);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(24, 11, 403, 351);
		contentPane.add(tabbedPane);
		
		JScrollPane scrollPane = new JScrollPane();
		tabbedPane.addTab("Danh sách mặt hàng", null, scrollPane, null);
		
		dsMathang = new JTable();
		scrollPane.setViewportView(dsMathang);
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.setBounds(647, 11, 448, 351);
		contentPane.add(tabbedPane_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		tabbedPane_1.addTab("Giỏ hàng", null, scrollPane_1, null);
		
		GioHang = new JTable();
		scrollPane_1.setViewportView(GioHang);
		
		JButton btnThemGioHang = new JButton("Thêm vào giỏ hàng");
		btnThemGioHang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int id = dsMathang.getSelectedRow();
					if(id == -1) {
						JOptionPane.showMessageDialog(null, "Chưa chọn mặt hàng bạn cần mua !!!");
						return;
					}
					String mahang = dsMathang.getValueAt(id, 0).toString();
					String soluong = JOptionPane.showInputDialog(null, "Vui lòng nhập số lượng bạn cần mua: ");
					if(soluong == null || soluong == "" || !Validate.isNumber(soluong)) {
						JOptionPane.showMessageDialog(null, "Nhập số lượng không hợp lệ, vui lòng kiểm tra lại !!!");
						return;
					}
					int sl = Integer.parseInt(soluong);
					if(sl <= 0) {
						JOptionPane.showMessageDialog(null, "Vui lòng chọn số lượng lớn hơn 0, vui lòng kiểm tra lại !!");
						return;
					}
					
					// Kiểm tra xem đủ số lượng hàng cần thiết không
					MatHangbean mhbean = mhb.TimkiemOneMatHang(mahang);
					if(mhbean.getSoluong() - sl < 0) {
						JOptionPane.showMessageDialog(null, "Không đủ số lượng để bạn mua, bạn có thể giảm số lượng hoặc chọn sản phẩm khác !!!");
						return;
					}

					// Xóa số lượng ở khi mua
					for(MatHangbean mh : dsMH) {
						if(mh.getMahang().trim().toLowerCase().equals(mahang.trim().toLowerCase())) {
							mh.setSoluong(mh.getSoluong() - sl);
							break;
						}
					}
					
					// Kiểm tra xem đã tồn tại mặt hàng này trong kho không ?
					boolean isExist = false;
					for(ChiTietHoaDonbean chitiet : dsBuy) {
						if(chitiet.getMahang().trim().toLowerCase().equals(mahang.trim().toLowerCase())) {
							chitiet.setSoluongmua(chitiet.getSoluongmua() + sl);
							isExist = true;
							break;
						}
					}
					if(!isExist)
						dsBuy.add(new ChiTietHoaDonbean(-1, -1, mahang, sl));
					
					UpdateMatHang(dsMH);
					UpdateGioHang();
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
				
			}
		});
		btnThemGioHang.setBounds(437, 118, 200, 32);
		contentPane.add(btnThemGioHang);
		
		JButton btnXoaGioHang = new JButton("Xóa mặt hàng trong giỏ hàng");
		btnXoaGioHang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int id = GioHang.getSelectedRow();
					if(id == -1) {
						JOptionPane.showMessageDialog(null, "Chưa chọn mặt hàng bạn cần xóa !!!");
						return;
					}
					String mahang = GioHang.getValueAt(id, 0).toString();
					int soluong = Integer.parseInt(GioHang.getValueAt(id, 1).toString());
					for(ChiTietHoaDonbean chitiet : dsBuy) {
						if(chitiet.getMahang().trim().toLowerCase().equals(mahang.trim().toLowerCase()))
						{
							dsBuy.remove(chitiet);
							break;
						}
					}
					
					// Xóa mặt hàng tại giỏ hàng thêm lại vào kho
					for(MatHangbean mh : dsMH) {
						if(mh.getMahang().trim().toLowerCase().equals(mahang.trim().toLowerCase())) {
							mh.setSoluong(mh.getSoluong() + soluong);
							break;
						}
					}
					UpdateMatHang(dsMH);
					UpdateGioHang();
					JOptionPane.showMessageDialog(null, "Đã xóa thành công ra khỏi giỏ hàng !!!");
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		});
		btnXoaGioHang.setBounds(437, 161, 200, 32);
		contentPane.add(btnXoaGioHang);
		
		JButton btnTimkiemgiohang = new JButton("Tìm kiếm mặt hàng trong giỏ hàng");
		btnTimkiemgiohang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String namesearch = JOptionPane.showInputDialog("Nhập tên mà bạn cần tìm kiếm");
					if(namesearch == null || namesearch.equals(""))
					{
						JOptionPane.showMessageDialog(null, "Vui lòng không bỏ trống tên tìm kiếm !!");
						UpdateMatHang(mhb.getDs());
						return;
					}
					
					UpdateMatHang(mhb.Timkiem(namesearch));
					JOptionPane.showMessageDialog(null, "Tìm kiểm thành công !!");
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		});
		btnTimkiemgiohang.setBounds(436, 204, 203, 32);
		contentPane.add(btnTimkiemgiohang);
		
		txtTongDonHang = new JTextField();
		txtTongDonHang.setEnabled(false);
		txtTongDonHang.setBounds(950, 369, 145, 20);
		contentPane.add(txtTongDonHang);
		txtTongDonHang.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Tổng hóa đơn:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(852, 370, 106, 14);
		contentPane.add(lblNewLabel);
		
		btnThanhToan = new JButton("Thanh toán");
		btnThanhToan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int kq = JOptionPane.showConfirmDialog(null, "Bạn có lựa chọn thanh toán các mặt hàng này không ?");
				if(kq == 0) {
					try {
						if(dsBuy == null || dsBuy.size() == 0) {
							JOptionPane.showMessageDialog(null, "Vui lòng thêm mặt hàng cần thanh toán !!!");
							return;
						}
						Boolean isTaoHoaDon = hdbo.TaoHoaDon(frmLogin.Account.getIdUser(), dsBuy);
						if(isTaoHoaDon) {
							JOptionPane.showMessageDialog(null, "Tạo hóa đơn thành công !!!");
							TruSoluongDaMua();
							UpdateMatHang(mhb.getDs());
							dsBuy.clear(); 
							UpdateGioHang();
						}else {
							JOptionPane.showMessageDialog(null, "Tạo hóa đơn thất bại !!!!");
						}
					} catch (Exception e2) {
						// TODO: handle exception
						e2.printStackTrace();
					}		
				}	
			}
		});
		btnThanhToan.setBounds(433, 247, 204, 32);
		contentPane.add(btnThanhToan);
	}
	public void TruSoluongDaMua() {
		try {
			for(ChiTietHoaDonbean chitiet : dsBuy) {
				MatHangbean mh = mhb.TimkiemOneMatHang(chitiet.getMahang());
				mhb.Chinhsuamathang(mh.getMahang(), mh.getTenhang(), mh.getNgaynhaphang(), mh.getSoluong(), mh.getGia());
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
