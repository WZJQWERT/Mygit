package com.gfxy.Thread;

public class Tester {
    public static void main(String[] args) {
        MyRunnable myRunnable=new MyRunnable();
        Thread t = new Thread(myRunnable,"售票窗口A");
        Thread t1 = new Thread(myRunnable,"售票窗口B");
        t.start();
        t1.start();
    }

}

