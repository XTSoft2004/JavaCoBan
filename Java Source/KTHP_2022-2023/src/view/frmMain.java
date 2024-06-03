package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import bean.Giangvienbean;
import bean.Nguoibean;
import bean.Nhanvienbean;
import bo.Nguoibo;
import dao.Ketnoidao;

import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmMain extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tableNV;
	private JTable tableGV;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmMain frame = new frmMain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public Nguoibo nbo = new Nguoibo();
	public void LoadDataTableNV(ArrayList<Nhanvienbean> ds) {
		DefaultTableModel dtb = new DefaultTableModel();
		dtb.addColumn("Mã nhân viên");
		dtb.addColumn("Họ và tên");
		dtb.addColumn("Loại hợp đồng");
		dtb.addColumn("Hệ số lương");
		for(Nhanvienbean nv : ds) {
			String[] s = nv.toString().split("[;]");
			dtb.addRow(s);
		}
		tableNV.setModel(dtb);
	}
	public void LoadDataTableGV(ArrayList<Giangvienbean> ds) {
		DefaultTableModel dtb = new DefaultTableModel();
		dtb.addColumn("Mã nhân viên");
		dtb.addColumn("Họ và tên");
		dtb.addColumn("Loại hợp đồng");
		dtb.addColumn("Hệ số lương");
		dtb.addColumn("Phụ cấp");
		for(Giangvienbean nv : ds) {
			String[] s = nv.toString().split("[;]");
			dtb.addRow(s);
		}
		tableGV.setModel(dtb);
	}
	/**
	 * Create the frame.
	 */
	public frmMain() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				
				Ketnoidao.ConnectSQL("TRUONGDESKTOP\\SQLEXPRESS", "QL_NVGV", "sa", "123");
				try {
					// Câu 1
					nbo.KiemTraDuLieuHopLe();
					// Câu 2
					ArrayList<Nguoibean> dsNguoi = nbo.NapDuLieu();			
					for(Nguoibean nv : dsNguoi) {
						if(nv instanceof Nhanvienbean) {
							nbo.NapNV((Nhanvienbean)nv);
						}
					}
					for(Nguoibean nv : dsNguoi) {
						if(nv instanceof Giangvienbean) {
							nbo.NapGV((Giangvienbean)nv);
						}
					}
					LoadDataTableGV(nbo.getDsGV());
					LoadDataTableNV(nbo.getDsNV());
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 368);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 45, 564, 273);
		contentPane.add(tabbedPane);
		
		JScrollPane scrollPane = new JScrollPane();
		tabbedPane.addTab("Nh\u00E2n vi\u00EAn", null, scrollPane, null);
		
		tableNV = new JTable();
		scrollPane.setViewportView(tableNV);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		tabbedPane.addTab("Gi\u1EA3ng vi\u00EAn", null, scrollPane_1, null);
		
		tableGV = new JTable();
		scrollPane_1.setViewportView(tableGV);
		
		JButton btnThongkeNV = new JButton("Thông kê nhân viên");
		btnThongkeNV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ArrayList<Nhanvienbean> dsNV = nbo.getDsNV();
					int cntHD = 0,cntCT = 0;
					for(Nguoibean nv : dsNV) {
						if(nv instanceof Nhanvienbean) {
							if(nv.getLoaiHopDong().equals("chinhthuc"))
								cntCT += 1;
							else if(nv.getLoaiHopDong().equals("hopdong"))
								cntHD += 1;		
						}
					}		
					JOptionPane.showMessageDialog(null, "Nhân viên thống kê:\n+Hợp đồng: " + cntHD + "\n+Chính thức: " + cntCT);
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		btnThongkeNV.setBounds(10, 11, 163, 23);
		contentPane.add(btnThongkeNV);
	}
}
