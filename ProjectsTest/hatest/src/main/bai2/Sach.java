package main.bai2;

public class Sach {
    private String tensach;
    private String tacgia;
    private int soluong;
    private int soluongbandau;
    public Sach(String tensach,String tacgia,int soluong){
        this.tensach=tensach;
        this.tacgia=tacgia;
        this.soluong=soluong;
        this.soluongbandau=soluong;
    }
    public String gettensach(){
        return tensach;
    }
    public String gettacgia(){
        return tacgia;
    }
    public int getsoluong(){
        return soluong;
    }
    public int getsoluongbandau() {
        return soluongbandau;
    }
    public void setsoluong(int soluong){
        this.soluong = soluong;
    }
}
