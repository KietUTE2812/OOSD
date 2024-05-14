import java.util.ArrayList;
import java.util.List;

public class GioHang {
    private String maGioHang;
    private List<SanPhamTrongGioHang> danhSachSP;
    private double tongTien;
    private String maKH;


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

    public void xemSanPhamGioHang() {
        if (danhSachSP.isEmpty()) {
            System.out.println("Giỏ hàng trống.");
        } else {
            System.out.println("Danh sách sản phẩm trong giỏ hàng:");
            for (SanPhamTrongGioHang item : danhSachSP) {
                System.out.println(item.getMaSP() + " - " + item.getTenSP() + " - Giá: " + item.getGiaSP() + " - Số lượng: " + item.getSoLuong());
            }
        }
    }

    public void xoaSanPham(String maSanPham) {
        boolean found = false;
        for (SanPhamTrongGioHang sp : danhSachSP) {
            if (sp.getMaSP().equals(maSanPham)) {
                danhSachSP.remove(sp);
                found = true;
                System.out.println("Xóa sản phẩm thành công trong giỏ hàng.");
                break;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy sản phẩm có mã " + maSanPham + " trong giỏ hàng.");
        }
    }


    public void themSP(SanPhamTrongGioHang sp) {
        danhSachSP.add(sp);
    }
}
