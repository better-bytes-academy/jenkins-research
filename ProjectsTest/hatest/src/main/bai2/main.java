package main.bai2;

public class main {
    public static void main(String[] args) {
        Sach sach1= new Sach("hatruongtrong","ha", 100);
        Sach sach2= new Sach("hahihi","haha", 100);
        Sach sach3= new Sach("hahuhu","hahaha", 100);

        ThuVien TV= new ThuVien();
        TV.muonsach(sach1,"hatruongtrong",9);
        TV.trasach(sach1,"hatruongtrong", 4);
        TV.timsach(sach2, "haha");
    }
}
