package BtGd;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class frmtest extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtA;
	private JTextField txtB;
	private JTextField txtResult;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmtest frame = new frmtest();
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
	public frmtest() {
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
//				System.out.println("Xin Chao");
				JOptionPane.showMessageDialog(null, "Ding Dong, Calculator !");
				
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("A = ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 11, 39, 28);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("B = ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(10, 61, 39, 25);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Result = ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(10, 105, 89, 28);
		contentPane.add(lblNewLabel_2);
		
		txtA = new JTextField();
		txtA.setBounds(142, 19, 266, 20);
		contentPane.add(txtA);
		txtA.setColumns(10);
		
		txtB = new JTextField();
		txtB.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == 10) {
					long a = Long.parseLong(txtA.getText());
					long b = Long.parseLong(txtB.getText());
					Long result = a + b;
					txtResult.setText(result.toString());
				}
				if (e.getKeyCode() == 27) {
					System.exit(1);
				}
			}
		});
		txtB.setBounds(142, 67, 266, 20);
		contentPane.add(txtB);
		txtB.setColumns(10);
		
		txtResult = new JTextField();
		txtResult.setBounds(142, 113, 266, 20);
		contentPane.add(txtResult);
		txtResult.setColumns(10);
		
		JButton btnNewButton = new JButton("+");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				long a = Long.parseLong(txtA.getText());
				long b = Long.parseLong(txtB.getText());
				Long result = a + b;
				txtResult.setText(result.toString());
			}
		});
		btnNewButton.setBounds(22, 164, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("-");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				long a = Long.parseLong(txtA.getText());
				long b = Long.parseLong(txtB.getText());
				Long result = a - b;
				txtResult.setText(result.toString());
			}
		});
		btnNewButton_1.setBounds(121, 164, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("*");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				long a = Long.parseLong(txtA.getText());
				long b = Long.parseLong(txtB.getText());
				Long result = a * b;
				txtResult.setText(result.toString());
			}
		});
		btnNewButton_2.setBounds(220, 164, 89, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("/");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double a = Double.parseDouble(txtA.getText());
				double b = Double.parseDouble(txtB.getText());
				if (b != 0) {
					Double result = a / b;
					txtResult.setText(result.toString());
				}
				else {
					JOptionPane.showMessageDialog(null, "Về học lại lớp 1 !");
					
				}
				
			}
		});
		btnNewButton_3.setBounds(319, 164, 89, 23);
		contentPane.add(btnNewButton_3);
	}
}
