package main.java;
import java.util.Scanner;
public class NhapSoNguyen {
    public static void main(String[] args) {
        Scanner hahihi = new Scanner(System.in);
        System.out.print("Nhập vào một số nguyên: ");
        int a = hahihi.nextInt();
        if (a >= 0) {
            System.out.println("Đây là số nguyên dương");
        } else {
            System.out.println("Đây là số nguyên âm");
        }
    }
}

