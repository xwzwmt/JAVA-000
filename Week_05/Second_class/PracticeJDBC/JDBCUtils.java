package Week_05.Second_class.PracticeJDBC;



import java.sql.*;


public class JDBCUtils {
    private Connection jdbcConnection;
    private Statement statement;
    private ResultSet rs;


    public JDBCUtils(String url, String user, String password) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class.forName("com.mysql.jdbc.Driver").newInstance();  // MYSQL驱动
        try {
            jdbcConnection = DriverManager.getConnection(url, user, password);
            statement = jdbcConnection.createStatement();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public Connection getConnection() {
        return jdbcConnection;
    }

    public Statement getStatement() {
        return statement;
    }
}
