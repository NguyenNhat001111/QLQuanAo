package MODELS;

public class ChiTietSanPham {

    private int idChiTietSP;
    private String moTa;
    private double giaTien;
    private String tenCT;
    private int trangThai;
    private int soLuong;

    public ChiTietSanPham() {
    }

    public ChiTietSanPham(int idChiTietSP, String moTa, double giaTien, String tenCT, int trangThai, int soLuong) {
        this.idChiTietSP = idChiTietSP;
        this.moTa = moTa;
        this.giaTien = giaTien;
        this.tenCT = tenCT;
        this.trangThai = trangThai;
        this.soLuong = soLuong;
    }

    public void setIdChiTietSP(int idChiTietSP) {
        this.idChiTietSP = idChiTietSP;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public void setGiaTien(double giaTien) {
        this.giaTien = giaTien;
    }

    public void setTenCT(String tenCT) {
        this.tenCT = tenCT;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getIdChiTietSP() {
        return idChiTietSP;
    }

    public String getMoTa() {
        return moTa;
    }

    public double getGiaTien() {
        return giaTien;
    }

    public String getTenCT() {
        return tenCT;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public int getSoLuong() {
        return soLuong;
    }

}
