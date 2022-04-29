package com.ipc1.cah.ui.hanoi_towers;

import javax.swing.*;

import com.ipc1.cah.ui.*;
import com.ipc1.cah.ui.utilities.BGPanel;

public class HanoiTowersFrame extends JFrame{

    public HanoiTowersFrame(){

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(null);
        setTitle("Partida de Damas");
        setSize(MainWindow.WIDTH, MainWindow.HEIGHT);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        BGPanel pnlBackground = new BGPanel(ImageRoutes.FULL_BACKGROUND);
        setContentPane(pnlBackground);

        this.setVisible(true);
    }
    
}
