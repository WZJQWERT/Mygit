package com.gfxy.lianXi;
import java.awt.Graphics;
import javax.swing.JApplet;
//*********Found**********
public class Ks27 extends JApplet{
    //*********Found**********
        public void paint(Graphics g){
            int counter = 1;
            do {
            //*********Found**********
               g.drawOval( 110 - counter * 10, 110 - counter * 10, counter * 20, counter * 20 );
                //*********Found**********
                ++counter;
            } while (counter<=10);
        }
    }

