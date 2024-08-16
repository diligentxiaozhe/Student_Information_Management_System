package Advanced_java.Student_Information_Management_System;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AllAccount extends JFrame {
    public AllAccount(Connection connection, Statement statement) throws SQLException {
        JPanel jp = new JPanel(new BorderLayout());
        JButton bt2 = new JButton("返回首页");
        String[] colName = {"登陆身份", "登录账号", "登陆密码"};
        String[][] data;

        int cnt = 0;
        String sql = "select * from password";
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            cnt++;
        }
        resultSet.close();
        ResultSet resultSet1 = statement.executeQuery(sql);
        data = new String[cnt][3];
        int i = 0;
        while (resultSet1.next()) {
            String identity = resultSet1.getString("identity");
            String acc_num = resultSet1.getString("acc_num");
            String psw = resultSet1.getString("psw");
            data[i][0] = identity;
            data[i][1] = acc_num;
            data[i][2] = psw;
            i++;
        }
            /*String str ;
            br = new BufferedReader(new FileReader("Password.txt"));

            while (br.readLine() != null)
            {
                cnt++;
            }
            br.close();
            data = new String[cnt][3];
            br = new BufferedReader(new FileReader("Password.txt"));
            int i = 0;
            while ((str = br.readLine()) != null)
            {
                String[] s = str.split("\\s+");
                System.arraycopy(s, 0, data[i], 0, 3);
                i++;
            }
            br.close();*/
        resultSet1.close();
        DefaultTableModel dtm = new DefaultTableModel(data, colName);
        JTable table = new JTable(dtm);
        JScrollPane jsp = new JScrollPane(table);
        table.setFillsViewportHeight(true);
        jp.add(jsp, BorderLayout.CENTER);
        jp.add(bt2, BorderLayout.SOUTH);
        add(jp);
        bt2.addActionListener(s -> {
            dispose();
            new AdminSys(connection, statement);
        });

        setTitle("所有账号信息");
        setBounds(600, 200, 400, 250);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    }
}
