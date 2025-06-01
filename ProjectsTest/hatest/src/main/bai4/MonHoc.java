package main.bai4;
import java.util.ArrayList;

public class MonHoc {
    private String monhoc;
    private int sohocsinhdangki;
    private ArrayList<SinhVien> danhsachsinhvien = new ArrayList<>();
    public MonHoc(String monhoc, int sohocsinhdangki) {
        this.monhoc = monhoc;
        this.sohocsinhdangki = sohocsinhdangki;
    }
    public String getMonhoc() {
        return monhoc;
    }
    public int getSohocsinhdangki() {
        return sohocsinhdangki;
    }
    public boolean themSinhVien(SinhVien sv) {
        if (!danhsachsinhvien.contains(sv)) {
            danhsachsinhvien.add(sv);
            sohocsinhdangki = danhsachsinhvien.size();
            return true;
        }
        return false;
    }
    public boolean xoaSinhVien(SinhVien sv) {
        boolean removed = danhsachsinhvien.remove(sv);
        if (removed) {
            sohocsinhdangki= danhsachsinhvien.size();
        }
        return removed;
    }
}
