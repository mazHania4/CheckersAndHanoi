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

        //jugadores provisionales, pendiente
        this.player1 = new Player("Pepe");
        this.player2 = new Player("Oni");
        this.isPlayer1Turn = true;

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
                squares[j][i] = tmp;
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
            verifyAddFirstSelectedSquare(square);
        } else{
            if (selectedSquare2 == null) { 
                verifyAddSecondSelectedSquare(square);
            }   
        }  
    }

    public void verifyAddFirstSelectedSquare(Square square){
        if (square.getBttnSelect() instanceof Token) {
            if (((Token)square.getBttnSelect()).getPlayer().equals(isPlayer1Turn ? player1 : player2)) {
                if (possibleMoveExists(square)) {
                    selectedSquare1 = square; 
                    showCorrectSelection();
                } else { showWrongSelection("No hay movimiento posible para esa ficha"); }
            } else { showWrongSelection("Elija una de sus fichas"); }
        } else { showWrongSelection("Elija primero una ficha a mover"); } 
    }

    public void verifyAddSecondSelectedSquare(Square square){
        if (square.getBttnSelect() instanceof Empty) {
            if (  ( (square.getPosX() + square.getPosY()) % 2 ) == 0  ) {
                selectedSquare2 = square; 
                moveToken();
                changeTurn();
            } else { showWrongSelection("Elija una casilla oscura"); }
        } else { showWrongSelection("Elija una casilla vacia"); }
    }

    public boolean isAPossibleMove(int posXTo, int posYTo){
        boolean answer = false;
        System.out.println("re: x-" + posXTo+ " y-" +posYTo);
        if ( (posYTo>0)&&(posYTo<squares.length) && (posXTo>0)&&(posXTo<squares.length) ) {
            answer = squares[posXTo][posYTo].getBttnSelect() instanceof Empty; 
        }
        System.out.println("verif1: " + answer);
        return answer;
    }

    public boolean isAPossibleMove(int posXTo, int posYTo, boolean isAscendantX, boolean isAscendantY){
        boolean answer = false;
        if ( (posYTo>0)&&(posYTo<squares.length) && (posXTo>0)&&(posXTo<squares.length) ) {
            int posXBtw = isAscendantX ? posXTo-1 : posXTo+1;
            int posYBtw = isAscendantY ? posYTo-1 : posYTo+1;
            if ((squares[posXBtw][posYBtw].getBttnSelect() instanceof Token)) {
                answer = (squares[posXTo][posYTo].getBttnSelect() instanceof Empty) && 
                (((Token)(squares[posXBtw][posYBtw].getBttnSelect())).getPlayer().equals(isPlayer1Turn ? player2 : player1)) ;
            }
            //if (radius == 2) { answer = ((squares[posX][posY].getBttnSelect() instanceof Empty)&&(squares[posX][posY].getBttnSelect() instanceof Token)); }
        }
        System.out.println(answer);
        return answer;
    }

    public boolean possibleMoveExists(Square square){
        int posX = square.getPosX();
        int posY = square.getPosY();
        System.out.println("posO: x-" + posX + " y-" + posY);
        boolean isPossible1 =   (isAPossibleMove(posX-1, posY-1)) ||
                                (isAPossibleMove(posX-1, posY+1)) ||
                                (isAPossibleMove(posX+1, posY-1)) ||
                                (isAPossibleMove(posX+1, posY+1)) ;
        boolean isPossible2 =   (isAPossibleMove(posX+2, posY+2, true, true)) ||
                                (isAPossibleMove(posX+2, posY-2, true, false)) ||
                                (isAPossibleMove(posX-2, posY+2, false, true)) ||
                                (isAPossibleMove(posX-2, posY-2, false, false)) ;
        System.out.println("1: "+isPossible1 + " 2: "+ isPossible2);
        return (isPossible1 || isPossible2);
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
        this.isPlayer1Turn = !isPlayer1Turn;
        checkersFrame.getLblTurnIndicator1().setBackground(this.isPlayer1Turn ? Color.GREEN : Color.RED); 
        checkersFrame.getLblTurnIndicator2().setBackground(this.isPlayer1Turn ? Color.RED : Color.GREEN); 
        checkersFrame.getLblWrongMoveDescripion().setText(("CAMBIA EL TURNO ( " + (isPlayer1Turn ? "-->" : "<--") + " )"));
        selectedSquare1 = null;
        selectedSquare2 = null;
    }

    public void showWrongSelection(String description){
        showWrongMoveBlinking(Color.ORANGE);
        checkersFrame.getLblWrongMoveDescripion().setText(description);
    }

    public void showCorrectSelection(){
        showWrongMoveBlinking(Color.CYAN);
        checkersFrame.getLblWrongMoveDescripion().setText("Seleccion correcta");
    }

    public void showWrongMoveBlinking(Color color){   
        JLabel lblToBlink = this.isPlayer1Turn ? checkersFrame.getLblTurnIndicator1(): checkersFrame.getLblTurnIndicator2();
        BlinkJLabel.blinkJLabel(lblToBlink, color, Color.GREEN, 1);
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
