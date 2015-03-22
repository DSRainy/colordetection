/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seniorproject.colordetection.algorithm;

import java.awt.Color;

/**
 *
 * @author RainWhileLoop
 */
public class ColorConverter {

    private int[][] data;
    private float[] highThreshold;
    private float[] lowThreshold;

    public ColorConverter() {
        lowThreshold = new float[3];
        highThreshold = new float[3];
    }

    public void execute() {
        float[] hsv = new float[3];
        
        //Changing RGB value to HSV value
        for (int y = 0; y < this.data[1].length; y++) {
            for (int x = 0; x < this.data.length; x++) {
                int r = this.data[x][y] >> 16 & 0xFF;
                int g = this.data[x][y] >> 8 & 0xFF;
                int b = this.data[x][y] & 0xFF;
                hsv = Color.RGBtoHSB(r, g, b, hsv);
//                this.data[x][y] = Color.getHSBColor(hsv[0], 1f, 1f).getRGB();
                this.data[x][y] = this.threshold(hsv);
            }
        }

    }

    private int threshold(float[] hsv) {
        hsv[0] *= 360f;
        if (lowThreshold[0] <= hsv[0] && hsv[0] <= highThreshold[0]
                && lowThreshold[1] <= hsv[1] && hsv[1] <= highThreshold[1]
                && lowThreshold[2] <= hsv[2] && hsv[2] <= highThreshold[2]) {
            return 0;
        } else {
            return -1;
        }
    }

    public void setData(int[][] data) {
        this.data = data;
    }

    public int[][] getData() {
        return data;
    }

    public void setThreshold(float[] low, float[] high){
        lowThreshold = low;
        highThreshold = high;
    }
    
}
