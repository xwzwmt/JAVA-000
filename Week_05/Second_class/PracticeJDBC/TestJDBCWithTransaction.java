package Week_05.Second_class.PracticeJDBC;

import java.sql.*;

public class TestJDBCWithTransaction {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://localhost:3306/vpr";
        String user = "root";
        String password = "Twy118023";

        JDBCUtils jdbcUtils = new JDBCUtils(url, user, password);
        Connection connection = jdbcUtils.getConnection();
        // 不自动提交
        connection.setAutoCommit(false);

        ResultSet rs = null;
        PreparedStatement preparedStatement = null;

        // 插入
//        String sql = "insert into voice_stream values(?, ?, ?, ?, ?)";
//        preparedStatement = connection.prepareStatement(sql);
//        preparedStatement.setInt(1, 3);
//        preparedStatement.setString(2, "0227");
//        preparedStatement.setString(3, "0130");
//        preparedStatement.setString(4, "tyjwmt");
//        preparedStatement.setString(5, "202011181605");
//        preparedStatement.execute();


//         //模拟程序出错，事务不提交，不会更新到mysql
//        int i = 1/0;
//        connection.commit();

        // 修改
//        String sql2 = "update voice_stream set base64 = ? where id = ?";
//        preparedStatement = connection.prepareStatement(sql2);
//        preparedStatement.setString(1, "ttyyjj");
//        preparedStatement.setInt(2, 3);
//        preparedStatement.executeUpdate();

//        // 模拟程序出错，事务不提交，不会更新到mysql
//        int i = 1/0;
//
//        connection.commit();

//        // 删除
//        String sql3 = "delete from voice_stream where id = ?";
//        preparedStatement = connection.prepareStatement(sql3);
//        preparedStatement.setInt(1, 1);
//        preparedStatement.executeUpdate();
//
//        // 模拟程序出错，事务不提交，不会更新到mysql
////        int i = 1/0;
//
//        connection.commit();

        // 查询
        // 查询
        String sql4 = "select *from voice_stream";
        preparedStatement = connection.prepareStatement(sql4);

        rs = preparedStatement.executeQuery(sql4);
        connection.commit();

        while (rs.next()) {
            int id = rs.getInt("id");
            String callId = rs.getString("callId");
            String base64 = rs.getString("base64");
            System.out.println(id + " " + callId + " " + base64);
        }
    }
}
