package com.ipc1.cah.ui.utilities;

import javax.swing.*;
import java.awt.*;

public class ChangeBGCLabel{
    
    public static void blinkJLabel(JLabel lblToBlink, Color color1, Color color2, int seconds){
        ChangelblBGColor changelblBGColor = new ChangelblBGColor(lblToBlink, color1);
        WaitChangelblBGColor waitChangelblBGColor = new WaitChangelblBGColor(lblToBlink, seconds, color2);
        changelblBGColor.start();
        waitChangelblBGColor.start();
    }
    public static void changeBGColorJLabel(JLabel lblToBlink, Color color){
        ChangelblBGColor changelblBGColor = new ChangelblBGColor(lblToBlink, color);
        changelblBGColor.start();
    }


    
}
