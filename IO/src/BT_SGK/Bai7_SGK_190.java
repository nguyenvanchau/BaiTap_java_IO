package BT_SGK;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Bai7_SGK_190 extends JFrame implements ActionListener {
	
	//tạo thành phần trên giao diện
	JTextArea ta = new JTextArea();
	JButton saveAs = new JButton("Save as... ");
	//sd lớp JfileChooser để hiển thị hộp thoại lưu tệp tin
	JFileChooser chooser;
	//sd lớp JfileWriter để ghi nội dung xuống tệp
	FileWriter f;
	
	public Bai7_SGK_190() {
		//tạo dao diện nút Open ,Save as và TextArea
		Container cont = this.getContentPane();
		saveAs.addActionListener(this);
		cont.add(ta);
		cont.add(saveAs, "South");
		this.setSize(400, 400);
		this.setVisible(true);
	}
	@Override
	//hàm này thực thi khi nhấn nút Save as
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//tạo đối tượng JfileChooser để mở hộp thoại ghi tệp 
		chooser = new JFileChooser();
		//thư mục hiện hành được mở 
		chooser.setCurrentDirectory(new java.io.File("."));
		//tiêu đề của hộp thoại
		chooser.setDialogTitle("Save as...");
		if(chooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
			//lấy tên tệp đã đặt hoặc chọn
			String filename = chooser.getSelectedFile().getAbsolutePath();
			saveFile(filename);
		}
	}
	//hàm đọc nội dung từ TextArea rồi ghi xuống tệp tin
	private void saveFile(String filename) {
		// TODO Auto-generated method stub
		try {
			String content = ta.getText();
			f = new FileWriter(filename);
			f.write(content);
			f.flush();
			f.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	public static void main(String[] a) {
		new Bai7_SGK_190();
	}

}
