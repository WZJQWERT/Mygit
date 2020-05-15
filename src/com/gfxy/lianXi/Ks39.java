package com.gfxy.lianXi;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
    //**************found*****************
    public class Ks39 extends Frame implements ItemListener{
        Color color = Color.blue;
        CheckboxGroup cg;
        Checkbox cb1,cb2,cb3;

        public Ks39(){
            cg = new CheckboxGroup();
            setSize(300,300);
            cb1 = new Checkbox("blue",cg,true);
            cb2 = new Checkbox("red",cg,true);
            cb3 = new Checkbox("green",cg,true);
            cg.setSelectedCheckbox(cb1);
            add(cb1);  add(cb2);  add(cb3);
            cb1.addItemListener(this);
            cb2.addItemListener(this);
            //**************found*****************
            cb3.addItemListener(this);
        }

        public void itemStateChanged(ItemEvent e){
            if(e.getSource()==cb1)
                color=Color.blue;
            if(e.getSource()==cb2)
                color=Color.red;
            if(e.getSource()==cb3)
                color=Color.green;
            repaint();
        }

        class MyEvent1 extends WindowAdapter {
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        }

        class MyEvent2 extends ComponentAdapter {
            public void componentResized(ComponentEvent e){
                repaint();
            }
        }

        //**************found*****************
        public void  paint(Graphics g) {
            int w = getWidth(),h=getHeight();
            int x0 = w/2,y0 = h/2;
            g.setColor(color);
            g.drawLine(x0,0,x0,h);
            g.drawLine(0,y0,w,y0);
            double pi = 3.1415926,angle,rou;
            int r,i,x,y;
            for(r=10;r<200;r+=20){
                for(i=0;i<1023;i++){

                    angle = i * pi/512;
                    rou = r * Math.sin(2*angle);
                    x = (int)Math.round(rou*Math.cos(angle));
                    y = (int)Math.round(rou*Math.sin(angle));
                    g.drawOval(x0+x,y0+y,1,1);
                }
            }
        }

        public static void main(String[] args){
           Ks39 f = new Ks39();
            MyEvent1 me1 = f.new MyEvent1();
            MyEvent2 me2 = f.new MyEvent2();
            //**************found*****************
            f.setTitle("四叶玫瑰线");
            f.setLayout(new FlowLayout());
            f.addWindowListener(me1);
            f.addComponentListener(me2);
            //**************found*****************
            f.setVisible(true);
        }
    }

