import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.util.Map;

public class HeThong {

    private static ArrayList<SanPham> sanPhams = new ArrayList<>();
    private static SanPham sp1 = new SanPham("SP001", "Laptop Dell", 18000000.0);
    private static SanPham sp2 = new SanPham("SP002", "Laptop Asus", 15000000.0);
    private static SanPham sp3 = new SanPham("SP003", "Laptop Lenovo", 200000000.0);
    private static SanPham sp4 = new SanPham("SP004", "Laptop Macbook", 300000000.0);
    private List<SanPham> dsSPDangCo = new ArrayList<>();
    private GioHang gioHang = new GioHang();
    private static ArrayList<Kho> khos = new ArrayList<>();
    private Kho kho = new Kho();
    private static   Kho k1 = new Kho("SP001", 20);
    private static   Kho k2 = new Kho("SP002", 40);
    private static   Kho k3 = new Kho("SP003", 10);
    private static   Kho k4 = new Kho("SP004", 15);

    public HeThong(){

        Scanner scanner = new Scanner(System.in);
        KhachHang khachHang=new KhachHang(UserSession.getInstance().getMaKH(), UserSession.getInstance().getHoVaTen(),UserSession.getInstance().getsDT(), UserSession.getInstance().getDiaChi(), UserSession.getInstance().getDiaChi(), UserSession.getInstance().getTaiKhoan(), UserSession.getInstance().getMatKhau());
        kho.themSanPham(sp1, 20);
        kho.themSanPham(sp2, 20);
        kho.themSanPham(sp3, 20);
        dsSPDangCo.add(sp1);
        dsSPDangCo.add(sp2);
        dsSPDangCo.add(sp3);
        dsSPDangCo.add(sp4);

        gioHang.setMaKH(UserSession.getInstance().getUsername());


        GioHang gioHang =new GioHang();
        List<SanPhamTrongGioHang> danhSachSP = new ArrayList<>();
        danhSachSP.add(new SanPhamTrongGioHang("SP001", "Áo thun", 15.0, 2));
        danhSachSP.add(new SanPhamTrongGioHang("SP002", "Quần jean", 25.0, 1));
        gioHang.setDanhSachSP(danhSachSP); // Gán danh sách sản phẩm cho giỏ hàng
        gioHang.setMaKH("12");
        gioHang.setMaGioHang("ma12");




        // Menu hiển thị các chức năng
        System.out.println("Menu:");
        System.out.println("1. Xem sản phẩm");
        System.out.println("2. Xem giỏ hàng");
        System.out.println("3. Xem danh sách đơn hàng");
        System.out.println("4. Chỉnh sửa tài khoản");
        System.out.println("5. Đăng xuất");
        System.out.println("0. Thoát");

        // Lặp cho đến khi người dùng chọn chức năng Thoát
        while (true) {
            System.out.print("Chọn chức năng: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Đọc ký tự xuống dòng

            switch (choice) {
                case 1:
                    xemSanPham(scanner, kho);
                    break;
                case 2:
                    menuGioHang(scanner, gioHang);
                    break;
                case 3:
                    hienThiDanhSachDonHang( scanner);
                    break;
                case 4:
                    capNhatThongTinTaiKhoan(khachHang);
                    break;
                case 5:
                    datHang(scanner);
                    break;
                case 6:
                    datHang(scanner);
                    break;
                case 0:
                    System.out.println("Thoát chương trình.");
                    return;
                default:
                    System.out.println("Chức năng không hợp lệ.");
            }
        }
    }

    public HeThong(List<NhanVien> nhanVienList) {
        Scanner scanner = new Scanner(System.in);
        NhanVien nhanVien=new NhanVien(UserSession.getInstance().getMaNV(),
                UserSession.getInstance().getHoVaTen(),
                UserSession.getInstance().getsDT(),
                UserSession.getInstance().getEmail(),
                UserSession.getInstance().getDiaChi(),
                (byte)UserSession.getInstance().getRole(),
                UserSession.getInstance().getTaiKhoan(),
                UserSession.getInstance().getMatKhau());
        kho.themSanPham(sp1,12);
        kho.themSanPham(sp2,20);
        kho.themSanPham(sp3,25);
        kho.themSanPham(sp4,30);
        // Hiển thị menu cho người dùng
        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Xem sản phẩm");
            System.out.println("2. Cập nhật sản phẩm");
            System.out.println("3. Thêm sản phẩm vào kho");
            System.out.println("4. Chỉnh sửa tài khoản");
            System.out.println("5. Cấp quyền truy cập");
            System.out.println("6. Đăng xuất");
            System.out.println("0. Thoát");
            // Yêu cầu người dùng chọn chức năng
            int choice;
            do {
                System.out.print("Nhập số để chọn chức năng : ");
                while (!scanner.hasNextInt()) {
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập lại.");
                    scanner.next();
                }
                choice = scanner.nextInt();
                scanner.nextLine(); // Đọc ký tự thừa sau khi nhập số
            } while (choice < 0 || choice > 6);
            // Xử lý chọn chức năng
            switch (choice) {
                case 1:
                    xemDanhSachSanPham(scanner);
                    break;
                case 2:
                    capNhatSanPham();
                    break;
                case 3:
                    themSanPhamVaoKho(scanner);
                    break;
                case 4:
                    chinhsuaThongTinTaiKhoan(nhanVien);
                    break;
                case 5:
                    capQuyenTruyCap(nhanVienList);
                    break;
                case 6:
                    capNhatSanPham();
                    break;
                case 0:
                    System.out.println("Thoát chương trình.");
                    return;
                default:
                    System.out.println("Chức năng không hợp lệ.");
            }
        }
    }

