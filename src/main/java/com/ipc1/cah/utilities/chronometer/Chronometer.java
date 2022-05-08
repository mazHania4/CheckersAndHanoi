package com.ipc1.cah.utilities.chronometer;

import javax.swing.JLabel;

public class Chronometer extends Thread {

    private Time time;
    private JLabel lblToShowTime;
    private boolean pause;
    private boolean end;

    public Chronometer(JLabel lblToShowTime){
        this.lblToShowTime = lblToShowTime;
        this.time = new Time();
        this.pause = true;
        this.end = false;
    }

    @Override
    public void run() {
        while (true) {
            if (end) {
                break;
            } else {
                try {
                    Thread.sleep(900);
                    if (!this.pause) {
                        time.addSecond();
                        lblToShowTime.setText(  ((time.getMinutes() < 9) ? ("0" + time.getMinutes()) : time.getMinutes()) + ":" +
                                                ((time.getSeconds() < 9) ? ("0" + time.getSeconds()) : time.getSeconds())
                                            );
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }  
            }
        }
    }

    public void pauseTimeCounter(){
        this.pause = true;
    }

    public void resumeTimeCounter(){
        this.pause = false;
    }

    public void endTimeCounter(){
        this.end = true;
    }

    public Time getTime(){
        return time;
    }

}
