package Advanced_java.Student_Information_Management_System;

import javax.swing.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class AdminSys extends JFrame implements Function
{
    public AdminSys(Connection connection, Statement statement)
    {
        JPanel panel=new JPanel();
        JButton button1=new JButton("账号登录情况");
        JButton button2=new JButton("添加管理员账号");
        JButton button3=new JButton("所有账号情况");
        JButton button4=new JButton("退出系统");

        Box box1=Box.createHorizontalBox();
        Box box2=Box.createHorizontalBox();
        Box box3=Box.createHorizontalBox();
        Box box4=Box.createHorizontalBox();
        Box bigBox=Box.createVerticalBox();
        box1.add(button1);
        box2.add(button2);
        box3.add(button3);
        box4.add(button4);
        bigBox.add(Box.createVerticalStrut(30));
        bigBox.add(box1);
        bigBox.add(Box.createVerticalStrut(20));
        bigBox.add(box2);
        bigBox.add(Box.createVerticalStrut(20));
        bigBox.add(box3);
        bigBox.add(Box.createVerticalStrut(20));
        bigBox.add(box4);
        panel.add(bigBox);
        add(panel);

        button1.addActionListener(e->{
           dispose();
            try {
                new AdminInFor(connection,statement);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        });
        button2.addActionListener(e->{
              dispose();
              new AddAdmin(connection,statement);
        });
        button3.addActionListener(e->{
               dispose();
            try {
                new AllAccount(connection,statement);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        });
        button4.addActionListener(e->{
            new PromptBox("当前系统下的所有信息已经保存！可以退出系统了！","提示信息");
            destroyConn(connection,statement);
            dispose();
        });

        setTitle("管理员系统");
        setBounds(600, 200, 400, 250);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    }
}
