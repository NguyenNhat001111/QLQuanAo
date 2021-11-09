package MODELS;

public class TaiKhoan {
    
    private int idTaiKhoan;
    private String email;
    private String matKhau;
    private int trangThai;

    public TaiKhoan() {
    }

    public TaiKhoan(int idTaiKhoan, String email, String matKhau, int trangThai) {
        this.idTaiKhoan = idTaiKhoan;
        this.email = email;
        this.matKhau = matKhau;
        this.trangThai = trangThai;
    }

    public void setIdTaiKhoan(int idTaiKhoan) {
        this.idTaiKhoan = idTaiKhoan;
    }

    public int getIdTaiKhoan() {
        return idTaiKhoan;
    }

    public String getEmail() {
        return email;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }
    
}
