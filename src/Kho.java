import java.util.ArrayList;
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

    public Kho() {
    }

    public Kho(String maSP, int soLuongSanPham) {
        this.maSP = maSP;
        this.soLuongSanPham = soLuongSanPham;
    }



    public void setSoLuongSanPham(int soLuongSanPham) {
        this.soLuongSanPham = soLuongSanPham;
    }





}
