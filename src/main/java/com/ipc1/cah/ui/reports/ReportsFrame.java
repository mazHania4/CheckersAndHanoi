package com.ipc1.cah.ui.reports;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;

import com.ipc1.cah.players.Player;
import com.ipc1.cah.players.PlayersManager;
import com.ipc1.cah.ui.ImageRoutes;
import com.ipc1.cah.ui.MainWindow;
import com.ipc1.cah.ui.players.PlayersPanel;
import com.ipc1.cah.ui.utilities.BGPanel;

/**
 * ReportsFrame
 */
public class ReportsFrame extends JFrame{

    private Player[] playersArray;
    private PlayersPanel playersPanel1;

    public ReportsFrame(){
        this.playersArray = PlayersManager.getSavedPlayersArray();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(null);
        setTitle("Reportes");
        setSize(MainWindow.WIDTH, MainWindow.HEIGHT);
        setResizable(false);
        setLocationRelativeTo(null);
        setContentPane(new BGPanel(ImageRoutes.EDGE_BACKGROUND));
        
        JLabel lblCheckers = new JLabel("Damas");
        lblCheckers.setBounds(200, 10, 200, 50);
        lblCheckers.setForeground(Color.WHITE);
        lblCheckers.setFont(new Font((lblCheckers.getFont().getName()), Font.BOLD, 20));
        add(lblCheckers);

        JPanel checkersReports = checkersReports(playersArray);
        checkersReports.setBounds(120, 60, 650, 160);
        add(checkersReports);

        JLabel lblHanoi = new JLabel("Hanoi");
        lblHanoi.setBounds(200, 250, 200, 50);
        lblHanoi.setForeground(Color.WHITE);
        lblHanoi.setFont(new Font((lblCheckers.getFont().getName()), Font.BOLD, 20));
        add(lblHanoi);

        JPanel HanoiReports = hanoiReports(playersArray);
        HanoiReports.setBounds(120, 300, 720, 160);
        add(HanoiReports);

        setVisible(true);
    }

    private JPanel checkersReports(Player[] players){
        JPanel answer = new JPanel();
        if (players != null) {
            String[] columnNames = {"NOMBRE", "Partidas", "Ganadas", "Perdidas", "Movimientos", "Promedio movimientos", "Record movimientos", "Record tiempo"};
            Object[][] data = null;  

            DefaultTableModel dtm= new DefaultTableModel(data, columnNames);
            final JTable table = new JTable(dtm);

            dtm.addRow(columnNames);

            for (int i = 0; i < players.length; i++) {
                if (players[i] != null) {
                    String[] newRow = {
                        players[i].getName(), String.valueOf(players[i].getPlayedMatchesCheckers()), String.valueOf(players[i].getWonMatchesCheckers()),
                        String.valueOf(players[i].getLostMatchesCheckers()), String.valueOf(players[i].getTotalMovesCheckers()), 
                        String.valueOf(players[i].getAverageMovesCheckers()), String.valueOf(players[i].getRecordMovesCheckers()), 
                        String.valueOf(players[i].getStringRecordTimeCheckers())
                    };
                    dtm.addRow(newRow);
                }
            }
            answer.add(table);
        }
        return answer;
    }

    private JPanel hanoiReports(Player[] players){
        JPanel answer = new JPanel();
        if (players != null) {
            String[] columnNames = {"NOMBRE", "Partidas", "Ganadas", "Perdidas", "Abandonadas", "Movimientos", "Promedio movimientos", "Tiempo", "Promedio tiempo"};
            Object[][] data = null;  

            DefaultTableModel dtm= new DefaultTableModel(data, columnNames);
            final JTable table = new JTable(dtm);

            dtm.addRow(columnNames);

            for (int i = 0; i < players.length; i++) {
                if (players[i] != null) {
                    String[] newRow = {
                        players[i].getName(), String.valueOf(players[i].getPlayedMatchesHanoi()), String.valueOf(players[i].getWonMatchesHanoi()),
                        String.valueOf(players[i].getLostMatchesHanoi()), String.valueOf(players[i].getAbandonedMatchesHanoi()),
                        String.valueOf(players[i].getTotalMovesHanoi()), String.valueOf(players[i].getAverageMovesHanoi()), 
                        String.valueOf(players[i].getStringTotalTimeHanoi()), String.valueOf(players[i].getStringAverageTimeHanoi())
                    };
                    dtm.addRow(newRow);
                }
            }
            answer.add(table);
        }
        return answer;
    }


}