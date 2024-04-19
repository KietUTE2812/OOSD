import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DonHang {
    private String maDH;
    private LocalDate ngayDH;
    private boolean trangThai;
    private List<SanPhamTrongGioHang> danhSachSP = new ArrayList();
    private double tongTien;
    private String maThanhToan;

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

}
