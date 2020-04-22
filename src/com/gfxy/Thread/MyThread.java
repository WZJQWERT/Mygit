package com.gfxy.Thread;

public class MyThread extends Thread {
    public MyThread (String name){
        super(name);
    }
  private int i=10;
    public void run() {
        super.run();
        task();
    }

    public void task() {
        while (i>0){
            i--;

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            //System.out.println(getName()+"-----"+ System.currentTimeMillis());
            //System.out.println(getId()+"-----"+ System.currentTimeMillis());
           // System.out.println(Thread.currentThread()+"-----"+ System.currentTimeMillis());
            System.out.println(Thread.currentThread().getName()+"-----"+"售出票"+i);
        }
            }


        }
