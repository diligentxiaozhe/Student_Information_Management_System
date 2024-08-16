package Advanced_java.Student_Information_Management_System;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class AddAdmin extends JFrame
{
    public AddAdmin(Connection connection, Statement statement)
    {
        setTitle("添加管理员账号");
        setBounds(550,200,450,250);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel jp=new JPanel();
        JLabel label=new JLabel("请输入您要添加的管理员账号:");
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
            /*BufferedWriter bw;
            try
            {
                bw = new BufferedWriter(new FileWriter("adminPassword.txt",true));
                bw.newLine();
                bw.write(text.getText());
                bw.flush();
                bw.close();
            }
            catch (IOException ex)
            {
                throw new RuntimeException(ex);
            }*/
            String sql="insert into adminpsw values(null,?)";
            try {
                PreparedStatement preparedStatement=connection.prepareStatement(sql);
                preparedStatement.setString(1,text.getText());
                preparedStatement.executeUpdate();
                preparedStatement.close();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            new PromptBox("管理员账号添加成功！","提示信息");
            dispose();
            new AdminSys(connection, statement);
        });
        jb2.addActionListener(e->{
            dispose();
            new AdminSys(connection, statement);
        });
        jb3.addActionListener(e->{
            dispose();
            new AddAdmin(connection, statement);
        });
    }
}
