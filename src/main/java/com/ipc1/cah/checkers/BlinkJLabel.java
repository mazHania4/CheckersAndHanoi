package com.ipc1.cah.checkers;

import javax.swing.*;

import com.ipc1.cah.ui.utilities.*;

import java.awt.*;

public class BlinkJLabel{
    
    public static void blinkJLabel(JLabel lblToBlink, Color color1, Color color2, int seconds){
        ChangelblBGColor changelblBGColor = new ChangelblBGColor(lblToBlink, color1);
        WaitChangelblBGColor waitChangelblBGColor = new WaitChangelblBGColor(lblToBlink, seconds, color2);
        changelblBGColor.start();
        waitChangelblBGColor.start();
    }


    
}
