package com.ipc1.cah.ui;

import java.awt.*;
import javax.swing.*;

public class LabelWithBGImage extends JLabel {

    private ImageIcon bgImage;
    private Icon icon;

    public LabelWithBGImage(String bgImageRoute, int width, int height){
        this.setSize(width, height);
        this.bgImage = new ImageIcon(bgImageRoute);
        this.icon = new ImageIcon(
                this.bgImage.getImage().getScaledInstance(
                        this.getWidth(), 
                        this.getHeight(), 
                        Image.SCALE_DEFAULT
                )
        );
        this.setIcon(this.icon);
        this.repaint();
    }
  
}
