package Advanced_java.Student_Information_Management_System;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Connection;
import java.sql.Statement;

public class Display extends JFrame implements Function
{
    public Display(Connection connection, Statement statement)
    {
        setTitle("显示学生信息");
        setBounds(450,200,600,400);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         JPanel jp=new JPanel(new BorderLayout());
         JButton bt1=new JButton("按学号进行排序");
         JButton bt2=new JButton("返回首页");
         String[][] data =getStudents();
         String[] colName ={"学生学号", "学生姓名","学生年龄", "学生班级", "所在院系"};
         DefaultTableModel dtm=new DefaultTableModel(data,colName);
         JTable table=new JTable(dtm);
         JScrollPane jsp=new JScrollPane(table);
         table.setFillsViewportHeight(true);
         jp.add(bt1,BorderLayout.EAST);
         jp.add(jsp ,BorderLayout.CENTER);
         jp.add(bt2,BorderLayout.SOUTH);
         add(jp);
         bt1.addActionListener(e->{
             sortStudent();
             dispose();
             new Display(connection,statement);
        });
         bt2.addActionListener(e->{
             dispose();
             new TeacherPage(connection,statement);
         });
    }
}
