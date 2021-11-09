package MODELS;

public class SanPham {
    
    private String idSanPham;
    private String tenSanPham;
    private int trangThaiSP;

    public SanPham() {
    }

    public SanPham(String idSanPham, String tenSanPham, int trangThaiSP) {
        this.idSanPham = idSanPham;
        this.tenSanPham = tenSanPham;
        this.trangThaiSP = trangThaiSP;
    }

    public String getIdSanPham() {
        return idSanPham;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public int getTrangThaiSP() {
        return trangThaiSP;
    }

    public void setIdSanPham(String idSanPham) {
        this.idSanPham = idSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public void setTrangThaiSP(int trangThaiSP) {
        this.trangThaiSP = trangThaiSP;
    }
    
}
