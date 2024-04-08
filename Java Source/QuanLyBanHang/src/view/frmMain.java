package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bean.HoaDonbean;
import bean.MatHangbean;
import bo.Hoadonbo;
import bo.Mathangbo;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class frmMain extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lbSohoadon;
	private JLabel lbSosanpham;

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

	/**
	 * Create the frame.
	 */
	public Mathangbo mhbo = new Mathangbo();
	public Hoadonbo hdbo = new Hoadonbo();
	public void LoadThongSo() {
		try {
			
			ArrayList<MatHangbean> dsMathang = mhbo.getDs();
			lbSosanpham.setText(dsMathang.size() + " sản phẩm");
			ArrayList<HoaDonbean> dsHoadon = hdbo.getDS();
			lbSohoadon.setText(dsHoadon.size() + " hóa đơn");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	public frmMain() {
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				setTitle("Chào mừng bạn " + frmLogin.Account.fullname);
				LoadThongSo();
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 747, 218);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnQuanLyMatHang = new JButton("Qu\u1EA3n l\u00FD m\u1EB7t h\u00E0ng");
		btnQuanLyMatHang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmMatHang frmMH = new frmMatHang();
				frmMH.setVisible(true);
			}
		});
		btnQuanLyMatHang.setBounds(31, 87, 211, 48);
		contentPane.add(btnQuanLyMatHang);
		
		JButton btnMuaHng = new JButton("Mua h\u00E0ng");
		btnMuaHng.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmThanhToan frmTT = new frmThanhToan();
				frmTT.setVisible(true);
			}
		});
		btnMuaHng.setBounds(251, 87, 211, 48);
		contentPane.add(btnMuaHng);
		
		JButton btnQuanLyThongkE = new JButton("Qu\u1EA3n l\u00FD th\u00F4ng k\u00EA");
		btnQuanLyThongkE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmThongKe frThongke = new frmThongKe();
				frThongke.setVisible(true);
			}
		});
		btnQuanLyThongkE.setBounds(472, 87, 211, 48);
		contentPane.add(btnQuanLyThongkE);
		
		JLabel lblNewLabel = new JLabel("S\u1ED1 s\u1EA3n ph\u1EA9m \u0111ang c\u00F3");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(139, 11, 180, 20);
		contentPane.add(lblNewLabel);
		
		lbSosanpham = new JLabel("0 s\u1EA3n ph\u1EA9m");
		lbSosanpham.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbSosanpham.setBounds(179, 42, 100, 14);
		contentPane.add(lbSosanpham);
		
		lbSohoadon = new JLabel("0 h\u00F3a \u0111\u01A1n");
		lbSohoadon.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbSohoadon.setBounds(450, 42, 100, 14);
		contentPane.add(lbSohoadon);
		
		JLabel lblSHan = new JLabel("S\u1ED1 h\u00F3a \u0111\u01A1n \u0111\u00E3 \u0111\u01B0\u1EE3c thanh to\u00E1n");
		lblSHan.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSHan.setBounds(369, 11, 259, 20);
		contentPane.add(lblSHan);
		
		JButton btnLoadThongSo = new JButton("Load các thông số");
		btnLoadThongSo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoadThongSo();
			}
		});
		btnLoadThongSo.setBounds(535, 145, 186, 23);
		contentPane.add(btnLoadThongSo);
	}
}
