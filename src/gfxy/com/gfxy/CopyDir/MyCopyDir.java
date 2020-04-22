package gfxy.com.gfxy.CopyDir;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
public class MyCopyDir {
    public static void main(String[] args) {
        File srcFile = new File("d:/test/src");
        File destFile = new File("d:/test/dest");
        copyDir(srcFile, destFile);
    }
    public static void copyDir(File srcFile, File destFile) {

            if(srcFile.isFile()) {
                try {
                    copyFile(srcFile, destFile);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }else if(srcFile.isDirectory()) {
                destFile.mkdirs();
                for(File f:srcFile.listFiles()) {
                    copyDir(f, new File(destFile,f.getName()));
                }
            }
        }
    public static void copyFile(File srcFile,File destFile) throws IOException {
        if(!srcFile.isFile()) {
            System.out.println("只能拷贝文件");
                throw new IOException("只能拷贝文件");
        }
        if(destFile.isDirectory()) {
            System.out.println("目标不能是文件夹，应该为文件");
                throw new IOException("目标不能是文件夹，应该为文件");
        }
        InputStream iStream = new BufferedInputStream(new FileInputStream(srcFile));
        OutputStream oStream = new BufferedOutputStream(new FileOutputStream(destFile));

        byte[] data = new byte[1024];
        int len = 0;
        while(-1 != (len=iStream.read(data))) {

                oStream.write(data, 0, len);

        }
        //强制刷出
        oStream.flush();
        oStream.close();
        iStream.close();
        }
}


