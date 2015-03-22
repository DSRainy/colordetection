/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seniorproject.colordetection.controller;

import com.seniorproject.colordetection.algorithm.ColorConverter;
import com.seniorproject.colordetection.utils.ImageUtil;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author RainWhileLoop
 */
public class MyProcess extends AbstractProcess {

    private final ColorConverter converter;
    private float[] high;
    private float[] low;

    public MyProcess() {
        this.converter = new ColorConverter();
    }

    @Override
    public void execute() {
        int[][] data = ImageUtil.changeImageToArray(imgIn);
        this.converter.setData(data);
        setHSVRanges();
        this.converter.setThreshold(low, high);
        this.converter.execute();
        data = this.converter.getData();
        imgOut = ImageUtil.getImage(data);
    }

    private void setHSVRanges() {
        try {
            high = new float[3];
            low = new float[3];
            String file = "src\\main\\resources\\txt\\threshold.txt";

            try (BufferedReader in = new BufferedReader(new FileReader(file))) {
                // get hues
                String line = in.readLine();
                String[] toks = line.split(" ");
                low[0] = Float.parseFloat(toks[1]);
                high[0] = Float.parseFloat(toks[2]);

                // get saturations
                line = in.readLine();
                toks = line.split(" ");
                low[1] = Float.parseFloat(toks[1]);
                high[1] = Float.parseFloat(toks[2]);

                // get brightnesses
                line = in.readLine();
                toks = line.split(" ");
                low[2] = Float.parseFloat(toks[1]);
                high[2] = Float.parseFloat(toks[2]);
            }
        } catch (IOException | NumberFormatException e) {
            System.exit(1);
        }
    }
}
