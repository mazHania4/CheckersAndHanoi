package com.ipc1.cah.checkers;

import java.awt.*;
import javax.swing.*;

import com.ipc1.cah.ui.ImageRoutes;
import com.ipc1.cah.ui.checkers.*;
import com.ipc1.cah.ui.checkers.square_buttons.SquareButton;
import com.ipc1.cah.utilities.GenerateRandom;

public class Match {

    public final int BOARD_SIZE = 8; 
    private CheckersFrame checkersFrame;
    private JPanel board;
    private Square squares[][];
    private String player1ColorTokenRoute;
    private String player2ColorTokenRoute;
    private Square selectedSquare1;
    private Square selectedSquare2;

    public Match(){

        squares = new Square[BOARD_SIZE][BOARD_SIZE];
        player1ColorTokenRoute = GenerateRandom.colorTokenRoute();
        player2ColorTokenRoute = GenerateRandom.colorTokenRoute(player1ColorTokenRoute);

        board = new JPanel();
        board.setLayout(new GridLayout(BOARD_SIZE, BOARD_SIZE));
        board.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.LIGHT_GRAY));
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                String bgImageRoute = ((i+j)%2 == 0) ? ImageRoutes.DARK_SQUARE : ImageRoutes.LIGHT_SQUARE;
                String bttnImageRoute = (j<3)   ? ( ((i+j)%2 != 0) ? player1ColorTokenRoute: "" ) 
                                                : (  (j>4) ? ( ((i+j)%2 != 0) ? player2ColorTokenRoute: "" ) : ""  ) ;
                Square tmp = new Square(bgImageRoute, bttnImageRoute, this, j, i );
                squares[i][j] = tmp;
                board.add(tmp);
            }
        }

        checkersFrame = new CheckersFrame(board);
    }

    public void selectSquare(Square square){
        if (selectedSquare1 == null) { 
            selectedSquare1 = square; 
        } else{
            if (selectedSquare2 == null) { 
                selectedSquare2 = square; 
                moveToken();
                checkersFrame.setTurn(false);
                System.out.println("Ya debio hacerlo");
                selectedSquare1 = null;
                selectedSquare2 = null;
            }   
        }  

    }
    
    public void moveToken() {
        selectedSquare1.getBttnSelect().setSquareContainer(selectedSquare2);
        selectedSquare2.getBttnSelect().setSquareContainer(selectedSquare1);
        SquareButton tmp = selectedSquare1.getBttnSelect();
        selectedSquare1.remove(selectedSquare1.getBttnSelect());
        selectedSquare1.setBttnSelect(selectedSquare2.getBttnSelect());
        selectedSquare2.remove(selectedSquare2.getBttnSelect());
        selectedSquare2.setBttnSelect(tmp); 
        this.board.repaint();
        //this.board.updateUI();        
    }

    
}
