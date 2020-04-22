package com.gfxy.TSwing;

import javax.swing.*;

public class Main03 {
    public static void main(String[] args) {
        JFrame jf =new JFrame("用户登录");
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //第一个Jpanel使用默认的浮动布局
        JPanel pane101 = new JPanel();
        pane101.add(new JLabel("用户名"));
        pane101.add(new JTextField(10));
        //第二个Jpanel使用默认的浮动布局
        JPanel pane102 = new JPanel();
        pane102.add(new JLabel("密码"));
        pane102.add(new JPasswordField(10));
        //第三个Jpanel使用默认的浮动布局
        JPanel pane103 = new JPanel();
        pane103.add(new JButton("登录"));
        pane103.add(new JButton("注册"));
        //创建一个垂直容器盒子，串接并作为内容面板连接起来
        Box vBox =Box.createVerticalBox();
        vBox.add(pane101);
        vBox.add(pane102);
        vBox.add(pane103);
        jf.setContentPane(vBox);
        jf.pack();
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);
    }
}
