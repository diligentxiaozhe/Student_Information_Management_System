package Advanced_java.Student_Information_Management_System;

import javax.swing.*;
import java.sql.Connection;
import java.sql.Statement;

public class Gai extends JFrame implements Function
{
    public Gai(String Id, Connection connection, Statement statement)
    {
        setTitle("修改学生信息");
        setBounds(450,200,600,400);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel jp=new JPanel();
        JLabel label1=new JLabel("学生学号(修改学生的学号):");
        JTextField text1=new JTextField(15);
        JLabel label2=new JLabel("学生姓名(修改学生的姓名):");
        JTextField text2=new JTextField(15);
        JLabel label3=new JLabel("学生年龄(修改学生的年龄):");
        JTextField text3=new JTextField(15);
        JLabel label4=new JLabel("学生班级(修改学生的班级):");
        JTextField text4=new JTextField(15);
        JLabel label5=new JLabel("所在学院(修改学生的所在院系):");
        JTextField text5=new JTextField(15);
        JButton jb1=new JButton("提交");
        JButton jb2=new JButton("首页");
        JButton jb3=new JButton("重置");

        Box box1=Box.createHorizontalBox();
        Box box2=Box.createHorizontalBox();
        Box box3=Box.createHorizontalBox();
        Box box4=Box.createHorizontalBox();
        Box box5=Box.createHorizontalBox();
        Box box7=Box.createHorizontalBox();
        Box bigBox=Box.createVerticalBox();

        box1.add(label1);
        box1.add(Box.createHorizontalStrut(15));
        box1.add(text1);
        box2.add(label2);
        box2.add(Box.createHorizontalStrut(15));
        box2.add(text2);
        box3.add(label3);
        box3.add(Box.createHorizontalStrut(15));
        box3.add(text3);
        box4.add(label4);
        box4.add(Box.createHorizontalStrut(15));
        box4.add(text4);
        box5.add(label5);
        box5.add(Box.createHorizontalStrut(15));
        box5.add(text5);
        box7.add(jb1);
        box7.add(Box.createHorizontalStrut(50));
        box7.add(jb2);
        box7.add(Box.createHorizontalStrut(50));
        box7.add(jb3);

        bigBox.add(Box.createVerticalStrut(50));
        bigBox.add(box1);
        bigBox.add(Box.createVerticalStrut(10));
        bigBox.add(box2);
        bigBox.add(Box.createVerticalStrut(10));
        bigBox.add(box3);
        bigBox.add(Box.createVerticalStrut(10));
        bigBox.add(box4);
        bigBox.add(Box.createVerticalStrut(10));
        bigBox.add(box5);
        bigBox.add(Box.createVerticalStrut(10));
        bigBox.add(Box.createVerticalStrut(80));
        bigBox.add(box7);
        jp.add(bigBox);
        add(jp);

        jb1.addActionListener(e->{
            Student students=getGaiStudent(Id);
            gaiStudent(students,text1.getText(),text2.getText(),text3.getText(),text4.getText());
            dispose();
            new TeacherPage(connection,statement);
        });
        jb2.addActionListener(e->{
            dispose();
            new TeacherPage(connection,statement);
        });
        jb3.addActionListener(e->{
            text1.setText(" ");
            text2.setText(" ");
            text3.setText(" ");
            text4.setText(" ");
        });
    }
}
