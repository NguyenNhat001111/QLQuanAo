package DAO;

import IServices.IDAOService;
import MODELS.SanPham;
import helper.XJdbc;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SanPhamDAO implements IDAOService<SanPham, Integer> {

    final String INSERT_SQL = "insert into SanPham(IDDanhMuc, IDNhaSanXuat, TenSanPham, TrangThai)\n"
            + "values(?, ?, ?, ?)";
    final String UPDATE_SQL = "update SanPham set IDDanhMuc=?,IDNhaSanXuat=?,TenSanPham=?,TrangThai=? where IDSanPham=?";
    final String DELETE_SQL = "delete from SanPham where IDSanPham = ?";
    final String SELECT_ALL_SQL = "select * from SanPham";
    final String SELECT_BY_ID_SQL = "select * from SanPham where IDSanPham = ?";

    @Override
    public void insert(SanPham entity) {
        XJdbc.update(INSERT_SQL, entity.getIdDanhMuc(), entity.getIdNhaSanXuat(), entity.getTenSanPham(), entity.getTrangThaiSP());
    }

    @Override
    public void update(SanPham entity) {
        XJdbc.update(UPDATE_SQL, entity.getIdDanhMuc(), entity.getIdNhaSanXuat(), entity.getTenSanPham(), entity.getTrangThaiSP(), entity.getIdSanPham());
    }

    @Override
    public void delete(Integer id) {
        XJdbc.update(DELETE_SQL, id);
    }

    @Override
    public List<SanPham> selectAll() {
        return selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public SanPham selectById(Integer id) {
        List<SanPham> list = selectBySql(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<SanPham> selectBySql(String sql, Object... agrs) {
        List<SanPham> list = new ArrayList<>();
        try {
            ResultSet rs = XJdbc.query(sql, agrs);
            while (rs.next()) {
                SanPham entity = new SanPham();
                entity.setIdSanPham(rs.getInt("IDSanPham"));
                entity.setIdDanhMuc(rs.getInt("IDDanhMuc"));
                entity.setIdNhaSanXuat(rs.getInt("IDNhaSanXuat"));
                entity.setTenSanPham(rs.getString("TenSanPham"));
                entity.setTrangThaiSP(rs.getInt("TrangThai"));
                list.add(entity);
            }
        } catch (Exception e) {
            throw new RuntimeException();
        }
        return list;
    }

}