    public void datHang(Scanner scanner) {
        // Bước 2: Nhập các mã sản phẩm cần mua  ||  nhapSP()
        System.out.println("Nhập các mã sản phẩm cần mua (cách nhau bằng dấu ','): ");
        String productsInput = scanner.nextLine();
        String[] productIds = productsInput.split(",");
        DonHang dh = new DonHang();

        // Bước 3: Kiểm tra và thêm sản phẩm vào đơn hàng || addToOrder();
        for (String productId : productIds) {

            SanPham product = findProductById(productId);
            if (product != null) {
                System.out.print("Nhập số lượng cho sản phẩm " + productId + ": ");
                int quantity = scanner.nextInt();
                scanner.nextLine(); // Đọc ký tự xuống dòng

                // Thêm sản phẩm vào đơn hàng
                SanPhamTrongGioHang cartItem = new SanPhamTrongGioHang(product.getMaSP(),product.getTenSP(),product.getGiaSP() , quantity);
                dh.add(cartItem);
            } else {
                System.out.println("Sản phẩm với mã " + productId + " không tồn tại.");
            }
        }



        // Bước 9: Hiển thị thông tin đơn hàng và yêu cầu xác nhận // displayOrder()
        System.out.println("Thông tin đơn hàng:");
        // Hiển thị thông tin giỏ hàng
        for (SanPhamTrongGioHang item : dh.getItems()) {
            System.out.println("Sản phẩm: " + item.getTenSP() + ", Số lượng: " + item.getSoLuong());
        }

        // Bước 4: Hiển thị thông báo có muốn thay đổi số lượng hay không || changeQuantity();
        System.out.print("Có muốn thay đổi số lượng sản phẩm (Y/N)? ");
        String changeQuantity = scanner.nextLine();

        // Bước 5: Nếu muốn thay đổi số lượng, thực hiện bước 5 và 6
        if (changeQuantity.equalsIgnoreCase("Y")) {
            System.out.println("Nhập mã sản phẩm muốn thay đổi số lượng: ");
            String productIdToChange = scanner.nextLine();
            System.out.print("Nhập số lượng mới cho sản phẩm " + productIdToChange + ": ");
            int newQuantity = scanner.nextInt();
            scanner.nextLine(); // Đọc ký tự xuống dòng

            // Thay đổi số lượng sản phẩm trong giỏ hàng
            dh.thayDoiSoLuong(productIdToChange, newQuantity);
        }

        // Bước 7: Nhập mã giảm giá || applyDiscount();
        System.out.print("Nhập mã giảm giá (nhấn Enter để bỏ trống): ");
        String discountCode = scanner.nextLine();

        for(SanPhamTrongGioHang item: dh.getItems())
        {
            item.capNhatGia(findDiscountById(discountCode).getPhanTramGiam());
        }

        // Bước 9: Hiển thị thông tin đơn hàng và yêu cầu xác nhận || displayOrder();
        System.out.println("Thông tin đơn hàng:");
        // Hiển thị thông tin giỏ hàng
        for (SanPhamTrongGioHang item : dh.getItems()) {
            System.out.println("Sản phẩm: " + item.getTenSP() + ", Số lượng: " + item.getSoLuong());
        }

        //confirmOrder();
        System.out.print("Xác nhận đặt hàng (Y/N)? ");
        String confirm = scanner.nextLine();

        // Bước 10: Xác nhận đặt hàng
        if (confirm.equalsIgnoreCase("Y")) {
            // Bước 11: Hiển thị thông báo đặt hàng thành công và chuyển đến bước thanh toán
            System.out.println("Đặt hàng thành công!!! Vui lòng nhấn Enter để đến bước thanh toán");
            scanner.nextLine(); // Chờ người dùng nhấn Enter
            // Bước 13: Kết thúc chức năng đặt hàng
        } else {
            System.out.println("Đã hủy đặt hàng.");
            // Bước 13: Kết thúc chức năng đặt hàng
        }
    }
    private void thanhToan(Scanner scanner, DonHang dh) {
        ThanhToan thanhToan = new ThanhToan();
        thanhToan.setMaDH(dh.getMaDH());
        thanhToan.setMaKH(UserSession.getInstance().getUsername());
        thanhToan.setTongTienThanhToan(dh.getTongTien());
        System.out.println("Nhập địa chỉ thanh toán ");
        String diaChi = scanner.next();
        thanhToan.setDiaChiNhanHang(diaChi);
        System.out.println("Chọn phương thức thanh toán ");
        System.out.println("Chọn 1 với phương thức là Thanh toán khi nhận hàng ");
        System.out.println("Chọn 2 với phương thức là Thanh toán trực tuyến ");
        int pttt = scanner.nextInt();
        if (pttt == 1 || pttt == 2) {
            thanhToan.setPhuongThucThanhToan(pttt);
        }
        System.out.println("Thông tin thanh toán");
        System.out.println(thanhToan.toString());
        System.out.print("Xác nhận đơn hàng (Y/N)? ");
        String enter = scanner.next();
        if (enter.equalsIgnoreCase("Y")) {
            if(thanhToan.getPhuongThucThanhToan() == 1) {
                System.out.println("Vui long thanh toan khi nhan hang. Nhan enter de ve trang chu");
                scanner.nextLine();
            }else
            {
                System.out.println("Stk Momo Chủ Shop: 0926023955 ");
                System.out.println("Bạn hãy thực hiện thanh toán trên điện thoại, nhấn bất kì nút nào sau khi hoàn thành");
                scanner.next();
                scanner.nextLine();
                System.out.println("Thanh toán thành công");
            }
        }
        else {
            System.out.println("Thanh toán không thành công");
            return;
        }
    }
    // Hàm giả định để tìm kiếm sản phẩm theo mã sản phẩm
    private SanPham findProductById(String productId) {
        for(SanPham sp : dsSPDangCo)
        {
            if(sp.getMaSP().equals(productId))
                return sp;
        }
        return null;
    }
    private PhieuGiamGia findDiscountById(String discountId) {
        // Giả định rằng hàm này sẽ trả về sản phẩm từ cơ sở dữ liệu hoặc danh sách sản phẩm
        // Ở đây chỉ cần trả về một sản phẩm tạm thời để minh họa
        return new PhieuGiamGia(discountId, "SP001", 75, 500);
    }
    private void menuGioHang(Scanner scanner, GioHang gioHang){
        gioHang.hienGioHang();
        while (true) {
            System.out.println("--1. Đặt hàng");
            System.out.println("--2. Xóa sản phẩm");
            System.out.println("--3. Thoát");
            System.out.print("Chọn chức năng: ");
            int choice1 = scanner.nextInt();
            scanner.nextLine(); // Đọc ký tự xuống dòng

            switch (choice1) {
                case 1:
                    datHang(scanner);
                    break;
                case 2:
                    datHang(scanner);
                    break;
                case 3:
                    System.out.println("Thoát giỏ hàng.");
                    return;
                default:
                    System.out.println("Chức năng không hợp lệ.");
            }
        }
    }
    private void xemSanPham(Scanner scanner, Kho kho) {
        System.out.println("Sản phẩm: \n");
        for(SanPham sp : dsSPDangCo){
            System.out.println("Sản phẩm: " + sp.toString());
        }

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Đặt hàng");
            System.out.println("2. Thêm sản phẩm vào giỏ hàng");
            System.out.println("0. Thoát");
            System.out.print("Chọn chức năng: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Đọc ký tự xuống dòng

            switch (choice) {
                case 1:
                    datHang(scanner);
                    break;
                case 2:
                    themSanPhamVaoGioHang(scanner, gioHang);
                    break;

                case 0:
                    System.out.println("Thoát chương trình.");
                    return;
                default:
                    System.out.println("Chức năng không hợp lệ.");
            }
        }
    }
    private void themSanPhamVaoGioHang(Scanner scanner, GioHang gioHang) {
        System.out.println("Nhập mã sản phẩm cần thêm");
        String maSP = scanner.next();
        int SL = scanner.nextInt();
        for(SanPham sp : dsSPDangCo){
            if (sp.getMaSP().equals(maSP)){
                SanPhamTrongGioHang sPGH = new SanPhamTrongGioHang();
                sPGH.setMaSP(sp.getMaSP());
                sPGH.setGiaSP(sp.getGiaSP());
                sPGH.setTenSP(sp.getTenSP());
                sPGH.setSoLuong(SL);
                gioHang.themSP(sPGH);
            }
        }
        System.out.println("Thêm sản phẩm vào giỏ hàng thành công");
        for(SanPham sp : dsSPDangCo){
            System.out.println("Sản phẩm: " + sp.toString());
        }
    }
    public void xemSanPhamGioHang(Scanner scanner, GioHang cart) {

        // Kiểm tra nếu danh sách sản phẩm không null thì mới hiển thị giỏ hàng
        if (cart.getDanhSachSP() != null) {
            System.out.println("Bạn đang thực hiện chức năng xem giỏ hàng!!! Nhấn Enter để tiếp tục");
            scanner.nextLine(); // Đọc ký tự Enter còn lại
            // Thực hiện bước 4
            cart.xemSanPhanGioHang();
        } else {
            System.out.println("Không có sản phẩm trong giỏ hàng.");
        }

        // Thực hiện bước 5
    }

