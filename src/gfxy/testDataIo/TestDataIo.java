package gfxy.testDataIo;

import java.io.*;
import java.nio.Buffer;

public class TestDataIo {
    public static void main(String[] args) {
        //TestDataOut();
        TestDataIn();
    }

    public static void TestDataOut() {

        File file = new File("d:/test/my.data");
        DataOutputStream js = null;
        try {
            js = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
            js.writeUTF("我是国防学院的");
            js.writeByte(10);
            js.writeDouble(188.88);
            js.flush();
            js.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void TestDataIn() {
        File file = new File("d:/test/my.data");
        try {
            DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(new FileInputStream(file)));
             String a =dataInputStream.readUTF();
            System.out.println(a);
             Byte d  = dataInputStream.readByte();
            System.out.println(d);
             Double b = dataInputStream.readDouble();
            System.out.println(b);
            dataInputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}




