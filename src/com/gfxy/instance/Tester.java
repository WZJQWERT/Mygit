package com.gfxy.instance;

public class Tester {
    public static void main(String[] args) {
        Thread thread = new Thread (()->System.out.println(MyClass.getInstance(200)));
        Thread thread1 = new Thread (()->System.out.println(MyClass.getInstance(200)));
        thread.start();
        thread1.start();
    }
}
