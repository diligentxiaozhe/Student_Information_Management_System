package Advanced_java.Student_Information_Management_System;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class Points extends JFrame
{
    public Points(String username, Connection connection, Statement statement)
    {
        JPanel jp = new JPanel(new BorderLayout());
        JButton bt2 = new JButton("返回首页");
        String[] colName = {"学生学号", "学生姓名", "高数","英语","C语言程序设计"};
        String[][] data = new String[1][5];
        try
        {
           /* String str ;
            br = new BufferedReader(new FileReader("StuAchieve.txt"));
            data = new String[1][5];
            while ((str = br.readLine()) != null)
            {
                String[] s = str.split("\\s+");
                if(s[0].equals(username))
                {
                    System.arraycopy(s, 0, data[0], 0, 5);
                }
            }*/
            String sql="select * from Stuachieve where stu_id=?";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,Integer.parseInt(username));
            ResultSet resultSet=preparedStatement.executeQuery();
            while(resultSet.next()) {
               data[0][0]=username;
               data[0][1]=resultSet.getString("stu_name");
               data[0][2]=resultSet.getInt("stu_a1")+"";
               data[0][3]=resultSet.getInt("stu_a2")+"";
               data[0][4]=resultSet.getInt("stu_a3")+"";
            }
            DefaultTableModel dtm = new DefaultTableModel(data, colName);
            JTable table = new JTable(dtm);
            JScrollPane jsp = new JScrollPane(table);
            table.setFillsViewportHeight(true);
            jp.add(jsp, BorderLayout.CENTER);
            jp.add(bt2, BorderLayout.SOUTH);
            add(jp);
            bt2.addActionListener(s->{
                dispose();
                new StudentPage(username,connection,statement);
            });
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }

        setTitle("学生成绩");
        setBounds(600, 200, 460, 250);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    }
}
