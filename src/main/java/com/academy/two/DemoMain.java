package com.academy.two;

import javax.swing.*;

public class DemoMain {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(DemoMain::createAndShowGUI);
    }
    /**
     *  Ovaj method treba da izvrsava GUI thread kako ne bismo blokirali MAIN thread
     */
    private static void createAndShowGUI() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//MAGIC NUMBER
        frame.setTitle("CheckBox Demonstration");
        JPanel buttonPanel = new CheckBoxPanel();
        frame.setContentPane(buttonPanel);
        frame.pack(); //iscrtaj ekran na nacin da pokazes samo onoliko koliko je potrebno
        frame.setVisible(true);
    }
}
