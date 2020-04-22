package gfxy.testbatyarrayio;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class TestByteArrayIo {
    public static void main(String[] args) {
        //调用两种方法
        //testByteArrayInput();
        testByteArrayOutput();
    }

    public static void testByteArrayInput() {
        String string = "myData 我的数据.";
        ByteArrayInputStream arrio = new ByteArrayInputStream(string.getBytes());
        byte[] data = new byte[10];
        int len = 0;
        try {
            while (-1 != (len = arrio.read(data))) {
                System.out.println(new String(data, 0, len));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void testByteArrayOutput() {
        String string = "我们是国防学院的.";
        ByteArrayOutputStream arrout = new ByteArrayOutputStream();

        arrout.write(string.getBytes(), 0, string.getBytes().length);
        byte[] data = arrout.toByteArray();
        System.out.println(new String(data));
    }
}
