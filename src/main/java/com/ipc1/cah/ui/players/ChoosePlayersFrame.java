package com.ipc1.cah.ui.players;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import com.ipc1.cah.checkers.Match;
import com.ipc1.cah.players.*;
import com.ipc1.cah.ui.*;
import com.ipc1.cah.ui.utilities.BGPanel;

public class ChoosePlayersFrame extends JFrame implements ActionListener{

    private boolean selects2Players;
    private boolean isForCheckers;
    private PlayersPanel playersPanel1;
    private PlayersPanel playersPanel2;
    private JButton bttnCreatePlayer;
    private JButton bttnConfirm;
    private Player[] playersArray;


    public ChoosePlayersFrame(boolean selects2Players, boolean isForCheckers){

        this.selects2Players = selects2Players;
        this.isForCheckers = isForCheckers;
        this.playersArray = PlayersManager.getSavedPlayersArray();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(null);
        setTitle("Seleccion de "+ (selects2Players ? "los jugadores" : "el jugador"));
        setSize(MainWindow.WIDTH, MainWindow.HEIGHT);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        setContentPane(new BGPanel(ImageRoutes.EDGE_BACKGROUND));

        JLabel lblPlayer1 = new JLabel("JUGADOR 1");
        lblPlayer1.setBounds((selects2Players ? 200 : 500), 20, 200, 50);
        lblPlayer1.setForeground(Color.WHITE);
        lblPlayer1.setFont(new Font((lblPlayer1.getFont().getName()), Font.BOLD, 20));
        add(lblPlayer1);

        playersPanel1 = new PlayersPanel(playersArray);
        playersPanel1.setLocation((selects2Players ? 100 : 400), 80);
        add(playersPanel1);

        if (selects2Players) {
            JLabel lblPlayer2 = new JLabel("JUGADOR 2");
            lblPlayer2.setBounds(600, 20, 200, 50);
            lblPlayer2.setForeground(Color.WHITE);
            lblPlayer2.setFont(new Font((lblPlayer1.getFont().getName()), Font.BOLD, 20));
            add(lblPlayer2);

            playersPanel2 = new PlayersPanel(playersArray);
            playersPanel2.setLocation(500, 80);
            add(playersPanel2);
        }    
        
        bttnCreatePlayer = new JButton("Agregar  nuevo jugador");
        bttnCreatePlayer.setBounds(225, 420, 200, 50);
        bttnCreatePlayer.addActionListener(this);
        add(bttnCreatePlayer);
        
        bttnConfirm = new JButton("Confirmar");
        bttnConfirm.setBounds(475, 420, 200, 50);
        bttnConfirm.addActionListener(this);
        add(bttnConfirm);
       
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.bttnConfirm) {
            if (selects2Players) {
                boolean areDifferentPlayers = !((playersPanel1.getPlayerSelected()).equals(playersPanel2.getPlayerSelected())); 
                if ((playersPanel1.getPlayerSelected() != null) && (playersPanel2.getPlayerSelected() != null) && areDifferentPlayers) {
                    if (isForCheckers) {
                        this.setVisible(false);
                        new Match(playersPanel1.getPlayerSelected(), playersPanel2.getPlayerSelected());
                    }
                }
            } else {
                if (playersPanel1.getPlayerSelected() != null) {
                    if (!isForCheckers) {
                        this.setVisible(false);
                        System.out.println("Inicia Hanoi");
                    }
                    
                }
            }
        }
        if (e.getSource() == this.bttnCreatePlayer) {
            boolean isAWrongName = true, cancel = false;
            String name = "";
            do {
                name = JOptionPane.showInputDialog(null, "Ingrese el nombre", "Crear Nuevo Jugador", JOptionPane.QUESTION_MESSAGE);
                if (name == null) {
                    cancel = true;
                    isAWrongName = false;
                } else {
                    if (((name.trim()).length()>0) && ((name.trim()).length()<=8)) {
                        boolean isADifferentName = true;
                        if (playersArray != null) {
                            for (int i = 0; i < playersArray.length; i++) {
                                if (name.equals(playersArray[i].getName())) {
                                    isADifferentName = false;
                                }
                            }
                        }
                        isAWrongName = !isADifferentName;
                    }

                }
            } while (isAWrongName);
            if (!cancel) {
                PlayersManager.addNewPlayer(name);
                this.setVisible(false);
                new ChoosePlayersFrame(selects2Players, isForCheckers);
                this.dispose();
            }
        }
    }
       
}