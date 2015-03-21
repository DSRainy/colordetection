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
    private final float[] highThreshold;
    private final float[] lowThreshold;

    public ColorConverter() {
        lowThreshold = new float[3];
        lowThreshold[0] = 144.0f;
        lowThreshold[1] = 0.6f;
        lowThreshold[2] = 0.0f;
        highThreshold = new float[3];
        highThreshold[0] = 288.0f;
        highThreshold[1] = 1.0f;
        highThreshold[2] = 0.4f;
    }

    public void execute() {
        
        //Changing RGB value to HSV value
        for (int row = 0; row < this.data.length; row++) {
            for (int col = 0; col < this.data[1].length; col++) {
                int r = this.data[row][col] >> 16 & 0xFF;
                int g = this.data[row][col] >> 8 & 0xFF;
                int b = this.data[row][col] & 0xFF;
                float[] hsv = Color.RGBtoHSB(r, g, b, null);
                
                this.data[row][col] = this.threshold(hsv);
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

}
