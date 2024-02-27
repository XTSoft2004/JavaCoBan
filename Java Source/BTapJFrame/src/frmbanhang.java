import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class frmbanhang extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtGia;
	private JTextField txtSoLuong;
	private JTextField txtThanhTien;
	JComboBox cmbHang = new JComboBox();
	ArrayList<String> ds = new ArrayList<String>();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmbanhang frame = new frmbanhang();
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
	public frmbanhang() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				try {
					FileReader f = new FileReader("Hang.txt");
					BufferedReader bd = new BufferedReader(f);
					while(true) {
						String st = bd.readLine();
						if (st == null || st == "") break;
						cmbHang.addItem(st.split("[;]")[0]);
						ds.add(st);
					}
					bd.close();
				}catch (Exception e2) {
					e2.printStackTrace();
				}
				
			}
		});
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel(" Loại Hàng: ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(16, 42, 82, 27);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Giá:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(63, 80, 35, 19);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Số Lượng:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(24, 110, 74, 27);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Thành Tiền:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(16, 148, 82, 27);
		contentPane.add(lblNewLabel_3);
		cmbHang.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				String test = cmbHang.getSelectedItem().toString();
				for (String temp : ds) {
					String [] re = temp.split("[;]");
					String hang = re[0];
					String gia = re[1];
					if (hang.equals(test))  txtGia.setText(gia);
				}
//				if (test.equals("Xăng")) {
//					txtGia.setText("20000");
//				}
//				if (test.equals("Dầu")) {
//					txtGia.setText("15000");
//				}
//				if (test.equals("Nhớt")) {
//					txtGia.setText("120000");
//				}
			}
		});
		
		
		cmbHang.setBounds(143, 46, 251, 22);
		contentPane.add(cmbHang);
		
		txtGia = new JTextField();
		
		txtGia.setBounds(143, 81, 251, 20);
		contentPane.add(txtGia);
		txtGia.setColumns(10);
		
		txtSoLuong = new JTextField();
		txtSoLuong.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				if (e.getKeyCode() == 10) {
					Long result = Long.parseLong(txtGia.getText()) * Long.parseLong(txtSoLuong.getText());
					txtThanhTien.setText(result.toString());
				}
				
			}
		});
		txtSoLuong.setBounds(143, 115, 251, 20);
		contentPane.add(txtSoLuong);
		txtSoLuong.setColumns(10);
		
		txtThanhTien = new JTextField();
		txtThanhTien.setBounds(143, 153, 251, 20);
		contentPane.add(txtThanhTien);
		txtThanhTien.setColumns(10);
	}
}
