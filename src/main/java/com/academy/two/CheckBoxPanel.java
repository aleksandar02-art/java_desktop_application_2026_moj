package com.academy.two;

import com.academy.one.ButtonPanel2;
import com.academy.one.icon.IconLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.EventObject;

public class CheckBoxPanel extends JPanel {

    private final JCheckBox chinCheckBox = new JCheckBox("Chin");
    private final JCheckBox glassesCheckBox = new JCheckBox("Glasses");
    private final JCheckBox hairCheckBox = new JCheckBox("Hair");
    private final JCheckBox teethCheckBox = new JCheckBox("Teeth");

    private final JLabel pictureLabel = new JLabel();

    private final StringBuffer pictureChoice = new StringBuffer("cght");

    public CheckBoxPanel(){
        this.setLayout(new BorderLayout());
//prvi nacin:
//        JPanel checkBoxPanel = new JPanel();
//        checkBoxPanel.setLayout(new GridLayout(0,1));
        //drugi nacin:
        CheckBoxListener checkBoxListener = new CheckBoxListener();
        JPanel checkBoxPanel = new JPanel(new GridLayout(0,1));
        chinCheckBox.setSelected(true);
        chinCheckBox.addItemListener(checkBoxListener);
        checkBoxPanel.add(chinCheckBox);
        glassesCheckBox.setSelected(true);
        glassesCheckBox.addItemListener(checkBoxListener);
        checkBoxPanel.add(glassesCheckBox);
        hairCheckBox.setSelected(true);
        hairCheckBox.addItemListener(checkBoxListener);
        checkBoxPanel.add(hairCheckBox);
        teethCheckBox.setSelected(true);
        teethCheckBox.addItemListener(checkBoxListener);
        checkBoxPanel.add(teethCheckBox);

        this.add(checkBoxPanel,BorderLayout.LINE_START);
        updatePicture();
        this.add(pictureLabel,BorderLayout.CENTER);
        this.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));


    }

    private void updatePicture() {
        IconLoader iconLoader = new IconLoader(CheckBoxPanel.class);
        String relativePath = "geek1/geek-" + pictureChoice + ".png";
        Icon imageIcon = iconLoader.loadIcon(relativePath);
        pictureLabel.setIcon(imageIcon);
    }

    private class CheckBoxListener implements ItemListener{

        @Override
        public void itemStateChanged(ItemEvent event) {

            Object source = event.getSource();
            boolean selected = event.getStateChange() == ItemEvent.SELECTED;
            Choice choice = switch (source){
                case JCheckBox cb when cb == chinCheckBox -> new Choice(0,selected ? 'c' : '-');
                case JCheckBox cb when cb == glassesCheckBox -> new Choice(1,selected ? 'g' : '-');
                case JCheckBox cb when cb == hairCheckBox -> new Choice(2,selected ? 'h' : '-');
                case JCheckBox cb when cb == teethCheckBox -> new Choice(3,selected ? 't' : '-');
                default -> new Choice(0,'-');

            };
//            if (source == chinCheckBox){
//               slovo  = 'c';
//            } else if (source == glassesCheckBox) {
//                 = 'g';
//            } else if (source == hairCheckBox) {
//                 = 'h';
//            } else if (source == teethCheckBox){
//                 = 't';
//            } else {
//                 ='-';
//            }
//            System.out.println("Slovo = " + choice);

            pictureChoice.setCharAt(choice.index(), choice.slovo());
            updatePicture();
        }
    }
}
