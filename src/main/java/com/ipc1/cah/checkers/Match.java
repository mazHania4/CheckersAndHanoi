package com.ipc1.cah.checkers;

import java.awt.*;
import javax.swing.*;

import com.ipc1.cah.players.*;
import com.ipc1.cah.ui.checkers.*;
import com.ipc1.cah.ui.checkers.square_buttons.*;
import com.ipc1.cah.ui.utilities.*;
import com.ipc1.cah.utilities.*;

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
    private int player1tokens;
    private int player2tokens;
    private int player1Moves;
    private int player2Moves;

    public Match(){

        //jugadores provisionales, pendiente establecer correctamente
        this.player1 = new Player("Pepe");
        this.player2 = new Player("Oni");

        this.isPlayer1Turn = true;
        this.player1tokens = 12;
        this.player2tokens = 12;

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
        if (!(square.getBttnSelect() instanceof Empty)) {
            boolean isToken = square.getBttnSelect() instanceof Token;
            if (isToken? ((Token)square.getBttnSelect()).getPlayer().equals(isPlayer1Turn ? player1 : player2)
                        :((Queen)square.getBttnSelect()).getPlayer().equals(isPlayer1Turn ? player1 : player2) ) {
                if (  possibleMoveExists( square, (square.getBttnSelect() instanceof Queen) )  ) {
                    selectedSquare1 = square; 
                    showCorrectSelection();
                } else { 
                    showWrongSelection("No hay movimiento posible para esa ficha"); 
                    if ((isPlayer1Turn ? player1tokens : player2tokens) == 1) {
                        endMatch();
                    }
                }
            } else { showWrongSelection("Elija una de sus fichas"); }
        } else { showWrongSelection("Elija primero una ficha a mover"); } 
    }

    public void verifyAddSecondSelectedSquare(Square square){
        boolean correctSelection = false, eatToken = false, isAscendantX = false, isAscendantY = false;
        if (square.getBttnSelect() instanceof Empty) {
            if (  ( (square.getPosX() + square.getPosY()) % 2 ) == 0  ) {              
                if (   !(   (  (selectedSquare1.getPosY() - square.getPosY()) == (selectedSquare1.getPosX() - square.getPosX()) ) ||
                            (  (selectedSquare1.getPosY() - square.getPosY()) == (square.getPosX() - selectedSquare1.getPosX()) ) ||
                            (  (square.getPosY() - selectedSquare1.getPosY()) == (selectedSquare1.getPosX() - square.getPosX()) ) ||
                            (  (square.getPosY() - selectedSquare1.getPosY()) == (square.getPosX() - selectedSquare1.getPosX()) )  )
                    ) {
                            showWrongSelection("Solo puede moverse en diagonal");
                } else {
                    boolean radiusIs1 = (square.getPosX() == selectedSquare1.getPosX()-1) || (square.getPosX() == selectedSquare1.getPosX()+1);
                    boolean radiusIs2 = (square.getPosX() == selectedSquare1.getPosX()-2) || (square.getPosX() == selectedSquare1.getPosX()+2);
                    if ((radiusIs1 || radiusIs2)) {
                        boolean isRightForToken = false;
                        if ((selectedSquare1.getBttnSelect() instanceof Token)) {
                            int radiustmp = radiusIs1 ? 1 : 2;
                            isRightForToken = isPlayer1Turn ? (square.getPosX() == selectedSquare1.getPosX()-radiustmp):(square.getPosX() == selectedSquare1.getPosX()+radiustmp);
                            if(!isRightForToken){ showWrongSelection("Solo puede moverse hacia el oponente"); }
                        }
                        if (radiusIs1) { correctSelection = (selectedSquare1.getBttnSelect() instanceof Queen) ? true : isRightForToken; }
                        if (radiusIs2) {
                            if ((selectedSquare1.getBttnSelect() instanceof Queen) || isRightForToken) { 
                                isAscendantX = (square.getPosX() == selectedSquare1.getPosX()+2);
                                isAscendantY = (square.getPosY() == selectedSquare1.getPosY()+2);
                                if (isAPossibleMove(square.getPosX(), square.getPosY(), isAscendantX, isAscendantY)) {
                                    eatToken = true;
                                    correctSelection = true;
                                } else {showWrongSelection("Puede moverse 2 casillas solo al comer");}
                            }
                        }
                    } else {showWrongSelection("Puede moverse hasta 2 casillas alrededor"); }
                }
            } else { showWrongSelection("Elija una casilla oscura"); }
        } else { showWrongSelection("Elija una casilla vacia"); }

        if (correctSelection) {
            selectedSquare2 = square; 
            if (eatToken) { eatToken(isAscendantX, isAscendantY); }
            moveToken();
            verifyConvertTokenToQueen();
            changeTurn();
        }
    }

    public boolean isAPossibleMove(int posXTo, int posYTo){
        boolean answer = false;
        if ( (posYTo>=0)&&(posYTo<squares.length) && (posXTo>=0)&&(posXTo<squares.length) ) {
            answer = squares[posXTo][posYTo].getBttnSelect() instanceof Empty; 
        }
        return answer;
    }

    public boolean isAPossibleMove(int posXTo, int posYTo, boolean isAscendantX, boolean isAscendantY){
        boolean answer = false;
        if ( (posYTo>=0)&&(posYTo<squares.length) && (posXTo>=0)&&(posXTo<squares.length) ) {
            int posXBtw = isAscendantX ? posXTo-1 : posXTo+1;
            int posYBtw = isAscendantY ? posYTo-1 : posYTo+1;
            if ((squares[posXBtw][posYBtw].getBttnSelect() instanceof Token)) {
                answer = (squares[posXTo][posYTo].getBttnSelect() instanceof Empty) && 
                (((Token)(squares[posXBtw][posYBtw].getBttnSelect())).getPlayer().equals(isPlayer1Turn ? player2 : player1)) ;
            }
            if ((squares[posXBtw][posYBtw].getBttnSelect() instanceof Queen)) {
                answer = (squares[posXTo][posYTo].getBttnSelect() instanceof Empty) && 
                (((Queen)(squares[posXBtw][posYBtw].getBttnSelect())).getPlayer().equals(isPlayer1Turn ? player2 : player1)) ;
            }
        }
        return answer;
    }

    public boolean possibleMoveExists(Square square, boolean hasAQueen){
        int posX = square.getPosX();
        int posY = square.getPosY();
        boolean isPossible1 = false, isPossible2 = false;
        if (hasAQueen) {
            isPossible1 =   (isAPossibleMove(posX-1, posY-1)) ||
                            (isAPossibleMove(posX-1, posY+1)) ||
                            (isAPossibleMove(posX+1, posY-1)) ||
                            (isAPossibleMove(posX+1, posY+1)) ;
            isPossible2 =   (isAPossibleMove(posX+2, posY+2, true, true)) ||
                            (isAPossibleMove(posX+2, posY-2, true, false)) ||
                            (isAPossibleMove(posX-2, posY+2, false, true)) ||
                            (isAPossibleMove(posX-2, posY-2, false, false)) ;
        } else {
            isPossible1 = isPlayer1Turn ? 
                            (isAPossibleMove(posX-1, posY-1)) || (isAPossibleMove(posX-1, posY+1))
                          : (isAPossibleMove(posX+1, posY-1)) || (isAPossibleMove(posX+1, posY+1)) ;
            isPossible2 = isPlayer1Turn ?
                            (isAPossibleMove(posX-2, posY+2, false, true)) || (isAPossibleMove(posX-2, posY-2, false, false))
                          : (isAPossibleMove(posX+2, posY+2, true, true)) || (isAPossibleMove(posX+2, posY-2, true, false));
                            
                            
        }
        return (isPossible1 || isPossible2);
    }
    
    public void moveToken() {
        selectedSquare1.getBttnSelect().setSquareContainer(selectedSquare2);
        selectedSquare2.getBttnSelect().setSquareContainer(selectedSquare1);
        SquareButton tmp = selectedSquare1.getBttnSelect();
        selectedSquare1.setBttnSelect(selectedSquare2.getBttnSelect());
        selectedSquare2.setBttnSelect(tmp);         
        this.board.repaint();        
        //this.board.updateUI();
        if (isPlayer1Turn) { player1Moves++; }
        else { player2Moves++; }
    
    }

    public void eatToken(boolean isAscendantX, boolean isAscendantY){
        int posXBtw = isAscendantX ? selectedSquare2.getPosX()-1 : selectedSquare2.getPosX()+1;
        int posYBtw = isAscendantY ? selectedSquare2.getPosY()-1 : selectedSquare2.getPosY()+1;
        squares[posXBtw][posYBtw].setBttnSelect(new Empty(squares[posXBtw][posYBtw]));
        this.board.repaint();
        if (isPlayer1Turn) { player2tokens = player2tokens - 1; }
        else { player1tokens = player1tokens - 1; }
    }

    public void verifyConvertTokenToQueen(){
        if (!(selectedSquare2.getBttnSelect() instanceof Queen)) {
            if (selectedSquare2.getPosX() == (isPlayer1Turn ? 0 : 7)) {
                selectedSquare2.setBttnSelect(new Queen(selectedSquare2));
                this.board.repaint();
            }
        }
    } 

    public void changeTurn(){ 
        System.out.println("Cambio turno, 1: " + player1tokens + " 2: " + player2tokens);
        if ((player2tokens > 0) && (player2tokens > 0)) {
            this.isPlayer1Turn = !isPlayer1Turn;
            checkersFrame.getLblTurnIndicator1().setBackground(this.isPlayer1Turn ? Color.GREEN : Color.RED); 
            checkersFrame.getLblTurnIndicator2().setBackground(this.isPlayer1Turn ? Color.RED : Color.GREEN); 
            checkersFrame.getLblWrongMoveDescripion().setText(("CAMBIA EL TURNO ( " + (isPlayer1Turn ? "-->" : "<--") + " )"));
            selectedSquare1 = null;
            selectedSquare2 = null;
        } else {
            endMatch();
        }
    }

    public void endMatch(){
        if (isPlayer1Turn) {
            player1.setLostMatchesCheckers(player1.getLostMatchesCheckers() + 1);
            player2.setWonMatchesCheckers(player2.getWonMatchesCheckers() + 1);
            
        } else { 
            player2.setLostMatchesCheckers(player2.getLostMatchesCheckers() + 1);
            player1.setWonMatchesCheckers(player1.getWonMatchesCheckers() + 1);
        }
        player1.setTotalMovesCheckers(player1.getTotalMovesCheckers() + player1Moves); 
        player2.setTotalMovesCheckers(player2.getPlayedMatchesCheckers() + player2Moves);
        player1.setRecordMovesCheckers(player1Moves); 
        player2.setRecordMovesCheckers(player2Moves); 
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
        ChangeBGCLabel.blinkJLabel(lblToBlink, color, Color.GREEN, 1);
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
