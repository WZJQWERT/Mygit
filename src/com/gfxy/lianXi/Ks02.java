package com.gfxy.lianXi;

public class Ks02 {

        public static void main(String[] args) {
            int [][] aMatric =new int[4][];
            int i= 0;
            int j= 0;
            int k= 4;
            for ( i=0;i<4;i++){
                //System.out.println(i);
                aMatric[i] =new int[k-i];
                for (j =0;j<aMatric[i].length;j++){
                    aMatric[i][j] =i+1;
                    System.out.print(aMatric[i][j]+"");
                }
                System.out.println();
            }
        }
    }

