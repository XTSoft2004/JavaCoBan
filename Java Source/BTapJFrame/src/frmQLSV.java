import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.lang.reflect.AnnotatedArrayType;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class frmQLSV extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtMaSV;
	private JTextField txtHoten;
	private JTextField txtKhoa;
	private JTextField txtDTB;
	private JTable table;
	
	ArrayList<String> dsSV = new ArrayList<String>();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmQLSV frame = new frmQLSV();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public Boolean KtraMaTrung(ArrayList<String> ds,String maSVC) {
		for(String sv : ds) {
			if(sv.split("[;]")[0].toLowerCase().equals(maSVC.toLowerCase()))
				return true;
		}
		return false;
	}
	public void AddItemTable(ArrayList<String> ds) {
		//Tao ra mo hinh bang
		DefaultTableModel mh = new DefaultTableModel();
		//them cot
		mh.addColumn("Masv");
		mh.addColumn("Hoten");
		mh.addColumn("Khoa");
		mh.addColumn("Dtb");
		// Cach 1
//		for(int i = 0;i < ds.size();i++) {
//			String[] info = ds.get(i).split("[;]");
//			mh.addRow(info);
//		}	
		// Cach 2
		for(String sv : ds) {
			String[] info = sv.split("[;]");
			mh.addRow(info);
		}
		// dua mo hinh vao bang
		table.setModel(mh);
	}
	/**
	 * Create the frame.
	 */
	public frmQLSV() {
		setTitle("Quản lí sinh viên");
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				try {		
					FileReader fr = new FileReader("sinhvien.txt");
					BufferedReader br = new BufferedReader(fr);
					while(true) {
						String st = br.readLine();
						if(st == null || st == "")
							break;
						// dua vao mang chuyen dong
						dsSV.add(st);
						System.out.println(st);
					}
					br.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				AddItemTable(dsSV);
			}
			@Override
			public void windowClosing(WindowEvent e) {
				int numClose = JOptionPane.showConfirmDialog(null, "Ban co luu du lieu khong !!");
				if(numClose == 0) {
					try {
						FileWriter fw = new FileWriter("sinhvien.txt",false);
						PrintWriter g = new PrintWriter(fw);
						for(String sv : dsSV) {
							g.println(sv);
						}
						fw.close();
					} catch (Exception e2) {
						// TODO: handle exception
					}
					JOptionPane.showMessageDialog(null,"Da luu thanh cong !!!!");
				}
			}
		});
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 830, 531);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("MaSV");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(41, 27, 46, 14);
		contentPane.add(lblNewLabel);
		
		txtMaSV = new JTextField();
		txtMaSV.setBounds(104, 24, 648, 20);
		contentPane.add(txtMaSV);
		txtMaSV.setColumns(10);
		
		JLabel lblHoTen = new JLabel("Ho ten");
		lblHoTen.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblHoTen.setBounds(39, 63, 55, 14);
		contentPane.add(lblHoTen);
		
		txtHoten = new JTextField();
		txtHoten.setColumns(10);
		txtHoten.setBounds(104, 62, 648, 20);
		contentPane.add(txtHoten);
		
		JLabel lblNewLabel_1_1 = new JLabel("Khoa");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(41, 99, 46, 14);
		contentPane.add(lblNewLabel_1_1);
		
		txtKhoa = new JTextField();
		txtKhoa.setColumns(10);
		txtKhoa.setBounds(104, 96, 648, 20);
		contentPane.add(txtKhoa);
		
		JLabel lblNewLabel_1_2 = new JLabel("DTB");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_2.setBounds(41, 138, 46, 14);
		contentPane.add(lblNewLabel_1_2);
		
		txtDTB = new JTextField();
		txtDTB.setColumns(10);
		txtDTB.setBounds(104, 135, 648, 20);
		contentPane.add(txtDTB);
		
		JButton btnNewButton = new JButton("Thêm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String maSV = txtMaSV.getText();
				if(KtraMaTrung(dsSV,maSV)) {
					JOptionPane.showMessageDialog(null,"Ma nay da trung vui long thu lai !!");
					return;
				}
				String hoten = txtHoten.getText();
				String khoa = txtKhoa.getText();
				String dtb = txtDTB.getText();
				String tt = maSV + ";" + hoten + ";" + khoa + ";" + dtb;
				dsSV.add(tt);
				AddItemTable(dsSV);
			}
		});
		btnNewButton.setBounds(41, 183, 143, 37);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Xóa");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String masv = JOptionPane.showInputDialog("Nhap ma sinh vien: ");
				for(String sv : dsSV) {
					String[] info = sv.split("[;]");
					if(info[0].trim().toLowerCase().equals(masv.trim().toLowerCase())) {
						int numXoa = JOptionPane.showConfirmDialog(null, "Xoa khong may`: ");
						if(numXoa == 0) {
							dsSV.remove(sv);
							break;
						}	
					}
				}
				AddItemTable(dsSV);
			}
		});
		btnNewButton_1.setBounds(199, 183, 124, 37);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Sửa");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String maSV = txtMaSV.getText();
				String hoten = txtHoten.getText();
				String khoa = txtKhoa.getText();
				String dtb = txtDTB.getText();
				String tt = maSV + ";" + hoten + ";" + khoa + ";" + dtb;
				int n = dsSV.size();
				for(int i = 0;i < n;i++) {
					String sv = dsSV.get(i);
					String[] che = sv.split("[;]");
					if(che[0].trim().toLowerCase().equals(maSV.trim().toLowerCase())) {
						dsSV.set(i, tt);
					}
				}
				AddItemTable(dsSV);
			}
		});
		btnNewButton_2.setBounds(337, 183, 130, 37);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Lưu");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					FileWriter fw = new FileWriter("sinhvien.txt",false);
					PrintWriter g = new PrintWriter(fw);
					for(String sv : dsSV) {
						g.println(sv);
					}
					fw.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
				JOptionPane.showMessageDialog(null,"Da luu thanh cong !!!!");
			}
		});
		btnNewButton_3.setBounds(477, 183, 135, 37);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Tìm kiếm");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String search = JOptionPane.showInputDialog("Nhap thu can tim kiem: ");
				System.out.println(search);
				if(search.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Vui long khong nhap trong tim kiem !!");
					AddItemTable(dsSV);
					return;
				}
				ArrayList<String> dsSearch = new ArrayList<String>();
				for(String sv : dsSV) {
					String[] info = sv.split("[;]");
					for(String io : info) {
						if(io.trim().toLowerCase().contains(search.trim().toLowerCase())) {
							dsSearch.add(sv);
							break;
						}			
					}
				}
				AddItemTable(dsSearch);
			}
		});
		btnNewButton_4.setBounds(622, 185, 130, 35);
		contentPane.add(btnNewButton_4);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(23, 231, 718, 250);
		contentPane.add(tabbedPane);
		
		JScrollPane scrollPane = new JScrollPane();
		tabbedPane.addTab("Danh sach sinh vien", null, scrollPane, null);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int d = table.getSelectedRow();
				String masv = table.getValueAt(d, 0).toString();
				String hoten = table.getValueAt(d, 1).toString();
				String khoa = table.getValueAt(d, 2).toString();
				String dtb = table.getValueAt(d, 3).toString();
				
				txtMaSV.setText(masv);
				txtHoten.setText(hoten);
				txtKhoa.setText(khoa);
				txtDTB.setText(dtb);
			}
		});
		scrollPane.setViewportView(table);
	}
}
