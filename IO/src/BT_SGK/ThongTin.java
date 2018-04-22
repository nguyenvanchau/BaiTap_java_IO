package BT_SGK;

public class ThongTin {
	private String hoTen;
	private String ngaySinh;
	private String email;
	private String dienThoai;
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public String getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(String ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDienThoai() {
		return dienThoai;
	}
	public void setDienThoai(String dienThoai) {
		this.dienThoai = dienThoai;
	}
	public ThongTin(String hoTen, String ngaySinh, String email, String dienThoai) {
		super();
		this.hoTen = hoTen;
		this.ngaySinh = ngaySinh;
		this.email = email;
		this.dienThoai = dienThoai;
	}
	public ThongTin() {
		hoTen = new String("");
		ngaySinh = new String("");
		email= new String("");
		dienThoai= new String("");
	}
	
}
