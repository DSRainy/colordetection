/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seniorproject.colordetection.main;

import com.github.sarxos.webcam.Webcam;
import com.seniorproject.colordetection.constant.WebcamDimensions;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.SwingWorker;

/**
 *
 * @author RainWhileLoop
 */
public class ColorDetector extends javax.swing.JFrame {

    /**
     * Creates new form ColorDetection
     */
    public ColorDetector() {
        initComponents();
        
        final Webcam webcam = Webcam.getWebcams().get(1);
        final Dimension dimension = WebcamDimensions.XL;
        
        webcam.setViewSize(dimension);
        
        colorDetectorPanel.setMaximumSize(dimension);
        colorDetectorPanel.setPreferredSize(dimension);
        setPreferredSize(dimension);
        setResizable(true);
        
        SwingWorker worker = new SwingWorker() {
            
            @Override
            protected Object doInBackground() throws Exception {
                
                webcam.open();
                while(isVisible()){
                    final BufferedImage bufferedImage = webcam.getImage();
//                    final BufferedImage bufferedImage = ImageIO.read(new File("E:\\001.jpg"));
                    colorDetectorPanel.setImage(bufferedImage);
                    colorDetectorPanel.repaint();
                    Thread.sleep(100);
                }
                
                return null;
            }
        };
        worker.execute();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        colorDetectorPanel = new com.seniorproject.colordetection.controller.ColorDetectorPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ColorDetection");
        setPreferredSize(new java.awt.Dimension(480, 400));
        setResizable(false);

        colorDetectorPanel.setMaximumSize(new java.awt.Dimension(480, 400));
        colorDetectorPanel.setPreferredSize(new java.awt.Dimension(480, 400));

        javax.swing.GroupLayout colorDetectorPanelLayout = new javax.swing.GroupLayout(colorDetectorPanel);
        colorDetectorPanel.setLayout(colorDetectorPanelLayout);
        colorDetectorPanelLayout.setHorizontalGroup(
            colorDetectorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 480, Short.MAX_VALUE)
        );
        colorDetectorPanelLayout.setVerticalGroup(
            colorDetectorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(colorDetectorPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(colorDetectorPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ColorDetector.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ColorDetector.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ColorDetector.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ColorDetector.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ColorDetector().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.seniorproject.colordetection.controller.ColorDetectorPanel colorDetectorPanel;
    // End of variables declaration//GEN-END:variables
}
