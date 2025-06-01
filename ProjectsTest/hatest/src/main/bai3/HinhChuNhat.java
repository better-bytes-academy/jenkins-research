package main.bai3;

public class HinhChuNhat extends HinhHoc {
    private double chieudai;
    private double chieurong;
    public HinhChuNhat(double chieudai, double chieurong){
        this.chieudai=chieudai;
        this.chieurong=chieurong;
    }
    public double dientich(){
        return chieudai*chieurong;
    }
    public double chuvi(){
        return (chieudai+chieurong)*2;
    }
}
