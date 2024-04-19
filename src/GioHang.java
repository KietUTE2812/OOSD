import java.util.List;

public class GioHang {
    private String maGioHang;
    private List<SanPhamTrongGioHang> danhSachSP;
    private double tongTien;

    public GioHang() {}

    public GioHang(String maGioHang, List<SanPhamTrongGioHang> danhSachSP, double tongTien) {
        this.maGioHang = maGioHang;
        this.danhSachSP = danhSachSP;
        this.tongTien = tongTien;
    }

    public String getMaGioHang() {
        return maGioHang;
    }

    public void setMaGioHang(String maGioHang) {
        this.maGioHang = maGioHang;
    }

    public List<SanPhamTrongGioHang> getDanhSachSP() {
        return danhSachSP;
    }

    public void setDanhSachSP(List<SanPhamTrongGioHang> danhSachSP) {
        this.danhSachSP = danhSachSP;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }
    public void displayCart() {
        System.out.println("Danh sách sản phẩm trong giỏ hàng:");
        for (SanPhamTrongGioHang item : danhSachSP) {
            System.out.println(item.getMaSP() + " - " + item.getTenSP() + " - Giá: " + item.getGiaSP() + " - Số lượng: " + item.getSoLuong());
        }
        System.out.println("Menu giỏ hàng:");
        // Thêm các chức năng menu giỏ hàng ở đây
    }

    public void xoaSanPham(String maSanPham) {
        // Kiểm tra nếu danh sách sản phẩm không null
        if (danhSachSP != null) {
            // Duyệt qua danh sách sản phẩm
            for (SanPhamTrongGioHang sp : danhSachSP) {
                // Nếu tìm thấy sản phẩm có mã trùng khớp
                if (sp.getMaSP().equals(maSanPham)) {
                    danhSachSP.remove(sp); // Xóa sản phẩm khỏi danh sách
                    break; // Kết thúc vòng lặp sau khi xóa sản phẩm
                }
            }
        }
        // Nếu không tìm thấy sản phẩm có mã trùng khớp hoặc danh sách sản phẩm null, không thực hiện gì cả
    }


}
