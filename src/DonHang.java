import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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

    private String maKH;

    @Override
    public String toString() {
        String tt = "Đã Thanh Toán";
        if (!trangThai  ) tt = "Chưa Thanh Toán";
        String ngayDathang = convertDay(ngayDH);
        return "DonHang: " +
                "Mã đơn hàng: " + maDH + '\'' +
                ", Ngày đặt hàng: " + ngayDathang +
                ", Trạng thái: " + tt +
                ", Tổng tiền: " + tongTien + "VNĐ" +
                ", Mã thanh toán: " + maThanhToan + '\'' +
                '}';
    }



    public DonHang(String maDH, LocalDate ngayDH, boolean trangThai, List<SanPhamTrongGioHang> danhSachSP, double tongTien, String maThanhToan) {
        this.maDH = maDH;
        this.ngayDH = ngayDH;
        this.trangThai = trangThai;
        this.danhSachSP = danhSachSP;
        this.tongTien = tongTien;
        this.maThanhToan = maThanhToan;
    }

    public DonHang(String maDH, LocalDate ngayDH, boolean trangThai, List<SanPhamTrongGioHang> danhSachSP, double tongTien, String maThanhToan, String maKH) {
        this.maDH = maDH;
        this.ngayDH = ngayDH;
        this.trangThai = trangThai;
        this.danhSachSP = danhSachSP;
        this.tongTien = tongTien;
        this.maThanhToan = maThanhToan;
        this.maKH = maKH;
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



    public LocalDate getNgayDH() {
        return ngayDH;
    }



    public boolean isTrangThai() {
        return trangThai;
    }



    public List<SanPhamTrongGioHang> getDanhSachSP() {
        return danhSachSP;
    }



    public double getTongTien() {
        return tongTien;
    }



    public String getMaThanhToan() {
        return maThanhToan;
    }



    public DonHang() {
    }





    public static String convertDay(LocalDate ngay) {
        // Định dạng ngày
        DateTimeFormatter dinhDang = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        // Chuyển đổi LocalDate thành chuỗi
        String ngayThangNam = ngay.format(dinhDang);
        return ngayThangNam;
    }
}
