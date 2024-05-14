import java.util.ArrayList;
import java.util.List;

public class GioHang {
    private String maGioHang;
    private List<SanPhamTrongGioHang> danhSachSP;
    private double tongTien;
    private String maKH;
    public void hienGioHang()
    {
        for(SanPhamTrongGioHang sanPhamTrongGioHang : danhSachSP)
        {
            System.out.println(sanPhamTrongGioHang.toString());
        }
    }
    public void setMaGioHang(String maGioHang) {
        this.maGioHang = maGioHang;
    }
    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }
    public GioHang() {
        this.danhSachSP = new ArrayList<>();
    }
    public List<SanPhamTrongGioHang> getDanhSachSP() {
        return danhSachSP;
    }
    public void setDanhSachSP(List<SanPhamTrongGioHang> danhSachSP) {
        this.danhSachSP = danhSachSP;
    }
    public void xemSanPhanGioHang() {
        System.out.println("Danh sách sản phẩm trong giỏ hàng:");
        for (SanPhamTrongGioHang item : danhSachSP) {
            System.out.println(item.getMaSP() + " - " + item.getTenSP() + " - Giá: " + item.getGiaSP() + " - Số lượng: " + item.getSoLuong());
        }
        System.out.println("Menu giỏ hàng:");
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
    }
    public void themSP(SanPhamTrongGioHang sp) {
        danhSachSP.add(sp);
    }
}
