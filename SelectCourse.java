package Advanced_java.Student_Information_Management_System;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectCourse extends JFrame
{
    public SelectCourse(String username, Connection connection, Statement statement)
    {
        JPanel panel=new JPanel();
        JLabel label1=new JLabel("Java程序设计");
        JButton button1=new JButton("选课");
        JLabel label2=new JLabel("数据结构");
        JButton button2=new JButton("选课");
        JLabel label3=new JLabel("计算机组成原理");
        JButton button3=new JButton("选课");
        JLabel label4=new JLabel("计算机网络");
        JButton button4=new JButton("选课");
        JLabel label5=new JLabel("操作系统");
        JButton button5=new JButton("选课");
        JButton button6=new JButton("返回首页");
        Box box1=Box.createHorizontalBox();
        Box box2=Box.createHorizontalBox();
        Box box3=Box.createHorizontalBox();
        Box box4=Box.createHorizontalBox();
        Box box5=Box.createHorizontalBox();
        Box bigBox=Box.createVerticalBox();

        box1.add(label1);
        box1.add(Box.createHorizontalStrut(30));
        box1.add(button1);
        box2.add(label2);
        box2.add(Box.createHorizontalStrut(30));
        box2.add(button2);
        box3.add(label3);
        box3.add(Box.createHorizontalStrut(30));
        box3.add(button3);
        box4.add(label4);
        box4.add(Box.createHorizontalStrut(30));
        box4.add(button4);
        box5.add(label5);
        box5.add(Box.createHorizontalStrut(30));
        box5.add(button5);
        bigBox.add(Box.createVerticalStrut(20));
        bigBox.add(box1);
        bigBox.add(Box.createVerticalStrut(20));
        bigBox.add(box2);
        bigBox.add(Box.createVerticalStrut(20));
        bigBox.add(box3);
        bigBox.add(Box.createVerticalStrut(20));
        bigBox.add(box4);
        bigBox.add(Box.createVerticalStrut(20));
        bigBox.add(box5);
        bigBox.add(Box.createVerticalStrut(20));
        bigBox.add(button6);
        panel.add(bigBox);
        add(panel);


        button1.addActionListener(e->{
            new PromptBox("选课成功!","提示信息");
            String sql="insert into course values(null,?,?,?)";
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1,label1.getText());
                preparedStatement.setString(2,"必修");
                preparedStatement.setString(3,"已选");
                preparedStatement.executeUpdate();
                preparedStatement.close();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            bigBox.remove(box1);
            panel.revalidate();
            panel.repaint();
            /*BufferedWriter bw;
            try
            {
                bw = new BufferedWriter(new FileWriter("Course.txt",true));
                bw.write(label1.getText()+"  "+"必修"+"  "+"已选");
                bw.newLine();
                bw.flush();
                bw.close();
            }
            catch (IOException ex)
            {
                throw new RuntimeException(ex);
            }*/
        });
        button2.addActionListener(e->{
            new PromptBox("选课成功!","提示信息");
            String sql="insert into course values(null,?,?,?)";
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1,label2.getText());
                preparedStatement.setString(2,"必修");
                preparedStatement.setString(3,"已选");
                preparedStatement.executeUpdate();
                preparedStatement.close();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            bigBox.remove(box2);
            panel.revalidate();
            panel.repaint();
        });
        button3.addActionListener(e->{
            new PromptBox("选课成功!","提示信息");
            String sql="insert into course values(null,?,?,?)";
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1,label3.getText());
                preparedStatement.setString(2,"必修");
                preparedStatement.setString(3,"已选");
                preparedStatement.executeUpdate();
                preparedStatement.close();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            bigBox.remove(box3);
            panel.revalidate();
            panel.repaint();
        });
        button4.addActionListener(e->{
            new PromptBox("选课成功!","提示信息");
            String sql="insert into course values(null,?,?,?)";
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1,label4.getText());
                preparedStatement.setString(2,"必修");
                preparedStatement.setString(3,"已选");
                preparedStatement.executeUpdate();
                preparedStatement.close();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            bigBox.remove(box4);
            panel.revalidate();
            panel.repaint();
        });
        button5.addActionListener(e->{
            new PromptBox("选课成功!","提示信息");
            String sql="insert into course values(null,?,?,?)";
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1,label5.getText());
                preparedStatement.setString(2,"必修");
                preparedStatement.setString(3,"已选");
                preparedStatement.executeUpdate();
                preparedStatement.close();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            bigBox.remove(box5);
            panel.revalidate();
            panel.repaint();
        });
        button6.addActionListener(e->{
            dispose();
            new StudentPage(username,connection,statement);
        });

        setTitle("学生选课");
        setBounds(600, 200, 400, 400);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    }
}
