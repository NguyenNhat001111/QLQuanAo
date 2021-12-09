package DAO;

import helper.XJdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ThongKeDAO {
    public static ResultSet rs = null;
    public static String thongke_SQL = "{CALL sp_ThongKe}";
    public static String guiemail_SQL = "{CALL sp_guiemail}";

    private List<Object[]> getListOfArray(String sql, String[] cols, Object... args) {
        try {
            List<Object[]> list = new ArrayList<>();
            rs = XJdbc.query(sql, args);
            while (rs.next()) {
                Object[] vals = new Object[cols.length];
                for (int i = 0; i < cols.length; i++) {
                    vals[i] = rs.getObject(cols[i]);
                }
                list.add(vals);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Object[]> getThongKe() {
          String sql = "{CALL sp_ThongKe}";
        String[] cols = {"Thoigian","SanPham","SoLuong","Doanhthu"};
        return this.getListOfArray(thongke_SQL, cols);
    }

    public List<Object[]> getguiemail(Date date) {
        String sql = "{call sp_guiemail(?)}";
        String[] cols = {"Email"};
        return this.getListOfArray(guiemail_SQL, cols);
    }

}
