package com.ipc1.cah.ui.players;


import javax.swing.*;
import java.awt.event.*;
import com.ipc1.cah.players.Player;

public class PlayerRButton extends JRadioButton implements ActionListener{
    
    private Player player;
    private PlayersPanel playersPanel;

    public PlayerRButton(Player player, PlayersPanel playersPanel){
        this.player = player;
        this.playersPanel = playersPanel;
        setText(player.getName());
        addActionListener(this);
    }

    @Override
    public void actionPerformed(java.awt.event.ActionEvent evt) {
        this.playersPanel.setPlayerSelected(this.player);
    }

}
