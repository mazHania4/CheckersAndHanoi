package com.ipc1.cah.ui.checkers;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Square
 */
public class Square extends JPanel implements ActionListener{

    public static final int SIZE = CheckersFrame.BOARD_SIZE/8;

    private String bgImageRoute;
    private JButton bttnSelect;
    private JPanel pnlContainer;
    private int posX;
    private int posY;


    public Square(String bgImageRoute, String bttnImageRoute, JPanel plnContainer, int posX, int posY){
        this.setLayout(null);
        this.pnlContainer = plnContainer;
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
    
    @Override
    public void paint(Graphics g){
        ImageIcon bgImage = new ImageIcon(getClass().getResource(bgImageRoute));
        g.drawImage(bgImage.getImage(), 0, 0, getWidth(), getHeight(), this);
        this.setOpaque(false);
        super.paintComponents(g);
    }

    public void actionPerformed(ActionEvent evt) {
        System.out.println("click sobre casilla " + getPosX() + " y: " + getPosY());
    }

    public JButton getBttnSelect() {
        return this.bttnSelect;
    }

    public void setBttnSelect(JButton bttnSelect) {
        this.bttnSelect = bttnSelect;
    }

    public JPanel getPnlContainer() {
        return pnlContainer;
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