import java.time.LocalDate;

public class PhieuGiamGia {
    private String maPhieu;
    private String maSanPham;
    private int phanTramGiam;
    private LocalDate ngayBatDau;
    private LocalDate ngayKetThuc;
    private int soLuongPhieu;



    public String getMaPhieu() {
        return maPhieu;
    }

    public void setMaPhieu(String maPhieu) {
        this.maPhieu = maPhieu;
    }

    public String getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(String maSanPham) {
        this.maSanPham = maSanPham;
    }

    public int getPhanTramGiam() {
        return phanTramGiam;
    }

    public void setPhanTramGiam(int phanTramGiam) {
        this.phanTramGiam = phanTramGiam;
    }

    public LocalDate getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(LocalDate ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public LocalDate getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(LocalDate ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    public int getSoLuongPhieu() {
        return soLuongPhieu;
    }

    public void setSoLuongPhieu(int soLuongPhieu) {
        this.soLuongPhieu = soLuongPhieu;
    }

    public PhieuGiamGia(String maPhieu, String maSanPham, int phanTramGiam, int soLuongPhieu) {
        this.maPhieu = maPhieu;
        this.maSanPham = maSanPham;
        this.phanTramGiam = phanTramGiam;
        this.soLuongPhieu = soLuongPhieu;
    }
}
