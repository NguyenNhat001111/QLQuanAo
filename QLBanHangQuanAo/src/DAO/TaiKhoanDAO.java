package DAO;

import MODELS.TaiKhoan;
import helper.XJdbc;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class TaiKhoanDAO implements IDAOService<TaiKhoan, Integer> {
    final String INSERT_SQL = "insert into TaiKhoan(Email, IDNguoiDung, MatKhau, TrangThai) values(?, ?, ?, ?)";
    final String UPDATE_SQL = "update TaiKhoan set MatKhau=?, TrangThai=? where IDTaiKhoan=?";
    final String SELECT_BY_ID_SQL = "select * from TaiKhoan where IDTaiKhoan=?";
    final String SELECT_ALL_SQL = "select * from TaiKhoan";
    @Override
    public void insert(TaiKhoan entity) {
        XJdbc.update(INSERT_SQL, entity.getEmail(), entity.getIdNguoiDung(), entity.getMatKhau(), entity.getTrangThai());
    }

    @Override
    public void update(TaiKhoan entity) {
        XJdbc.update(UPDATE_SQL, entity.getMatKhau(), entity.getTrangThai(), entity.getIdTaiKhoan());
    }

    @Override
    public void delete(Integer id) {
       
    }

    @Override
    public List<TaiKhoan> selectAll() {
        return selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public TaiKhoan selectById(Integer id) {
       List<TaiKhoan> list = selectBySql(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<TaiKhoan> selectBySql(String sql, Object... agrs) {
        List<TaiKhoan> list = new ArrayList<>();
        try {
            ResultSet rs = XJdbc.query(sql, agrs);
            while (rs.next()) {
                TaiKhoan entity = new TaiKhoan();
                entity.setIdTaiKhoan(rs.getInt("IDTaiKhoan"));
                entity.setEmail(rs.getString("Email"));
                entity.setIdNguoiDung(rs.getInt("IDNguoiDung"));
                entity.setMatKhau(rs.getString("MatKhau"));
                entity.setTrangThai(rs.getInt("TrangThai"));
                list.add(entity);
            }
        } catch (Exception e) {
            throw new RuntimeException();
        }
        return list;
    }
}
