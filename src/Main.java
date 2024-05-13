import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main {
    static List<NhanVien> nhanVienList = new ArrayList<>();
    public static NhanVien nhanVien1 = new NhanVien("NV001", "Nguyen Van A", "0123456789", "nv1@example.com", "Address 1", (byte) 0, "user1", "pass1");
    public static NhanVien nhanVien2 = new NhanVien("NV002", "Nguyen Van B", "0987654321", "nv2@example.com", "Address 2", (byte) 1, "user2", "pass2");
    public static NhanVien nhanVien3 = new NhanVien("NV003", "Nguyen Thi C", "0456789123", "nv3@example.com", "Address 3", (byte) 2, "user3", "pass3");


    public static void main(String[] args) {
//        String username = UserSession.getInstance().getUsername();
//        nhanVienList.add(nhanVien1);
//        nhanVienList.add(nhanVien2);
//        nhanVienList.add(nhanVien3);
//        Byte role = UserSession.getInstance().getRole();
//        if (role == 2 || role == 1) {
//            HeThong ht = new HeThong();
//        } else if (role == 0) {
//            HeThong ht = new HeThong(nhanVienList);
//        } else {
//            System.out.println("Vai trò không hợp lệ");
//        }

        HeThong ht = new HeThong(nhanVienList);

    }
}