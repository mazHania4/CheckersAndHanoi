package com.ipc1.cah.ui.checkers;

import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;
import com.ipc1.cah.ui.*;

public class CheckersFrame extends JFrame implements ActionListener{

    public static final int BOARD_SIZE = 400;
    private JLabel bttnTurnIndicator1;
    private JLabel bttnTurnIndicator2;

    public CheckersFrame(JPanel checkersBoard){

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(null);
        setTitle("Partida de Damas");
        setSize(MainWindow.WIDTH, MainWindow.HEIGHT);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        BGPanel pnlBackground = new BGPanel(ImageRoutes.FULL_BACKGROUND);
        setContentPane(pnlBackground);

        checkersBoard.setSize(BOARD_SIZE, BOARD_SIZE);
        int cBoardX = (getWidth() - checkersBoard.getWidth() - getInsets().left - getInsets().right) / 2;
	    int cBoardY = 80;//(getHeight() - checkersBoard.getHeight() - getInsets().top - getInsets().bottom) / 2;
		checkersBoard.setLocation(cBoardX, cBoardY);
        add(checkersBoard);
        
        bttnTurnIndicator1 = new JLabel();
        bttnTurnIndicator1.setBounds(600, 20, 35, 35);
        bttnTurnIndicator1.setOpaque(true);
        add(bttnTurnIndicator1);

        bttnTurnIndicator2 = new JLabel();
        bttnTurnIndicator2.setBounds(262, 20, 35, 35);
        bttnTurnIndicator2.setOpaque(true);
        add(bttnTurnIndicator2);

        setTurn(true);
        
        this.setVisible(true);
    }
    
    public void setTurn(boolean isPlayer1Turn){
        bttnTurnIndicator1.setBackground(Color.GREEN); 
        bttnTurnIndicator2.setBackground(Color.RED); 
    }

    public void actionPerformed(ActionEvent evt) {
        
    }
    
}
