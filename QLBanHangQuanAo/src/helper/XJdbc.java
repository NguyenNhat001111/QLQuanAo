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
 
    
    //nạp truyền giá trị đối số vào prepareStatement
    //có thể statment không có đối số
    //prepareStatement có thể là prepareStatement hoặc CallableStatements
    /*
    @param sql câu lệnh sql statement (có đối số hoặc không)
    @param args mảng đối số của câu lệnh sql (có hoặc không)
    return pstmt là PrepareStatement đã được truyền đối số
    */
    public static PreparedStatement preparedStatement(String sql,Object...args)throws SQLException{
        Connection con=DriverManager.getConnection(dburl, user, pass);
        PreparedStatement pstmt=null;
        if(sql.startsWith("{"))pstmt=con.prepareCall(sql);    //có thể gán biến kiểu PreparedStatement là prepareCall (CallableStatement)
        else pstmt=con.prepareStatement(sql);
        for(int i=0; i<args.length;i++){
            pstmt.setObject(i+1, args[i]);
        }
        return pstmt;
    }
    
    //thao tác (INSERT, UPDATE, DELETE)
    //thực thi prepareStatement (đã được truyền đối số ở hàm trên)
    //khi làm chỉ cần gọi hàm này, từ trong hàm này nó sẽ gọi ra hàm preparedStatement ở trên
    /*
    @param sql (String) câu lệnh sql statement (có đối số hoặc không)
    @param args mảng đối số của câu lệnh sql (có hoặc không)
    */
    public static void executeUpdate(String sql,Object...args){
        try {
            PreparedStatement pstmt= preparedStatement(sql, args);
            try{
                pstmt.executeUpdate();
            }finally{
                pstmt.getConnection().close();            //đóng Connection từ statement
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    
    //thao tác truy vấn (SELECT)
    //thực thi prepareStatement (đã được truyền đối số ở hàm trên)
    //khi làm chỉ cần gọi hàm này, từ trong hàm này nó sẽ gọi ra hàm preparedStatement ở trên
    /*
    @param sql (String) câu lệnh sql statement (có đối số hoặc không)
    @param args mảng đối số của câu lệnh sql (có hoặc không)
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
            throw new RuntimeException(ex);         //throw các lỗi khi chạy CT, VD không có return khi try bị lỗi
        }
    }

   
}
