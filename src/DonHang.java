import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DonHang {
    private String maDH;
    private LocalDate ngayDH;
    private boolean trangThai;
    private List<SanPhamTrongGioHang> danhSachSP = new ArrayList();
    private double tongTien;
    private String maThanhToan;

    public DonHang(String maDH, LocalDate ngayDH, boolean trangThai, List<SanPhamTrongGioHang> danhSachSP, double tongTien, String maThanhToan) {
        this.maDH = maDH;
        this.ngayDH = ngayDH;
        this.trangThai = trangThai;
        this.danhSachSP = danhSachSP;
        this.tongTien = tongTien;
        this.maThanhToan = maThanhToan;
    }

    public void add(SanPhamTrongGioHang s) {
        danhSachSP.add(s);
    }
    public List<SanPhamTrongGioHang> getItems(){
        return danhSachSP;
    }
    public void thayDoiSoLuong(String maSP, int soLuong)
    {

    }

    public String getMaDH() {
        return maDH;
    }

    public void setMaDH(String maDH) {
        this.maDH = maDH;
    }

    public LocalDate getNgayDH() {
        return ngayDH;
    }

    public void setNgayDH(LocalDate ngayDH) {
        this.ngayDH = ngayDH;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
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

    public String getMaThanhToan() {
        return maThanhToan;
    }

    public void setMaThanhToan(String maThanhToan) {
        this.maThanhToan = maThanhToan;
    }

    public DonHang() {
    }
    public DonHang(String maDH, LocalDate ngayDH) {}


    //--------------------------------------------------------
    public static List<DonHang> hienThiDanhSachDonHang() {
        List<DonHang> danhSachDonHang = new ArrayList<>();
        // Thêm các đơn hàng mẫu vào danh sách
        danhSachDonHang.add(new DonHang("DH001", LocalDate.of(2024, 4, 12), true, new ArrayList<>(), 250.0, "TT001"));
        danhSachDonHang.add(new DonHang("DH002", LocalDate.of(2024, 4, 13), false, new ArrayList<>(), 300.0, "TT002"));
        danhSachDonHang.add(new DonHang("DH003", LocalDate.of(2024, 4, 14), true, new ArrayList<>(), 400.0, "TT003"));
        return danhSachDonHang;
    }

    public static DonHang getDonHanginListDonHang(String maDonHang, List<DonHang> danhSachDonHang) {
        for (DonHang donHang : danhSachDonHang) {
            if (donHang.getMaDH().equals(maDonHang)) {
                return donHang;
            }
        }

        return null;
    }

    public static void xemChiTietDonHang()
    {
        Scanner scanner = new Scanner(System.in);
        List<DonHang> danhSachDonHang = hienThiDanhSachDonHang();

        // Nhập mã đơn hàng từ người dùng
        System.out.print("Nhập mã đơn hàng để xem chi tiết: ");
        String maDonHang = scanner.nextLine();
        DonHang donHang = DonHang.getDonHanginListDonHang(maDonHang, danhSachDonHang);
        if (donHang == null) {
            System.out.println("Không tìm thấy đơn hàng với mã " + maDonHang);
            return;
        } else {
            // In ra chi tiết đơn hàng
            System.out.println("Chi tiết đơn hàng:");
            System.out.println("Mã đơn hàng: " + donHang.getMaDH());
            System.out.println("Ngày đặt hàng: " + donHang.getNgayDH());
            System.out.println("Trạng thái: " + (donHang.isTrangThai() ? "Đã hoàn thành" : "Chưa hoàn thành"));
            // In ra các sản phẩm trong đơn hàng
            System.out.println("Danh sách sản phẩm:");
            for (SanPhamTrongGioHang sp : donHang.getDanhSachSP()) {
                System.out.println("  - " + sp.getTenSP() + ": " + sp.getSoLuong() + " x " + sp.getGiaSP() + " đồng");
            }
            System.out.println("Tổng tiền: " + donHang.getTongTien() + " đồng");
            System.out.println("Mã thanh toán: " + donHang.getMaThanhToan());
            System.out.print("Nhập Enter để thoát: ");
            scanner.nextLine();
            return;
        }

    }
}
