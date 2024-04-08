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
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class frmLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField txtpassword;
	private JTextField txtusername;
	private JButton btnDangNhap;
	private JButton btnDangKi;
	private JCheckBox cbLuuThongTin;

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
	public void SaveInfo() {
		try {
			File f = new File("D:\\testout.txt");
			FileWriter fw = new FileWriter("saveinfo.txt");
			PrintWriter pw = new PrintWriter(fw);
			pw.print(txtusername.getText() + "|" + txtpassword.getText());
			fw.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	public void LoadInfo() {
		try {
			File f = new File("saveinfo.txt");
			if(!f.exists())
				return;
			FileReader fr = new FileReader("saveinfo.txt");
			BufferedReader br = new BufferedReader(fr);
			String st = br.readLine();
			String[] che = st.split("[|]");
			txtusername.setText(che[0]);
			txtpassword.setText(che[1]);
			br.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	//public static Accountbean Account = new Accountbean(1, "admin", "1", "Xuân Trường");
	public static Accountbean Account;
	public frmLogin() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				LoadInfo();
			}
		});
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 345, 214);
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
						if(cbLuuThongTin.isSelected())
							SaveInfo();
						
						//Join from gốc
					}
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
				
			}
		});
		btnDangNhap.setBounds(49, 123, 108, 38);
		contentPane.add(btnDangNhap);
		
		btnDangKi = new JButton("\u0110\u0103ng k\u00ED");
		btnDangKi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frRegister frReg = new frRegister();
				frReg.setVisible(true);
				setVisible(false);
			}
		});
		btnDangKi.setBounds(164, 123, 108, 38);
		contentPane.add(btnDangKi);
		
		cbLuuThongTin = new JCheckBox("Lưu mật khẩu");
		cbLuuThongTin.setBounds(28, 96, 129, 23);
		contentPane.add(cbLuuThongTin);
	}
}
