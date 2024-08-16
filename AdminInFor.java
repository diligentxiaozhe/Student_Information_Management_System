package Advanced_java.Student_Information_Management_System;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class AdminInFor extends JFrame {
    public AdminInFor(Connection connection, Statement statement) throws SQLException {
        JPanel jp = new JPanel(new BorderLayout());
        JButton bt2 = new JButton("返回首页");
        String[] colName = {"登陆身份", "登录账号", "登陆时间"};
        String[][] data;
        int cnt = 0;
        String sql = "select * from account";
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            cnt++;
        }
        resultSet.close();
        ResultSet resultSet1 = statement.executeQuery(sql);
        data = new String[cnt][3];
        int i=0;
        while (resultSet1.next()) {
            String identity = resultSet1.getString("identity");
            String acc_num = resultSet1.getString("acc_num");
            Timestamp date = resultSet1.getTimestamp("date");
            data[i][0] = identity;
            data[i][1] = acc_num;
            data[i][2] = date.toString();
            i++;
        }
            /*br = new BufferedReader(new FileReader("account.txt"));
            while (br.readLine() != null)
            {
                cnt++;
            }
            br.close();
            data = new String[cnt][3];
            br = new BufferedReader(new FileReader("account.txt"));
            int i = 0;
            while ((str = br.readLine()) != null)
            {
                String[] s = str.split("\\s+");
                System.arraycopy(s, 0, data[i], 0, 3);
                i++;
            }
            br.close();*/
        resultSet.close();
        DefaultTableModel dtm = new DefaultTableModel(data, colName);
        JTable table = new JTable(dtm);
        JScrollPane jsp = new JScrollPane(table);
        table.setFillsViewportHeight(true);
        jp.add(jsp, BorderLayout.CENTER);
        jp.add(bt2, BorderLayout.SOUTH);
        add(jp);
        bt2.addActionListener(s -> {
            dispose();
            new AdminSys(connection,statement);
        });

        setTitle("账号登录情况");
        setBounds(600, 200, 400, 250);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    }
}
