package com.academy.three;

import com.academy.three.combo.ComboBoxPanel;
import com.academy.three.combo.ComboBoxPanel2;
import com.academy.three.combo.CustomComboBoxPanel;

import javax.swing.*;

public class Demo {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Demo::createAndShowGUI);

    }

    private static void createAndShowGUI(){
        JFrame frame = new JFrame("JComboBox Demonstration");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        JPanel comboBoxPanel = new ComboBoxPanel();
//        JPanel comboBoxPanel = new ComboBoxPanel2();
        JPanel comboBoxPanel = new CustomComboBoxPanel();
        frame.setContentPane(comboBoxPanel);
        frame.pack();
        frame.setVisible(true);
    }
}
