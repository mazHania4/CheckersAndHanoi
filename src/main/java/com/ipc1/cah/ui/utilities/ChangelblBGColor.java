package com.ipc1.cah.ui.utilities;

import javax.swing.*;
import java.awt.*;

public class ChangelblBGColor extends Thread{
    
    private JLabel lblToBlink;
    private Color color;

    public ChangelblBGColor(JLabel lblToBlink, Color color){
        this.lblToBlink = lblToBlink;
        this.color = color;
    }

    @Override
    public void run() {
        lblToBlink.setBackground(color);
    }
    
    
}
