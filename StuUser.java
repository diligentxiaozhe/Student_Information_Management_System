package Advanced_java.Student_Information_Management_System;

import javax.swing.*;
import java.io.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StuUser extends JFrame
{
    public StuUser(String identity)
    {
        JPanel panel=new JPanel();
        JLabel label1=new JLabel("账号:");
        JTextField text1=new JTextField(15);
        JLabel label2=new JLabel("密码:");
        JPasswordField text2=new JPasswordField(15);
        JButton button1=new JButton("登录");
        JButton button2=new JButton("注册");
        Box box1=Box.createHorizontalBox();
        Box box2=Box.createHorizontalBox();
        Box box3=Box.createHorizontalBox();
        Box bigBox=Box.createVerticalBox();
        box1.add(label1);
        box1.add(Box.createHorizontalStrut(15));
        box1.add(text1);
        box2.add(label2);
        box2.add(Box.createHorizontalStrut(15));
        box2.add(text2);
        box3.add(button1);
        box3.add(Box.createHorizontalStrut(50));
        box3.add(button2);
        bigBox.add(Box.createVerticalStrut(50));
        bigBox.add(box1);
        bigBox.add(Box.createVerticalStrut(50));
        bigBox.add(box2);
        bigBox.add(Box.createVerticalStrut(50));
        bigBox.add(box3);
        panel.add(bigBox);
        add(panel);
        button1.addActionListener(e->{
            Conn conn = new Conn();
            Connection connection = conn.getConnection();
            String countName= text1.getText();
            String password=text2.getText();
            int temp=0;
            try {
                Statement statement= connection.createStatement();
                String sql = "select * from password";
                ResultSet resultSet = statement.executeQuery(sql);
                while(resultSet.next()) {
                    String acc_num = resultSet.getString("acc_num");
                    String psw = resultSet.getString("psw");
                    if (countName.equals(acc_num) && password.equals(psw)) {
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd/HH:mm:ss");
                        String sql1 = "insert into account(identity,acc_num,date) values(?,?,?)";
                        try {
                            PreparedStatement preparedStatement = connection.prepareStatement(sql1);
                            preparedStatement.setString(1, identity);
                            preparedStatement.setString(2, acc_num);
                            preparedStatement.setString(3, sdf.format(new Date()));
                            preparedStatement.executeUpdate();
                            preparedStatement.close();
                            dispose();
                            new StudentPage(countName,connection,statement);
                            temp = 1;
                            break;
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }

                    }
                }
                resultSet.close();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            /*try
            {
                BufferedReader br=new BufferedReader(new FileReader("Password.txt"));
                String str;
                String countName= text1.getText();
                String password=text2.getText();
                int temp=0;
                while((str=br.readLine())!=null)
                {
                    String[] s=str.split(" ");
                    if(countName.equals(s[1]) && password.equals(s[2])){
                        BufferedWriter bw=new BufferedWriter(new FileWriter("account.txt",true));
                        SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd/HH:mm:ss");
                        bw.write(identity+"  "+countName+"  "+sdf.format(new Date()));
                        bw.newLine();
                        bw.flush();
                        bw.close();
                        dispose();
                        new StudentPage(countName);
                        temp++;
                    }
                }
                br.close();*/
                if(temp==0)
                {
                    new PromptBox("密码或账号错误请重新输入！","提示信息");
                    dispose();
                    new StuUser(identity);
                }

        });
        button2.addActionListener(e->{
            dispose();
            new Register(identity);
        });
        setTitle("学生端登录");
        setBounds(600,300,400,300);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
