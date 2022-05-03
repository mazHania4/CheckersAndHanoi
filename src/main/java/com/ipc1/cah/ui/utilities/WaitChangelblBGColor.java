package com.ipc1.cah.ui.utilities;

import javax.swing.*;
import java.awt.*;

public class WaitChangelblBGColor extends Thread{
    
    private JLabel lblToBlink;
    private int seconds;
    private Color color;

    public WaitChangelblBGColor(JLabel lblToBlink, int seconds, Color color){
        this.lblToBlink = lblToBlink;
        this.seconds = seconds;
        this.color = color;
    }

    @Override
    public void run() {
        try {
            System.out.println("espero:");
            Thread.sleep(seconds * 1000);
            lblToBlink.setBackground(color);
            System.out.println("termine de esperar");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }   
    
        
    }
    
}
