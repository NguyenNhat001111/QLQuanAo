package DAO;

import MODELS.ChatLieu;
import MODELS.DanhMuc;
import MODELS.DonViTinh;
import MODELS.GioiTinh;
import MODELS.KichCo;
import MODELS.MauSac;
import MODELS.NhaSanXuat;
import helper.XJdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ThuocTinhDAO {
    
    public List<DanhMuc> selectDanhMuc() {
        String sql = "select * from DanhMucSP";
        List<DanhMuc> list = new ArrayList<>();
        try {
            ResultSet rs = XJdbc.query(sql);
            while (rs.next()) {
                list.add(new DanhMuc(rs.getInt(1), rs.getString(2)));
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    
    public DanhMuc selectByIDDanhMuc(Integer id) {
        String sql = "select * from DanhMucSP where IDDanhMuc = ?";
        DanhMuc dm = new DanhMuc();
        try {
            ResultSet rs = XJdbc.query(sql, id);
            while (rs.next()) {
                dm.setIdDanhMuc(rs.getInt(1));
                dm.setDanhMuc(rs.getString(2));
            }
            rs.getStatement().getConnection().close();
            return dm;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public List<NhaSanXuat> selectNSX() {
        String sql = "select * from NhaSanXuat";
        List<NhaSanXuat> list = new ArrayList<>();
        try {
            ResultSet rs = XJdbc.query(sql);
            while (rs.next()) {
                list.add(new NhaSanXuat(rs.getInt(1), rs.getString(2)));
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    
    public NhaSanXuat selectByIDNSX(Integer id) {
        String sql = "select * from NhaSanXuat where IDNhaSanXuat = ?";
        NhaSanXuat nsx = new NhaSanXuat();
        try {
            ResultSet rs = XJdbc.query(sql, id);
            while (rs.next()) {
                nsx.setIdNhaSanXuat(rs.getInt(1));
                nsx.setNhaSanXuat(rs.getString(2));
            }
            rs.getStatement().getConnection().close();
            return nsx;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public List<KichCo> selectKichCo() {
        String sql = "select * from KichCoSP";
        List<KichCo> list = new ArrayList<>();
        try {
            ResultSet rs = XJdbc.query(sql);
            while (rs.next()) {
                list.add(new KichCo(rs.getInt(1), rs.getString(2)));
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    
    public KichCo selectByIDKichCo(Integer id) {
        String sql = "select * from KichCoSP where IDKichCo = ?";
        KichCo kc = new KichCo();
        try {
            ResultSet rs = XJdbc.query(sql, id);
            while (rs.next()) {
                kc.setIdKichCo(rs.getInt(1));
                kc.setKichCo(rs.getString(2));
            }
            rs.getStatement().getConnection().close();
            return kc;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public List<MauSac> selectMauSac() {
        String sql = "select * from MauSac";
        List<MauSac> list = new ArrayList<>();
        try {
            ResultSet rs = XJdbc.query(sql);
            while (rs.next()) {
                list.add(new MauSac(rs.getInt(1), rs.getString(2)));
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    
    public MauSac selectByIDMauSac(Integer id) {
        String sql = "select * from MauSac where IDMauSac = ?";
        MauSac ms = new MauSac();
        try {
            ResultSet rs = XJdbc.query(sql, id);
            while (rs.next()) {
                ms.setIdMauSac(rs.getInt(1));
                ms.setMauSac(rs.getString(2));
            }
            rs.getStatement().getConnection().close();
            return ms;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    
    public List<ChatLieu> selectChatLieu() {
        String sql = "select * from ChatLieu";
        List<ChatLieu> list = new ArrayList<>();
        try {
            ResultSet rs = XJdbc.query(sql);
            while (rs.next()) {
                list.add(new ChatLieu(rs.getInt(1), rs.getString(2)));
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    
    public ChatLieu selectByIDChatLieu(Integer id) {
        String sql = "select * from ChatLieu where IDChatLieu = ?";
        ChatLieu cl = new ChatLieu();
        try {
            ResultSet rs = XJdbc.query(sql, id);
            while (rs.next()) {
                cl.setIdChatLieu(rs.getInt(1));
                cl.setChatLieu(rs.getString(2));
            }
            rs.getStatement().getConnection().close();
            return cl;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    
    public List<DonViTinh> selectDonViTinh() {
        String sql = "select * from DonViTinh";
        List<DonViTinh> list = new ArrayList<>();
        try {
            ResultSet rs = XJdbc.query(sql);
            while (rs.next()) {
                list.add(new DonViTinh(rs.getInt(1), rs.getString(2)));
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    
    public DonViTinh selectByIDDonViTinh(Integer id) {
        String sql = "select * from DonViTinh where IDDonViTinh = ?";
        DonViTinh dvt = new DonViTinh();
        try {
            ResultSet rs = XJdbc.query(sql, id);
            while (rs.next()) {
                dvt.setIdDonViTinh(rs.getInt(1));
                dvt.setDonViTinh(rs.getString(2));
            }
            rs.getStatement().getConnection().close();
            return dvt;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    
    public List<GioiTinh> selectGioiTinh() {
        String sql = "select * from GioiTinh";
        List<GioiTinh> list = new ArrayList<>();
        try {
            ResultSet rs = XJdbc.query(sql);
            while (rs.next()) {
                list.add(new GioiTinh(rs.getInt(1), rs.getString(2)));
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    
    public GioiTinh selectByIDGioiTinh(Integer id) {
        String sql = "select * from GioiTinh where IDGioiTinh = ?";
        GioiTinh gt = new GioiTinh();
        try {
            ResultSet rs = XJdbc.query(sql, id);
            while (rs.next()) {
                gt.setIdGioiTinh(rs.getInt(1));
                gt.setGioiTinh(rs.getString(2));
            }
            rs.getStatement().getConnection().close();
            return gt;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}
