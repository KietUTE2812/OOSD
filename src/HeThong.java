import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HeThong {
    private static ArrayList<SanPham> sanPhams = new ArrayList<>();
    private static SanPham sp1 = new SanPham("SP001", "Laptop Dell", 18000000.0);
    private static SanPham sp2 = new SanPham("SP002", "Laptop Asus", 15000000.0);
    private static SanPham sp3 = new SanPham("SP003", "Laptop Lenovo", 200000000.0);


    private static ArrayList<Kho> khos = new ArrayList<>();

    private static   Kho k1 = new Kho("SP001", 20);
    private static   Kho k2 = new Kho("SP002", 40);
    private static   Kho k3 = new Kho("SP003", 10);



    public HeThong() {
        Scanner scanner = new Scanner(System.in);


        while (true) {
            // Menu hiển thị các chức năng
            System.out.println("Menu:");


            System.out.println("1. Xem sản phẩm");
            System.out.println("2. Xem giỏ hàng");
            System.out.println("3. Xem danh sách đơn hàng");
            System.out.println("4. Chỉnh sửa tài khoản");
            System.out.println("5. Đăng xuất");
            System.out.println("0. Thoát");
            System.out.print("Chọn chức năng: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Đọc ký tự xuống dòng

            switch (choice) {
                case 1:
                    datHang(scanner);
                    break;
                case 2:
                    menuGioHang(scanner);
                    break;
                case 3:
                    danhSachDonHang(scanner);
                    break;
                case 4:
                    datHang(scanner);
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
                SanPhamTrongGioHang cartItem = new SanPhamTrongGioHang(product.getMaSP(), product.getTenSP(), product.getGiaSP(), quantity);
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

        for (SanPhamTrongGioHang item : dh.getItems()) {
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

    public HeThong(List<NhanVien> nhanVienList) {

        Scanner scanner = new Scanner(System.in);

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
                    capNhatSanPham();
                    break;
                case 2:
                    capNhatSanPham();
                    break;
                case 3:
                    capNhatSanPham();
                    break;
                case 4:
                    capNhatSanPham();
                    break;
                case 5:
                    capNhatSanPham();
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


    // Hàm giả định để tìm kiếm sản phẩm theo mã sản phẩm
    private SanPham findProductById(String productId) {
        // Giả định rằng hàm này sẽ trả về sản phẩm từ cơ sở dữ liệu hoặc danh sách sản phẩm
        // Ở đây chỉ cần trả về một sản phẩm tạm thời để minh họa
        return new SanPham(productId, "Tên sản phẩm", 100.0);
    }

    private PhieuGiamGia findDiscountById(String discountId) {
        // Giả định rằng hàm này sẽ trả về sản phẩm từ cơ sở dữ liệu hoặc danh sách sản phẩm
        // Ở đây chỉ cần trả về một sản phẩm tạm thời để minh họa
        return new PhieuGiamGia(discountId, "SP001", 75, 500);
    }

    private void menuGioHang(Scanner scanner) {
        System.out.println("--1. Đặt hàng");
        System.out.println("--2. Xóa sản phẩm");
        System.out.println("--3. Thoát");
        while (true) {
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

    public void danhSachDonHang(Scanner scanner) {

        List<DonHang> donHangs = hienThiDanhSachDonHang();
        for (DonHang donHang : donHangs) {
            System.out.println(donHang.toString());
        }

        xemChiTietDonHang(scanner);
    }


    //--------------------------------------------------------
    public List<DonHang> hienThiDanhSachDonHang() {
        List<DonHang> danhSachDonHang = new ArrayList<>();
        // Thêm các đơn hàng mẫu vào danh sách
        danhSachDonHang.add(new DonHang("DH001", LocalDate.of(2024, 4, 12), true, new ArrayList<>(), 250.0, "TT001"));
        danhSachDonHang.add(new DonHang("DH002", LocalDate.of(2024, 4, 13), false, new ArrayList<>(), 300.0, "TT002"));
        danhSachDonHang.add(new DonHang("DH003", LocalDate.of(2024, 4, 14), true, new ArrayList<>(), 400.0, "TT003"));
        return danhSachDonHang;
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
        List<DonHang> danhSachDonHang = hienThiDanhSachDonHang();

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
        ArrayList<Kho> khos = DanhSachSanPhamTrongKho();

        hienThiDanhSanPham(sanPhams, khos);


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
                    capNhatSoLuongSanPhamTrongKho(sanPhamTimKiem, soLuongMoi, khos);
                }

                // Hiển thị thông tin sản phẩm sau khi cập nhật
                System.out.println("Thông tin sản phẩm sau khi cập nhật:");
                System.out.println(sanPhamTimKiem.toString() + "Số lương trong kho: " + soLuongMoi);
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
        sanPhams.add(sp1);
        sanPhams.add(sp2);
        sanPhams.add(sp3);

        return sanPhams;
    }

    public ArrayList<Kho> DanhSachSanPhamTrongKho() {
        khos.add(k1);
        khos.add(k2);
        khos.add(k3);
        return khos;
    }

    public void hienThiDanhSanPham(List<SanPham> sps, List<Kho> khos) {
        for (SanPham sanpham : sps) {
            for (Kho k : khos) {
                if (k.getMaSanPham().equals(sanpham.getMaSP())) {

                    System.out.println(sanpham.toString() + "Số lượng trong kho: " + k.getSoLuongSanPham());
                    break;

                }
            }
        }
    }

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


    public static void capNhatSoLuongSanPhamTrongKho(SanPham sanPham, int soLuongMoi, List<Kho> sanPhamTrongKhoList) {


        // Duyệt qua danh sách sản phẩm trong kho để tìm sản phẩm có mã tương ứng và cập nhật số lượng mới
        for (Kho sanPhamTrongKho : sanPhamTrongKhoList) {
            if (sanPhamTrongKho.getMaSanPham().equalsIgnoreCase(sanPham.getMaSP())) {
                sanPhamTrongKho.setSoLuongSanPham(soLuongMoi);
                break;
            }
        }
        System.out.println("Số lượng sản phẩm trong kho đã được cập nhật.");
    }
}
