package main.bai1;
public class TaiKhoanNganHang {
    private double sodu;
    public TaiKhoanNganHang(double sodu){
        this.sodu =sodu;
    }
     public void guitien(double tiengui){
        if(tiengui<0){
            System.out.println("không hợp lệ");
        }else{
            sodu = sodu + tiengui;
            System.out.println("số dư hiện tại: "+sodu);
        }
    }
    public void ruttien(double ruttien){
        if(ruttien<0){
            System.out.println("không hợp lệ");
        }else if(ruttien>sodu){
            System.out.println("số dư không đủ");
        }else {
            sodu = sodu - ruttien;
            System.out.println("rút tiền thành công, số dư hiện tại là: "+sodu);
        }
    }
    public double kiemtrasodu(){
        return sodu;
    }
    public static void main(String[] args){
        TaiKhoanNganHang hahihi = new TaiKhoanNganHang(1000);
        hahihi.guitien(40);
        hahihi.ruttien(200);
        hahihi.ruttien(888888);
        System.out.println("Số dư hiện tại: "+hahihi.kiemtrasodu());
    }
}