    public String nhapMaSanPham() {
        System.out.println("Yêu cầu người dùng nhập mã sản phẩm cần xóa trong giỏ hàng và nhấn phím Enter:");
        Scanner scanner = new Scanner(System.in);
        String maSanPham = scanner.nextLine();
        return maSanPham;
    }

    // Phương thức kiểm tra mã sản phẩm có tồn tại trong giỏ hàng hay không
    public boolean kiemtraMaSanPham(String maSP, GioHang gioHang) {
        List<SanPhamTrongGioHang> danhSachSP = gioHang.getDanhSachSP();
        if (danhSachSP != null) {
            for (SanPhamTrongGioHang sp : danhSachSP) {
                if (sp.getMaSP().equals(maSP)) {
                    return true; // Mã sản phẩm tồn tại trong giỏ hàng
                }
            }
        }
        return false;
    }

    // Phương thức xóa sản phẩm khỏi giỏ hàng
    public void xoaSanPhamKhoiGioHang(Scanner scanner,GioHang gioHang) {
        String masp = nhapMaSanPham();
        if (kiemtraMaSanPham(masp, gioHang)) {
            gioHang.xoaSanPham(masp);
            System.out.println("Xóa sản phẩm thành công!!! Vui lòng nhấn Enter để quay về giỏ hàng.");
            scanner.nextLine(); // Đọc ký tự Enter còn lại
            xemSanPhamGioHang(scanner,gioHang);
            menuGioHang(scanner, gioHang);
        } else {
            System.out.println("Xóa sản phẩm thất bại!!! Vui lòng kiểm tra lại mã sản phẩm mà bạn vừa nhập và nhấn Enter để quay về giỏ hàng.");
            scanner.nextLine();
            xemSanPhamGioHang(scanner,gioHang);
            menuGioHang(scanner, gioHang);
        }
    }

    public void hienThiDanhSachDonHang(Scanner scanner) {

        List<DonHang> donHangs = DanhSachDonHang();
        for (DonHang donHang : donHangs) {
            System.out.println(donHang.toString());
        }

        xemChiTietDonHang(scanner);
    }


    //--------------------------------------------------------
    public List<DonHang> DanhSachDonHang() {
        List<DonHang> danhSachDonHang = new ArrayList<>();
        // Thêm các đơn hàng mẫu vào danh sách
        danhSachDonHang.add(new DonHang("DH001", LocalDate.of(2024, 4, 12), true, new ArrayList<>(), 250.0, "TT001", "KH001"));
        danhSachDonHang.add(new DonHang("DH002", LocalDate.of(2024, 4, 13), false, new ArrayList<>(), 300.0, "TT002", "KH001"));
        danhSachDonHang.add(new DonHang("DH003", LocalDate.of(2024, 4, 14), true, new ArrayList<>(), 400.0, "TT003", "KH002"));

        List<DonHang> danhSachDonHangTheoMaKH = new ArrayList<>();
        for(DonHang dh : danhSachDonHang)
        {
            if(UserSession.getInstance().getMaKH().equals(dh.getMaKH()))
            {
                danhSachDonHangTheoMaKH.add(dh);
            }
        }
        return danhSachDonHangTheoMaKH;
    }

    public DonHang getDonHanginListDonHang(String maDonHang, List<DonHang> danhSachDonHang) {
        for (DonHang donHang : danhSachDonHang) {
            if (donHang.getMaDH().equals(maDonHang)) {
                return donHang;
            }
        }

        return null;
    }

