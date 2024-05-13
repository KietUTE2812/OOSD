import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HeThong {


    public HeThong() {
        Scanner scanner = new Scanner(System.in);


        GioHang gioHang =new GioHang();
        List<SanPhamTrongGioHang> danhSachSP = new ArrayList<>();
        danhSachSP.add(new SanPhamTrongGioHang("SP001", "Máy tính", 15.0, 2));
        danhSachSP.add(new SanPhamTrongGioHang("SP002", "Chuột", 25.0, 1));
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
}
