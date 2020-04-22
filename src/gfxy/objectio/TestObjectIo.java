package gfxy.objectio;

import java.io.*;
import java.sql.SQLInput;

public class TestObjectIo {


    public static void main(String[] args) {
        //TestObjectOutput();
        TestObjectIn();
    }

    public static void TestObjectOutput() {
        Student student = new Student("张三", 19);
        File file = new File("d:/test/my.obj");


        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)));

            outputStream.writeObject(student);
            outputStream.flush();
            outputStream.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void TestObjectIn() {
        File file = new File("d:/test/my.obj");

        try {
            ObjectInputStream inputStream = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));
            Object object = inputStream.readObject();
            if (object instanceof Student) {
                Student student = (Student) object;
                System.out.println(student.getStudentName() + "-------" + student.getAge());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}