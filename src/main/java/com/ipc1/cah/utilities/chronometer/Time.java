package com.ipc1.cah.utilities.chronometer;

import java.io.Serializable;

public class Time implements Serializable{
    
    private int minutes;
    private int seconds;

    public Time(){
        this.minutes = 0;
        this.seconds = 0;
    }


    public int getMinutes() {
        return minutes;
    }

    public void addMinute() {
        minutes = minutes + 1;   
    }

    public int getSeconds() {
        return seconds;
    }

    public void addSecond() {
        if (seconds < 59) {
            seconds = seconds + 1;
        } else {
            seconds = 0;
            addMinute();
        }
    }

    public void addMinutes(int minutes) {
        this.minutes = minutes;
    }

    public void addSeconds(int secondstoAdd) {
        if (secondstoAdd>0) {
            for (int i = 1; i <= seconds; i++) {
                addSecond();   
            }
        }
    }

    
    

}
