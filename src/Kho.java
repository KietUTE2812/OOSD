import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Kho {
    private String maSP;
    private int soLuongSanPham;

    public int getSoLuongSanPham() {
        return soLuongSanPham;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getMaSanPham() {
        return maSP;
    }



    public Kho(String maSP, int soLuongSanPham) {
        this.maSP = maSP;
        this.soLuongSanPham = soLuongSanPham;
    }



    public void setSoLuongSanPham(int soLuongSanPham) {
        this.soLuongSanPham = soLuongSanPham;
    }

    private Map<SanPham, Integer> danhSachSanPham;

    public Kho() {
        danhSachSanPham = new HashMap<>();
    }

    public Map<SanPham, Integer> getDanhSachSanPham() {
        return danhSachSanPham;
    }

    public void setDanhSachSanPham(Map<SanPham, Integer> danhSachSanPham) {
        this.danhSachSanPham = danhSachSanPham;
    }
    public void themSanPham(SanPham sanPham, int soLuong) {
        danhSachSanPham.put(sanPham, soLuong);
    }

    public void hienThiDanhSachSanPham() {
        System.out.println("Danh sách sản phẩm trong kho:");
        for (Map.Entry<SanPham, Integer> entry : danhSachSanPham.entrySet()) {
            SanPham sanPham = entry.getKey();
            int soLuong = entry.getValue();
            System.out.println("Mã sản phẩm: " + sanPham.getMaSP() +
                    ", Tên sản phẩm: " + sanPham.getTenSP() +
                    ", Giá sản phẩm: " + sanPham.getGiaSP() +
                    ", Số lượng: " + soLuong);
        }
    }

}
