/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seniorproject.colordetection.controller;

import java.awt.image.BufferedImage;

/**
 *
 * @author RainWhileLoop
 */
public abstract class AbstractProcess {
    private BufferedImage imgIn;
    private BufferedImage imgOut;
    
    public void setImgIn(BufferedImage imgIn) {
        this.imgIn = imgIn;
    }

    public BufferedImage getImgOut() {
        return imgOut;
    }
    
    
    public abstract void execute();
}
