package Advanced_java.Student_Information_Management_System;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.Statement;

public class Delete extends JFrame implements Function
{
    public Delete(Connection connection, Statement statement)
    {
        setTitle("删除学生信息");
        setBounds(550,200,450,250);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel jp=new JPanel();
        JLabel label=new JLabel("学生学号(要删除学生的学号):");
        JTextField text=new JTextField(15);
        JButton jb1=new JButton("确定");
        JButton jb2=new JButton("返回首页");
        JButton jb3=new JButton("重置");
        label.setFont(new Font("宋体",Font.PLAIN,15));
        Box box=Box.createHorizontalBox();
        Box buttonBox=Box.createHorizontalBox();
        Box bigBox=Box.createVerticalBox();
        box.add(label);
        box.add(Box.createHorizontalStrut(15));
        box.add(text);
        buttonBox.add(jb1);
        buttonBox.add(Box.createHorizontalStrut(100));
        buttonBox.add(jb2);
        buttonBox.add(Box.createHorizontalStrut(100));
        buttonBox.add(jb3);

        bigBox.add(Box.createVerticalStrut(50));
        bigBox.add(box);
        bigBox.add(Box.createVerticalStrut(70));
        bigBox.add(buttonBox);
        jp.add(bigBox);
        add(jp);

        jb1.addActionListener(e->{
                deleteStudent(text.getText(),connection,statement);
                dispose();
                new TeacherPage(connection,statement);
        });
        jb2.addActionListener(e->{
            dispose();
            new TeacherPage(connection,statement);
        });
        jb3.addActionListener(e->{
            dispose();
            new Delete(connection,statement);
        });
    }
}
