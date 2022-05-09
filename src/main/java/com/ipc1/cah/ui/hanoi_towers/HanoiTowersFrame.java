package com.ipc1.cah.ui.hanoi_towers;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import com.ipc1.cah.hanoi.HanoiMatch;
import com.ipc1.cah.ui.*;
import com.ipc1.cah.ui.utilities.BGPanel;

public class HanoiTowersFrame extends JFrame implements ActionListener{

    private JLabel lblPlayerTime;
    private HanoiMatch match;
    private JButton bttnTower1To3;
    private JButton bttnTower1To2;
    private JButton bttnTower2To1;
    private JButton bttnTower2To3;
    private JButton bttnTower3To2;
    private JButton bttnTower3To1;

    public HanoiTowersFrame(String playerName, HanoiMatch match, Tower[] towers){

        this.match = match;

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(null);
        setTitle("Partida de Damas");
        setSize(MainWindow.WIDTH, MainWindow.HEIGHT);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        setContentPane(new BGPanel(ImageRoutes.FULL_BACKGROUND));

        JLabel lblPlayer = new JLabel(playerName, SwingConstants.CENTER);
        lblPlayer.setBounds(225, 425, 150, 50);
        lblPlayer.setForeground(Color.WHITE);
        lblPlayer.setOpaque(true);
        lblPlayer.setBackground(Color.DARK_GRAY);
        lblPlayer.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.LIGHT_GRAY));
        lblPlayer.setFont(new Font((lblPlayer.getFont().getName()), Font.BOLD, 24));
        add(lblPlayer);

        lblPlayerTime = new JLabel("00:00", SwingConstants.CENTER);
        lblPlayerTime.setBounds(500, 425, 150, 50);
        lblPlayerTime.setForeground(Color.WHITE);
        lblPlayerTime.setOpaque(true);
        lblPlayerTime.setBackground(Color.DARK_GRAY);
        lblPlayerTime.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.LIGHT_GRAY));
        lblPlayerTime.setFont(new Font((lblPlayerTime.getFont().getName()), Font.BOLD, 24));
        add(lblPlayerTime);

        JPanel pnlboard = new BGPanel(ImageRoutes.HANOI_BOARD);
        pnlboard.setBounds(65, 50, 770, 350);
        add(pnlboard);

        bttnTower1To3 = createButtonTower(false, 40);
        pnlboard.add(bttnTower1To3);
        
        bttnTower1To2 = createButtonTower(true, 140);
        pnlboard.add(bttnTower1To2);
        
        bttnTower2To1 = createButtonTower(false, 300);
        pnlboard.add(bttnTower2To1);
        
        bttnTower2To3 = createButtonTower(true, 410);
        pnlboard.add(bttnTower2To3);
        
        bttnTower3To2 = createButtonTower(false, 555);
        pnlboard.add(bttnTower3To2);
        
        bttnTower3To1 = createButtonTower(true, 665);
        pnlboard.add(bttnTower3To1);

        for (int i = 0; i < towers.length; i++) {
            towers[i].setBounds((i*250)+20, 0, 250, 295);  
            pnlboard.add(towers[i]); 
        }
/*
        towers[0].setBounds(0, 0, 250, 300);
        Tower tower = new Tower();
        tower.setBounds(0, 0, 250, 300);
        pnlboard.add(tower);

        Disk disk = new Disk(2, tower);
        disk.setLocation(30, 20);
        tower.stack(disk);
        tower.add(disk);
*/
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.bttnTower1To3) {

        }
        if (e.getSource() == this.bttnTower1To2) {

        }
        if (e.getSource() == this.bttnTower2To1) {

        }
        if (e.getSource() == this.bttnTower2To3) {

        }
        if (e.getSource() == this.bttnTower3To2) {

        }
        if (e.getSource() == this.bttnTower3To1) {

        }
    }

    private JButton createButtonTower(boolean isToRight, int x){
        JButton answer = new JButton((isToRight ? ">>" : "<<"));        
        answer.setBounds(x, 303, 70, 30);
        answer.addActionListener(this);
        answer.setOpaque(false);        
        answer.setContentAreaFilled(false);
        answer.setBorderPainted(false);
        answer.setForeground(new Color(109, 65, 42));
        answer.setFont(new Font((answer.getFont().getName()), Font.BOLD, 30));
        return answer;
    }

    public JLabel getLblPlayerTime() {
        return lblPlayerTime;
    }
    
    
}
