package com.ipc1.cah.ui.utilities;

import javax.swing.*;
import java.awt.*;

public class BGPanel extends JPanel{

    private String bgImageRoute;

    public BGPanel(String bgImageRoute){
        this.setLayout(null);
        this.bgImageRoute = bgImageRoute;
    }
    
    @Override
    public void paint(Graphics g){
        ImageIcon bgImage = new ImageIcon(getClass().getResource(bgImageRoute));
        g.drawImage(bgImage.getImage(), 0, 0, getWidth(), getHeight(), this);
        this.setOpaque(false);
        super.paint(g);
    }
}
