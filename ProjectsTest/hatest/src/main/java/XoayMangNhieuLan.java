package main.java;
public class XoayMangNhieuLan {
    public static void main(String[] args){
        int[] hahihi={1, 2, 3, 4, 5};
        int k = 4;
        for (int lan=0;lan<k;lan++){
            int last=hahihi[hahihi.length-1];
            for (int i=hahihi.length-1;i>0;i--){
                hahihi[i]=hahihi[i-1];
            }
            hahihi[0]=last;
        }
        for (int x : hahihi) {
            System.out.print(x+" ");
        }
    }
}

