package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import bean.ChiTietHoaDonbean;
import bean.HoaDonbean;
import bean.MatHangbean;
import bo.Chitiethoadonbo;
import bo.Hoadonbo;
import bo.Mathangbo;
import dao.Mathangdao;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class frmThongKe extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable HoaDon;
	private JTable ChiTietHoaDon;
	private JComboBox cbbDate;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmThongKe frame = new frmThongKe();
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
	public Hoadonbo hdbo = new Hoadonbo();
	public Chitiethoadonbo chitietbo = new Chitiethoadonbo();
	public Mathangbo mhb = new Mathangbo();
	
	public void UpdateHoaDon(ArrayList<HoaDonbean> dsHoadon) {
		DefaultTableModel dtm = new DefaultTableModel();
		dtm.addColumn("Ma hoa don");
		dtm.addColumn("Ngay tao hoa don");
		dtm.addColumn("Id User");
		
		for(HoaDonbean hoadon : dsHoadon) {
			dtm.addRow(hoadon.toString().split("[;]"));
		}
		
		HoaDon.setModel(dtm);	
	}
	public void UpdateChiTietHoaDon(ArrayList<ChiTietHoaDonbean> dsChitiet) {
		DefaultTableModel dtm = new DefaultTableModel();
		dtm.addColumn("Ma hang");
		dtm.addColumn("So luong mua");
		dtm.addColumn("Gia");
		
		for(ChiTietHoaDonbean chitiet : dsChitiet) {
			String full = chitiet.toString();
			MatHangbean mhbeans = mhb.TimkiemOneMatHang(chitiet.getMahang());
			if(mhbeans != null) {
				double gia = mhbeans.getGia();
				double tonggia = (gia * chitiet.getSoluongmua());
				full = full + ";" + String.valueOf(tonggia);
				dtm.addRow(full.split("[;]"));
			}	
		}
		
		ChiTietHoaDon.setModel(dtm);
	}
	public frmThongKe() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				try {
					setTitle("Thông kê hóa đơn | Account: " + frmLogin.Account.fullname);
					mhb.getDs();
					 ArrayList<String> dsDate = hdbo.getDate();
					 for(String date : dsDate) {
						 cbbDate.addItem(date);
					 }
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
				
			}
		});
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1033, 504);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		cbbDate = new JComboBox();
		cbbDate.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				try {
					String x = String.valueOf(cbbDate.getSelectedItem());
					ArrayList<HoaDonbean> dsHoadon = hdbo.getDS_Date(x);
					UpdateHoaDon(dsHoadon);
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		});
		cbbDate.setBounds(99, 11, 129, 22);
		contentPane.add(cbbDate);
		
		JLabel lblNewLabel = new JLabel("Ng\u00E0y thanh to\u00E1n:");
		lblNewLabel.setBounds(10, 15, 93, 14);
		contentPane.add(lblNewLabel);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 44, 499, 315);
		contentPane.add(tabbedPane);
		
		JScrollPane scrollPane = new JScrollPane();
		tabbedPane.addTab("Danh sách hóa đơn", null, scrollPane, null);
		
		HoaDon = new JTable();
		HoaDon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					int id = HoaDon.getSelectedRow();
					int mahoadon = Integer.parseInt(HoaDon.getValueAt(id, 0).toString());
					System.out.println(mahoadon);
					ArrayList<ChiTietHoaDonbean> dschitiet = chitietbo.getDs_mahoadon(mahoadon);
					UpdateChiTietHoaDon(dschitiet);
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		});
		scrollPane.setViewportView(HoaDon);
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.setBounds(519, 44, 477, 315);
		contentPane.add(tabbedPane_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		tabbedPane_1.addTab("Danh sách hóa đơn chi tiết", null, scrollPane_1, null);
		
		ChiTietHoaDon = new JTable();
		scrollPane_1.setViewportView(ChiTietHoaDon);
	}
}
