import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class DonHang {
    private String maDH;
    private LocalDate ngayDH;
    private boolean trangThai;
    private List<SanPhamTrongGioHang> danhSachSP = new ArrayList();
    private double tongTien;
    private String maThanhToan;

    public double tinhTongTien()
    {
        double tongTien = 0;
        for(SanPhamTrongGioHang sp : danhSachSP)
        {
            tongTien += sp.getSoLuong()*sp.getGiaSP();
        }
        return tongTien;
    }
    public void generateMaDH() {
        String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        maDH = "MaDH" + timeStamp;
    }
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
        this.tongTien = tinhTongTien();
        return tongTien;
    }



    public String getMaThanhToan() {
        return maThanhToan;
    }



    public DonHang() {
        generateMaDH();
    }





    public static String convertDay(LocalDate ngay) {
        // Định dạng ngày
        DateTimeFormatter dinhDang = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        // Chuyển đổi LocalDate thành chuỗi
        String ngayThangNam = ngay.format(dinhDang);
        return ngayThangNam;
    }

}
