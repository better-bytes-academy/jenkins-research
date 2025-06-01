package main.bai4;

public class Main {
    public static void main(String[] args) {
        SinhVien sinhvien1 = new SinhVien("truongha", 111, 6, 7, 8);
        SinhVien sinhvien2 = new SinhVien("truonghahihi", 222, 3, 6, 5);

        MonHoc tinhoc = new MonHoc("Tin Học",0);
        MonHoc giaitich = new MonHoc("Giải Tích",0);
        MonHoc thechat = new MonHoc("Thể Chất",0);

        ChucNang cn = new ChucNang();
        cn.themsinhvien(sinhvien1, tinhoc);
        cn.themsinhvien(sinhvien1, giaitich);
        cn.themsinhvien(sinhvien1, thechat);

        cn.themsinhvien(sinhvien2, tinhoc);
        cn.themsinhvien(sinhvien2, giaitich);
        cn.themsinhvien(sinhvien2, thechat);

        cn.xoasinhvien(sinhvien1, tinhoc);

        System.out.println("danh sách sinh viên đăng kí môn tin học: "+tinhoc.getSohocsinhdangki());
        System.out.println("danh sách sinh viên đăng kí môn giải tích: "+giaitich.getSohocsinhdangki());
        System.out.println("Điểm trung bình của " +sinhvien1.gettensinhvien()+ " mã sinh viên: "+ sinhvien1.getmaso() + " điểm: " + cn.tinhdiemtrungbinh(sinhvien1));
    }
}