    public void xemChiTietDonHang(Scanner scanner) {
        List<DonHang> danhSachDonHang = DanhSachDonHang();

        // Nhập mã đơn hàng từ người dùng
        System.out.print("Nhập mã đơn hàng để xem chi tiết hoặc nhấn phím 'q' để thoát: ");
        String maDonHang = scanner.nextLine();
        DonHang donHang = getDonHanginListDonHang(maDonHang, danhSachDonHang);
        if (maDonHang.equals("q")) return;
        else {

            if (donHang == null) {
                System.out.println("Không tìm thấy đơn hàng với mã " + maDonHang);
                return;
            } else {
                // In ra chi tiết đơn hàng
                System.out.println("Chi tiết đơn hàng:");
                System.out.println("Mã đơn hàng: " + donHang.getMaDH());
                System.out.println("Ngày đặt hàng: " + convertDay(donHang.getNgayDH()));
                System.out.println("Trạng thái: " + (donHang.isTrangThai() ? "Đã hoàn thành" : "Chưa hoàn thành"));
                // In ra các sản phẩm trong đơn hàng
                System.out.println("Danh sách sản phẩm:");
                for (SanPhamTrongGioHang sp : donHang.getDanhSachSP()) {
                    System.out.println("  - " + sp.getTenSP() + ": " + sp.getSoLuong() + " x " + sp.getGiaSP() + " đồng");
                }
                System.out.println("Tổng tiền: " + donHang.getTongTien() + " đồng");
                System.out.println("Mã thanh toán: " + donHang.getMaThanhToan());
                System.out.print("Nhập Enter để thoát! ");
                scanner.nextLine();
                return;
            }
        }
    }

    public static String convertDay(LocalDate ngay) {
        // Định dạng ngày
        DateTimeFormatter dinhDang = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        // Chuyển đổi LocalDate thành chuỗi
        String ngayThangNam = ngay.format(dinhDang);
        return ngayThangNam;
    }

    //-------------------------------------- cập nhật sản phẩm
    public void capNhatSanPham() {
        ArrayList<SanPham> sanPhams = DanhSachSanPham();
        kho.hienThiDanhSachSanPham();


        Scanner scanner = new Scanner(System.in);

        // Khởi tạo sản phẩm cần cập nhật
        SanPham sanPhamTimKiem = null;

        // Nhập mã sản phẩm cần tìm kiếm
        System.out.print("Nhập mã sản phẩm cần cập nhật: ");
        String maSanPhamCanTim = scanner.nextLine();
        sanPhamTimKiem = timKiemSanPhamTheoMa(sanPhams, maSanPhamCanTim);
        // Tìm kiếm sản phẩm theo mã


        // Nếu sản phẩm được tìm thấy
        if (sanPhamTimKiem != null) {
            System.out.println("Thông tin sản phẩm cần cập nhật:");
            System.out.println(sanPhamTimKiem.toString());

            // Nhập và validate các giá trị mới cho sản phẩm
            String tenMoi = nhapTen(scanner, sanPhamTimKiem);
            double giaMoi = nhapGia(scanner);
            int soLuongMoi = nhapSoLuong(scanner);

            System.out.println("Xác nhận cập nhật (Y): ");
            String xacNhan = scanner.nextLine();
            if (xacNhan.equalsIgnoreCase("y")) {
                // Cập nhật thông tin cho sản phẩm
                if (!tenMoi.isEmpty()) {
                    sanPhamTimKiem.setTenSP(tenMoi);
                }
                if (giaMoi != -1) {
                    sanPhamTimKiem.setGiaSP(giaMoi);
                }
                if (soLuongMoi >= 0) {
                    capNhatSoLuongSanPhamTrongKho(sanPhamTimKiem, soLuongMoi, kho.getDanhSachSanPham());
                }

                // Hiển thị thông tin sản phẩm sau khi cập nhật
                //System.out.println("Thông tin sản phẩm sau khi cập nhật:");
                //System.out.println(sanPhamTimKiem.toString() + "Số lương trong kho: " + soLuongMoi);
                System.out.println("Nhấn Enter để thoát");
                scanner.nextLine();

            } else {
                System.out.println("Hủy xác nhận cập nhật, nhấn Enter để thoát");
                scanner.nextLine();
                return;

            }

        } else {
            System.out.println("Không tìm thấy sản phẩm có mã " + maSanPhamCanTim);
            System.out.print("Nhập Enter để thoát: ");
            scanner.nextLine();
            return;
        }
    }

    public ArrayList<SanPham> DanhSachSanPham() {
        sanPhams.clear();
        sanPhams.add(sp1);
        sanPhams.add(sp2);
        sanPhams.add(sp3);
        sanPhams.add(sp4);

        return sanPhams;
    }

//    public ArrayList<Kho> DanhSachSanPhamTrongKho() {
//        khos.clear();
//        khos.add(k1);
//        khos.add(k2);
//        khos.add(k3);
//        return khos;
//    }



    public SanPham timKiemSanPhamTheoMa(ArrayList<SanPham> sanPhams, String maSanPham) {
        for (SanPham sanPham : sanPhams) {
            if (sanPham.getMaSP().equals(maSanPham)) {
                return sanPham;
            }
        }
        return null;
    }

    // Nhập tên mới của sản phẩm
    public static String nhapTen(Scanner scanner, SanPham sp) {
        String tenMoi = "";
        while (true) {
            System.out.print("Nhập tên mới của sản phẩm (nhấn Enter để bỏ qua): ");
            tenMoi = scanner.nextLine().trim();
            if (tenMoi.isEmpty()) {
                // Bỏ qua nếu người dùng không muốn thay đổi tên sản phẩm
                break;
            } else if (!isValidTenSanPham(sp, tenMoi)) {
                System.out.println("Tên sản phẩm không hợp lệ. Vui lòng nhập lại.");
            } else {
                // Thoát khỏi vòng lặp nếu tên hợp lệ
                break;
            }
        }
        return tenMoi;
    }

    // Kiểm tra tính hợp lệ của tên sản phẩm
    public static boolean isValidTenSanPham(SanPham sanPham, String tenMoi) {
        if (sanPham.getTenSP().equals(tenMoi)) {
            return false; // Tên mới trùng với tên của sản phẩm cũ
        }
        return tenMoi.matches("[a-zA-Z0-9\\s]+");
    }

