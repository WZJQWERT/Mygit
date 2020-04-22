package com.gfxy.lianXi;



public class Ks01 {

    public static void main(String[] args) {
        //
        int[] f = new int[10];
        f[0] = f[1] = 1;
        //
        for (int i = 2; i < 10; i++)
            f[i] = f[i - 1] + f[i - 2];
        //
        for (int i = 0; i < f.length; i++)
            //
            System.out.print(f[i] + " 输出结果 ");
    }

}


