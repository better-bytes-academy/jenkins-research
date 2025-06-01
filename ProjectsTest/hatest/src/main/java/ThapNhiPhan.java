package main.java;
public class ThapNhiPhan {
    public static void main(String[] args) {
        int soThapPhan = 2;
        String nhiPhan = "";

        int n = soThapPhan;
        while (n > 0) {
            int du = n % 2;
            nhiPhan = du + nhiPhan;
            n = n / 2;
        }
        System.out.println("nhị phân: " + nhiPhan);
    }
}