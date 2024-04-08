package view;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import bean.MatHangbean;
import bo.Mathangbo;
import dao.Mathangdao;
import util.Validate;

import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JSpinner;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SpinnerNumberModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class frmMatHang extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable Dsmathang;
	
	private JTextField txtmahang;
	private JTextField txttenhang;
	private JTextField txtngaynhaphang;
	private JSpinner numsoluong;
	private JSpinner numgia;
	/**
	 * Launch the application.
	 */
	public Mathangbo mhbo = new Mathangbo();
	//public ArrayList<MatHangbean> dsMathang = new ArrayList<MatHangbean>();
	public SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmMatHang frame = new frmMatHang();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void UpdateMatHang(ArrayList<MatHangbean> dsMathang) {
		Collections.sort(dsMathang, new Comparator<MatHangbean>() {
		      @Override
		      public int compare(MatHangbean matHang1, MatHangbean matHang2) {
		          return matHang1.mahang.compareTo(matHang2.mahang);
		      }
		  });
		
		DefaultTableModel dtm = new DefaultTableModel();
		dtm.addColumn("Ma hang");
		dtm.addColumn("Ten hang");
		dtm.addColumn("Ngay nhap hang");
		dtm.addColumn("So luong");
		dtm.addColumn("Gia");
		
		for(MatHangbean mathang : dsMathang) {
			dtm.addRow(mathang.toString().split("[;]"));
		}
		
		Dsmathang.setModel(dtm);
	}
	/**
	 * Create the frame.
	 */
	public frmMatHang() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				try {
					UpdateMatHang(mhbo.getDs());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 952, 442);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(257, 11, 669, 367);
		contentPane.add(tabbedPane);
		
		JScrollPane scrollPane = new JScrollPane();
		tabbedPane.addTab("Danh sach cac mat hang", null, scrollPane, null);
		
		Dsmathang = new JTable();
		Dsmathang.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int d = Dsmathang.getSelectedRow();
				String mahang = Dsmathang.getValueAt(d, 0).toString();
				String tenhang = Dsmathang.getValueAt(d, 1).toString();
				String ngaynhaphang = Dsmathang.getValueAt(d, 2).toString();
				int soluong = Integer.parseInt(Dsmathang.getValueAt(d, 3).toString());
				Double gia = Double.parseDouble(Dsmathang.getValueAt(d, 4).toString());
				
				txtmahang.setText(mahang);
				txttenhang.setText(tenhang);
				txtngaynhaphang.setText(ngaynhaphang);
				numsoluong.setValue(soluong);
				numgia.setValue(gia);		
			}
		});
		scrollPane.setViewportView(Dsmathang);
		
		txtmahang = new JTextField();
		txtmahang.setBounds(125, 40, 107, 20);
		contentPane.add(txtmahang);
		txtmahang.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("M\u00E3 h\u00E0ng:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(63, 39, 70, 19);
		contentPane.add(lblNewLabel);
		
		JLabel lblTnHanghf = new JLabel("T\u00EAn h\u00E0ng:");
		lblTnHanghf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTnHanghf.setBounds(52, 69, 70, 19);
		contentPane.add(lblTnHanghf);
		
		txttenhang = new JTextField();
		txttenhang.setColumns(10);
		txttenhang.setBounds(125, 70, 107, 20);
		contentPane.add(txttenhang);
		
		JLabel lblNewLabel_1_1 = new JLabel("Ng\u00E0y nh\u1EADp h\u00E0ng:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(11, 97, 107, 19);
		contentPane.add(lblNewLabel_1_1);
		
		txtngaynhaphang = new JTextField();
		txtngaynhaphang.setColumns(10);
		txtngaynhaphang.setBounds(125, 98, 107, 20);
		contentPane.add(txtngaynhaphang);
		
		JLabel lblNewLabel_1_2 = new JLabel("S\u1ED1 l\u01B0\u1EE3ng:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2.setBounds(63, 127, 70, 19);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Gi\u00E1:");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_3.setBounds(97, 166, 23, 19);
		contentPane.add(lblNewLabel_1_3);
		
		numsoluong = new JSpinner();
		numsoluong.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
		numsoluong.setBounds(125, 127, 107, 22);
		contentPane.add(numsoluong);
		
		numgia = new JSpinner();
		numgia.setModel(new SpinnerNumberModel(Double.valueOf(0), Double.valueOf(0), null, Double.valueOf(1)));
		numgia.setBounds(125, 166, 107, 22);
		contentPane.add(numgia);
		
		JButton btnRemoveMathang = new JButton("X\u00F3a");
		btnRemoveMathang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String mahang = txtmahang.getText();
					UpdateMatHang(mhbo.getDs());
					mhbo.Xoamathang(mahang);
					JOptionPane.showMessageDialog(null, "Xóa mặt hàng thành công !!!");
					UpdateMatHang(mhbo.getDs());
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
				
			}
		});
		btnRemoveMathang.setBounds(135, 221, 112, 38);
		contentPane.add(btnRemoveMathang);
		
		JButton btnAddMathang = new JButton("Th\u00EAm");
		btnAddMathang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String mahang = txtmahang.getText();
					String tenhang = txtmahang.getText();
					Date ngaynhaphang = sdf.parse(txtngaynhaphang.getText());
					if(!Validate.isDate(txtngaynhaphang.getText()))
					{
						JOptionPane.showMessageDialog(null, "Thời gian nhập hàng không hợp lệ, vui lòng kiểm tra lại !!!");
						return;
					}
					int soluong = Integer.parseInt(numsoluong.getValue().toString());
					double gia = Double.parseDouble(numgia.getValue().toString());
					mhbo.Themmathang(mahang, tenhang, ngaynhaphang, soluong, gia);
					UpdateMatHang(mhbo.getDs());
					JOptionPane.showMessageDialog(null, "Thêm mặt hàng thành công !!!");
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
				
			}
		});
		btnAddMathang.setBounds(11, 221, 112, 38);
		contentPane.add(btnAddMathang);
		
		JButton btnEditMathang = new JButton("S\u1EEDa");
		btnEditMathang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String mahang = txtmahang.getText();
					String tenhang = txtmahang.getText();
					Date ngaynhaphang = sdf.parse(txtngaynhaphang.getText());
					if(!Validate.isDate(txtngaynhaphang.getText()))
					{
						JOptionPane.showMessageDialog(null, "Thời gian nhập hàng không hợp lệ, vui lòng kiểm tra lại !!!");
						return;
					}
					int soluong = Integer.parseInt(numsoluong.getValue().toString());
					double gia = Double.parseDouble(numgia.getValue().toString());
					mhbo.Chinhsuamathang(mahang, tenhang, ngaynhaphang, soluong, gia);
					UpdateMatHang(mhbo.getDs());
					JOptionPane.showMessageDialog(null, "Sửa mặt hàng thành công !!");
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
				
			}
		});
		btnEditMathang.setBounds(11, 270, 112, 38);
		contentPane.add(btnEditMathang);
		
		JButton btnFindMathang = new JButton("T\u00ECm ki\u1EBFm");
		btnFindMathang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String namesearch = JOptionPane.showInputDialog("Nhập tên mà bạn cần tìm kiếm");
					if(namesearch == null || namesearch.equals(""))
					{
						JOptionPane.showMessageDialog(null, "Vui lòng không bỏ trống tên tìm kiếm !!");
						UpdateMatHang(mhbo.getDs());
						return;
					}
					
					UpdateMatHang(mhbo.Timkiem(namesearch));
					JOptionPane.showMessageDialog(null, "Tìm kiểm thành công !!");
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
				
			}
		});
		btnFindMathang.setBounds(135, 270, 112, 38);
		contentPane.add(btnFindMathang);
		
		JButton btnCreateData = new JButton("Nh\u1EADp data t\u1EEB file");
		btnCreateData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String namefile = JOptionPane.showInputDialog("Nhập tên file bạn muốn đưa vào database: ");
					if(namefile == null || namefile.equals(""))
					{
						JOptionPane.showMessageDialog(null, "Vui lòng không bỏ trống nhập file !!");
						return;
					}
					mhbo.LoadDataFile(namefile);
					UpdateMatHang(mhbo.getDs());
					JOptionPane.showMessageDialog(null, "Đưa dữ liệu vào database thành công");
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
				
			}
		});
		btnCreateData.setBounds(11, 319, 236, 38);
		contentPane.add(btnCreateData);
	}
}
