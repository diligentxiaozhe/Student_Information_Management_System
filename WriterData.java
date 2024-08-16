package Advanced_java.Student_Information_Management_System;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class WriterData implements Function
{
    public WriterData(Connection connection,String Id, String name, String age, String studentClass, String faculties) throws SQLException {
        /*BufferedWriter bfw=new BufferedWriter(new FileWriter("studentData.txt",true));
        bfw.write(Id+"  "+name+"  "+age+"  "+studentClass+"  "+faculties);
        bfw.newLine();
        bfw.flush();
        bfw.close();*/
        String sql ="insert into studentdata values(?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,Integer.parseInt(Id));
        preparedStatement.setString(2,name);
        preparedStatement.setInt(3,Integer.parseInt(age));
        preparedStatement.setInt(4,Integer.parseInt(studentClass));
        preparedStatement.setString(5,faculties);
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }
}
