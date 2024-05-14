public class SanPhamTrongGioHang {
    private String maSP;
    private String tenSP;
    private double giaSP;
    private int soLuong;

    public SanPhamTrongGioHang() {}
    public void capNhatGia(int phanTramGiam){
        giaSP -= giaSP*phanTramGiam;
    }

    public SanPhamTrongGioHang(String maSP, String tenSP, double giaSP, int soLuong) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.giaSP = giaSP;
        this.soLuong = soLuong;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public double getGiaSP() {
        return giaSP;
    }

    public void setGiaSP(double giaSP) {
        this.giaSP = giaSP;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }



}
