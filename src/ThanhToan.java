import java.text.SimpleDateFormat;
import java.util.Date;

public class ThanhToan {
    private String maThanhToan;
    private int phuongThucThanhToan;
    private String diaChiNhanHang;
    private double tongTienThanhToan;
    private String maKH;
    private String maDH;

    public ThanhToan() {
        generateMaTT();
    }

    @Override
    public String toString() {
        return "ThanhToan{" +
                "maThanhToan='" + maThanhToan + '\'' +
                ", phuongThucThanhToan=" + phuongThucThanhToan +
                ", diaChiNhanHang='" + diaChiNhanHang + '\'' +
                ", tongTienThanhToan=" + tongTienThanhToan +
                ", maKH='" + maKH + '\'' +
                ", maDH='" + maDH + '\'' +
                '}';
    }

    public String getMaThanhToan() {
        return maThanhToan;
    }

    public void setMaThanhToan(String maThanhToan) {
        this.maThanhToan = maThanhToan;
    }

    public int getPhuongThucThanhToan() {
        return phuongThucThanhToan;
    }

    public void setPhuongThucThanhToan(int phuongThucThanhToan) {
        this.phuongThucThanhToan = phuongThucThanhToan;
    }

    public String getDiaChiNhanHang() {
        return diaChiNhanHang;
    }

    public void setDiaChiNhanHang(String diaChiNhanHang) {
        this.diaChiNhanHang = diaChiNhanHang;
    }

    public double getTongTienThanhToan() {
        return tongTienThanhToan;
    }

    public void setTongTienThanhToan(double tongTienThanhToan) {
        this.tongTienThanhToan = tongTienThanhToan;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getMaDH() {
        return maDH;
    }
    public void setMaDH(String maDH) {
        this.maDH = maDH;
    }

    public void generateMaTT() {
        String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        maDH = "MaTT" + timeStamp;
    }
}
