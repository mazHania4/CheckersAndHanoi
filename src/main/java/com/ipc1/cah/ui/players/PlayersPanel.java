package com.ipc1.cah.ui.players;

import javax.swing.*;
import java.awt.*;

import com.ipc1.cah.players.*;

public class PlayersPanel extends JPanel{

    private Player playerSelected;

    public PlayersPanel(Player[] players){

        setSize(300, 300);
        if (players != null) {
            int cols = (players.length>24) ? 3 : 2;
            int rows = (int)(players.length/cols) + 1;
            setLayout(new GridLayout(rows, cols));
    
            ButtonGroup bg = new ButtonGroup();
    
            for (int i = 0; i < players.length; i++) {
                if (players[i] != null) {
                    PlayerRButton playerRButton = new PlayerRButton(players[i], this);
                    add(playerRButton);
                    bg.add(playerRButton);
                }
            }
        }

        
    }

    public Player getPlayerSelected(){
        return this.playerSelected;
    }

    public void setPlayerSelected(Player playerSelected) {
        this.playerSelected = playerSelected;
    }

    
    
}

