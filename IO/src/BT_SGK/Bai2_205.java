package BT_SGK;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class Bai2_205 extends JFrame {

	private JPanel contentPane;
	private JTextField txtTen;
	private JTextField txtNgaySinh;
	private JTextField txtEmail;
	private JTextField txtSDT;
	
	FileWriter fw;
	PrintWriter pw;
	Vector list = new Vector();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bai2_205 frame = new Bai2_205();
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
	public void updateList(String hoTen, String ngaySinh, String email, String dienThoai)
	{
		ThongTin st = new ThongTin(hoTen, ngaySinh, email, dienThoai);
		list.add(st);
	}
	
	public void saveFiles()
	{
		try {
			fw = new FileWriter("./src/BT_SGK/bai2.txt", false);
			pw = new PrintWriter(fw);
			Enumeration vEnum = list.elements();
			while(vEnum.hasMoreElements()) {
				ThongTin st = (ThongTin)vEnum.nextElement();
			String ghiFile = st.getHoTen()+" & "+st.getNgaySinh()+" & "+st.getEmail()
							+" & "+st.getDienThoai();
			pw.println(ghiFile);
			pw.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void loadData()
	{
		FileReader fr;
		try {
			fr = new FileReader("./src/BT_SGK/bai2.txt");
			BufferedReader br = new BufferedReader(fr);
			String s;
			while((s = br.readLine())!=null)
			{
				String[] data = s.split(" & ");
				ThongTin st = new ThongTin(data[0], data[1], data[2], data[3]);
				list.add(st);
				txtTen.setText(data[0]);
				txtNgaySinh.setText(data[1]);
				txtEmail.setText(data[2]);
				txtSDT.setText(data[3]);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public Bai2_205() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 390, 220);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTen = new JLabel("Họ tên");
		lblTen.setBounds(10, 11, 61, 14);
		contentPane.add(lblTen);
		
		JLabel lblNgaySinh = new JLabel("Ngày sinh");
		lblNgaySinh.setBounds(10, 42, 61, 14);
		contentPane.add(lblNgaySinh);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(10, 73, 86, 14);
		contentPane.add(lblEmail);
		
		JLabel lblSDT = new JLabel("SĐT");
		lblSDT.setBounds(10, 105, 86, 14);
		contentPane.add(lblSDT);
		
		txtTen = new JTextField();
		txtTen.setBounds(81, 8, 265, 20);
		contentPane.add(txtTen);
		txtTen.setColumns(10);
		
		txtNgaySinh = new JTextField();
		txtNgaySinh.setBounds(81, 39, 265, 20);
		contentPane.add(txtNgaySinh);
		txtNgaySinh.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(81, 70, 265, 20);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		txtSDT = new JTextField();
		txtSDT.setBounds(81, 102, 265, 20);
		contentPane.add(txtSDT);
		txtSDT.setColumns(10);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				updateList(txtTen.getText(), txtNgaySinh.getText(), txtEmail.getText(), txtSDT.getText());
				saveFiles();
			}
		});
		btnSave.setBounds(107, 148, 89, 23);
		contentPane.add(btnSave);
		loadData();
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnCancel.setBounds(206, 148, 89, 23);
		contentPane.add(btnCancel);
	}
}
