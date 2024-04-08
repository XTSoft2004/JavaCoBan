package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bean.Accountbean;
import bo.Accountbo;
import bo.Hoadonbo;

import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField txtpassword;
	private JTextField txtusername;
	private JButton btnDangNhap;
	private JButton btnDangKi;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmLogin frame = new frmLogin();
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
	public boolean IsFullInfo() {
		String username =txtusername.getText();
		String password = txtpassword.getText();
		if(username.equals("") || password.equals(""))
			return false;
		else
			return true;
	}
	public Accountbo accBo = new Accountbo();
	public Hoadonbo hdbo = new Hoadonbo();
	
	public static Accountbean Account;
	public frmLogin() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 345, 186);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtpassword = new JPasswordField();
		txtpassword.setBounds(88, 69, 196, 20);
		contentPane.add(txtpassword);
		
		txtusername = new JTextField();
		txtusername.setBounds(90, 33, 194, 20);
		contentPane.add(txtusername);
		txtusername.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("T\u00E0i kho\u1EA3n:");
		lblNewLabel.setBounds(28, 33, 64, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("M\u1EADt kh\u1EA9u:");
		lblNewLabel_1.setBounds(28, 69, 62, 14);
		contentPane.add(lblNewLabel_1);
		
		btnDangNhap = new JButton("\u0110\u0103ng nh\u1EADp");
		btnDangNhap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(!IsFullInfo()) {
						JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin !!!");
						return;
					}
					String username =txtusername.getText();
					String password = txtpassword.getText();
					boolean isLogin = accBo.LoginAccount(username,password);
					if(!isLogin) {
						JOptionPane.showMessageDialog(null, "Đăng nhập thất bại, vui lòng kiểm tra lại tài khoản !!!");
						return;
					}else{
						JOptionPane.showMessageDialog(null, "Đăng nhập thành công");
						frmMain frMain = new frmMain();
						frMain.setVisible(true);
						setVisible(false);				
						Account = accBo.GetAccount(username);					
						//Join from gốc
					}
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
				
			}
		});
		btnDangNhap.setBounds(52, 97, 108, 38);
		contentPane.add(btnDangNhap);
		
		btnDangKi = new JButton("\u0110\u0103ng k\u00ED");
		btnDangKi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frRegister frReg = new frRegister();
				frReg.setVisible(true);
				setVisible(false);
			}
		});
		btnDangKi.setBounds(167, 97, 108, 38);
		contentPane.add(btnDangKi);
	}
}
