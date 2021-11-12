/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import MODELS.NguoiDung;
import helper.XJdbc;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class NguoiDungDAO implements IDAOService<NguoiDung, Integer>{
    final String INSERT_SQL = "insert into NguoiDung(IDVaiTro, HoTenNhanVien, SDT, DiaChi, CCCD, TrangThai) values(?, ?, ?, ?, ?, ?)";
    final String UPDATE_SQL = "update NguoiDung set IDVaiTro=?, HoTenNhanVien=?, SDT=?, DiaChi=?, TrangThai=? where IDNguoiDung=?";
    final String SELECT_BY_ID_SQL= "select * from NguoiDung where IDNguoiDung=?";
    final String SELECT_ALL_SQL = "select * from NguoiDung";
    @Override
    public void insert(NguoiDung entity) {
        XJdbc.update(INSERT_SQL, entity.getIdNguoiDung(), entity.getHoTen(), entity.getSdt(), entity.getDiaChi(), entity.getCccd(), entity.getTrangThai());
    }

    @Override
    public void update(NguoiDung entity) {
        XJdbc.update(UPDATE_SQL, entity.getVaiTro(), entity.getHoTen(), entity.getSdt(), entity.getDiaChi(), entity.getTrangThai(), entity.getIdNguoiDung());
    }

    @Override
    public void delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<NguoiDung> selectAll() {
        return selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public NguoiDung selectById(Integer id) {
        List<NguoiDung> list = selectBySql(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<NguoiDung> selectBySql(String sql, Object... agrs) {
        List<NguoiDung> list = new ArrayList<>();
        try {
            ResultSet rs = XJdbc.query(sql, agrs);
            while (rs.next()) {
                NguoiDung entity = new NguoiDung();
                entity.setIdNguoiDung(rs.getInt("IDNguoiDung"));
                entity.setVaiTro(rs.getInt("IDVaiTro"));
                entity.setHoTen(rs.getString("HoTenNhanVien"));
                entity.setSdt(rs.getString("SDT"));
                entity.setDiaChi(rs.getString("DiaChi"));
                entity.setCccd(rs.getString("CCCD"));
                entity.setTrangThai(rs.getInt("TrangThai"));
                list.add(entity);
            }
        } catch (Exception e) {
            throw new RuntimeException();
        }
        return list;
    }
    
}
