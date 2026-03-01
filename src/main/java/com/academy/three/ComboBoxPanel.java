package com.academy.three;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import static java.awt.Color.green;

public class ComboBoxPanel extends JPanel {
    private final String[] dateTimePatterns ={
            "dd MMMMM yyyy",
            "dd.MM.yyyy",
            "dd.MM.yy",
            "MM/dd/yy",
            "MM/dd/yyyy",
            "yyyy-MM-dd",
            "yyyy.MM.dd G 'at' HH:mm:ss z",
            "yyyy.MM.dd HH:mm:ss",
            "yyyy.MM.dd G hh:mm aaa"
    };

    private String currentSelectedDateTimePattern;
    private JLabel resultLabel = new JLabel("");

    public ComboBoxPanel() {
        setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
        this.currentSelectedDateTimePattern = dateTimePatterns[0];

        JLabel patternLabel1 = new JLabel("Unesite tekstualni pattern datuma/vremena ili");
        JLabel patternLabel2 = new JLabel("odaberite postojeci pattern datuma/vremena");
        JComboBox<String> patternComboBox = new JComboBox<>(dateTimePatterns);
        DateTimePatternComboBoxListener patternListener = new DateTimePatternComboBoxListener(this::consumeSelectedPattern);
        patternComboBox.addActionListener(patternListener);
        JPanel patternPanel = new JPanel();
    //    patternPanel.setBorder(BorderFactory.createLineBorder(Color.red));
        patternPanel.setLayout(new BoxLayout(patternPanel,BoxLayout.PAGE_AXIS));
        patternPanel.add(patternLabel1);
        patternPanel.add(patternLabel2);

//        patternPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
//        patternLabel1.setAlignmentX(LEFT_ALIGNMENT);
//        patternLabel2.setAlignmentX(LEFT_ALIGNMENT);
        patternComboBox.setAlignmentX(LEFT_ALIGNMENT);
        patternPanel.setAlignmentX(LEFT_ALIGNMENT);
        patternPanel.add(patternComboBox);


        JLabel patternResultLabel = new JLabel("Trenutni datum/vreme formatirano", JLabel.LEADING);
        JPanel resultPanel = new JPanel();
        resultPanel.setLayout(new GridLayout(0,1));
        resultPanel.add(patternResultLabel);
//        resultLabel.setText(currentSelectedDateTimePattern);
        resultLabel.setForeground(Color.BLUE);
        resultLabel.setBackground(Color.BLACK);
        Border lineBorder = BorderFactory.createLineBorder(Color.black);
        Border emptyBorder = BorderFactory.createEmptyBorder(5,5,5,5);
        Border compoundBorder = BorderFactory.createCompoundBorder(lineBorder,emptyBorder);
        resultLabel.setBorder(compoundBorder);
        LocalDateTime now = LocalDateTime.now();
 //       SimpleDateFormat dateFormat = new SimpleDateFormat(currentSelectedDateTimePattern);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(currentSelectedDateTimePattern);
        String formattedDate = formatter.format(now);
        resultLabel.setText(formattedDate);
        resultPanel.add(resultLabel);




        patternPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
   //     patternPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        resultPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
  //      resultPanel.setBorder(BorderFactory.createLineBorder(Color.GREEN));
        add(patternPanel);
        add(Box.createRigidArea(new Dimension(0,10)));
        add(resultPanel);

        setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
    }

    private void consumeSelectedPattern(String pattern){
  //      LocalDateTime now = LocalDateTime.now();
        ZonedDateTime now = ZonedDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        String formattedDate = formatter.format(now);
        resultLabel.setText(formattedDate);
    }
}
