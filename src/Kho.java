import java.util.ArrayList;
import java.util.Scanner;

public class Kho {
    private String maSanPham;
    private int soLuongSanPham;

    public String getMaSanPham() {
        return maSanPham;
    }

    public Kho() {
    }

    public Kho(String maSP, int soLuongSanPham) {
        this.maSanPham = maSP;
        this.soLuongSanPham = soLuongSanPham;
    }

    public int getSoLuongSanPham() {
        return soLuongSanPham;
    }

    public void setSoLuongSanPham(int soLuongSanPham) {
        this.soLuongSanPham = soLuongSanPham;
    }

    public void setMaSP(String maSP) {
        this.maSanPham = maSP;
    }

    public void capNhatSanPham() {
        ArrayList<SanPham> sanPhams = new ArrayList<>();
        sanPhams = hienThiDanhSachSanPham();

        for (SanPham sanpham : sanPhams) {
            System.out.println(sanpham.toString());
        }

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
            if(xacNhan.equalsIgnoreCase("y"))
            {
                // Cập nhật thông tin cho sản phẩm
                if (!tenMoi.isEmpty()) {
                    sanPhamTimKiem.setTenSP(tenMoi);
                }
                if (giaMoi != -1) {
                    sanPhamTimKiem.setGiaSP(giaMoi);
                }
                if (soLuongMoi >= 0) {
                    capNhatSoLuongSanPhamTrongKho(sanPhamTimKiem, soLuongMoi);
                }

                // Hiển thị thông tin sản phẩm sau khi cập nhật
                System.out.println("Thông tin sản phẩm sau khi cập nhật:");
                System.out.println(sanPhamTimKiem.toString());

            }
            else{
                System.out.println("Hủy xác nhận cập nhật, nhấn Enter để thoát");
                HeThong heThong = new HeThong();
                heThong.hienThiMenuKhachHang();

            }

        }
        else
        {
            System.out.println("Không tìm thấy sản phẩm có mã " + maSanPhamCanTim);
            System.out.print("Nhập 'q' để thoát: ");
            HeThong heThong = new HeThong();
            heThong.hienThiMenuKhachHang();

        }
    }

    public ArrayList<SanPham> hienThiDanhSachSanPham() {
        ArrayList<SanPham> sanPhams = new ArrayList<>();
        // Thêm các sản phẩm mẫu vào danh sách
        sanPhams.add(new SanPham("SP001", "Sản phẩm 1", 100.0));
        sanPhams.add(new SanPham("SP002", "Sản phẩm 2", 150.0));
        sanPhams.add(new SanPham("SP003", "Sản phẩm 3", 200.0));
        return sanPhams;
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
                }
                else
                {
                    // Thoát khỏi vòng lặp nếu giá hợp lệ
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Số lượng phải là một số nguyên. Vui lòng nhập lại.");
            }
        }
        return soLuongMoi;
    }


    public static void capNhatSoLuongSanPhamTrongKho(SanPham sanPham, int soLuongMoi) {
        ArrayList<Kho> sanPhamTrongKhoList = new ArrayList<>();
        // Thêm các sản phẩm vào danh sách (đây chỉ là một ví dụ, bạn cần thay thế bằng cách truy vấn CSDL thực tế)
        sanPhamTrongKhoList.add(new Kho("SP001", 100));
        sanPhamTrongKhoList.add(new Kho("SP002", 150));
        sanPhamTrongKhoList.add(new Kho("SP003", 200));

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
