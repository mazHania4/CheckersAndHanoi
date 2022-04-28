package com.ipc1.cah.ui.checkers;

import javax.swing.*;

import com.ipc1.cah.checkers.Match;

import java.awt.*;
import java.awt.event.*;

/**
 * Square
 */
public class Square extends JPanel implements ActionListener{

    public static final int SIZE = CheckersFrame.BOARD_SIZE/8;

    private String bgImageRoute;
    private JButton bttnSelect;
    private Match match;
    private int posX;
    private int posY;


    public Square(String bgImageRoute, String bttnImageRoute, Match match, int posX, int posY){
        this.setLayout(null);
        this.match = match;
        this.bgImageRoute = bgImageRoute;
        this.posX = posX;
        this.posY = posY;

        bttnSelect = new JButton();
        bttnSelect.setIcon( new ImageIcon(getClass().getResource(bttnImageRoute)) );   
        bttnSelect.addActionListener(this);
        bttnSelect.setSize(SIZE, SIZE);
        bttnSelect.setOpaque(false);
        bttnSelect.setContentAreaFilled(false);
        bttnSelect.setBorderPainted(false);
        add(bttnSelect); 

    }
    
    public void actionPerformed(ActionEvent evt) {
        this.match.selectToken(this);        
        System.out.println("click sobre casilla " + getPosX() + " y: " + getPosY());
        this.repaint();
        updateUI();        
    }
    
    @Override
    public void paint(Graphics g){
        ImageIcon bgImage = new ImageIcon(getClass().getResource(bgImageRoute));
        g.drawImage(bgImage.getImage(), 0, 0, getWidth(), getHeight(), this);
        this.setOpaque(false);
        super.paintComponents(g);
    }

    public JButton getBttnSelect() {
        return this.bttnSelect;
    }

    public void setBttnSelect(JButton bttnSelect) {
        this.bttnSelect = bttnSelect;
    }

    public int getPosX() {
        return this.posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return this.posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    


}