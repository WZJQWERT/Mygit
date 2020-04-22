package com.gfxy.lianXi;
import java.io.*;
public class Ks06 {
        public static void main(String[] args)  {
            Ks06 exceptionExample = new Ks06();
            //*********Found**********
            try {
                FileInputStream fi = new FileInputStream("C:" + "\\" + "abc.txt");
                //*********Found**********
                 }catch(FileNotFoundException ex){

                //*********Found**********
                System.out.println(ex.getMessage()+ "请确认文件路径及文件名是否正确！");
            }
        }
    }


