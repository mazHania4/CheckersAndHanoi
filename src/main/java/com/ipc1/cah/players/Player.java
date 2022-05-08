package com.ipc1.cah.players;

import java.io.Serializable;

import com.ipc1.cah.utilities.chronometer.Time;

public class Player implements Serializable{
   
    private String name;

    private int playedMatchesCheckers;
    private int wonMatchesCheckers;
    private int lostMatchesCheckers;
    private int totalMovesCheckers;
    private int averageMovesCheckers;
    private int recordMovesCheckers;
    private Time recordTimeCheckers;
    
    private int playedMatchesHanoi;
    private int wonMatchesHanoi;
    private int lostMatchesHanoi;
    private int abandonedMatchesHanoi;
    private int averageMovesHanoi;
    private Time averageTimeHanoi;
    private int totalMovesHanoi;
    private Time totalTimeHanoi;
    
    public Player(String name){
        this.name = name;
        this.playedMatchesCheckers = 0;
        this.wonMatchesCheckers = 0;
        this.lostMatchesCheckers = 0;
        this.totalMovesCheckers = 0;
        this.averageMovesCheckers = 0;
        this.recordMovesCheckers = 0;
        this.recordTimeCheckers = new Time();
        
        this.playedMatchesHanoi = 0;
        this.wonMatchesHanoi = 0;
        this.lostMatchesHanoi = 0;
        this.abandonedMatchesHanoi = 0;
        this.averageMovesHanoi = 0;
        this.averageTimeHanoi = new Time();
        this.totalMovesHanoi = 0;
        this.totalTimeHanoi = new Time();
    }

    public String getName() {
        return name;
    }




    //Checkers


    
    public int getPlayedMatchesCheckers() {
        this.playedMatchesCheckers = wonMatchesCheckers + lostMatchesCheckers;
        return playedMatchesCheckers;
    }

    public int getWonMatchesCheckers() {
        return wonMatchesCheckers;
    }

    public void setWonMatchesCheckers(int wonMatchesCheckers) {
        this.wonMatchesCheckers = wonMatchesCheckers;
    }

    public int getLostMatchesCheckers() {
        return lostMatchesCheckers;
    }

    public void setLostMatchesCheckers(int lostMatchesCheckers) {
        this.lostMatchesCheckers = lostMatchesCheckers;
    }

    public int getTotalMovesCheckers() {
        return totalMovesCheckers;
    }

    public void setTotalMovesCheckers(int totalMovesCheckers) {
        this.totalMovesCheckers = totalMovesCheckers;
    }

    public int getAverageMovesCheckers() {
        if (this.getPlayedMatchesCheckers()>0) {
            this.averageMovesCheckers = (int)(this.getTotalMovesCheckers() / this.getPlayedMatchesCheckers());
        } else {
            this.averageMovesCheckers = 0;
        }
        return averageMovesCheckers;
    }

    public int getRecordMovesCheckers() {
        return recordMovesCheckers;
    }

    public void setRecordMovesCheckers(int recordMovesCheckers) {
        if (recordMovesCheckers < this.getRecordMovesCheckers()) {
            this.recordMovesCheckers = recordMovesCheckers;
        }
    }
    
    public Time getRecordTimeCheckers() {
        return recordTimeCheckers;
    }
    
    public void setRecordTimeCheckers(Time newRecordTimeCheckers) {
        if (newRecordTimeCheckers.getMinutes() <= this.getRecordTimeCheckers().getMinutes()) {
            if (newRecordTimeCheckers.getSeconds() < this.getRecordTimeCheckers().getSeconds()) {
                this.recordTimeCheckers = newRecordTimeCheckers;
            }
        }
    }




    //Hanoi

    
    
    public int getPlayedMatchesHanoi() {
        this.playedMatchesHanoi = this.getWonMatchesHanoi() + this.getLostMatchesHanoi() + this.getAbandonedMatchesHanoi();
        return playedMatchesHanoi;
    }
    
    public int getWonMatchesHanoi() {
        return wonMatchesHanoi;
    }
    
    public void setWonMatchesHanoi(int wonMatchesHanoi) {
        this.wonMatchesHanoi = wonMatchesHanoi;
    }

    public int getLostMatchesHanoi() {
        return lostMatchesHanoi;
    }

    public void setLostMatchesHanoi(int lostMatchesHanoi) {
        this.lostMatchesHanoi = lostMatchesHanoi;
    }

    public int getAbandonedMatchesHanoi() {
        return abandonedMatchesHanoi;
    }

    public void setAbandonedMatchesHanoi(int abandonedMatchesHanoi) {
        this.abandonedMatchesHanoi = abandonedMatchesHanoi;
    }

    public int getAverageMovesHanoi() {
        if (this.getPlayedMatchesHanoi()>0) {
            this.averageMovesHanoi = (int)(this.getTotalMovesHanoi() / this.getPlayedMatchesHanoi());
        } else {
            this.averageMovesHanoi = 0;
        }
        return averageMovesHanoi;
    }
    
    public Time getAverageTimeHanoi() {
        if (this.getPlayedMatchesHanoi()>0) {
            this.averageTimeHanoi.addMinutes( (int) this.getTotalTimeHanoi().getMinutes() / this.getPlayedMatchesHanoi());
            this.averageTimeHanoi.addSeconds( (int) this.getTotalTimeHanoi().getSeconds() / this.getPlayedMatchesHanoi());
        }
        return averageTimeHanoi;
    }

    public int getTotalMovesHanoi() {
        return totalMovesHanoi;
    }

    public void setTotalMovesHanoi(int totalMovesHanoi) {
        this.totalMovesHanoi = totalMovesHanoi;
    }

    public Time getTotalTimeHanoi() {
        return totalTimeHanoi;
    }

    public void sumToTotalTimeHanoi(Time timeToAdd) {
        this.totalTimeHanoi.addMinutes(timeToAdd.getMinutes());
        this.totalTimeHanoi.addSeconds(timeToAdd.getSeconds());
    }
}
