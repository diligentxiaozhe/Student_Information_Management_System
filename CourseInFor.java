package Advanced_java.Student_Information_Management_System;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CourseInFor extends JFrame
{
    public CourseInFor(String userName, Connection connection, Statement statement) throws SQLException {
        JPanel jp = new JPanel(new BorderLayout());
        JButton bt2 = new JButton("返回首页");
        String[] colName = {"课程名称", "课程性质", "课程状态"};
        String[][] data;
        int cnt = 0;
        String sql = "select * from course";
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            cnt++;
        }
        resultSet.close();
        ResultSet resultSet1 = statement.executeQuery(sql);
        data = new String[cnt][3];
        int i=0;
        while (resultSet1.next()) {
            String c_name = resultSet1.getString("c_name");
            String c_nature = resultSet1.getString("c_nature");
            String c_s = resultSet1.getString("c_s");
            data[i][0] = c_name;
            data[i][1] = c_nature;
            data[i][2] = c_s;
            i++;
        }
        /*try
        {
            String str ;
            br = new BufferedReader(new FileReader("Course.txt"));

            while (br.readLine() != null)
            {
                cnt++;
            }
            br.close();
            data = new String[cnt][3];
            br = new BufferedReader(new FileReader("Course.txt"));
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
            bt2.addActionListener(s->{
                dispose();
                new StudentPage(userName,connection,statement);
            });
        setTitle("选课信息");
        setBounds(600, 200, 400, 250);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    }
}
