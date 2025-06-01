package main.bai3;

public class Main {
    public static void main(String[] args) {
        HinhTron HT  =new HinhTron(4);
        HinhHoc HCN=new HinhChuNhat(5,6);
        HinhHoc HTG=new HinhTamGiac(5,5,6);
        System.out.println("diện tích hình tròn: "+ HT.dientich()+" chu vi hình tròn: "+HT.chuvi());
        System.out.println("diện tích hình chữ nhật: "+ HCN.dientich()+" chu vi hình chữ nhật: "+HCN.chuvi());
        System.out.println("diện tích hình tam giác: "+ HTG.dientich()+" chu vi hình tam giác: "+HTG.chuvi());
    }
}
