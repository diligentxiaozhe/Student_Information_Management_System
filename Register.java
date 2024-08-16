package Advanced_java.Student_Information_Management_System;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Register extends  JFrame
{
    public Register(String identify)
    {
        setTitle("登录");
        setBounds(450,200,600,500);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel=new JPanel();
        JLabel label1=new JLabel("请输入要注册的账号:");
        JTextField text1=new JTextField(15);
        JLabel label2=new JLabel("设置密码:");
        JTextField text2=new JTextField(15);
        JLabel label3=new JLabel("确认密码:");
        JTextField text3=new JTextField(15);
        JButton button=new JButton("注册");
        Box box1=Box.createHorizontalBox();
        Box box2=Box.createHorizontalBox();
        Box box3=Box.createHorizontalBox();
        Box box4=Box.createHorizontalBox();
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
        box4.add(Box.createHorizontalStrut(25));
        box4.add(button);
        bigBox.add(Box.createVerticalStrut(50));
        bigBox.add(box1);
        bigBox.add(Box.createVerticalStrut(50));
        bigBox.add(box2);
        bigBox.add(Box.createVerticalStrut(50));
        bigBox.add(box3);
        bigBox.add(Box.createVerticalStrut(50));
        bigBox.add(box4);
        panel.add(bigBox);
        add(panel);
        button.addActionListener(e->{
            try
            {
                if(text2.getText().equals(text3.getText()))
            {
                BufferedWriter bfw=new BufferedWriter(new FileWriter("D:\\Code\\Java\\src\\Advanced_java\\Student_Information_Management_System\\Password.txt",true));
                String countName=text1.getText();
                String password=text2.getText();
                bfw.write(identify+" "+countName+" "+password);
                bfw.newLine();
                bfw.flush();
                bfw.close();
                new PromptBox("恭喜你注册成功,您可以返回登陆啦!","提示信息");
                dispose();
                new Login();
            }
                else
                {
                    new PromptBox("您两次输入的密码不一致,请重新设置您的密码！","提示信息");
                    dispose();
                    new Register(identify);
                }
            }
            catch (IOException ex)
            {
                throw new RuntimeException(ex);
            }
        });
    }
}
