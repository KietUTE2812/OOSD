import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<NhanVien> nhanVienList = new ArrayList<>();
    public static NhanVien nhanVien1 = new NhanVien("NV001", "Nguyen Van A", "0123456789", "nv1@example.com", "Address 1", (byte) 1, "user1", "pass1");
    public static NhanVien nhanVien2 = new NhanVien("NV002", "Nguyen Van B", "0987654321", "nv2@example.com", "Address 2", (byte) 1, "user2", "pass2");
    public static NhanVien nhanVien3 = new NhanVien("NV003", "Nguyen Thi C", "0456789123", "nv3@example.com", "Address 3", (byte) 2, "user3", "pass3");

    public static List<KhachHang> khachHangList = new ArrayList<>();

    public static KhachHang kh1 = new KhachHang("KH001", "Dang Thanh Binh", "0399915678", "abc@gmail.com", "HCM", "thanhbinhne", "123");
    public static KhachHang kh2 = new KhachHang("thanhbinhdang", "123");
    public static KhachHang kh3 = new KhachHang("thanhbinhdayne", "123");

    public static Byte role;

    public static void main(String[] args) {
        nhanVienList.add(nhanVien1);
        nhanVienList.add(nhanVien2);
        nhanVienList.add(nhanVien3);

        khachHangList.add((kh1));
        khachHangList.add((kh2));
        khachHangList.add((kh3));
        dangNhap();

        //String username = UserSession.getInstance().getUsername();

        role = UserSession.getInstance().getRole();
        if (role == 2 || role == 1) {
            HeThong ht = new HeThong(nhanVienList);
        } else if (role == 0) {
            HeThong ht = new HeThong();
        } else {
            System.out.println("Vai trò không hợp lệ");
        }

        //HeThong ht = new HeThong(nhanVienList);

    }

    public static void dangNhap() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập tên người dùng: ");
        String userName = sc.nextLine();

        System.out.print("Nhập mật khẩu: ");
        String password = sc.nextLine();

        if (checkDangNhap(userName, password)) {
            System.out.println("Đăng nhập thành công! Nhấn Enter để tiếp tục.");
        } else {
            System.out.println("Tên người dùng hoặc mật khẩu không chính xác.");
        }
        sc.nextLine();


    }

    public static boolean checkDangNhap(String username, String pass) {
        for (NhanVien nv : nhanVienList) {
            if (username.equals(nv.getTaiKhoan()) && pass.equals(nv.getMatKhau())) {
                UserSession.getInstance().setRole(nv.getQuyenTruyCap());
                UserSession.getInstance().setMaNV(nv.getMaNV());
                UserSession.getInstance().setDiaChi(nv.getTaiKhoan());
                UserSession.getInstance().setMatKhau(nv.getMatKhau());
                UserSession.getInstance().setDiaChi(nv.getDiaChi());
                UserSession.getInstance().setEmail(nv.getEmail());
                UserSession.getInstance().setsDT(nv.getsDT());

                return true;
            }
        }
        for (KhachHang kh : khachHangList) {
            if (username.equals(kh.getTaiKhoan()) && pass.equals(kh.getMatKhau())) {
                UserSession.getInstance().setRole((byte) 0);
                UserSession.getInstance().setMaKH(kh.getMaKH());
                UserSession.getInstance().setDiaChi(kh.getTaiKhoan());
                UserSession.getInstance().setMatKhau(kh.getMatKhau());
                UserSession.getInstance().setDiaChi(kh.getDiaChi());
                UserSession.getInstance().setEmail(kh.getEmail());
                UserSession.getInstance().setsDT(kh.getsDT());
                return true;
            }
        }
        return false;
    }
}