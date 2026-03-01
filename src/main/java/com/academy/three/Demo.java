package com.academy.three;

import javax.swing.*;

public class Demo {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Demo::createAndShowGUI);

    }

    private static void createAndShowGUI(){
        JFrame frame = new JFrame("JComboBox Demonstration");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel comboBoxPanel = new ComboBoxPanel();
        frame.setContentPane(comboBoxPanel);
        frame.pack();
        frame.setVisible(true);
    }
}
