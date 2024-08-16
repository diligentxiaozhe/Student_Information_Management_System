package Advanced_java.Student_Information_Management_System;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ReadData implements Function
{
    public ReadData(Connection connection, Statement statement) throws SQLException {
        String sql = "select * from studentdata";
        ResultSet result = statement.executeQuery(sql);
        while (result.next()){
           String stu_id=  result.getString("stu_id");
           String stu_name=  result.getString("stu_name");
           String stu_age=  result.getString("stu_age");
           String stu_class=  result.getString("stu_class");
           String stu_college=  result.getString("stu_college");
            addStudentByIo(new Student(stu_id, stu_name,stu_age ,stu_class, stu_college));
        }

        /*BufferedReader bfr=new BufferedReader(new FileReader("studentData.txt"));
        String str;
        bfr.readLine();
        while((str=bfr.readLine())!=null)
        {
            String[] s= (str.split("\\s+"));
            addStudentByIo(new Student(s[0], s[1],s[2] ,s[3], s[4]));
        }
        bfr.close();*/
    }
}
