package baitaptenlopJ2EE;

import java.util.*;

/**
 *
 * @author MinhThuan
 */
public class QuanLySach {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<Sach> ds = new ArrayList<>();

    public static void main(String[] args) {
        int chon;
        do {
            System.out.println("\n--- MENU QUAN LY SACH ---");
            System.out.println("1. Them sach");
            System.out.println("2. Xoa sach");
            System.out.println("3. Thay đoi sach");
            System.out.println("4. Xuat danh sach sách");
            System.out.println("5. Tim sach co tieu đe chua 'Lap trinh'");
            System.out.println("6. Lay K sach co gia <= P");
            System.out.println("7. Tim sach theo danh sach tac gia");
            System.out.println("0. Thoat");
            System.out.print("Chọn: ");
            chon = sc.nextInt();
            sc.nextLine();

            switch (chon) {
                case 1 ->
                    themSach();
                case 2 ->
                    xoaSach();
                case 3 ->
                    suaSach();
                case 4 ->
                    xuatSach();
                case 5 ->
                    timSachLapTrinh();
                case 6 ->
                    laySachTheoGia();
                case 7 ->
                    timSachTheoTacGia();
            }
        } while (chon != 0);

    }

    static void themSach() {
        System.out.print("ma: ");
        int ma = sc.nextInt();
        sc.nextLine();
        System.out.print("Ten sach: ");
        String ten = sc.nextLine();
        System.out.print("Tac gia: ");
        String tg = sc.nextLine();
        System.out.print("Don gia: ");
        double gia = sc.nextDouble();

        ds.add(new Sach(ma, ten, tg, gia));
    }

    static void xoaSach() {
        System.out.print("Nhap ma sach can xoa: ");
        int ma = sc.nextInt();

        ds.removeIf(s -> s.getMaSach() == ma);
    }

    static void suaSach() {
        System.out.print("Nhap ma sach can sua: ");
        int ma = sc.nextInt();
        sc.nextLine();

        for (Sach s : ds) {
            if (s.getMaSach() == ma) {
                System.out.print("Ten moi: ");
                s.setTenSach(sc.nextLine());
                System.out.print("Tac gia moi: ");
                s.setTacGia(sc.nextLine());
                System.out.print("Gia moi: ");
                s.setDonGia(sc.nextDouble());
                break;
            }
        }
    }

    static void timSachLapTrinh() {
        for (Sach s : ds) {
            if (s.getTenSach().toLowerCase().contains("lap trinh")) {
                System.out.println(s);
            }
        }
    }

    static void laySachTheoGia() {
        System.out.print("Nhap K: ");
        int K = sc.nextInt();
        System.out.print("Nhap P: ");
        double P = sc.nextDouble();

        int dem = 0;
        for (Sach s : ds) {
            if (s.getDonGia() <= P && dem < K) {
                System.out.println(s);
                dem++;
            }
        }
    }

    static void timSachTheoTacGia() {
        System.out.print("Nhap so tac gia: ");
        int n = sc.nextInt();
        sc.nextLine();

        ArrayList<String> tgList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            tgList.add(sc.nextLine().toLowerCase());
        }

        for (Sach s : ds) {
            if (tgList.contains(s.getTacGia().toLowerCase())) {
                System.out.println(s);
            }
        }
    }

    static void xuatSach() {
        for (Sach s : ds) {
            System.out.println(s);
        }
    }

}
