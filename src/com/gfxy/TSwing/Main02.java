package com.gfxy.TSwing;

import javax.swing.*;
import javax.swing.text.html.Option;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main02 {
    public static void main(String[] args) {
        final JFrame jf =new JFrame("测试窗口");
        jf.setSize(400,400);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JButton btn01 = new JButton("show MessageDialog ");
        btn01.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showConfirmDialog(jf, "Hello Information Message ",
                        "消息标题",JOptionPane.INFORMATION_MESSAGE

                );

            }
        });
        //消息对话框（警告消息）
        JButton btn02 = new JButton("show MessageDialog (警告消息)");
        btn02.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        //消息对话框无返回，做通知作用
                                        JOptionPane.showConfirmDialog(jf, "Hello Warning Message ", "消息标题",
                                                JOptionPane.WARNING_MESSAGE
                                        );
                                    }
                                });


                //确认对话框
                JButton btn03 = new JButton("show ConfirmDialog");
                btn03.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int result = JOptionPane.showConfirmDialog(jf, "确定删除", "提示", JOptionPane.YES_NO_CANCEL_OPTION);
                        System.out.println("选择结束");
                    }
                });
                //输入对话框(文本框输入)
                JButton btn04 = new JButton("show Dialog(文本框输入)");
                btn04.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String inputContent = JOptionPane.showInputDialog(jf, "输入你的名字", "默认内容");
                        System.out.println("你输入的内容");
                    }
                });

                //输入对话框（下拉框选择）
                JButton btn05 = new JButton("show inputDialog(下拉框选择)");
                btn05.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Object[] selectionValues = new Object[]{"香蕉", "雪梨", "苹果"};
                        //显示输入的对话框，返回选择的内容，点击取消或者关闭，返回null
                        Object inputContent = JOptionPane.showInputDialog(jf, "选择一项:", "标题",
                                JOptionPane.PLAIN_MESSAGE, null, selectionValues, selectionValues[0]);
                        System.out.println("输入的内容" + inputContent);
                    }
                });
                //选项对话框
                JButton btn06 = new JButton("showOptionDialog");
                btn06.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        //选项按钮
                        Object[] options = new Object[]{"香蕉", "雪梨", "苹果"};
                        //显示选择对话框，反回选择的索引，点击关闭按钮返回-1
                        int optionSelected = JOptionPane.showOptionDialog(jf, "请点击一个按钮选择一项", "对话框标题",
                                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE, null, options, options[0]);
                        if (optionSelected >= 0) {
                            System.out.println("点击的按钮" + options[optionSelected]);
                        }
                    }
                });

                //垂直排列按钮
                Box vBox = Box.createVerticalBox();
                vBox.add(btn01);
                vBox.add(btn02);
                vBox.add(btn03);
                vBox.add(btn04);
                vBox.add(btn05);
                vBox.add(btn06);
                JPanel panel = new JPanel();
                panel.add(vBox);
                jf.setContentPane(panel);
                jf.setVisible(true);
            }
            }







