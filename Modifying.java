package Advanced_java.Student_Information_Management_System;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.Statement;

public class Modifying extends JFrame implements Function
{
    public Modifying(Connection connection, Statement statement)
    {
        setTitle("修改学生信息");
        setBounds(550,200,450,250);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel jp=new JPanel();
        JLabel label=new JLabel("学生学号(要修改学生的学号):");
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
            if(modifyingStudent(text.getText()))
            {
                new PromptBox("当前系统中存在您要修改的学生,请完成学生信息的修改!","提示信息");
                dispose();
                new Gai(text.getText(),connection,statement);
            }
            else {
                new PromptBox("您要修改的学生不存在,请重新填写要修改学生的学号!","提示信息");
                new Modifying(connection,statement);
            }
        });
        jb2.addActionListener(e->{
            dispose();
            new TeacherPage(connection,statement);
        });
        jb3.addActionListener(e-> text.setText(" "));
    }
}
