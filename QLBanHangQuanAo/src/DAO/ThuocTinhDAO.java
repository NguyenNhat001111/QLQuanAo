package DAO;

import MODELS.ChatLieu;
import MODELS.DanhMuc;
import MODELS.DonViTinh;
import MODELS.KichCo;
import MODELS.MauSac;
import MODELS.NhaSanXuat;
import helper.XJdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ThuocTinhDAO {
    
    public void insertDanhMuc(DanhMuc entity) {
        XJdbc.update("insert into DanhMucSP values(?)", entity.getDanhMuc());
    }
    
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
    
    public List<DonViTinh> selectDonViTinh() {
        String sql = "select * from DonVi";
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
}
