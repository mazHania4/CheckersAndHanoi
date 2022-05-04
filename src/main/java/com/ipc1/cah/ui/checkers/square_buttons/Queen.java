package com.ipc1.cah.ui.checkers.square_buttons;

import javax.swing.*;
import com.ipc1.cah.players.Player;
import com.ipc1.cah.ui.ImageRoutes;
import com.ipc1.cah.ui.checkers.Square;

public class Queen extends SquareButton{

    private Player player; 

    public Queen(Square squareContainer){
        super(squareContainer);
        this.player = ((Token)squareContainer.getBttnSelect()).getPlayer();
        if (squareContainer.getMatch().getPlayer1() == player) {
            setIcon( new ImageIcon(getClass().getResource( ImageRoutes.WHITE_QUEEN )) );   
        } else {
            setIcon( new ImageIcon(getClass().getResource( ImageRoutes.BLACK_QUEEN )) );
        }   
    }

    public Player getPlayer() {
        return player;
    }    
    
    
}
