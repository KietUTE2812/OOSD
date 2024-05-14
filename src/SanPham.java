import java.text.DecimalFormat;

public class SanPham {
    private String maSP;
    private String tenSP;
    private double giaSP;

    public SanPham(String maSP, String tenSP, double giaSP) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.giaSP = giaSP;
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

    @Override
    public String toString() {
        return "Mã sản phẩm: " + maSP + ", Tên sản phẩm: " + tenSP + ", Giá sản phẩm: " + chuyenDoiGiaTien(giaSP) + "VNĐ ";
    }

    public static String chuyenDoiGiaTien(double gia) {
        // Định dạng số tiền
        DecimalFormat dinhDang = new DecimalFormat("#,###");
        return dinhDang.format(gia).replaceAll(",", "."); // Thay dấu phân cách hàng nghìn bằng dấu chấm
    }
}
