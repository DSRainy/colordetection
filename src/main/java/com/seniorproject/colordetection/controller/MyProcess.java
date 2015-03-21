/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seniorproject.colordetection.controller;

import com.seniorproject.colordetection.algorithm.ColorConverter;
import com.seniorproject.colordetection.utils.ImageUtil;
import java.awt.image.BufferedImage;
import java.util.List;

/**
 *
 * @author RainWhileLoop
 */
public class MyProcess extends AbstractProcess{
    private BufferedImage imgIn;
    private BufferedImage imgOut;
    
    private final ColorConverter converter;

    public MyProcess() {
        this.converter = new ColorConverter();
    }
    
    @Override
    public void execute(){
        int[][] data = ImageUtil.convertToArray(imgIn);
        this.converter.setData(data);
        this.converter.execute();
        data = this.converter.getData();
        
    }
    
    
}
