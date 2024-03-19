package view;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import bean.TinA;
import bean.TinB;
import bo.Hocvienbo;

import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmMain extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tableA;
	private JTable tableB;
	public ArrayList<TinA> dsTinA = new ArrayList<TinA>();
	public ArrayList<TinB> dsTinB = new ArrayList<TinB>();
	public Hocvienbo hvb = new Hocvienbo();
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
	public void UpdateTableTinA(ArrayList<TinA> dsA) {
		DefaultTableModel dtm = new DefaultTableModel();
		dtm.addColumn("Ma sinh vien");
		dtm.addColumn("Ho va ten");
		dtm.addColumn("Diem Win");
		dtm.addColumn("Diem Word");
		dtm.addColumn("Diem Trung Binh");
		
		for(TinA tA : dsA) {
			String[] st = tA.toString().split("[|]");
			dtm.addRow(st);
		}
		
		tableA.setModel(dtm);
	}
	public void UpdateTableTinB(ArrayList<TinB> dsB) {
		DefaultTableModel dtm = new DefaultTableModel();
		dtm.addColumn("Ma sinh vien");
		dtm.addColumn("Ho va ten");
		dtm.addColumn("Diem Excel");
		dtm.addColumn("Diem Power Point");
		dtm.addColumn("Diem Web");
		dtm.addColumn("Diem Trung Binh");
		
		for(TinB tB : dsB) {
			String[] st = tB.toString().split("[|]");
			dtm.addRow(st);
		}
		
		tableB.setModel(dtm);
	}

	/**
	 * Create the frame.
	 */
	public frmMain() {
		setTitle("Bài tập kiểm tra");
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				hvb.getDanhsach();
				dsTinA = hvb.getDsTinA();
				dsTinB = hvb.getDsTinB();
				UpdateTableTinA(dsTinA);
				UpdateTableTinB(dsTinB);
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 685, 482);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 98, 649, 334);
		contentPane.add(tabbedPane);
		
		JScrollPane scrollPane = new JScrollPane();
		tabbedPane.addTab("Danh sach A", null, scrollPane, null);
		
		tableA = new JTable();
		scrollPane.setViewportView(tableA);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		tabbedPane.addTab("Danh sach B", null, scrollPane_1, null);
		
		tableB = new JTable();
		scrollPane_1.setViewportView(tableB);
		
		JButton btnSearchSV = new JButton("Tìm kiếm");
		btnSearchSV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nameSearch = JOptionPane.showInputDialog("Nhap ho va ten can tim kiem: ");
				ArrayList<TinA> dsSearchA = hvb.SearchTinA(nameSearch);
				if(dsSearchA != null && dsSearchA.size() == 0) {
					JOptionPane.showMessageDialog(null, "Khong ton tai du lieu tim kiem cua hoc vien A");
				}
				ArrayList<TinB> dsSearchB = hvb.SearchTinB(nameSearch);
				if(dsSearchB != null && dsSearchB.size() == 0) {
					JOptionPane.showMessageDialog(null, "Khong ton tai du lieu tim kiem cua hoc vien B");
				}
				UpdateTableTinA(dsSearchA);
				UpdateTableTinB(dsSearchB);
			}
		});
		btnSearchSV.setBounds(10, 29, 135, 51);
		contentPane.add(btnSearchSV);
		
		JButton btnLuuThongTin = new JButton("Lưu thông tin học viên");
		btnLuuThongTin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hvb.CreateDanhSachSinhVien();
				JOptionPane.showMessageDialog(null, "Đã lưu thành công 2 file \"f1.txt\" va \"f2.txt\"");
			}
		});
		btnLuuThongTin.setBounds(155, 29, 173, 51);
		contentPane.add(btnLuuThongTin);
	}
}
