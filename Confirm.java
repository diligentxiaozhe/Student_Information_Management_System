package Advanced_java.Student_Information_Management_System;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.Statement;

public class Confirm extends JFrame
{
    public Confirm(Connection connection, Statement statement)
    {
        setBounds(450,200,600,400);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel jp=new JPanel(null);
        JLabel label=new JLabel("是否要添加学生信息");
        JButton jb1=new JButton("是");
        JButton jb2=new JButton("否");
        jp.add(label);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setFont(new Font("宋体",Font.PLAIN,20));
        jp.add(jb1);
        jp.add(jb2);
        add(jp);
        label.setBounds(199,50,200,80);
        jb1.setBounds(100,150,200,100);
        jb2.setBounds(300,150,200,100);
        jb1.addActionListener(e-> {
            dispose();
            new Add(connection,statement);
        });
        jb2.addActionListener(e->{
            dispose();
            new TeacherPage(connection,statement);
                });
    }
}
