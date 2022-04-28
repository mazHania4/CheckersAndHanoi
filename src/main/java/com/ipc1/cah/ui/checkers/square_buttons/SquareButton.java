package com.ipc1.cah.ui.checkers.square_buttons;

import javax.swing.*;
import java.awt.event.*;
import com.ipc1.cah.ui.checkers.Square;

public class SquareButton extends JButton implements ActionListener{

    private Square squareContainer;

    public SquareButton(String bttnImageRoute, Square squareContainer){

        this.squareContainer = squareContainer;
        
        setIcon( new ImageIcon(getClass().getResource(bttnImageRoute)) );   
        setSize(Square.SIZE, Square.SIZE);
        setOpaque(false);
        setContentAreaFilled(false);
        setBorderPainted(false);
        addActionListener(this);
    }

    public void actionPerformed(java.awt.event.ActionEvent evt) {
        squareContainer.getMatch().selectSquare(squareContainer);        
        System.out.println("click sobre casilla " + squareContainer.getPosX() + " y: " + squareContainer.getPosY());
    }

    public Square getSquareContainer() {
        return squareContainer;
    }

    public void setSquareContainer(Square squareContainer) {
        this.squareContainer = squareContainer;
    }

    
    
}
