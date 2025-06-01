package main.java;
public class DungMangTimSoNguyenTo {
    public static void main(String[] args) {
        int n = 30;
        int[] hahihi = new int[n];
        int dem = 0;
        for (int i = 2; i <= n; i++) {
            boolean songuyento = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    songuyento = false;
                }
            }
            if (songuyento) {
                hahihi[dem] = i;
                dem++;
            }
        }
        System.out.println("Các số nguyên tố từ 1 đến " + n + ":");
        for (int i = 0; i < dem; i++) {
            System.out.print(hahihi[i] + " ");
        }
    }
}
