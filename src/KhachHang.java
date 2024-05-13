public class KhachHang {
    private String maKH;
    private String hoVaTen;
    private String sDT;
    private String email;
    private String diaChi;
    private String taiKhoan;
    private String matKhau;



    public KhachHang(String maKH, String hoVaTen, String sDT, String email, String diaChi, String taiKhoan, String matKhau) {
        this.maKH = maKH;
        this.hoVaTen = hoVaTen;
        this.sDT = sDT;
        this.email = email;
        this.diaChi = diaChi;
        this.taiKhoan = taiKhoan;
        this.matKhau = matKhau;
    }

    public KhachHang(String taiKhoan, String matKhau) {
        this.taiKhoan = taiKhoan;
        this.matKhau = matKhau;
    }

    public KhachHang() {
    }

    public String getMaKH() {
        return maKH;
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

    public String getTaiKhoan() {
        return taiKhoan;
    }
    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }


}
