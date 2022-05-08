package com.ipc1.cah;

//import java.io.FileNotFoundException;
//import java.io.IOException;

//import com.ipc1.cah.players.Players;
import com.ipc1.cah.ui.players.ChoosePlayersFrame;
//import com.ipc1.cah.utilities.file_management.SerializationManager;

//import com.ipc1.cah.checkers.Match;
//import com.ipc1.cah.ui.hanoi_towers.HanoiTowersFrame;
//import com.ipc1.cah.ui.MainWindow;
//import com.ipc1.cah.ui.checkers.CheckersFrame;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ){

        System.out.println( "Hello World!" );
        //new MainWindow();
        //new CheckersFrame();
        //new HanoiTowersFrame();
        //new Match();

        /*
        SerializationManager playersSerializer = new SerializationManager("src/main/java/com/ipc1/cah/files/");
        Players players = new Players();
        players.addPlayer(new Player("Onidas"));

        try {
            playersSerializer.writeSerialization(players, "players");
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
  

        new ChoosePlayersFrame(true, true);

    }
}
