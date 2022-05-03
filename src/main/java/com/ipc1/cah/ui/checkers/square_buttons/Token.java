package com.ipc1.cah.ui.checkers.square_buttons;

import javax.swing.*;
import com.ipc1.cah.players.Player;
import com.ipc1.cah.ui.checkers.Square;

public class Token extends SquareButton{

    private Player player; 

    public Token(Square squareContainer){
        super(squareContainer);
        if (this.getSquareContainer().getPosX()>4) {
            this.player = squareContainer.getMatch().getPlayer1();
            setIcon( new ImageIcon(getClass().getResource( squareContainer.getMatch().getPlayer1ColorTokenRoute() )) );   
        } else {
            this.player = squareContainer.getMatch().getPlayer2();
            setIcon( new ImageIcon(getClass().getResource( squareContainer.getMatch().getPlayer2ColorTokenRoute() )) );   
        }
    }

    public Player getPlayer() {
        return player;
    }    
    
}
