package com.gfxy.lianXi;
//***************************Found*********************
 class PrintStrings implements Runnable{


        int ind = 0 ;
        //***************************Found*********************
        String[]  strings = { "one", "two", "three", "four", "five"};

        public PrintStrings( int n) {
            if( n < 0)
                n = 0;
            else if ( n >= strings.length)
                //***************************Found*********************
                n =strings.length - 1 ;
            ind = n;
        }
        //***************************Found*********************
        public void run( ){
            while(ind < strings.length){
                System.out.print(strings[ind] + "  ");
                //***************************Found*********************
                ind ++;

            }
            System.out.println();
        }
    }

    public class Ks38{
        public static void main(String[] args){
            PrintStrings p = new PrintStrings(-1);
            //***************************Found*********************
             Thread t =new Thread(p);
            t.start();;
        }
    }

