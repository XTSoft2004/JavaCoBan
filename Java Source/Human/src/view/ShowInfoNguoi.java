package view;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import bean.Hocsinhbean;
import bean.NguoiBean;
import bean.NhanVienBean;
import bo.Nguoibo;

import javax.swing.JTable;
import javax.swing.JTabbedPane;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ShowInfoNguoi extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable TableNV;
	private JScrollPane scrollPane_1;
	private JTable TableHS;
	ArrayList<NguoiBean> ds = new ArrayList<NguoiBean>();
	Nguoibo nbModel = new Nguoibo();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShowInfoNguoi frame = new ShowInfoNguoi();
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
	
	public void AddItemTableHocSinh(ArrayList<NguoiBean> ds) {
		DefaultTableModel mh = new DefaultTableModel();
		mh.addColumn("Hoten");
		mh.addColumn("Gioi Tinh");
		mh.addColumn("Ngay Sinh");
		mh.addColumn("Ma hoc sinh");
		mh.addColumn("Ten lop");
		mh.addColumn("Diem trung binh");
		for(NguoiBean sv : ds) {
			if(sv instanceof Hocsinhbean) {
				String[] info = sv.toString().split("[;]");
				info[1] = info[1] == "false" ? "Nam" : "Nu";
				mh.addRow(info);
			}
		}
		TableHS.setModel(mh);
	}
	public void AddItemTableNhanVien(ArrayList<NguoiBean> ds) {
		DefaultTableModel mh = new DefaultTableModel();
		mh.addColumn("Hoten");
		mh.addColumn("Gioi Tinh");
		mh.addColumn("Ngay Sinh");
		mh.addColumn("Ma sinh vien");
		mh.addColumn("He so luong");
		mh.addColumn("Email");
		mh.addColumn("Phone");
		for(NguoiBean sv : ds) {
			if(sv instanceof NhanVienBean) {
				String[] info = sv.toString().split("[;]");
				info[1] = info[1] == "false" ? "Nam" : "Nu";
				mh.addRow(info);
			}
		}
		TableNV.setModel(mh);
	}
	public ShowInfoNguoi() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				try {
					ds = nbModel.getsinhvien();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				AddItemTableHocSinh(ds);
				AddItemTableNhanVien(ds);
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 653, 415);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 617, 215);
		contentPane.add(tabbedPane);
		
		JScrollPane scrollPane = new JScrollPane();
		tabbedPane.addTab("Danh sách nhân viên", null, scrollPane, null);
		
		TableNV = new JTable();
		scrollPane.setViewportView(TableNV);
		
		scrollPane_1 = new JScrollPane();
		tabbedPane.addTab("Danh sách học sinh", null, scrollPane_1, null);
		
		TableHS = new JTable();
		TableHS.setFillsViewportHeight(true);
		scrollPane_1.setViewportView(TableHS);
		
		JButton btnNewButton = new JButton("Đếm đậu rớt");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,nbModel.DemDauRot());
			}
		});
		btnNewButton.setBounds(10, 237, 111, 23);
		contentPane.add(btnNewButton);
		
		JButton btnSearchName = new JButton("Tìm kiếm họ tên nhân viên");
		btnSearchName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String search = JOptionPane.showInputDialog("Nhap thu can tim kiem: ");
				System.out.println(search);
				if(search.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Vui long khong nhap trong tim kiem !!");
					AddItemTableNhanVien(ds);
					return;
				}
				
				ArrayList<NguoiBean> dsSearch = nbModel.SearchNhanVien(search);
				AddItemTableNhanVien(dsSearch);
			}
		});
		btnSearchName.setBounds(128, 237, 157, 23);
		contentPane.add(btnSearchName);
	}
}
