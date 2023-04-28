package models;

public class TaiKhoan {
    private String tenDangNhap;
    private String matKhau;
    int money;
    Player player;

    public TaiKhoan(String tenDangNhap, String matKhau) {
        this.tenDangNhap = tenDangNhap;
        this.matKhau = matKhau;
        this.money=50000;
    }

    public boolean dangNhap(String tenDangNhap, String matKhau) {
        return this.tenDangNhap.equals(tenDangNhap) && this.matKhau.equals(matKhau);
    }
    public void setPlayer(Player player) {
    	this.player=player;
    }
    public String getName() {
    	return tenDangNhap;
    }
    public int getMoney() {
    	return money;
    }

	@Override
	public String toString() {
		return "TaiKhoan [tenDangNhap=" + tenDangNhap + ", matKhau=" + matKhau + ", money=" + money + ", player="
				+ player + "]";
	}
    
}
