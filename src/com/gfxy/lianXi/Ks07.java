package com.gfxy.lianXi;

public class Ks07 extends TT {


        //*********Found**********
        public static void main(String args[]) {
            Ks07 t = new Ks07("小龙");
        }
        public Ks07(String s) {
            super(s);
            System.out.println("您好吗？");
        }
        public Ks07() {
            this("我是文朋");
        }
    }

    class TT {
        public TT() {
            System.out.println("多高兴啊!");
        }
        public TT(String s) {
            //*********Found**********
             this();          ;
            System.out.println("我是"+s);
        }
    }


