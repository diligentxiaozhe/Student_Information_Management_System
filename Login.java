package Advanced_java.Student_Information_Management_System;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;

public class Login extends JFrame
{
    public Login()
    {
        JPanel panel=new JPanel();
        JLabel label1=new JLabel("请选择您的登录身份:");
        JComboBox<String> comBox=new JComboBox<>();
        comBox.addItem("管理员");
        comBox.addItem("教师");
        comBox.addItem("学生");
        comBox.setSelectedIndex(-1);
        JLabel label2=new JLabel("注意:身份为管理者，只需要用账号登录");
        JLabel label3=new JLabel("用户(教师，学生等)，需要账号和密码登录");
        Box box1=Box.createHorizontalBox();
        Box box2=Box.createHorizontalBox();
        Box box3=Box.createHorizontalBox();
        Box bigBox=Box.createVerticalBox();
        box1.add(label1);
        box1.add(Box.createHorizontalStrut(15));
        box1.add(comBox);
        box2.add(label2);
        box3.add(label3);
        bigBox.add(Box.createVerticalStrut(50));
        bigBox.add(box1);
        bigBox.add(Box.createVerticalStrut(50));
        bigBox.add(box2);
        bigBox.add(box3);
        panel.add(bigBox);
        add(panel);
        comBox.addItemListener(e->{
            if(Objects.requireNonNull(comBox.getSelectedItem()).toString().equals("管理员"))
            {
                dispose();
                new Admin();
            }
            else if(Objects.requireNonNull(comBox.getSelectedItem()).toString().equals("教师"))
            {
                dispose();
                new TeacherUser(Objects.requireNonNull(comBox.getSelectedItem()).toString());
            }
            else
            {
                dispose();
                new StuUser(Objects.requireNonNull(comBox.getSelectedItem()).toString());
            }
        });
        setTitle("登录");
        setBounds(600,300,380,280);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
