package com.ipc1.cah.players;

import java.io.Serializable;
import java.util.ArrayList;

public class Players implements Serializable{
    
    private ArrayList<Player> players = new ArrayList<Player>();

    public void addPlayer(Player player){
        if (player != null) {
            players.add(player);
        }
    }

    public Player[] getPlayersArray(){
        Player[] tmpPlayers = new Player[players.size()];
        for (int i = 0; i < tmpPlayers.length; i++) {
            tmpPlayers[i] = players.get(i);
        }
        return tmpPlayers;
    }

}
