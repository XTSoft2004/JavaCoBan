package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmMain extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

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
	public frmMain() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 758, 364);
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
		btnQuanLyMatHang.setBounds(76, 96, 211, 48);
		contentPane.add(btnQuanLyMatHang);
		
		JButton btnMuaHng = new JButton("Mua h\u00E0ng");
		btnMuaHng.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmThanhToan frmTT = new frmThanhToan();
				frmTT.setVisible(true);
			}
		});
		btnMuaHng.setBounds(296, 96, 211, 48);
		contentPane.add(btnMuaHng);
	}
}
