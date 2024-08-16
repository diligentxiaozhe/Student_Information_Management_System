package Advanced_java.Student_Information_Management_System;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public interface Function
{
     List<Student> students = new ArrayList<>();
    default void addStudent(Student s)
    {
        students.add(s);
        new PromptBox("恭喜你已经成功添加该学生信息!","提示信息");
    }
    default void addStudentByIo(Student s)
    {
        students.add(s);
    }
    default String[][] getStudents()
    {
        Student[] student = new Student[100];
        int i=0;
        for (Student student1 : students)
        {
            student[i]=student1;
            i++;
        }
        String[][] data =new String[i][5];
        for(int k=0;k<i;k++)
        {
                data[k][0]= student[k].getStudentId();
                data[k][1]=student[k].getStudentName();
                data[k][2]=student[k].getStudentAge();
                data[k][3]=student[k].getStudentClass();
                data[k][4]= student[k].getFaculties();
        }
        return data;
    }
    default void deleteStudent(String Id ,Connection connection,Statement statement)
    {
        Iterator<Student> it=students.iterator();
        int temp=0;
        while(it.hasNext())
        {
            if(it.next().getStudentId().equals(Id))
            {
                it.remove();
                new PromptBox("您已经成功删除该学生信息！","提示信息");
                new TeacherPage(connection,statement);
                temp=1;
                break;
            }
        }
        if(temp==0)
        {
            new PromptBox("您要删除的学生不存在！","提示信息");
        }
    }
    default void sortStudent()
    {
        Collections.sort(students);
    }
    default  boolean modifyingStudent(String Id)
    {
        for (Student student : students)
        {
            if (student.getStudentId().equals(Id))
            {
                return true;
            }
        }
            return false;
    }
    default Student getGaiStudent(String Id)
    {
        Student stu=null;
        for (Student student : students)
        {
            if (student.getStudentId().equals(Id))
            {
                stu=student;
               break;
            }
        }
        return  stu;
    }
    default void gaiStudent(Student students,String studentId,String studentName,String studentClass,String studentFaculties)
    {
        students.setStudentId(studentId);
        students.setStudentName(studentName);
        students.setStudentClass(studentClass);
        students.setFaculties(studentFaculties);
        new PromptBox("您已经成功修改该学生信息！","提示信息");
    }
    default void destroyConn(Connection connection,Statement sta){
        try {//先释放statement
            if (sta != null) {
                sta.close();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {//最后释放connection
            if (connection != null){
                connection.close();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
