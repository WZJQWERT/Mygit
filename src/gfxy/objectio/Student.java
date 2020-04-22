package gfxy.objectio;

import java.io.Serializable;

public class Student implements Serializable {
    private  String studentName;
    private  int age;
    private  transient long no;
    public Student(String studentName, int age) {
        super();
        this.studentName = studentName;
        this.age = age;
    }
    public String getStudentName() {
        return studentName;
    }
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

}
