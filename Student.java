package Advanced_java.Student_Information_Management_System;

public class Student implements  Comparable<Student>
{
    private   String studentName;
    private   String studentId;
    private   String  studentAge;
    private String studentClass;
    private  String faculties;


    public Student(String studentId, String studentName,String studentAge ,String studentClass, String faculties )
    {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentAge=studentAge;
        this.studentClass = studentClass;
        this.faculties=faculties;
    }

    public void setStudentName(String studentName)
    {
        this.studentName = studentName;
    }

    public void setStudentId(String studentId)
    {
        this.studentId = studentId;
    }

    public void setStudentClass(String studentClass)
    {
        this.studentClass = studentClass;
    }

    public void setFaculties(String faculties)
    {
        this.faculties = faculties;
    }

    public String getStudentName()
    {
        return studentName;
    }

    public String getStudentId()
    {
        return studentId;
    }

    public String getStudentAge()
    {
        return studentAge;
    }

    public String getStudentClass()
    {
        return studentClass;
    }

    public String getFaculties()
    {
        return faculties;
    }

    @Override
    public int compareTo(Student o)
    {
        return Integer.parseInt(this.getStudentId())-Integer.parseInt((o.getStudentId()));
    }
}
