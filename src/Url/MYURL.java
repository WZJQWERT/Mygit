package Url;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;

public class MYURL {
        public static void main (String [] args) {
            try {
                URL MyUrl = new URL("https://www.baidu.com");
                //          System.out.println("端口"+MyUrl.getPort());
                //			System.out.println("文件名称"+MyUrl.getFile());
                //			System.out.println("主机名称"+MyUrl.getHost());
                //			System.out.println("文件路径"+MyUrl.getPath());
                //			System.out.println("协议"+MyUrl.getProtocol());
                //			System.out.println("参数"+MyUrl.getQuery());
                try {
                    BufferedReader 	reader = new BufferedReader(new InputStreamReader(MyUrl.openStream(),"utf-8"));
                    String string =null;
                    //在C盘提前创造好一个text.html文件
                    BufferedWriter writer =new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File("c:/text.html"))));
                    while ((string = reader.readLine())  != null) {
                        System.out.println(string);
                        writer.write(string);
                    }

                    writer.flush();
                } catch (MalformedURLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }








