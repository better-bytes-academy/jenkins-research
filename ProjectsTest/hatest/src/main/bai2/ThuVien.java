package main.bai2;

public class ThuVien {
    public void muonsach( Sach sach, String tensachmuon, int soluongmuon) {
        if (sach.gettensach().equalsIgnoreCase(tensachmuon)) {
            if (soluongmuon > 0 && soluongmuon <= sach.getsoluong()) {
                System.out.println("Mượn sách thành công sách: " +tensachmuon );
                sach.setsoluong(sach.getsoluong() - soluongmuon);
                System.out.println("Số lượng sách còn lại: "+ sach.getsoluong()+" quyển");
            } else {
                System.out.println("Không cho mượn.");
            }
        } else {
            System.out.println("Không tìm thấy sách.");
        }
    }
    public void trasach(Sach sach, String tensachtra, int soluongtra) {
        if (sach.gettensach().equalsIgnoreCase(tensachtra)) {
            int soluonghientai = sach.getsoluong();
            int tongsoluongbandau = sach.getsoluongbandau();
            int soluongdamuon = tongsoluongbandau - soluonghientai;
            if (soluongtra > 0 && soluongtra <= soluongdamuon) {
                sach.setsoluong(soluonghientai + soluongtra);
                System.out.println("Trả sách thành công.");
                System.out.println("Số lượng sách còn lại: " + sach.getsoluong() + " quyển.");
            } else {
                System.out.println("Số lượng trả không hợp lệ.");
            }
        } else {
            System.out.println("Mày có mượn sách này đâu mà đòi trả.");
        }
    }
    public void timsach(Sach sach,String tacgia){
        if(tacgia==sach.gettacgia()){
            System.out.println("đây là tác giả của cuốn sách: "+sach.gettensach()+" với số lượng: "+sach.getsoluong());
        }else{
            System.out.println("không có cuốn sách nào của tác giả này.");
        }
    }
}

