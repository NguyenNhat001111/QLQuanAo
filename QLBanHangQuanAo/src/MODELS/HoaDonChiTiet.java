package MODELS;

public class HoaDonChiTiet {
    private int idHoaDon;
    private double donGia;
    private int soLuong;
    private int trangThai;

    public HoaDonChiTiet() {
    }

    public HoaDonChiTiet(int idHoaDon, double donGia, int soLuong, int trangThai) {
        this.idHoaDon = idHoaDon;
        this.donGia = donGia;
        this.soLuong = soLuong;
        this.trangThai = trangThai;
    }

    public double getDonGia() {
        return donGia;
    }

    public int getIdHoaDon() {
        return idHoaDon;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setIdHoaDon(int idHoaDon) {
        this.idHoaDon = idHoaDon;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }
    
}
