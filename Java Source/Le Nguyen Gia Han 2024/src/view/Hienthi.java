package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import bean.TinAbean;
import bean.TinBbean;
import bo.Hocvienbo;

import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Hienthi extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable DsachAtable;
	private JTable DsachBtable;
	public ArrayList<TinAbean> dsA = new ArrayList<TinAbean>();
	public ArrayList<TinBbean> dsB = new ArrayList<TinBbean>();
	public Hocvienbo hvbo = new Hocvienbo();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Hienthi frame = new Hienthi();
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
	public void updateTableA(ArrayList<TinAbean> ds) {
		DefaultTableModel dtb = new DefaultTableModel();
		dtb.addColumn("Ma sv");
		dtb.addColumn("Ho va ten");
		dtb.addColumn("Diem Win");
		dtb.addColumn("Diem Word");
		dtb.addColumn("Diem trung binh");
		
		for(TinAbean hv : ds) {
			String[] che = hv.toString().split("[;]");
			dtb.addRow(che);
		}
		
		DsachAtable.setModel(dtb);
	}
	public void updateTableB(ArrayList<TinBbean> ds) {
		DefaultTableModel dtb = new DefaultTableModel();
		dtb.addColumn("Ma sv");
		dtb.addColumn("Ho va ten");
		dtb.addColumn("Diem Excel");
		dtb.addColumn("Diem PowerPoint");
		dtb.addColumn("Diem Web");
		dtb.addColumn("Diem trung binh");
		
		for(TinBbean hv : ds) {
			String[] che = hv.toString().split("[;]");
			dtb.addRow(che);
		}
		
		DsachBtable.setModel(dtb);
	}
	public Hienthi() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				hvbo.getDS();
				dsA = hvbo.getDSA();
				dsB = hvbo.getDSB();
				updateTableA(dsA);
				updateTableB(dsB);
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 626, 312);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 10, 589, 209);
		contentPane.add(tabbedPane);
		
		JScrollPane scrollPane = new JScrollPane();
		tabbedPane.addTab("Danh sach A", null, scrollPane, null);
		
		DsachAtable = new JTable();
		scrollPane.setViewportView(DsachAtable);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		tabbedPane.addTab("Danh sach B", null, scrollPane_1, null);
		
		DsachBtable = new JTable();
		scrollPane_1.setViewportView(DsachBtable);
		
		JButton btnSearchName = new JButton("Tìm kiếm");
		btnSearchName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String namesearch = JOptionPane.showInputDialog("Nhap ho ten can tim kiem:");
				ArrayList<TinAbean> dsA = hvbo.searchDSA(namesearch);
				if(dsA== null || dsA.size() == 0) {
					JOptionPane.showMessageDialog(null, "Khong ton tai ten nao trong danh sach A");
				}
				ArrayList<TinBbean> dsB = hvbo.searchDSB(namesearch);
				if(dsB== null || dsB.size() == 0) {
					JOptionPane.showMessageDialog(null, "Khong ton tai ten nao trong danh sach B");
				}
				updateTableA(dsA);
				updateTableB(dsB);
			}
		});
		btnSearchName.setBounds(48, 229, 85, 21);
		contentPane.add(btnSearchName);
		
		JButton btnNewButton = new JButton("Lưu thông tin của TinA và TinB");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hvbo.CreateInfoA();
				hvbo.CreateInfoB();
				JOptionPane.showMessageDialog(null, "Da luu danh sach A va danh sach B");
			}
		});
		btnNewButton.setBounds(143, 229, 216, 21);
		contentPane.add(btnNewButton);
	}
}
