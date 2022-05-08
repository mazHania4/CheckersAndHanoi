package com.ipc1.cah.players;

import java.io.*;

import com.ipc1.cah.utilities.file_management.SerializationManager;

public class PlayersManager {
    
    private static SerializationManager playersSerializer = new SerializationManager("src/main/java/com/ipc1/cah/files/");
    private static Players playersList = getSavedPlayersList();

    public static void savePlayersList(){
        try {
            playersSerializer.writeSerialization(playersList, "players");
        } catch (FileNotFoundException e) {
            //e.printStackTrace();
        }
    }

    public static Player[] getSavedPlayersArray(){
        Player[] answer = null;
        try {
            Players tmp = (Players) playersSerializer.readSerialization("players");
            answer = tmp.getPlayersArray();    
        } catch (FileNotFoundException e) { /*e.printStackTrace();*/ } 
        catch (IOException e) { /*e.printStackTrace();*/ }
        catch (ClassNotFoundException e) { /*e.printStackTrace();*/}
        return answer;
    }

    private static Players getSavedPlayersList(){
        Players answer = new Players();
        try {
            answer = (Players) playersSerializer.readSerialization("players");
        } catch (FileNotFoundException e) { /*e.printStackTrace();*/ } 
          catch (IOException e) { /*e.printStackTrace();*/ }
          catch (ClassNotFoundException e) { /*e.printStackTrace();*/ }
        return answer;
    }

    public static void addNewPlayer(String name){
        playersList.addPlayer(new Player(name));
        savePlayersList();
    }


}
