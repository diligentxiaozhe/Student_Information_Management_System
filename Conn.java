package Advanced_java.Student_Information_Management_System;

import java.sql.*;

public class Conn {      // 创建类Conn

    public Connection con; // 声明Connection对象
    public static String user;
    public static String password;

    public Connection getConnection() { // 建立返回值为Connection的方法
        try { // 加载数据库驱动类
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        user = "root";//数据库登录名
        password = "123456";//密码
        try { // 通过访问数据库的URL获取数据库连接对象
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sims", user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con; // 按方法要求返回一个Connection对象
    }

    /*public static void main(String[] args) throws SQLException { // 主方法，测试连接
        String str="222222";
        String sql="insert into adminpsw values("+str+")";
        Conn conn=new Conn();
        Statement statement=conn.getConnection().createStatement();
        statement.executeUpdate(sql);
    }*/
}


