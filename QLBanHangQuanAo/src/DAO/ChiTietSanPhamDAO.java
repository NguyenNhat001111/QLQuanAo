package DAO;

import IServices.IDAOService;
import MODELS.ChiTietSanPham;
import helper.XJdbc;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ChiTietSanPhamDAO implements IDAOService<ChiTietSanPham, Integer> {

    final String INSERT_SQL = "insert into ChiTietSanPham(IDSanPham, MaSanPham, IDKichCo, IDMauSac, IDDonViTinh, IDChatLieu, IDGioiTinh, MoTa, GiaTien, TenChiTiet, Soluong, TrangThai)\n"
            + "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    final String UPDATE_SQL = "update ChiTietSanPham set IDSanPham=?,MaSanPham=?,IDKichCo=?,IDMauSac=?,IDDonViTinh=?, IDChatLieu=?, IDGioiTinh=?, MoTa=?, GiaTien=?, TenChiTiet=?, Soluong=?, TrangThai=? where IDCTSP=?";
    final String DELETE_SQL = "delete from ChiTietSanPham where IDCTSP = ?";
    final String SELECT_ALL_SQL = "select * from ChiTietSanPham";
    final String SELECT_BY_ID_SQL = "select * from ChiTietSanPham where IDCTSP = ?";
    final String SELECT_BY_MA_SQL = "select * from ChiTietSanPham where MaSanPham = ?";

    @Override
    public void insert(ChiTietSanPham entity) {
        XJdbc.update(INSERT_SQL,entity.getIdSanPham(),entity.getMaSP(),entity.getIdKichCo(),entity.getIdMauSac(),entity.getIdDonViTinh(),entity.getIdChatLieu(),entity.getIdGioiTinh(),entity.getMoTa(),entity.getGiaTien(),entity.getTenCT(),entity.getSoLuong(),entity.getTrangThai());
        
    }

    @Override
    public void update(ChiTietSanPham entity) {
       XJdbc.update(UPDATE_SQL,entity.getIdSanPham(),entity.getMaSP(),entity.getIdKichCo(),entity.getIdMauSac(),entity.getIdDonViTinh(),entity.getIdChatLieu(),entity.getIdGioiTinh(),entity.getMoTa(),entity.getGiaTien(),entity.getTenCT(),entity.getSoLuong(),entity.getTrangThai(),entity.getIdChiTietSP());

    }

    @Override
    public void delete(Integer id) {
        XJdbc.update(DELETE_SQL, id);
    }

    @Override
    public List<ChiTietSanPham> selectAll() {
        return selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public ChiTietSanPham selectById(Integer id) {
        List<ChiTietSanPham> list = selectBySql(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }
    
    public ChiTietSanPham selectByMa(String ma) {
        List<ChiTietSanPham> list = selectBySql(SELECT_BY_MA_SQL, ma);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<ChiTietSanPham> selectBySql(String sql, Object... agrs) {
        List<ChiTietSanPham> list = new ArrayList<>();
        try {
            ResultSet rs = XJdbc.query(sql, agrs);
            while (rs.next()) {
                ChiTietSanPham entity = new ChiTietSanPham();
                entity.setIdSanPham(rs.getInt("IDSanPham"));
                entity.setMaSP(rs.getString("MaSanPham"));
                entity.setIdChatLieu(rs.getInt("IDChatLieu"));
                entity.setIdChiTietSP(rs.getInt("IDCTSP"));
                entity.setIdDonViTinh(rs.getInt("IDDonViTinh"));
                entity.setIdGioiTinh(rs.getInt("IDGioiTinh"));
                entity.setGiaTien(rs.getFloat("GiaTien"));
                entity.setIdKichCo(rs.getInt("IDKichCo"));
                entity.setIdMauSac(rs.getInt("IDMauSac"));
                entity.setMoTa(rs.getString("MoTa"));
                entity.setSoLuong(rs.getInt("Soluong"));
                entity.setTenCT(rs.getString("TenChiTiet"));
                entity.setTrangThai(rs.getInt("TrangThai"));
                list.add(entity);
            }
        } catch (Exception e) {
            throw new RuntimeException();
        }
        return list;
    }

}
