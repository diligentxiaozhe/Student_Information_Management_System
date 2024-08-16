package Advanced_java.Student_Information_Management_System;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TeacherPage extends JFrame
{
    public TeacherPage(Connection connection, Statement statement)
    {
        setTitle("教师端系统");
        setBounds(600, 200, 600, 530);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        JPanel jp = new JPanel(null);
        JLabel label = new JLabel("学生信息管理");
        JButton jb1 = new JButton("1.增加学生信息");
        JButton jb2 = new JButton("2.显示所有学生信息");
        JButton jb3 = new JButton("3.删除学生信息");
        JButton jb4 = new JButton("4.修改学生信息");
        JButton jb5=new JButton("退出系统");
        JButton jb6=  new JButton("添加学生成绩");

        jp.add(label);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setFont(new Font("宋体", Font.PLAIN, 25));
        jp.add(jb1);
        jp.add(jb2);
        jp.add(jb3);
        jp.add(jb4);
        jp.add(jb6);
        jp.add(jb5);
        label.setBounds(137, 10, 300, 80);
        jb1.setBounds(80, 80, 200, 100);
        jb2.setBounds(300, 80, 200, 100);
        jb3.setBounds(80, 200, 200, 100);
        jb4.setBounds(300, 200, 200, 100);
        jb6.setBounds(180, 310, 200, 100);
        jb5.setBounds(240,430,100,50);
        add(jp);

        jb1.addActionListener(e ->
        {
            dispose();
            new Confirm(connection,statement);
        });
        jb2.addActionListener(e ->
        {
            dispose();
            new Display(connection,statement);
        });
        jb3.addActionListener(e ->
        {
            dispose();
            new Delete(connection,statement);
        });
        jb4.addActionListener(e->{
              dispose();
              new Modifying(connection,statement);
        });
        jb5.addActionListener(e -> {
            new PromptBox("当前系统下的所有信息已经保存！可以退出系统了！","提示信息");
            String sql2="delete from studentdata";
            try {
                statement.executeUpdate(sql2);
                new Export(connection);
                dispose();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }

                    /* try
            {
                BufferedWriter bfw=new BufferedWriter(new FileWriter("studentData.txt"));
                bfw.write("");
                bfw.flush();
                bfw.close();
                new Export();
            }
            catch (IOException ex)
            {
                throw new RuntimeException(ex);
            }
            dispose();*/
        });
        jb6.addActionListener(e->{
          dispose();
          new Achievements(connection,statement);
        });
    }
}
