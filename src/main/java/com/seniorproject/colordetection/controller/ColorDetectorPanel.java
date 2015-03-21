/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seniorproject.colordetection.controller;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 *
 * @author RainWhileLoop
 */
public class ColorDetectorPanel extends JPanel {

    private BufferedImage image;
    
    AbstractProcess processor = new MyProcess();

    @Override
    protected void paintComponent(Graphics g) {
        if (image != null) {
            Graphics2D g2 = (Graphics2D) g;
            g2.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), null);
            g2.dispose();
        }
    }

    public void setImage(BufferedImage image) {
//        this.image = image;
        processor.setImgIn(image);
        try {
            processor.execute();
        } catch (Exception ex) {
            Logger.getLogger(ColorDetectorPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.image = processor.getImgOut();
        
    }
}
