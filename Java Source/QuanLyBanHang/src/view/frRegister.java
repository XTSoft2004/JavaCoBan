package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bo.Accountbo;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frRegister extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtusername;
	private JPasswordField txtpassword;
	private JTextField txtFullname;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frRegister frame = new frRegister();
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
		String username = txtusername.getText();
		String password = txtpassword.getText();
		String fullname = txtFullname.getText();
		if(username.equals("") || password.equals("") || fullname.equals(""))
			return false;
		else
			return true;
	}
	public Accountbo accBo = new Accountbo();
	public frRegister() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 317, 189);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tài khoản:");
		lblNewLabel.setBounds(20, 14, 64, 14);
		contentPane.add(lblNewLabel);
		
		txtusername = new JTextField();
		txtusername.setColumns(10);
		txtusername.setBounds(82, 11, 194, 20);
		contentPane.add(txtusername);
		
		txtpassword = new JPasswordField();
		txtpassword.setBounds(82, 47, 194, 20);
		contentPane.add(txtpassword);
		
		JLabel lblNewLabel_1 = new JLabel("Mật khẩu:");
		lblNewLabel_1.setBounds(22, 50, 62, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("H\u1ECD v\u00E0 t\u00EAn:");
		lblNewLabel_1_1.setBounds(22, 81, 62, 14);
		contentPane.add(lblNewLabel_1_1);
		
		txtFullname = new JTextField();
		txtFullname.setColumns(10);
		txtFullname.setBounds(82, 78, 194, 20);
		contentPane.add(txtFullname);
		
		JButton btnCreateAccount = new JButton("Tạo tài khoản");
		btnCreateAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(!IsFullInfo()) {
						JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin !!!");
						return;
					}
					String username = txtusername.getText();
					String password = txtpassword.getText();
					String fullname = txtFullname.getText();
					boolean isReg = accBo.TaoTaiKhoan(username, password, fullname);
					if(isReg) {
						JOptionPane.showMessageDialog(null, "Tạo tài khoản thành công !!!");
						frmLogin frLogin = new frmLogin();
						frLogin.setVisible(true);
						setVisible(false);
						//Join from gốc
					}else {
						JOptionPane.showMessageDialog(null, "Tạo tài khoản thất bại, vui lòng kiểm tra lại hoặc username đã tồn tại !!!");
					}
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		});
		btnCreateAccount.setBounds(46, 112, 111, 23);
		contentPane.add(btnCreateAccount);
		
		JButton btnCancel = new JButton("Hủy");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmLogin frMain = new frmLogin();
				frMain.setVisible(true);
				setVisible(false);
			}
		});
		btnCancel.setBounds(167, 112, 109, 23);
		contentPane.add(btnCancel);
	}
}
