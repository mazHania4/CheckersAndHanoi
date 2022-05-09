package com.ipc1.cah.ui.hanoi_towers;

//import java.awt.*;
import javax.swing.*;

import com.ipc1.cah.ui.ImageRoutes;

public class Disk extends JLabel{

    private Disk next;
    private String bgImageRoute;

    private Tower tower;
    private int radio;

    public Disk(int radio, Tower tower){
        this.setLayout(null);
        this.radio = radio;
        this.tower = tower;
        this.setSize(250, 30);
        switch (radio) {
            case 1: this.bgImageRoute = ImageRoutes.RED_DISK; break;
            case 2: this.bgImageRoute = ImageRoutes.ORANGE_DISK; break;
            case 3: this.bgImageRoute = ImageRoutes.YELLOW_DISK; break;
            case 4: this.bgImageRoute = ImageRoutes.GREEN_DISK; break;
            case 5: this.bgImageRoute = ImageRoutes.AQUA_DISK; break;
            case 6: this.bgImageRoute = ImageRoutes.CYAN_DISK; break;
            case 7: this.bgImageRoute = ImageRoutes.BLUE_DISK; break;
            case 8: this.bgImageRoute = ImageRoutes.PURPLE_DISK; break;
        }
        setIcon(new ImageIcon(getClass().getResource(bgImageRoute))); 
        tower.add(this);
    }

    public Disk getNext() {
        return next;
    }

    public void setNext(Disk next) {
        this.next = next;
    }

    public Tower getTower() {
        return tower;
    }

    public void setTower(Tower tower) {
        this.tower = tower;
    }

    public int getRadio() {
        return radio;
    }

/*
    @Override
    public void paint(Graphics g){
        ImageIcon bgImage = new ImageIcon(getClass().getResource(bgImageRoute));
        g.drawImage(bgImage.getImage(), 0, 0, getWidth(), getHeight(), this);
        this.setOpaque(false);
        super.paintComponents(g);
    }    
*/
}
