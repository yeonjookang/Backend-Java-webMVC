package core.jdbc;

import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionManager {

    /**
     * h2 데이터베이스와 connection을 연결하는 클래스
     * JDBC를 사용함으로써 DB가 바뀌어도 Connection 연결 부분을 바꿀 필요가 없다.
     */

    private static final String DB_DRIVER = "org.h2.Driver";
    private static final String DB_URL = "jdbc:h2:~/jwp-basic";
    private static final String DB_USERNAME = "sa";
    private static final String DB_PW = "";

    private static BasicDataSource ds;
    public static DataSource getDataSource() {
        if (ds == null) {
            ds = new BasicDataSource();
            ds.setDriverClassName(DB_DRIVER);
            ds.setUrl(DB_URL);
            ds.setUsername(DB_USERNAME);
            ds.setPassword(DB_PW);
        }
        return ds;
    }

    public static Connection getConnection() {
        try {
            //내부적으로 적절한 드라이버를 찾아 반환
            return getDataSource().getConnection();
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }
}
