package com.gfxy.Yuan;

import javafx.scene.shape.Circle;

import java.awt.*;

public class MyYuan {
        Point center;
        double r;
        //构造方法
        public MyYuan (Point center,double r) {
            this.center = center;
            this.r = r;
        }
        //构造方法

    public MyYuan (int x,int y,double r) {
        this.center.x = x;
        this.center.y = y;
        this.r = r;
    }
    //计算圆的面积
    public double area (MyYuan r) {
        return Math.PI * (r.r * r.r);
    }
    //计算当前图形是否包含指定的点
    public boolean contains(Point p){
            double d =this.center.distance(p);
            return d <= r ;
    }
    public boolean contains(int x,int y ){
            double d = this.center.distance(x,y);
            return d <= r;
    }

    public static void main(String[] args) {
        Circle c = new Circle(3,4,5);
        boolean b =c.contains(6,8);
      System.out.println(b);

    }
    }



