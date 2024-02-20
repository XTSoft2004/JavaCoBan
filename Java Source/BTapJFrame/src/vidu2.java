import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class vidu2 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vidu2 frame = new vidu2();
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
	public vidu2() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				//Tao ra mo hinh bang
				DefaultTableModel mh = new DefaultTableModel();
				//them cot
				mh.addColumn("Masv");
				mh.addColumn("Hoten");
				mh.addColumn("Khoa");
				mh.addColumn("Dtb");
				for(int i = 0;i < 100;i++) {
					// Them 1 dong
					Object[] t = new Object[4];
					t[0] = "Sv1";
					t[1] = "Le Van Nam";
					t[2] = "K46";
					t[3] = 8.5;
					mh.addRow(t);
				}	
				// dua mo hinh vao bang
				table.setModel(mh);
				
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 695, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 659, 389);
		contentPane.add(tabbedPane);
		
		JScrollPane scrollPane = new JScrollPane();
		tabbedPane.addTab("Thuan map", null, scrollPane, null);
		
		table = new JTable();
		scrollPane.setViewportView(table);
	}
}
