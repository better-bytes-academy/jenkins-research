package main.bai3;

public class HinhTamGiac extends HinhHoc {
    private double canh1;
    private double canh2;
    private double canh3;
    public HinhTamGiac(double canh1, double canh2, double canh3) {
        this.canh1 = canh1;
        this.canh2 = canh2;
        this.canh3 = canh3;
        if (canh1 + canh2 < canh3 || canh1 + canh3 < canh2 || canh2 + canh3 < canh1) {
            System.out.println("đây không phải hình tam giác.");
        }
    }
    public double dientich(){
        double p=(canh1+canh2+canh3)/2;
        return Math.sqrt(p*(p-canh1)*(p-canh2)*(p-canh3));
    }
    public double chuvi(){
        return canh1 + canh2 + canh3;
    }
}
