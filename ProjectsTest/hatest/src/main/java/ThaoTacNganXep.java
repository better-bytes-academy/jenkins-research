package main.java;
public class ThaoTacNganXep {
    public static void main(String[] args) {
        int[] hahihi = new int[5];
        int top = 0;
        top++;
        hahihi[top] = 10;
        top++;
        hahihi[top] = 20;
        top++;
        hahihi[top] = 500;
        System.out.println("Đỉnh ngăn xếp: " + hahihi[top]);
        top--;
        System.out.println("Đỉnh sau khi sửa: " + hahihi[top]);
    }
}
