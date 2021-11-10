package DAO;

import MODELS.HoaDon;
import helper.XJdbc;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class HoaDonDAO implements IDAOService<HoaDon, Integer> {

    final String INSERT_SQL = "insert into HoaDon(IDNguoiDung, IDKhachHang, NgayLapHoaDon, TongGiaTien, HinhThucThanhToan, TrangThaiHoaDon)\n"
            + "values(?, ?, ?, ?, ?, ?)";
    final String UPDATE_SQL = "update HoaDon set IDNguoiDung=?,IDKhachHang=?,NgayLapHoaDon=?,TongGiaTien=?,HinhThucThanhToan=?,TrangThaiHoaDon=? where IDHoaDon=?";
    final String DELETE_SQL = "delete from HoaDon where IDHoaDon = ?";
    final String SELECT_ALL_SQL = "select * from HoaDon";
    final String SELECT_BY_ID_SQL = "select * from HoaDon where IDHoaDon=?";

    @Override
    public void insert(HoaDon entity) {
        XJdbc.update(INSERT_SQL, entity.getIdNguoiDung(), entity.getIdKhachHang(), entity.getNgayLap(), entity.getTongTien(), entity.getHinhThucThanhToan(), entity.getTrangThai());
    }

    @Override
    public void update(HoaDon entity) {
        XJdbc.update(UPDATE_SQL, entity.getIdNguoiDung(), entity.getIdKhachHang(), entity.getNgayLap(), entity.getTongTien(), entity.getHinhThucThanhToan(), entity.getTrangThai(), entity.getIdHoaDon());
    }

    @Override
    public void delete(Integer id) {
        XJdbc.update(DELETE_SQL, id);
    }

    @Override
    public List<HoaDon> selectAll() {
        return selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public HoaDon selectById(Integer id) {
        List<HoaDon> list = selectBySql(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<HoaDon> selectBySql(String sql, Object... agrs) {
        List<HoaDon> list = new ArrayList<>();
        try {
            ResultSet rs = XJdbc.query(sql, agrs);
            while (rs.next()) {
                HoaDon entity = new HoaDon();
                entity.setIdHoaDon(rs.getInt("IDHoaDon"));
                entity.setIdKhachHang(rs.getInt("IDKhachHang"));
                entity.setIdNguoiDung(rs.getInt("IDNguoiDung"));
                entity.setNgayLap(rs.getString("NgayLapHoaDon"));
                entity.setTongTien(rs.getDouble("TongGiaTien"));
                entity.setTrangThai(rs.getInt("TrangThaiHoaDon"));
                entity.setHinhThucThanhToan(rs.getString("HinhThucThanhToan"));
                list.add(entity);
            }
        } catch (Exception e) {
            throw new RuntimeException();
        }
        return list;
    }

}
