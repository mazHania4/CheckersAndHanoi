package com.ipc1.cah.ui.checkers;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import com.ipc1.cah.ui.*;
import com.ipc1.cah.ui.utilities.BGPanel;

public class CheckersFrame extends JFrame implements ActionListener{

    public static final int BOARD_SIZE = 400;
    private JLabel lblTurnIndicator1;
    private JLabel lblTurnIndicator2;
    private JLabel lblWrongMoveDescripion;

    public CheckersFrame(JPanel checkersBoard, String player1Name, String player2Name){

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
        
        lblTurnIndicator1 = new JLabel();
        lblTurnIndicator1.setBounds(600, 20, 35, 35);
        lblTurnIndicator1.setOpaque(true);
        lblTurnIndicator1.setBackground(Color.GREEN); 
        add(lblTurnIndicator1);

        lblTurnIndicator2 = new JLabel();
        lblTurnIndicator2.setBounds(262, 20, 35, 35);
        lblTurnIndicator2.setOpaque(true);
        lblTurnIndicator2.setBackground(Color.RED); 
        add(lblTurnIndicator2);

        lblWrongMoveDescripion = new JLabel();
        lblWrongMoveDescripion.setBounds(325, 20, 250, 35);
        lblWrongMoveDescripion.setOpaque(true);
        lblWrongMoveDescripion.setBackground(Color.LIGHT_GRAY); 
        lblWrongMoveDescripion.setHorizontalAlignment(SwingConstants.CENTER);
        lblWrongMoveDescripion.setText("INICIA TURNO ( --> )");
        add(lblWrongMoveDescripion);

        JLabel lblPlayer1 = new JLabel(player1Name, SwingConstants.CENTER);
        lblPlayer1.setBounds(50, 150, 150, 50);
        lblPlayer1.setForeground(Color.WHITE);
        lblPlayer1.setOpaque(true);
        lblPlayer1.setBackground(Color.DARK_GRAY);
        lblPlayer1.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.LIGHT_GRAY));
        lblPlayer1.setFont(new Font((lblPlayer1.getFont().getName()), Font.BOLD, 24));
        add(lblPlayer1);
        
        JLabel lblPlayer2 = new JLabel(player2Name, SwingConstants.CENTER);
        lblPlayer2.setBounds(700, 150, 150, 50);
        lblPlayer2.setForeground(Color.WHITE);
        lblPlayer2.setOpaque(true);
        lblPlayer2.setBackground(Color.DARK_GRAY);
        lblPlayer2.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.LIGHT_GRAY));
        lblPlayer2.setFont(new Font((lblPlayer2.getFont().getName()), Font.BOLD, 24));
        add(lblPlayer2);

        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent evt) {
        

    }

    public JLabel getLblTurnIndicator1() {
        return lblTurnIndicator1;
    }

    public JLabel getLblTurnIndicator2() {
        return lblTurnIndicator2;
    }

    public JLabel getLblWrongMoveDescripion() {
        return lblWrongMoveDescripion;
    }

}
