package com.ipc1.cah;

import com.ipc1.cah.hanoi.HanoiMatch;
import com.ipc1.cah.players.Player;
import com.ipc1.cah.ui.MainWindow;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ){

        System.out.println( "Hello World!" );
        new MainWindow();
        
        /*
        SerializationManager playersSerializer = new SerializationManager("src/main/java/com/ipc1/cah/files/");
        Players players = new Players();
        players.addPlayer(new Player("Prueba"));

        try {
            playersSerializer.writeSerialization(players, "prueba");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            Players tmp = (Players) playersSerializer.readSerialization("players");
            //to do:
            Player[] pla1 = tmp.getPlayersList();
            if (pla1.length>0) {
                System.out.println(pla1.length + pla1[0].getName());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        */
    }
}
