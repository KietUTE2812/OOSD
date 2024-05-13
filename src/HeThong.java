public class HeThong {


    public HeThong() {
        Scanner scanner = new Scanner(System.in);

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
                    datHang(scanner);
                    break;
                case 2:
                    xemSanPhamGioHang(scanner,gioHang);
                    menuGioHang(scanner,gioHang);
                    break;
                case 3:
                    datHang(scanner);
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

    private void menuGioHang(Scanner scanner,GioHang gioHang) {
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
                    xoaSanPhamKhoiGioHang(scanner,gioHang);
                    break;
                case 3:
                    System.out.println("Thoát giỏ hàng.");
                    return;
                default:
                    System.out.println("Chức năng không hợp lệ.");
            }
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
    public void xoaSanPhamKhoiGioHang(Scanner scanner,GioHang gioHang   ) {
        String masp = nhapMaSanPham();
        if (kiemtraMaSanPham(masp, gioHang)) {
            gioHang.xoaSanPham(masp);
            System.out.println("Xóa sản phẩm thành công!!! Vui lòng nhấn Enter để quay về giỏ hàng.");
            scanner.nextLine(); // Đọc ký tự Enter còn lại
            xemSanPhamGioHang(scanner,gioHang);
            menuGioHang(scanner,gioHang);
        } else {
            System.out.println("Xóa sản phẩm thất bại!!! Vui lòng kiểm tra lại mã sản phẩm mà bạn vừa nhập và nhấn Enter để quay về giỏ hàng.");
            scanner.nextLine();
            xemSanPhamGioHang(scanner,gioHang);
            menuGioHang(scanner,gioHang);
        }
    }

     List<NhanVien> nhanVienList = new ArrayList<>();
    public static NhanVien nhanVien1 = new NhanVien("NV001", "Nguyen Van A", "0123456789", "nv1@example.com", "Address 1", (byte) 0, "user1", "pass1");
    public static NhanVien nhanVien2 = new NhanVien("NV002", "Nguyen Van B", "0987654321", "nv2@example.com", "Address 2", (byte) 1, "user2", "pass2");
    public static NhanVien nhanVien3 = new NhanVien("NV003", "Nguyen Thi C", "0456789123", "nv3@example.com", "Address 3", (byte) 2, "user3", "pass3");


    public static byte quyen = nhanVien3.getQuyenTruyCap();
    public HeThong(List<NhanVien>nhanVienList) {
        nhanVienList.add(nhanVien1);
        nhanVienList.add(nhanVien2);
        nhanVienList.add(nhanVien3);
        Scanner scanner = new Scanner(System.in);

        // Hiển thị menu cho người dùng
        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Cập nhật quyền truy cập");
            System.out.println("2. Cập nhật thông tin tài khoản");

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
                    if (quyen == 2) {
                        datQuyenTruyCap();
                    } else System.out.println("Bạn không có quyền sử dụng quyền này");
                    break;
                case 2:
                    capNhatThongTinTaiKhoan(nhanVienList.getLast());
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        }
    }
    public void datQuyenTruyCap()
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
                capQuyenTruyCap();
                break;
            case 2:
                thuHoiQuyenTruyCap();
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ.");
                return;
        }
    }

    private void thuHoiQuyenTruyCap() {
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

    public void capQuyenTruyCap() {
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


}
