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
    protected BufferedImage imgIn;
    protected BufferedImage imgOut;
    
    public void setImgIn(BufferedImage image) {
        this.imgIn = image;
    }

    public BufferedImage getImgOut() {
        return this.imgOut;
    }
    
    public abstract void execute();
}
