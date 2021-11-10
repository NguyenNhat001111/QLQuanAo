package DAO;

import MODELS.HoaDonChiTiet;
import helper.XJdbc;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class HoaDonChiTietDAO implements IDAOService<HoaDonChiTiet, Integer> {

    final String INSERT_SQL = "insert into HoaDonChiTiet(IDHoaDon, IDCTSP, DonGia, SoLuong, ThanhTien,TrangThai)\n"
            + "values(?, ?, ?, ?, ?, ?))";
    final String UPDATE_SQL = "update HoaDonChiTiet set DonGia=?,SoLuong=?,ThanhTien=?,TrangThai=? where IDHoaDon=? and IDIDCTSP=?";
    final String DELETE_SQL = "delete from HoaDonChiTiet where IDHoaDon = ?";
    final String SELECT_ALL_SQL = "select * from HoaDonChiTiet";
    final String SELECT_BY_ID_SQL = "select * from HoaDonChiTiet where IDHoaDon = ?";

    @Override
    public void insert(HoaDonChiTiet entity) {
        XJdbc.update(INSERT_SQL, entity.getIdHoaDon(), entity.getIdChiTietSP(), entity.getDonGia(), entity.getSoLuong(), entity.getThanhTien(), entity.getTrangThai());
    }

    @Override
    public void update(HoaDonChiTiet entity) {
        XJdbc.update(UPDATE_SQL, entity.getDonGia(), entity.getSoLuong(), entity.getThanhTien(), entity.getTrangThai(), entity.getIdHoaDon(), entity.getIdChiTietSP());
    }

    @Override
    public void delete(Integer id) {
        XJdbc.update(DELETE_SQL, id);
    }

    @Override
    public List<HoaDonChiTiet> selectAll() {
        return selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public HoaDonChiTiet selectById(Integer id) {
        List<HoaDonChiTiet> list = selectBySql(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<HoaDonChiTiet> selectBySql(String sql, Object... agrs) {
        List<HoaDonChiTiet> list = new ArrayList<>();
        try {
            ResultSet rs = XJdbc.query(sql, agrs);
            while (rs.next()) {
                HoaDonChiTiet entity = new HoaDonChiTiet();
                entity.setIdHoaDon(rs.getInt("IDHoaDon"));
                entity.setIdChiTietSP(rs.getInt("IDCTSP"));
                entity.setDonGia(rs.getDouble("DonGia"));
                entity.setSoLuong(rs.getInt("SoLuong"));
                entity.setThanhTien(rs.getDouble("ThanhTien"));
                entity.setTrangThai(rs.getInt("TrangThai"));
                list.add(entity);
            }
        } catch (Exception e) {
            throw new RuntimeException();
        }
        return list;
    }

}
