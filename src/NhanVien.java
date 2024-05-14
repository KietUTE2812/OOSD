public class NhanVien {
    private String maNV;
    private String hoVaTen;
    private String sDT;
    private String email;
    private String diaChi;
    private byte quyenTruyCap;
    private String taiKhoan;
    private String matKhau;
    public NhanVien(String maNV, String hoVaTen, String sDT, String email, String diaChi, byte quyenTruyCap, String taiKhoan, String matKhau) {
        this.maNV = maNV;
        this.hoVaTen = hoVaTen;
        this.sDT = sDT;
        this.email = email;
        this.diaChi = diaChi;
        this.quyenTruyCap = quyenTruyCap;
        this.taiKhoan = taiKhoan;
        this.matKhau = matKhau;
    }

    public String getMaNV() {
        return maNV;
    }
    public String getHoVaTen() {
        return hoVaTen;
    }
    public void setHoVaTen(String hoVaTen) {
        this.hoVaTen = hoVaTen;
    }
    public String getsDT() {
        return sDT;
    }
    public void setsDT(String sDT) {
        this.sDT = sDT;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getDiaChi() {
        return diaChi;
    }
    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
    public byte getQuyenTruyCap() {
        return quyenTruyCap;
    }
    public void setQuyenTruyCap(byte quyenTruyCap) {
        this.quyenTruyCap = quyenTruyCap;
    }
    public String getTaiKhoan() {
        return taiKhoan;
    }
    public String getMatKhau() {
        return matKhau;
    }
    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }
    @Override
    public String toString() {
        return "NhanVien{" +
                "maNV='" + maNV + '\'' +
                ", hoVaTen='" + hoVaTen + '\'' +
                ", sDT='" + sDT + '\'' +
                ", email='" + email + '\'' +
                ", diaChi='" + diaChi + '\'' +
                ", quyenTruyCap=" + quyenTruyCap +
                ", taiKhoan='" + taiKhoan + '\'' +
                ", matKhau='" + matKhau + '\'' +
                '}';
    }
}
