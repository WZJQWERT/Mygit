package gfxy.testinputstreamreader;

import java.io.*;

//测试字节流转换字符流
public class TestInPutStreamReader {


    public static void main(String[] args)  {
        File file = new File("d:/test/1.txt");
             try {
             Reader reader = new InputStreamReader(new FileInputStream(file),"utf-8");
            char[] data =new char[20];
             reader.read(data);
             System.out.println(new String(data));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
                 e.printStackTrace();
             }


    }
    }
