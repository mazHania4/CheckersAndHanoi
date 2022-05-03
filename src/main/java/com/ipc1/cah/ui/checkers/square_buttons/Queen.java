package com.ipc1.cah.ui.checkers.square_buttons;

import javax.swing.*;
import com.ipc1.cah.players.Player;
import com.ipc1.cah.ui.ImageRoutes;

public class Queen extends SquareButton{

    private Player player; 

    public Queen(Token token){
        super(token.getSquareContainer());
        this.player = token.getPlayer();
        if (token.getSquareContainer().getMatch().getPlayer1() == token.getPlayer()) {
            setIcon( new ImageIcon(getClass().getResource( ImageRoutes.WHITE_QUEEN )) );   
        } else {
            setIcon( new ImageIcon(getClass().getResource( ImageRoutes.BLACK_QUEEN )) );
        }   
    }

    public Player getPlayer() {
        return player;
    }    
    
    
}
