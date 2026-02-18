package com.academy.one.question;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;

public class GraphicFrame extends JFrame {


    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);

        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.setColor(Color.lightGray);
        graphics2D.fillRect(50,50,80,50);

        AffineTransform at = new AffineTransform();
        at.translate(140,100);
        at.scale(0.5,0.5);

        graphics2D.setTransform(at);

        graphics2D.setColor(Color.GRAY);
        graphics2D.drawRect(50,50,80,50);


    }

    public static void main(String[] args) {
        GraphicFrame graphicFrame = new GraphicFrame();
        graphicFrame.setSize(300, 300);
        graphicFrame.setResizable(true);
        graphicFrame.setVisible(true);
    }
}
