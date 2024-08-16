package Advanced_java.Student_Information_Management_System;

import java.sql.Connection;
import java.sql.SQLException;

public class Export implements Function
{
    public Export(Connection connection) throws SQLException {
        String[][] stuMessage=getStudents();
        for (String[] strings : stuMessage) {
            new WriterData(connection,strings[0], strings[1], strings[2], strings[3], strings[4]);
        }
       /* String[][] stuMessage=getStudents();
        BufferedWriter bfw=new BufferedWriter(new FileWriter("studentData.txt",true));
        bfw.write("学生学号"+"  "+"学生姓名"+"  "+"学生年龄"+"  "+"学生班级"+"  "+"学生所在学院");
        bfw.newLine();
        bfw.flush();
        for (String[] strings : stuMessage) {
            new WriterData(strings[0], strings[1], strings[2], strings[3], strings[4]);
        }*/
    }
}
