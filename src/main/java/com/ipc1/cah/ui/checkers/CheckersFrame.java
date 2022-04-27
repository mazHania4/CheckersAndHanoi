package com.ipc1.cah.ui.checkers;

import java.awt.event.*;
import javax.swing.*;
import com.ipc1.cah.ui.*;

public class CheckersFrame extends JFrame implements ActionListener{

    public static final int BOARD_SIZE = 400;

    private CheckersBoard checkersBoard;

    public CheckersFrame(){

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(null);
        setTitle("Partida de Damas");
        setSize(MainWindow.WIDTH, MainWindow.HEIGHT);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        BGPanel pnlBackground = new BGPanel(ImageRoutes.FULL_BACKGROUND);
        setContentPane(pnlBackground);

        checkersBoard = new CheckersBoard();
        checkersBoard.setSize(BOARD_SIZE, BOARD_SIZE);
        int cBoardX = (getWidth() - checkersBoard.getWidth() - getInsets().left - getInsets().right) / 2;
	    int cBoardY = 50;//(getHeight() - checkersBoard.getHeight() - getInsets().top - getInsets().bottom) / 2;
		checkersBoard.setLocation(cBoardX, cBoardY);
        add(checkersBoard);


        
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent evt) {
        
    }
    
}
