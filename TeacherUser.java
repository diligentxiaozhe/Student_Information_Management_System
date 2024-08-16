package Advanced_java.Student_Information_Management_System;

import javax.swing.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TeacherUser extends JFrame {
    public TeacherUser(String identity) {
        JPanel panel = new JPanel();
        JLabel label1 = new JLabel("账号:");
        JTextField text1 = new JTextField(15);
        JLabel label2 = new JLabel("密码:");
        JPasswordField text2 = new JPasswordField(15);
        JButton button1 = new JButton("登录");
        JButton button2 = new JButton("注册");
        Box box1 = Box.createHorizontalBox();
        Box box2 = Box.createHorizontalBox();
        Box box3 = Box.createHorizontalBox();
        Box bigBox = Box.createVerticalBox();
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
        button1.addActionListener(e -> {
            String sql = "select * from password";
            Conn conn = new Conn();
            Connection connection = conn.getConnection();
            Statement statement;
            try {
                statement = connection.createStatement();
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
            String password = text2.getText();
            int temp = 0;
            while (true) {
                try {
                    if (!resultSet.next()) break;
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                String acc_num;
                try {
                    acc_num = resultSet.getString("acc_num");
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                String psw;
                try {
                    psw = resultSet.getString("psw");
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                if (countName.equals(acc_num) && password.equals(psw)) {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd/HH:mm:ss");
                    String sql1 = "insert into account(identity,acc_num,date) values(?,?,?)";
                    try {
                        PreparedStatement preparedStatement=connection.prepareStatement(sql1);
                        preparedStatement.setString(1,identity);
                        preparedStatement.setString(2,acc_num);
                        preparedStatement.setString(3,sdf.format(new Date()));
                        /*int result=statement.executeUpdate(sql1);
                        System.out.println(result);*/
                        preparedStatement.close();

                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                    dispose();
                    try {
                        new ReadData(connection, statement);
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                    new TeacherPage(connection, statement);
                    temp = 1;
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
                new TeacherUser(identity);
            }
                    /*BufferedReader br=new BufferedReader(new FileReader("Password.txt"));
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
                            new ReadData();
                            new TeacherPage();
                            temp=1;
                        }
                    }
                    br.close();
                    if(temp==0)
                    {
                        new PromptBox("密码或账号错误请重新输入！","提示信息");
                        dispose();
                        new TeacherUser(identity);
                    }*/
        });
        button2.addActionListener(e -> {
            dispose();
            new Register(identity);
        });
        setTitle("教师端登录");
        setBounds(600, 300, 400, 300);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
