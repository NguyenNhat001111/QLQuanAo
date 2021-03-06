package helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class XJdbc {

    public static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    public static String dburl = "jdbc:sqlserver://localhost:1433;databaseName=QLBQA";
    public static String user = "sa";
    public static String pass = "123";

    static {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }
    }

    public static PreparedStatement getStmt(String sql, Object... args) throws SQLException {
        Connection conn = DriverManager.getConnection(dburl, user, pass);
        PreparedStatement stmt;
        if (sql.trim().startsWith("{")) {
            stmt = conn.prepareCall(sql);
        } else {
            stmt = conn.prepareStatement(sql);
        }
        for (int i = 0; i < args.length; i++) {
            stmt.setObject(i + 1, args[i]);
        }
        return stmt;
    }

    public static int update(String sql, Object... agrs) {
        try {
            PreparedStatement stmt = XJdbc.getStmt(sql, agrs);
            try {
                return stmt.executeUpdate();
            } finally {
                stmt.getConnection().close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static ResultSet query(String sql, Object... agrs) throws SQLException {
        PreparedStatement stmt = XJdbc.getStmt(sql, agrs);
        return stmt.executeQuery();
    }

    public static Object values(String sql, Object... agrs) {
        try {
            ResultSet rs = query(sql, agrs);
            if (rs.next()) {
                return rs.getObject(0);
            }
            rs.getStatement().getConnection().close();
            return null;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
 
    
    //n???p truy???n gi?? tr??? ?????i s??? v??o prepareStatement
    //c?? th??? statment kh??ng c?? ?????i s???
    //prepareStatement c?? th??? l?? prepareStatement ho???c CallableStatements
    /*
    @param sql c??u l???nh sql statement (c?? ?????i s??? ho???c kh??ng)
    @param args m???ng ?????i s??? c???a c??u l???nh sql (c?? ho???c kh??ng)
    return pstmt l?? PrepareStatement ???? ???????c truy???n ?????i s???
    */
    public static PreparedStatement preparedStatement(String sql,Object...args)throws SQLException{
        Connection con=DriverManager.getConnection(dburl, user, pass);
        PreparedStatement pstmt=null;
        if(sql.startsWith("{"))pstmt=con.prepareCall(sql);    //c?? th??? g??n bi???n ki???u PreparedStatement l?? prepareCall (CallableStatement)
        else pstmt=con.prepareStatement(sql);
        for(int i=0; i<args.length;i++){
            pstmt.setObject(i+1, args[i]);
        }
        return pstmt;
    }
    
    //thao t??c (INSERT, UPDATE, DELETE)
    //th???c thi prepareStatement (???? ???????c truy???n ?????i s??? ??? h??m tr??n)
    //khi l??m ch??? c???n g???i h??m n??y, t??? trong h??m n??y n?? s??? g???i ra h??m preparedStatement ??? tr??n
    /*
    @param sql (String) c??u l???nh sql statement (c?? ?????i s??? ho???c kh??ng)
    @param args m???ng ?????i s??? c???a c??u l???nh sql (c?? ho???c kh??ng)
    */
    public static void executeUpdate(String sql,Object...args){
        try {
            PreparedStatement pstmt= preparedStatement(sql, args);
            try{
                pstmt.executeUpdate();
            }finally{
                pstmt.getConnection().close();            //????ng Connection t??? statement
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    
    //thao t??c truy v???n (SELECT)
    //th???c thi prepareStatement (???? ???????c truy???n ?????i s??? ??? h??m tr??n)
    //khi l??m ch??? c???n g???i h??m n??y, t??? trong h??m n??y n?? s??? g???i ra h??m preparedStatement ??? tr??n
    /*
    @param sql (String) c??u l???nh sql statement (c?? ?????i s??? ho???c kh??ng)
    @param args m???ng ?????i s??? c???a c??u l???nh sql (c?? ho???c kh??ng)
    */
    public static ResultSet executeQuery(String sql, Object...args){
        try {
            PreparedStatement pstmt=preparedStatement(sql, args);
            try{
                return pstmt.executeQuery();
            }finally{
                //pstmt.getConnection().close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);         //throw c??c l???i khi ch???y CT, VD kh??ng c?? return khi try b??? l???i
        }
    }

   
}
