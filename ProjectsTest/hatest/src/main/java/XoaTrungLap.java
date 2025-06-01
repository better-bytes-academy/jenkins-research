package main.java;
public class XoaTrungLap {
    public static void main(String[] args) {
        int[] hahihi = {1,1,44,44,44,4,9,98,66,66,888,888};
        int[] ketQua = new int[hahihi.length];
        int dem = 0;
        for (int i = 0; i < hahihi.length; i++) {
            boolean daco = false;
            for (int j = 0; j < i; j++) {
                if (hahihi[i] == ketQua[j]) {
                    daco = true;
                }
            }
            if (!daco) {
                ketQua[dem] = hahihi[i];
                dem++;
            }
        }
        System.out.println("Mảng sau khi loại bỏ phần tử trùng lặp:");
        for (int i = 0; i < dem; i++) {
            System.out.print(ketQua[i] + " ");
        }
    }
}

