package main.bai4;

public class ChucNang {
    public void themsinhvien(SinhVien sv, MonHoc mh) {
        if (mh.themSinhVien(sv)) {
            System.out.println("Thêm sinh viên " + sv.gettensinhvien() + " vào môn " + mh.getMonhoc() + " thành công");
        } else {
            System.out.println("Sinh viên đã tồn tại trong môn học");
        }
    }
    public void xoasinhvien(SinhVien sv, MonHoc mh) {
        if (mh.xoaSinhVien(sv)) {
            System.out.println("Xoá sinh viên " + sv.gettensinhvien() + " khỏi môn " + mh.getMonhoc() + " thành công");
        } else {
            System.out.println("Sinh viên không tồn tại trong môn học");
        }
    }
    public double tinhdiemtrungbinh(SinhVien sv) {
        return (sv.getdiemTH() + sv.getdiemGT() + sv.getdiemTC()) / 3;
    }
}

