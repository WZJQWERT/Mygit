package com.gfxy.lianXi;
import java.lang.*;
import java.util.*;
public class Ks37 {
        public static void main(String[] args){
            int n;
            double e = 1.0;
            System.out.print("请输入n:  ");
            //***************************Found*********************
            Scanner scan = new Scanner (System.in);
            String nstr = scan.next();
            //***************************Found*********************
            n = Integer.parseInt(nstr);
            double t = 1.0;
            for(int i=1;i<=n;i++){
                //***************************Found*********************
                t = t/i;
                e = e + t;
            }
            System.out.print("e 的近似值为： "+e);
        }
    }
