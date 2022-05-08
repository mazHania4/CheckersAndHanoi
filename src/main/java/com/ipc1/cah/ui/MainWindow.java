package com.ipc1.cah.ui;

import javax.swing.*;
import java.awt.event.*;

import com.ipc1.cah.ui.utilities.BGPanel;

public class MainWindow extends JFrame implements ActionListener{

    public static final int WIDTH = 900;
    public static final int HEIGHT = 550;
   
    private BGPanel pnlBackground;
    private JLabel lblGameTitle;
    private JButton bttnPlayCheckers ;
    private JButton bttnPlayHanoiTowers; 
    private JButton bttnReports;
    
    public MainWindow(){

        lblGameTitle = new JLabel();
        bttnPlayCheckers = new JButton();
        bttnPlayHanoiTowers = new JButton();
        bttnReports = new JButton();
        pnlBackground = new BGPanel(ImageRoutes.EDGE_BACKGROUND);
        
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(null);
        setContentPane(pnlBackground);
        setTitle("Damas y Hanoi");
        setSize(WIDTH, HEIGHT);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        lblGameTitle.setIcon(new ImageIcon(getClass().getResource(ImageRoutes.GAME_TITLE))); 
        lblGameTitle.setBounds(170, 50, 500, 160);
        add(lblGameTitle); 
        
        bttnPlayCheckers.setIcon(new ImageIcon(getClass().getResource(ImageRoutes.PLAY_CHECKERS)));
        bttnPlayCheckers.setBounds(190, 210, 180, 100);
        bttnPlayCheckers.addActionListener(this);
        add(bttnPlayCheckers); 
        
        bttnPlayHanoiTowers.setIcon(new ImageIcon(getClass().getResource(ImageRoutes.PLAY_HANOI)));
        bttnPlayHanoiTowers.setBounds(510, 210, 180, 100);
        bttnPlayHanoiTowers.addActionListener(this);
        add(bttnPlayHanoiTowers); 
        
        bttnReports.setIcon(new ImageIcon(getClass().getResource(ImageRoutes.REPORTS)));     
        bttnReports.setBounds(360, 370, 170, 80);
        bttnReports.addActionListener(this);
        add(bttnReports); 
        
        this.setVisible(true); 
    }

    public void actionPerformed(ActionEvent evt) {
        if (evt.getSource() == bttnPlayCheckers) {
            System.out.println("click sobre jugar damas");
        }
        if (evt.getSource() == bttnPlayHanoiTowers) {
            System.out.println("click sobre jugar torres de hanoi");
        }
        if (evt.getSource() == bttnReports) {
            System.out.println("click sobre reportes");
        }
    }

}
