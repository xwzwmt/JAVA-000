package Week_05.Second_class.PracticeJDBC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestJDBC {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://localhost:3306/vpr";
        String user = "root";
        String password = "Twy118023";

        JDBCUtils jdbcUtils = new JDBCUtils(url, user, password);
        Connection connection = jdbcUtils.getConnection();
        System.out.println(connection);

        ResultSet rs = null;

        // 创建statement
        Statement statement = jdbcUtils.getStatement();

        // 插入
        String sql = "insert into voice_stream values(2, '12345', '22', 'test', '202011181534')";
        boolean b = statement.execute(sql);
        if (b) {
            System.out.println("Insert success");
        }

        // 修改
        String sql2 = "update voice_stream set base64 = 'tyj' where id = 1";
        int i = statement.executeUpdate(sql2);
        if (i > 0) {
            System.out.println("修改数据成功");
        }

        // 删除
        String sql3 = "delete from voice_stream where id = 2";
        int j = statement.executeUpdate(sql3);
        if (j > 0) {
            System.out.println("删除数据成功");
        }

        // 查询
        String sql4 = "select *from voice_stream";
        rs = statement.executeQuery(sql4);

        while (rs.next()) {
            int id = rs.getInt("id");
            String callId = rs.getString("callId");
            String base64 = rs.getString("base64");
            System.out.println(id + " " + callId + " " + base64);
        }
    }
}
