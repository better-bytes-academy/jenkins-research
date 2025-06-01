package main.java;

public class TongMang {
    public static void main(String[] args) {
        int[] hahihi = {10,45,66,44,65,33,24,65};
        int tong=0;
        for (int i=0; i<hahihi.length; i++){
            tong=tong+hahihi[i];
        }
        System.out.println("tong la: "+ tong);
    }
}
