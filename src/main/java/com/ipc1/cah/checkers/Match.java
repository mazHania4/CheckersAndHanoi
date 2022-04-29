package com.ipc1.cah.checkers;

import java.awt.*;
import javax.swing.*;

import com.ipc1.cah.players.*;
//import com.ipc1.cah.ui.ImageRoutes;
import com.ipc1.cah.ui.checkers.*;
import com.ipc1.cah.ui.checkers.square_buttons.*;
import com.ipc1.cah.utilities.GenerateRandom;

public class Match {

    public final int BOARD_SIZE = 8; 

    private CheckersFrame checkersFrame;
    private JPanel board;
    private Square squares[][];
    private Player player1;
    private Player player2;
    private String player1ColorTokenRoute;
    private String player2ColorTokenRoute;
    private Square selectedSquare1;
    private Square selectedSquare2;
    private boolean isPlayer1Turn;

    public Match(){

        squares = new Square[BOARD_SIZE][BOARD_SIZE];
        player1ColorTokenRoute = GenerateRandom.colorTokenRoute();
        player2ColorTokenRoute = GenerateRandom.colorTokenRoute(player1ColorTokenRoute);

        board = new JPanel();
        board.setLayout(new GridLayout(BOARD_SIZE, BOARD_SIZE));
        board.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.LIGHT_GRAY));
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                boolean isDarkSquare = (i+j)%2 == 0;
                boolean hasToken = isDarkSquare && (j<3 || j>4);
                Square tmp = new Square(isDarkSquare, hasToken, this, j, i );
                squares[i][j] = tmp;
                board.add(tmp);
                /*String bgImageRoute = ((i+j)%2 != 0) ? ImageRoutes.DARK_SQUARE : ImageRoutes.LIGHT_SQUARE;
                String bttnImageRoute = (j<3)   ? ( ((i+j)%2 == 0) ? player1ColorTokenRoute: "" ) 
                                                : (  (j>4) ? ( ((i+j)%2 == 0) ? player2ColorTokenRoute: "" ) : ""  ) ;
                Square tmp = new Square(bgImageRoute, bttnImageRoute, this, j, i );
                squares[i][j] = tmp;
                board.add(tmp);*/
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
                moveTokenIfPossible();
                selectedSquare1 = null;
                selectedSquare2 = null;
            }   
        }  
    }

    public void moveTokenIfPossible(){
        //int posX1 = selectedSquare1.getPosX();
        //int posY1 = selectedSquare1.getPosY();
        int posX2 = selectedSquare2.getPosX();
        int posY2 = selectedSquare2.getPosY();
        boolean squareToIsDark = ((posX2+posY2)%2 == 0) ? true : false;
        if (squareToIsDark) {
            moveToken();
            changeTurn();
        } else {
            System.out.println("no es posible");           
            showWrongMoveBlinking();
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

    public void changeTurn(){
        checkersFrame.getLblTurnIndicator1().setBackground(this.isPlayer1Turn ? Color.GREEN : Color.RED); 
        checkersFrame.getLblTurnIndicator2().setBackground(this.isPlayer1Turn ? Color.RED : Color.GREEN); 
        this.isPlayer1Turn = !isPlayer1Turn;
    }

    public void showWrongMoveBlinking(){   
        JLabel lblToBlink = this.isPlayer1Turn ? checkersFrame.getLblTurnIndicator1(): checkersFrame.getLblTurnIndicator2();
        BlinkJLabel.blinkJLabel(lblToBlink, Color.ORANGE, Color.GREEN, 1);
    }

    public String getPlayer1ColorTokenRoute() {
        return player1ColorTokenRoute;
    }

    public String getPlayer2ColorTokenRoute() {
        return player2ColorTokenRoute;
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }
    
}
