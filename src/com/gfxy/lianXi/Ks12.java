package com.gfxy.lianXi;

import static java.lang.Thread.sleep;

public class Ks12 {
    public static void main(String[] args) {
        Thread t = new SimpleThread("Testing_Thread");
        //*********Found**********
            t.start();
    }
}
//*********Found**********
class SimpleThread extends Thread
{
    public SimpleThread(String str)
    {
        //*********Found**********
        setName(str);
    }
    //*********Found**********
    public void run()
    {
        System.out.println("Running the " + getName() + ":");
        for (int i = 0; i < 5; i++)
        {
            System.out.println("---" + i + "---" + getName());
            try
            {
                sleep((int)(2 * 100));
            }
            //*********Found**********
            catch (InterruptedException e) { }
        }
    }
}