    // Nhập giá mới của sản phẩm
    public static double nhapGia(Scanner scanner) {
        double giaMoi = -1; // Giá trị mặc định là -1 để xác định người dùng đã nhập giá mới hay chưa
        while (true) {
            System.out.print("Nhập giá mới của sản phẩm (nhấn Enter để bỏ qua): ");
            String input = scanner.nextLine();
            if (input.isEmpty()) {
                // Bỏ qua nếu người dùng không muốn thay đổi giá sản phẩm
                break;
            }
            try {
                giaMoi = Double.parseDouble(input);
                if (giaMoi < 0) {
                    System.out.println("Giá phải lớn hơn hoặc bằng 0. Vui lòng nhập lại.");
                } else {
                    // Thoát khỏi vòng lặp nếu giá hợp lệ
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Giá phải là một số. Vui lòng nhập lại.");
            }
        }
        return giaMoi;
    }

    //nhập số lượng mới cảu sản phẩm
    public static int nhapSoLuong(Scanner scanner) {
        int soLuongMoi = -1;
        while (soLuongMoi <= 0) {
            System.out.print("Nhập số lượng mới của sản phẩm (nhấn Enter để bỏ qua): ");
            String input = scanner.nextLine();
            if (input.isEmpty()) {
                // Bỏ qua nếu người dùng không muốn thay đổi giá sản phẩm
                break;
            }
            try {
                soLuongMoi = Integer.parseInt(input);
                if (soLuongMoi <= 0) {

                    System.out.println("Số lượng phải lớn hơn 0. Vui lòng nhập lại.");
                } else {
                    // Thoát khỏi vòng lặp nếu giá hợp lệ
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Số lượng phải là một số nguyên. Vui lòng nhập lại.");
            }
        }
        return soLuongMoi;
    }


    public static void capNhatSoLuongSanPhamTrongKho(SanPham sanPham, int soLuongMoi, Map<SanPham, Integer> danhSachSanPham) {
        if (danhSachSanPham.containsKey(sanPham)) {
            // Lấy số lượng hiện tại của sản phẩm
            int soLuongHienTai = danhSachSanPham.get(sanPham);

            // Cập nhật số lượng mới cho sản phẩm
            danhSachSanPham.put(sanPham, soLuongMoi);

            System.out.println("Đã cập nhật số lượng của sản phẩm " + sanPham + " từ " + soLuongHienTai + " thành " + soLuongMoi);
        } else {
            // Xử lý khi sản phẩm không tồn tại trong Map
            System.out.println("Sản phẩm " + sanPham + " không tồn tại trong danh sách.");
        }

        // Duyệt qua danh sách sản phẩm trong kho để tìm sản phẩm có mã tương ứng và cập nhật số lượng mới
//        for (Kho sanPhamTrongKho : danhSachSanPham) {
//            if (sanPhamTrongKho.getMaSanPham().equalsIgnoreCase(sanPham.getMaSP())) {
//                sanPhamTrongKho.setSoLuongSanPham(soLuongMoi);
//                break;
//            }
//        }
        //System.out.println("Số lượng sản phẩm trong kho đã được cập nhật.");
    }

    public void datQuyenTruyCap(List<NhanVien> nhanVienList)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bạn đang thực hiện chức năng Đặt quyền truy cập cho nhân viên và yêu cầu người dùng nhấn Enter để tiếp tục");
        scanner.nextLine();

        // Hiển thị menu cho người dùng chọn cấp quyền hoặc thu hồi quyền
        System.out.println("Menu:");
        System.out.println("1. Cấp quyền truy cập");
        System.out.println("2. Thu hồi quyền truy cập");
        System.out.print("Chọn chức năng (1 hoặc 2): ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Đọc ký tự thừa sau khi nhập số

        // Xử lý chọn chức năng
        switch (choice) {
            case 1:
                capQuyenTruyCap(nhanVienList);
                break;
            case 2:
                thuHoiQuyenTruyCap(nhanVienList);
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ.");
                return;
        }
    }

    private void thuHoiQuyenTruyCap(List<NhanVien> nhanVienList) {
        System.out.println("Bạn đã chọn thu hồi quyền truy cập.");
        Scanner scanner = new Scanner(System.in);
        String maNV;
        NhanVien nv;
        // Yêu cầu nhập mã nhân viên được cấp quyền truy cập
        do {
            // Yêu cầu nhập mã nhân viên được cấp quyền truy cập
            System.out.print("Nhập mã nhân viên được thu hồi quyền truy cập: ");
            maNV = scanner.nextLine();
            nv = timNhanVienTheoMa(nhanVienList, maNV);
            if (nv == null) {
                System.out.println("Mã nhân viên không tồn tại. Vui lòng nhập lại.");
            }
        } while (nv == null);

        // Hiển thị thông tin nhân viên và yêu cầu xác nhận
        System.out.println("Thông tin nhân viên:");
        System.out.println("Mã nhân viên: " + nv.getMaNV());
        System.out.println("Họ và tên: " + nv.getHoVaTen());
        String confirm;
        do {
            System.out.print("Bạn có muốn thu hồi quyền truy cập cho nhân viên này? (Y/N): ");
            confirm = scanner.nextLine();
        } while (!confirm.equalsIgnoreCase("Y") && !confirm.equalsIgnoreCase("N"));

        // Xác nhận cấp quyền truy cập
        if (confirm.equalsIgnoreCase("Y")) {
            // Thực hiện cấp quyền truy cập bằng cách đổi giá trị quyenTruyCap thành 2
            nv.setQuyenTruyCap((byte) 1);
            System.out.println("Đã thu hồi quyền truy cập cho nhân viên thành công.");

        } else {
            System.out.println("Đã hủy bỏ thao tác.");
        }
        System.out.println("Nhấn Enter để quay về Menu chính.");
        scanner.nextLine();

    }

    public void capQuyenTruyCap(List<NhanVien> nhanVienList) {
        System.out.println("Bạn đã chọn cấp quyền truy cập.");
        Scanner scanner = new Scanner(System.in);
        String maNV;
        NhanVien nv;
        // Yêu cầu nhập mã nhân viên được cấp quyền truy cập
        do {
            // Yêu cầu nhập mã nhân viên được cấp quyền truy cập
            System.out.print("Nhập mã nhân viên được cấp quyền truy cập: ");
            maNV = scanner.nextLine();
            nv = timNhanVienTheoMa(nhanVienList, maNV);
            if (nv == null) {
                System.out.println("Mã nhân viên không tồn tại. Vui lòng nhập lại.");
            }
        } while (nv == null);

        // Hiển thị thông tin nhân viên và yêu cầu xác nhận
        System.out.println("Thông tin nhân viên:");
        System.out.println("Mã nhân viên: " + nv.getMaNV());
        System.out.println("Họ và tên: " + nv.getHoVaTen());
        String confirm;
        do {
            System.out.print("Bạn có muốn cấp quyền truy cập cho nhân viên này? (Y/N): ");
            confirm = scanner.nextLine();
        } while (!confirm.equalsIgnoreCase("Y") && !confirm.equalsIgnoreCase("N"));

        // Xác nhận cấp quyền truy cập
        if (confirm.equalsIgnoreCase("Y")) {
            // Thực hiện cấp quyền truy cập bằng cách đổi giá trị quyenTruyCap thành 2
            nv.setQuyenTruyCap((byte) 2);
            System.out.println("Đã cấp quyền truy cập cho nhân viên thành công.");
        } else {
            System.out.println("Đã hủy bỏ thao tác.");
        }
        System.out.println("Nhấn Enter để quay về Menu chính.");
        scanner.nextLine();
        return;
    }
    public static NhanVien timNhanVienTheoMa(List<NhanVien> nhanVienList, String maNV) {
        for (NhanVien nv : nhanVienList) {
            if (nv.getMaNV().equals(maNV)) {
                return nv;
            }
        }
        return null; // Không tìm thấy nhân viên có mã tương ứng
    }
    public static void capNhatThongTinTaiKhoan(NhanVien nhanVien) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bạn đang thực hiện chức năng Đặt quyền truy cập cho nhân viên và yêu cầu người dùng nhấn Enter để tiếp tục");
        scanner.nextLine();
        // Hiển thị thông tin người dùng
        System.out.println("Thông tin người dùng:");
        // Hiển thị thông tin của người dùng ở đây
        System.out.println("Họ và tên: " + nhanVien.getHoVaTen());
        System.out.println("Địa chỉ: " + nhanVien.getDiaChi());
        System.out.println("Số điện thoại: " + nhanVien.getsDT());
        System.out.println("Email: " + nhanVien.getEmail());
        // Hiển thị menu chỉnh sửa thông tin
        System.out.println("Menu chỉnh sửa thông tin:");
        System.out.println("1. Chỉnh sửa thông tin tài khoản");
        System.out.println("2. Chỉnh sửa mật khẩu");

        // Yêu cầu người dùng chọn chức năng
        int choice;
        do {
            System.out.print("Nhập số để chọn chức năng (1 hoặc 2): ");
            while (!scanner.hasNextInt()) {
                System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập lại.");
                scanner.next();
            }
            choice = scanner.nextInt();
            scanner.nextLine(); // Đọc ký tự thừa sau khi nhập số
        } while (choice < 1 || choice > 2);

        // Xử lý chọn chức năng
        switch (choice) {
            case 1:
                // Thực hiện chức năng chỉnh sửa thông tin tài khoản
                System.out.println("Bạn đang thực hiện chức năng Chỉnh sửa thông tin tài khoản và yêu cầu nhấn Enter để tiếp tục");
                scanner.nextLine();
                chinhsuaThongTinTaiKhoan(nhanVien);
                break;
            case 2:
                System.out.println("Bạn đang thực hiện chức năng Chỉnh sửa mật khẩu và yêu cầu nhấn Enter để tiếp tục");
                scanner.nextLine();
                chinhsuaMatKhau(nhanVien);
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ.");
                break;
        }
        System.out.println("Nhấn Enter để quay về Menu chính.");
        scanner.nextLine();
        return;
    }
    public static void chinhsuaThongTinTaiKhoan(NhanVien nhanVien) {
        Scanner scanner = new Scanner(System.in);
        String hoVaTen = "", diaChi = "", soDienThoai = "", email = "";

        // Hiển thị menu chỉnh sửa thông tin tài khoản
        System.out.println("Menu chỉnh sửa thông tin tài khoản:");
        System.out.println("1. Chỉnh sửa họ và tên");
        System.out.println("2. Chỉnh sửa địa chỉ");
        System.out.println("3. Chỉnh sửa số điện thoại");
        System.out.println("4. Chỉnh sửa email");
        System.out.println("5. Dừng cập nhật thông tin");

        int choice;
        do {
            // Yêu cầu người dùng chọn loại thông tin để chỉnh sửa
            System.out.print("Nhập số để chọn loại thông tin để chỉnh sửa (1-5): ");
            while (!scanner.hasNextInt()) {
                System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập lại.");
                scanner.next();
            }
            choice = scanner.nextInt();
            scanner.nextLine(); // Đọc ký tự thừa sau khi nhập số

            switch (choice) {
                case 1:
                    // Chỉnh sửa họ và tên
                    System.out.print("Nhập họ và tên không chứa ký tự số hoặc đặc biệt: ");
                    hoVaTen = scanner.nextLine();
                    break;
                case 2:
                    // Chỉnh sửa địa chỉ
                    System.out.print("Nhập địa chỉ: ");
                    diaChi = scanner.nextLine();
                    break;
                case 3:
                    // Chỉnh sửa số điện thoại
                    System.out.print("Nhập số điện thoại: ");
                    soDienThoai = scanner.nextLine();
                    break;
                case 4:
                    // Chỉnh sửa email
                    System.out.print("Nhập email (nhấn Enter để bỏ qua): ");
                    email = scanner.nextLine();
                    break;
                case 5:
                    // Dừng cập nhật thông tin
                    System.out.println("Đã dừng cập nhật thông tin.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        } while (choice != 5);

        // Hiển thị thông tin vừa nhập
        System.out.println("Thông tin vừa nhập:");
        if (!hoVaTen.isEmpty()) {
            System.out.println("Họ và tên: " + hoVaTen);
        }
        if (!diaChi.isEmpty()) {
            System.out.println("Địa chỉ: " + diaChi);
        }
        if (!soDienThoai.isEmpty()) {
            System.out.println("Số điện thoại: " + soDienThoai);
        }
        if (!email.isEmpty()) {
            System.out.println("Email: " + email);
        }

        // Yêu cầu xác nhận lưu thông tin
        System.out.print("Bạn có muốn lưu thông tin này không? (Y/N): ");
        String confirm = scanner.nextLine();

        // Xác nhận và hiển thị thông báo
        if (confirm.equalsIgnoreCase("Y")) {
            if (!hoVaTen.isEmpty())
                nhanVien.setHoVaTen(hoVaTen);

            if (!diaChi.isEmpty()) {
                nhanVien.setDiaChi(diaChi);
            }
            if (!soDienThoai.isEmpty()) {
                nhanVien.setsDT(soDienThoai);
            }
            if (!email.isEmpty()) {
                nhanVien.setEmail(email);
            }
            System.out.println("Thông tin đã được cập nhật thành công.");
            System.out.println("Họ và tên: " + nhanVien.getHoVaTen());
            System.out.println("Địa chỉ: " + nhanVien.getDiaChi());
            System.out.println("Số điện thoại: " + nhanVien.getsDT());
            System.out.println("Email: " + nhanVien.getEmail());
        } else {
            System.out.println("Đã hủy bỏ thao tác.");
        }
        System.out.println("Nhấn Enter để quay về Menu chính.");
        scanner.nextLine();
        return;
    }
    public static void chinhsuaMatKhau(NhanVien nhanVien) {
        Scanner scanner = new Scanner(System.in);
        String newPassword;
        String confirmPassword;

        do {
            // Yêu cầu người dùng nhập mật khẩu mới
            System.out.print("Nhập mật khẩu mới: ");
            newPassword = scanner.nextLine();

            // Yêu cầu người dùng xác nhận mật khẩu mới
            System.out.print("Xác nhận mật khẩu mới: ");
            confirmPassword = scanner.nextLine();

            // Kiểm tra xác nhận mật khẩu
            if (!newPassword.equals(confirmPassword)) {
                System.out.println("Mật khẩu xác nhận không khớp. Vui lòng thử lại.");
            }
        } while (!newPassword.equals(confirmPassword));

        // Cập nhật mật khẩu
        nhanVien.setMatKhau(newPassword);

        // Hiển thị thông báo mật khẩu đã được cập nhật
        System.out.println("Mật khẩu đã được cập nhật thành công.");

        // Hiển thị mật khẩu vừa được cập nhật
        System.out.println("Mật khẩu mới: " + nhanVien.getMatKhau());
        System.out.println("Nhấn Enter để quay về Menu chính.");
        scanner.nextLine();
        return;
    }
    public static void capNhatThongTinTaiKhoan(KhachHang khachHang) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bạn đang thực hiện chức năng Đặt quyền truy cập cho nhân viên và yêu cầu người dùng nhấn Enter để tiếp tục");
        scanner.nextLine();
        // Hiển thị thông tin người dùng
        System.out.println("Thông tin người dùng:");
        // Hiển thị thông tin của người dùng ở đây
        System.out.println("Họ và tên: " + khachHang.getHoVaTen());
        System.out.println("Địa chỉ: " + khachHang.getDiaChi());
        System.out.println("Số điện thoại: " + khachHang.getsDT());
        System.out.println("Email: " + khachHang.getEmail());
        // Hiển thị menu chỉnh sửa thông tin
        System.out.println("Menu chỉnh sửa thông tin:");
        System.out.println("1. Chỉnh sửa thông tin tài khoản");
        System.out.println("2. Chỉnh sửa mật khẩu");

        // Yêu cầu người dùng chọn chức năng
        int choice;
        do {
            System.out.print("Nhập số để chọn chức năng (1 hoặc 2): ");
            while (!scanner.hasNextInt()) {
                System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập lại.");
                scanner.next();
            }
            choice = scanner.nextInt();
            scanner.nextLine(); // Đọc ký tự thừa sau khi nhập số
        } while (choice < 1 || choice > 2);

        // Xử lý chọn chức năng
        switch (choice) {
            case 1:
                // Thực hiện chức năng chỉnh sửa thông tin tài khoản
                System.out.println("Bạn đang thực hiện chức năng Chỉnh sửa thông tin tài khoản và yêu cầu nhấn Enter để tiếp tục");
                scanner.nextLine();
                chinhsuaThongTinTaiKhoan(khachHang);
                break;
            case 2:
                System.out.println("Bạn đang thực hiện chức năng Chỉnh sửa mật khẩu và yêu cầu nhấn Enter để tiếp tục");
                scanner.nextLine();
                chinhsuaMatKhau(khachHang);
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ.");
                break;
        }
        System.out.println("Nhấn Enter để quay về Menu chính.");
        scanner.nextLine();
        return;
    }
    public static void chinhsuaThongTinTaiKhoan(KhachHang khachHang) {
        Scanner scanner = new Scanner(System.in);
        String hoVaTen = "", diaChi = "", soDienThoai = "", email = "";

        // Hiển thị menu chỉnh sửa thông tin tài khoản
        System.out.println("Menu chỉnh sửa thông tin tài khoản:");
        System.out.println("1. Chỉnh sửa họ và tên");
        System.out.println("2. Chỉnh sửa địa chỉ");
        System.out.println("3. Chỉnh sửa số điện thoại");
        System.out.println("4. Chỉnh sửa email");
        System.out.println("5. Dừng cập nhật thông tin");

        int choice;
        do {
            // Yêu cầu người dùng chọn loại thông tin để chỉnh sửa
            System.out.print("Nhập số để chọn loại thông tin để chỉnh sửa (1-5): ");
            while (!scanner.hasNextInt()) {
                System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập lại.");
                scanner.next();
            }
            choice = scanner.nextInt();
            scanner.nextLine(); // Đọc ký tự thừa sau khi nhập số

            switch (choice) {
                case 1:
                    // Chỉnh sửa họ và tên
                    System.out.print("Nhập họ và tên không chứa ký tự số hoặc đặc biệt: ");
                    hoVaTen = scanner.nextLine();
                    break;
                case 2:
                    // Chỉnh sửa địa chỉ
                    System.out.print("Nhập địa chỉ: ");
                    diaChi = scanner.nextLine();
                    break;
                case 3:
                    // Chỉnh sửa số điện thoại
                    System.out.print("Nhập số điện thoại: ");
                    soDienThoai = scanner.nextLine();
                    break;
                case 4:
                    // Chỉnh sửa email
                    System.out.print("Nhập email (nhấn Enter để bỏ qua): ");
                    email = scanner.nextLine();
                    break;
                case 5:
                    // Dừng cập nhật thông tin
                    System.out.println("Đã dừng cập nhật thông tin.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        } while (choice != 5);

        // Hiển thị thông tin vừa nhập
        System.out.println("Thông tin vừa nhập:");
        if (!hoVaTen.isEmpty()) {
            System.out.println("Họ và tên: " + hoVaTen);
        }
        if (!diaChi.isEmpty()) {
            System.out.println("Địa chỉ: " + diaChi);
        }
        if (!soDienThoai.isEmpty()) {
            System.out.println("Số điện thoại: " + soDienThoai);
        }
        if (!email.isEmpty()) {
            System.out.println("Email: " + email);
        }

        // Yêu cầu xác nhận lưu thông tin
        System.out.print("Bạn có muốn lưu thông tin này không? (Y/N): ");
        String confirm = scanner.nextLine();

        // Xác nhận và hiển thị thông báo
        if (confirm.equalsIgnoreCase("Y")) {
            if (!hoVaTen.isEmpty())
                khachHang.setHoVaTen(hoVaTen);

            if (!diaChi.isEmpty()) {
                khachHang.setDiaChi(diaChi);
            }
            if (!soDienThoai.isEmpty()) {
                khachHang.setsDT(soDienThoai);
            }
            if (!email.isEmpty()) {
                khachHang.setEmail(email);
            }
            System.out.println("Thông tin đã được cập nhật thành công.");
            System.out.println("Họ và tên: " + khachHang.getHoVaTen());
            System.out.println("Địa chỉ: " + khachHang.getDiaChi());
            System.out.println("Số điện thoại: " + khachHang.getsDT());
            System.out.println("Email: " + khachHang.getEmail());
        } else {
            System.out.println("Đã hủy bỏ thao tác.");
        }
        System.out.println("Nhấn Enter để quay về Menu chính.");
        scanner.nextLine();
        return;
    }
    public static void chinhsuaMatKhau(KhachHang khachHang) {
        Scanner scanner = new Scanner(System.in);
        String newPassword;
        String confirmPassword;

        do {
            // Yêu cầu người dùng nhập mật khẩu mới
            System.out.print("Nhập mật khẩu mới: ");
            newPassword = scanner.nextLine();

            // Yêu cầu người dùng xác nhận mật khẩu mới
            System.out.print("Xác nhận mật khẩu mới: ");
            confirmPassword = scanner.nextLine();

            // Kiểm tra xác nhận mật khẩu
            if (!newPassword.equals(confirmPassword)) {
                System.out.println("Mật khẩu xác nhận không khớp. Vui lòng thử lại.");
            }
        } while (!newPassword.equals(confirmPassword));

        // Cập nhật mật khẩu
        khachHang.setMatKhau(newPassword);

        // Hiển thị thông báo mật khẩu đã được cập nhật
        System.out.println("Mật khẩu đã được cập nhật thành công.");

        // Hiển thị mật khẩu vừa được cập nhật
        System.out.println("Mật khẩu mới: " + khachHang.getMatKhau());
        System.out.println("Nhấn Enter để quay về Menu chính.");
        scanner.nextLine();
        return;
    }

    //---------
    public void themSanPhamVaoKho(Scanner scanner) {
        System.out.println("Thêm sản phẩm vào kho:");

        // Yêu cầu nhập mã sản phẩm hợp lệ
        String maSP;
        do {
            System.out.print("Nhập mã sản phẩm (4 ký tự không có ký tự đặc biệt và không trùng): ");
            maSP = scanner.nextLine();
        } while (!maSP.matches("[a-zA-Z0-9]+") || kho.daTonTaiMaSP(maSP));

        // Yêu cầu nhập tên sản phẩm không chứa ký tự đặc biệt
        String tenSP;
        do {
            System.out.print("Nhập tên sản phẩm (không chứa ký tự đặc biệt): ");
            tenSP = scanner.nextLine();
        } while (!tenSP.matches("[a-zA-Z0-9\\s]+"));

        // Yêu cầu nhập giá sản phẩm không âm
        double giaSP;
        do {
            System.out.print("Nhập giá sản phẩm (không âm): ");
            giaSP = scanner.nextDouble();
            scanner.nextLine(); // Đọc ký tự xuống dòng
        } while (giaSP < 0);

        // Yêu cầu nhập số lượng sản phẩm không âm
        int soLuong;
        do {
            System.out.print("Nhập số lượng sản phẩm (không âm): ");
            soLuong = scanner.nextInt();
            scanner.nextLine(); // Đọc ký tự xuống dòng
        } while (soLuong < 0);

        // Tạo đối tượng sản phẩm mới
        SanPham sanPham = new SanPham(maSP, tenSP, giaSP);

        // Hiển thị thông tin sản phẩm mới
        System.out.println("Thông tin sản phẩm mới:");
        System.out.println("Mã sản phẩm: " + sanPham.getMaSP());
        System.out.println("Tên sản phẩm: " + sanPham.getTenSP());
        System.out.println("Giá sản phẩm: " + sanPham.getGiaSP());
        System.out.println("Số lượng sản phẩm: " + soLuong);

        //Chương trinh hỏi người dunng có xác nhận thêm sản phẩm vào kho
        System.out.print("Bạn có muốn thêm sản phẩm vào kho không? (Y/N): ");
        String confirm = scanner.nextLine();

        if (confirm.equalsIgnoreCase("Y")) {
            kho.themSanPham(sanPham, soLuong);
            System.out.println("Sản phẩm đã được thêm vào kho thành công.");
        } else if (confirm.equalsIgnoreCase("N")) {
            System.out.println("Không thêm sản phẩm vào kho.");
        } else {
            System.out.println("Lựa chọn không hợp lệ. Không thêm sản phẩm vào kho.");
        }

    }


    public void xemDanhSachSanPham(Scanner scanner) {
        kho.hienThiDanhSachSanPham();
        System.out.println("--1. Thêm sản phẩm vào kho");
        System.out.println("--2. Cập Nhật Thông Tin Sản Phẩm ");
        System.out.println("--3. Thoát");
        while (true) {
            System.out.print("Chọn chức năng: ");
            int choice1 = scanner.nextInt();
            scanner.nextLine();

            switch (choice1) {
                case 1:
                    themSanPhamVaoKho(scanner);
                    break;
                case 2:
                    capNhatSanPham();
                    break;
                case 3:
                    System.out.println("Thoát");
                    return;
                default:
                    System.out.println("Chức năng không hợp lệ.");
            }
        }
    }
}
