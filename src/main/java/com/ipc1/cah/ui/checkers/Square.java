package com.ipc1.cah.ui.checkers;

import javax.swing.*;
import java.awt.*;
import com.ipc1.cah.checkers.CheckersMatch;
import com.ipc1.cah.ui.ImageRoutes;
import com.ipc1.cah.ui.checkers.square_buttons.*;

/**
 * Square
 */
public class Square extends JPanel {

    public static final int SIZE = CheckersFrame.BOARD_SIZE/8;

    private String bgImageRoute;
    private SquareButton bttnSelect;
    private CheckersMatch match;
    private int posX;
    private int posY;

    public Square(boolean isDarkSquare, boolean hasToken, CheckersMatch match, int posX, int posY){
        this.setLayout(null);
        this.match = match;
        this.bgImageRoute = isDarkSquare ? ImageRoutes.DARK_SQUARE : ImageRoutes.LIGHT_SQUARE;
        this.posX = posX;
        this.posY = posY;
        if (hasToken) {
            this.bttnSelect = new Token(this);
        } else {
            this.bttnSelect = new Empty(this);
        }
        add(bttnSelect);
    }
    
    @Override
    public void paint(Graphics g){
        ImageIcon bgImage = new ImageIcon(getClass().getResource(bgImageRoute));
        g.drawImage(bgImage.getImage(), 0, 0, getWidth(), getHeight(), this);
        this.setOpaque(false);
        super.paintComponents(g);
    }

    public SquareButton getBttnSelect() {
        return this.bttnSelect;
    }

    public void setBttnSelect(SquareButton bttnSelect) {
        this.remove(this.bttnSelect);
        this.bttnSelect = bttnSelect;
        this.add(bttnSelect);
    }

    public int getPosX() {
        return this.posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return this.posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public CheckersMatch getMatch() {
        return match;
    }

    


}