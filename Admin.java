package Advanced_java.Student_Information_Management_System;

import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Admin extends JFrame
{
    public Admin()
    {
        JPanel panel=new JPanel();
        JLabel label1=new JLabel("管理员账号:");
        JTextField text1=new JTextField(15);
        JButton button1=new JButton("登录");
        Box box1=Box.createHorizontalBox();
        Box box2=Box.createHorizontalBox();
        Box bigBox=Box.createVerticalBox();
        box1.add(label1);
        box1.add(Box.createHorizontalStrut(15));
        box1.add(text1);
        box2.add(Box.createHorizontalStrut(50));
        box2.add(button1);
        bigBox.add(Box.createVerticalStrut(50));
        bigBox.add(box1);
        bigBox.add(Box.createVerticalStrut(50));
        bigBox.add(box2);
        panel.add(bigBox);
        add(panel);
        button1.addActionListener(e->{
            String sql = "select * from adminpsw";
            Conn conn = new Conn();
            Connection connection=conn.getConnection();
            Statement statement;
            try {
                statement =conn.getConnection().createStatement();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            ResultSet resultSet;
            try {
                resultSet = statement.executeQuery(sql);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            String countName = text1.getText();
            int temp = 0;
            while (true) {
                try {
                    if (!resultSet.next()) break;
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                String adminPsw;
                try {
                    adminPsw = resultSet.getString("apsw");
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                if (countName.equals(adminPsw)) {

                    dispose();
                    temp = 1;
                    try {
                        new ReadData(connection,statement);
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                    new AdminSys(connection,statement);
                    break;
                }
            }
            try {
                resultSet.close();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            if (temp == 0) {
                new PromptBox("密码或账号错误请重新输入！", "提示信息");
                dispose();
                new Admin();
            }
               /* BufferedReader br=new BufferedReader(new FileReader("adminPassword.txt"));
                String str;
                String countName= text1.getText();
                int temp=0;
                while((str=br.readLine())!=null)
                {
                    if(countName.equals(str)){
                        dispose();
                        new ReadData();
                        new AdminSys();
                        temp++;
                    }
                }
                br.close();
                if(temp==0)
                {
                    new PromptBox("密码或账号错误请重新输入！","提示信息");
                    dispose();
                    new Admin();
                }
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }*/
            /*catch (IOException ex)
            {
                throw new RuntimeException(ex);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }*/
        });
        setTitle("管理员登录");
        setBounds(600,300,350,200);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
