package com.academy.one;

import javax.swing.*;
import java.awt.*;

public class ButtonDemo {
    public static void main(String[] args) {

        System.out.println(Thread.currentThread().getName());
        Runnable runnable = ButtonDemo::createAndShowGUI;
        SwingUtilities.invokeLater(runnable);

    }

    private static void createAndShowGUI(){
        System.out.println(Thread.currentThread().getName());
        JFrame frame = new JFrame();
//        BorderLayout borderLayout = new BorderLayout();
//        frame.setLayout(borderLayout);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//MAGIC NUMBER
        frame.setTitle("Button Demonstration");
        JPanel buttonPanel = new ButtonPanel2();
        frame.setContentPane(buttonPanel);
        frame.pack(); //iskrtaj ekran na nacin da pokazes samo onoliko koliko je potrebno
        frame.setVisible(true);
    }
}
