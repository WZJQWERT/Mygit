package com.gfxy.lianXi;

public class Ks10 {

        //*********Found**********
        public  static  void main (String  args[]) {
            new SimpleThread("第1").start();
            new SimpleThread("第2").start();
        }
    }

    //*********Found**********
    class Simple extends Thread{
        public Simple(String str) {
            super(str);
        }
        public void run() {
            for (int i = 0; i < 5; i++) {
                //*********Found**********
                System.out.println(i + " " + getName());
                try
                {
                    sleep((int)(2 * 100));
                }
                catch (InterruptedException e) { }
            }
            System.out.println("运行! " + getName());
        }
    }


