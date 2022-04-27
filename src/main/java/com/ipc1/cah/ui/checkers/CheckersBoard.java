package com.ipc1.cah.ui.checkers;

import javax.swing.*;
import com.ipc1.cah.ui.ImageRoutes;
import com.ipc1.cah.utilities.GenerateRandom;

import java.awt.*;

public class CheckersBoard extends JPanel{

    public final int SIZE = 8; 

    private Square squares[][] = new Square[SIZE][SIZE];
    
    public CheckersBoard(){
        setLayout(new GridLayout(SIZE,SIZE));
        setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.LIGHT_GRAY));
        String player1colorTokenRoute = GenerateRandom.randomColorTokenRoute();
        String player2colorTokenRoute = GenerateRandom.randomColorTokenRoute();
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                String bgImageRoute = ((i+j)%2 == 0) ? ImageRoutes.DARK_SQUARE : ImageRoutes.LIGHT_SQUARE;
                String bttnImageRoute = (i<3)   ? ( ((i+j)%2 == 0) ? player1colorTokenRoute: "" ) 
                                                : (  (i>4) ? ( ((i+j)%2 != 0) ? player2colorTokenRoute: "" ) : ""  ) ;
                Square tmp = new Square(bgImageRoute, bttnImageRoute, this, j, i );
                squares[i][j] = tmp;
                add(tmp);
            }
        }
        
    }

    

    
}
