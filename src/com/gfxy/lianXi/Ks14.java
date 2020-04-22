package com.gfxy.lianXi;
//*********Found**********
import javax.swing.*;

public class Ks14 {
        //*********Found**********
        public static void main(String[] args) {
        System.out.println();
        System.out.println("这是一个指定球半径，求球体积的程序。");
        String input= JOptionPane.showInputDialog("请输入球半径。");
        //*********Found**********
        double r=Double.parseDouble(input);
        System.out.println("当球的半径是" + r + "时，该球的体积是    " + (Math.PI*r*r*r*4/3));
        System.exit(0);
    }
    }

