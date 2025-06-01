package main.java;
public class MinMaxMang {
    public static void main(String[] args) {
        int[] hahihi ={99,32,142,23,9,3,2,41,1223,234};
        int min = hahihi[0];
        int max = hahihi[0];
        for(int i=1;i<hahihi.length;i++){
            if(hahihi[i] < min){
                min=hahihi[i];
            }
        }
        for(int i=0;i<hahihi.length;i++){
            if(hahihi[i] > max){
                max=hahihi[i];
            }
        }
        System.out.println("Giá trị nhỏ nhất trong mảng là: " + min);
        System.out.println("Giá trị lớn nhất trong mảng là: " + max);
    }
}
