//import java.util.Scanner;
//
//public class TrungBinhCong {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Nhập số lượng phần tử n: ");
//        int n = scanner.nextInt();
//        if (n <= 0) {
//            System.out.println("Số lượng phần tử phải lớn hơn 0");
//        }
//        int[] mang = new int[n];
//        int tong = 0;
//        for (int i = 0; i < n; i++) {
//            System.out.print("Nhập phần tử thứ " + (i + 1) + ": ");
//            mang[i] = scanner.nextInt();
//            tong = tong + mang[i];
//        }
//        int trungbinh = (int) tong / n;
//        System.out.println("trung bình cộng mảng là: " + trungbinh);
//    }
//}
