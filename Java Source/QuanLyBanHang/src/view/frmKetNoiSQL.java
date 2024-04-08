package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.Ketnoidao;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

import javax.swing.JCheckBox;

public class frmKetNoiSQL extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtServername;
	private JTextField txtUsername;
	private JTextField txtPassword;
	private JCheckBox cbLuuInfo;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmKetNoiSQL frame = new frmKetNoiSQL();
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
	public boolean isFullInfo() {
		String Servername = txtServername.getText();
		String Username = txtUsername.getText();
		String Password = txtPassword.getText();
		if(Servername.equals("") || Username.equals("") || Password.equals(""))
			return false;
		else
			return true;
	}
	public boolean KetNoiSQL() {
		String Servername = txtServername.getText();
		if(Servername.equals(""))
			return false;
		
		String Username = txtUsername.getText();
		String Password = txtPassword.getText();
		Connection cn = Ketnoidao.ConnectSQL(Servername, Username, Password);
		if(cn != null)
			return true;
		else
			return false;
			
	}
	public void SaveInfo() {
		try {
			String Servername = txtServername.getText();
			String Username = txtUsername.getText();
			String Password = txtPassword.getText();
			
			FileWriter fw = new FileWriter("saveinfoDatabase.txt");
			PrintWriter pw = new PrintWriter(fw);
			pw.print(Servername + "|" + Username + "|" + Password);
			fw.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}	
	}
	public void LoadInfo() {
		try {
			File f = new File("saveinfoDatabase.txt");
			if(!f.exists())
				return;
			FileReader fr = new FileReader("saveinfoDatabase.txt");
			BufferedReader br = new BufferedReader(fr);
			String st = br.readLine();
			String[] che = st.split("[|]");
			txtServername.setText(che[0]);
			txtUsername.setText(che[1]);
			txtPassword.setText(che[2]);
			br.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public frmKetNoiSQL() {
		setTitle("Kết nối SQL");
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				LoadInfo();
				if(KetNoiSQL()) {
					frmLogin frLogin = new frmLogin();
					frLogin.setVisible(true);
					setVisible(false);
				}
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 355, 244);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtServername = new JTextField();
		txtServername.setBounds(141, 32, 142, 20);
		contentPane.add(txtServername);
		txtServername.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Server  name:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(39, 32, 120, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUsername.setBounds(55, 63, 104, 14);
		contentPane.add(lblUsername);
		
		txtUsername = new JTextField();
		txtUsername.setColumns(10);
		txtUsername.setBounds(141, 63, 142, 20);
		contentPane.add(txtUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPassword.setBounds(55, 95, 104, 18);
		contentPane.add(lblPassword);
		
		txtPassword = new JTextField();
		txtPassword.setColumns(10);
		txtPassword.setBounds(137, 97, 142, 20);
		contentPane.add(txtPassword);
		
		JButton btnKetNoi = new JButton("K\u1EBFt n\u1ED1i");
		btnKetNoi.addActionListener(new ActionListener() {		
			public void actionPerformed(ActionEvent e) {
				if(!isFullInfo())
				{
					JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin trước khi kết nối !!!");
					return;
				}
				
				if(cbLuuInfo.isSelected())
					SaveInfo();
				
				if(KetNoiSQL()) {
					JOptionPane.showMessageDialog(null, "Kết nối thành công");
					frmLogin frLogin = new frmLogin();
					frLogin.setVisible(true);	
					setVisible(false);
				}else {
					JOptionPane.showMessageDialog(null, "Kết nối thất bại");
				}
			}
		});
		btnKetNoi.setBounds(86, 149, 167, 45);
		contentPane.add(btnKetNoi);
		
		cbLuuInfo = new JCheckBox("Lưu thông tin kết nối database");
		cbLuuInfo.setBounds(25, 120, 243, 23);
		contentPane.add(cbLuuInfo);
	}
}
