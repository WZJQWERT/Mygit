package com.gfxy.TSwing;



import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame jf = new JFrame("测试按钮");

        jf.setSize(250, 250);
        //设置窗口大小
        jf.setLocationRelativeTo(null);
        //将窗口放置在屏幕中间
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //点击
        JPanel panel = new JPanel();
        //创建中间容器
        JButton a = new JButton("测试按钮");
        //添加基本元素：按钮
        panel.add(a);
        jf.setContentPane(panel);
        //把面板容器作为窗口的内容面板设置到窗口
        jf.setVisible(true);
        //显示窗口
    }
}

