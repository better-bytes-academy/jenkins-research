package main.java;

public class KiemTraChuoiDoiXung {
    public static void main(String[] args){
        String ha = "haahhaahhaah";
        boolean chuoi=false;
        for(int i=0;i<ha.length()/2;i++){
            if (ha.charAt(i) == ha.charAt(ha.length()-1-i)){
            chuoi=true;
            }
        }
        System.out.printf("Kết quả: "+chuoi);
    }
}
