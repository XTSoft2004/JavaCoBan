package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import bean.TinAbean;
import bean.TinBbean;
import bean.Tinbean;
import bo.Tinbo;

import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.lang.reflect.Array;
import java.util.ArrayList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class frmMain extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tableTin;
	private JComboBox cbbTin;
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
	public String pathFile;
	public Tinbo tbo = new Tinbo();
	public ArrayList<Tinbean> dsTin = new ArrayList<Tinbean>();
	public void LoadTableTin(ArrayList<Tinbean> dsTin) {
		String namecbb = cbbTin.getSelectedItem().toString();
		DefaultTableModel dtb = new DefaultTableModel();
		dtb.addColumn("Ma SV");
		dtb.addColumn("Ho va ten");
		if(namecbb == "Tin A") {
			dtb.addColumn("Diem Win");
			dtb.addColumn("Diem Word");
		}
		else if(namecbb == "Tin B") {
			dtb.addColumn("Diem Excel");
			dtb.addColumn("Diem PowerPoint");
			dtb.addColumn("Diem Web");
		}
		dtb.addColumn("Diem Trung Binh");
		for(Tinbean tbean : dsTin){
			if(tbean instanceof TinAbean && namecbb == "Tin A")
			{
				String[] tach = ((TinAbean)tbean).toString().split("[;]");
				dtb.addRow(tach);
			}
			else if(tbean instanceof TinBbean && namecbb == "Tin B") {
				String[] tach = ((TinBbean)tbean).toString().split("[;]");
				dtb.addRow(tach);
			}
		}
		tableTin.setModel(dtb);
	}
	/**
	 * Create the frame.
	 */
	public frmMain() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				cbbTin.addItem("Tin A");
				cbbTin.addItem("Tin B");
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 599, 403);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 57, 565, 280);
		contentPane.add(tabbedPane);
		
		JScrollPane scrollPane = new JScrollPane();
		tabbedPane.addTab("New tab", null, scrollPane, null);
		
		tableTin = new JTable();
		scrollPane.setViewportView(tableTin);
		
		cbbTin = new JComboBox();
		cbbTin.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				LoadTableTin(dsTin);
			}
		});
		cbbTin.setBounds(74, 26, 105, 21);
		contentPane.add(cbbTin);
		
		JLabel lblNewLabel = new JLabel("Lo\u1EA1i Tin:");
		lblNewLabel.setBounds(10, 30, 74, 13);
		contentPane.add(lblNewLabel);
		
		JButton btnAddDataFile = new JButton("Th\u00EAm d\u1EEF li\u1EC7u t\u1EEB File");
		btnAddDataFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					pathFile = JOptionPane.showInputDialog("Nhập file bạn muốn thêm: ");
					if(pathFile == null || pathFile == "")
					{
						JOptionPane.showMessageDialog(null, "Vui lòng không để trống tên file muốn đưa vào !!!");
						return;
					}
					dsTin = tbo.getDS(pathFile);
					LoadTableTin(dsTin);
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		});
		btnAddDataFile.setBounds(189, 26, 125, 21);
		contentPane.add(btnAddDataFile);
		
		JButton btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nameSearch = JOptionPane.showInputDialog("Nhập họ tên cần tìm kiếm: ");
				if(nameSearch == null || nameSearch == "")
				{
					try {
						dsTin = tbo.getDS(pathFile);
						LoadTableTin(dsTin);		
					} catch (Exception e2) {
						// TODO: handle exception
					}
					return;
				}
				dsTin = tbo.SearchHovaTen(nameSearch);
				LoadTableTin(dsTin);
			}
		});
		btnTimKiem.setBounds(331, 26, 90, 21);
		contentPane.add(btnTimKiem);
		
		JButton SaveF1F2 = new JButton("Save f1.txt và f2.txt");
		SaveF1F2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					tbo.getDS(pathFile);
					tbo.SaveTinATinB();
					JOptionPane.showMessageDialog(null, "Đã lưu thành công");
				} catch (Exception e2) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, "Lưu thất bại");
				}
			}
		});
		SaveF1F2.setBounds(428, 26, 147, 21);
		contentPane.add(SaveF1F2);
	}
}
