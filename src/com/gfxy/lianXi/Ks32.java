package com.gfxy.lianXi;
//*********Found**********
public class Ks32 implements Runnable{


        private int x=0;
        private int y=0;

        public static void main(String[]args){
            Ks32 r = new Ks32();
            //*********Found**********
            Thread t = new Thread(r);
            t.start();
        }
        public void run() {
            //*********Found**********
            int k = 0;
            for(;;){
                x++;
                //*********Found**********
                y=k+1;
                k++;
                if (k>5) break;
                System.out.println("x=" + x + ",y ="+ y);
            }
        }
    }

