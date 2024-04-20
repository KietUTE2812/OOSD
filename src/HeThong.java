import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HeThong {

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
