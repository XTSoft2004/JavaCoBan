package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import bean.Nhanvienbean;
import bo.Nhanvienbo;

import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmNhanVien extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField txtmanv;
	private JTextField txthoten;
	private JTextField txtgioitinh;
	private JTextField txthsl;
	private JTextField txtemail;
	private JTextField txtPhone;
	private JTextField txtngaysinh;
	public Nhanvienbo nvbo = new Nhanvienbo();
	public SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmNhanVien frame = new frmNhanVien();
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
	public void UpdateTable(ArrayList<Nhanvienbean> ds) {
		DefaultTableModel dtm = new DefaultTableModel();
		dtm.addColumn("Ma nhan vien");
		dtm.addColumn("Ho ten");
		dtm.addColumn("Gioi tinh");
		dtm.addColumn("Ngay sinh");
		dtm.addColumn("He so luong");
		dtm.addColumn("Email");
		dtm.addColumn("Phone");	
		
		for(Nhanvienbean nv : ds) {
			String[] st = nv.toString().split("[;]");
			dtm.addRow(st);
		}
		table.setModel(dtm);
	}
	
	public frmNhanVien() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				try {
					UpdateTable(nvbo.getDsNV());
				} catch (Exception e2) {
					// TODO: handle exception
				}
				
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1021, 620);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 211, 969, 359);
		contentPane.add(tabbedPane);
		
		JScrollPane scrollPane = new JScrollPane();
		tabbedPane.addTab("Danh sách nhân viên", null, scrollPane, null);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("Mã nhân viên:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(25, 41, 112, 14);
		contentPane.add(lblNewLabel);
		
		txtmanv = new JTextField();
		txtmanv.setBounds(129, 41, 112, 20);
		contentPane.add(txtmanv);
		txtmanv.setColumns(10);
		
		JLabel lblHTn = new JLabel("Họ tên:");
		lblHTn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblHTn.setBounds(64, 70, 83, 14);
		contentPane.add(lblHTn);
		
		txthoten = new JTextField();
		txthoten.setColumns(10);
		txthoten.setBounds(129, 69, 112, 20);
		contentPane.add(txthoten);
		
		JLabel lblGiiTnh = new JLabel("Giới tính:");
		lblGiiTnh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblGiiTnh.setBounds(64, 94, 67, 14);
		contentPane.add(lblGiiTnh);
		
		txtgioitinh = new JTextField();
		txtgioitinh.setColumns(10);
		txtgioitinh.setBounds(129, 95, 112, 20);
		contentPane.add(txtgioitinh);
		
		JLabel lblHTn_1_1 = new JLabel("Hệ số lương:");
		lblHTn_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblHTn_1_1.setBounds(251, 42, 83, 14);
		contentPane.add(lblHTn_1_1);
		
		txthsl = new JTextField();
		txthsl.setColumns(10);
		txthsl.setBounds(344, 41, 112, 20);
		contentPane.add(txthsl);
		
		JLabel lblHTn_1_2 = new JLabel("Email:");
		lblHTn_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblHTn_1_2.setBounds(292, 71, 42, 14);
		contentPane.add(lblHTn_1_2);
		
		txtemail = new JTextField();
		txtemail.setColumns(10);
		txtemail.setBounds(344, 70, 112, 20);
		contentPane.add(txtemail);
		
		JLabel lblHTn_1_3 = new JLabel("Phone:");
		lblHTn_1_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblHTn_1_3.setBounds(289, 96, 55, 14);
		contentPane.add(lblHTn_1_3);
		
		txtPhone = new JTextField();
		txtPhone.setColumns(10);
		txtPhone.setBounds(344, 96, 112, 20);
		contentPane.add(txtPhone);
		
		JLabel lblHTn_1_3_1 = new JLabel("Ngày sinh:");
		lblHTn_1_3_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblHTn_1_3_1.setBounds(42, 127, 92, 14);
		contentPane.add(lblHTn_1_3_1);
		
		txtngaysinh = new JTextField();
		txtngaysinh.setColumns(10);
		txtngaysinh.setBounds(129, 126, 112, 20);
		contentPane.add(txtngaysinh);
		
		JButton btnAddNhanVien = new JButton("Thêm");
		btnAddNhanVien.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String manv = txtmanv.getText();
					String hoten =  txthoten.getText();
					Boolean isGioiTinh = txtgioitinh.getText().toLowerCase() == "nam" ? true : false;
					Date ngaysinh = sdf.parse(txtngaysinh.getText());
					Double hsl = Double.parseDouble(txthsl.getText());
					String email = txtemail.getText();
					String phone = txtPhone.getText();
					int kq = nvbo.ThemNV(manv, hoten, isGioiTinh, ngaysinh, hsl, email, phone);
					
					if(kq == -1)
						JOptionPane.showMessageDialog(null, "Ma nv " + manv + " da ton tai trong danh sach");
					else if(kq == 1)
						JOptionPane.showMessageDialog(null, "Da them nhan vien " + hoten + " vao danh sach");
					else
						JOptionPane.showMessageDialog(null, "Them nhan vien " + hoten + " vao danh sach that bai");
					
					UpdateTable(nvbo.getDsNV());
				} catch (Exception e2) {
					e2.printStackTrace();
					// TODO: handle exception
				}
				
			}
		});
		btnAddNhanVien.setBounds(251, 121, 205, 33);
		contentPane.add(btnAddNhanVien);
		
		JButton btnRemoveNhanvien = new JButton("Xóa nhân viên");
		btnRemoveNhanvien.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String manv = JOptionPane.showInputDialog("Nhap ma nhan vien de xoa: ");
					if(nvbo.XoaNV(manv) == 1) {
						JOptionPane.showMessageDialog(null, "Xoa thanh cong nhan vien " + manv);
					}
					else {
						JOptionPane.showMessageDialog(null, "Xoa that bai nhan vien " + manv);
					}
					UpdateTable(nvbo.getDsNV());
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
				
				
			}
		});
		btnRemoveNhanvien.setBounds(465, 120, 205, 33);
		contentPane.add(btnRemoveNhanvien);
		
		JButton btnTngHS = new JButton("Tăng hệ số lương nhân viên");
		btnTngHS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String manv = JOptionPane.showInputDialog("Nhap ma nhan vien de tang hsl: ");
					Double hsl = Double.parseDouble(JOptionPane.showInputDialog("Nhap hsl muon tang: "));
					if(nvbo.TangHSL(manv, hsl) == 1) {
						JOptionPane.showMessageDialog(null, "Tang he so luong thanh cong cho nhan vien " + manv);
					}else {
						JOptionPane.showMessageDialog(null, "Tang he so luong that bai cho nhan vien " + manv);
					}
					UpdateTable(nvbo.getDsNV());
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
				
			}
		});
		btnTngHS.setBounds(680, 120, 205, 33);
		contentPane.add(btnTngHS);
	}
}
