package main.bai3;

public class HinhTron extends HinhHoc {
    private double bankinh;
    public HinhTron(double bankinh){
        this.bankinh=bankinh;
    }
    public double dientich(){
        return Math.PI *bankinh*bankinh;
    }
    public double chuvi(){
        return Math.PI*2*bankinh;
    }
}
