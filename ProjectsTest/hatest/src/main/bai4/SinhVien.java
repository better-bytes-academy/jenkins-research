package main.bai4;

public class SinhVien {
    private String tensinhvien;
    private int maso;
    private int diemTH;
    private int diemGT;
    private int diemTC;
    public SinhVien(String tensinhvien, int maso, int diemTH, int diemGT, int diemTC) {
        this.tensinhvien = tensinhvien;
        this.maso = maso;
        this.diemTH = diemTH;
        this.diemGT = diemGT;
        this.diemTC = diemTC;
    }
    public String gettensinhvien() {
        return tensinhvien;
    }
    public int getmaso(){
        return maso;
    }
    public int getdiemTH() {
        return diemTH;
    }
    public int getdiemGT() {
        return diemGT;
    }
    public int getdiemTC() {
        return diemTC;
    }
}
