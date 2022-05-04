package com.ipc1.cah.players;

public class Player {
   
    private String name;

    private int playedMatchesCheckers;
    private int wonMatchesCheckers;
    private int lostMatchesCheckers;
    private int totalMovesCheckers;
    private double averageMovesCheckers;
    private int recordMovesCheckers;
    private double recordTimeCheckers;
    
    private int playedMatchesHanoi;
    private int wonMatchesHanoi;
    private int lostMatchesHanoi;
    private int abandonedMatchesHanoi;
    private double averageMovesHanoi;
    private double averageTimeHanoi;
    private int totalMovesHanoi;
    private double totalTimeHanoi;
    
    public Player(String name){
        this.name = name;
        this.playedMatchesCheckers = 0;
        this.wonMatchesCheckers = 0;
        this.lostMatchesCheckers = 0;
        this.totalMovesCheckers = 0;
        this.averageMovesCheckers = 0;
        this.recordMovesCheckers = 0;
        this.recordTimeCheckers = 0;
        
        this.playedMatchesHanoi = 0;
        this.wonMatchesHanoi = 0;
        this.lostMatchesHanoi = 0;
        this.abandonedMatchesHanoi = 0;
        this.averageMovesHanoi = 0;
        this.averageTimeHanoi = 0;
        this.totalMovesHanoi = 0;
        this.totalTimeHanoi = 0;
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

    public double getAverageMovesCheckers() {
        if (this.getPlayedMatchesCheckers()>0) {
            this.averageMovesCheckers = this.getTotalMovesCheckers() / this.getPlayedMatchesCheckers();
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
    
    public double getRecordTimeCheckers() {
        return recordTimeCheckers;
    }
    
    public void setRecordTimeCheckers(int recordTimeCheckers) {
        if (recordTimeCheckers < this.getRecordTimeCheckers()) {
            this.recordTimeCheckers = recordTimeCheckers;
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

    public double getAverageMovesHanoi() {
        if (this.getPlayedMatchesHanoi()>0) {
            this.averageMovesHanoi = this.getTotalMovesHanoi() / this.getPlayedMatchesHanoi();
        } else {
            this.averageMovesHanoi = 0;
        }
        return averageMovesHanoi;
    }
    
    public double getAverageTimeHanoi() {
        if (this.getPlayedMatchesHanoi()>0) {
            this.averageTimeHanoi = this.getTotalTimeHanoi() / this.getPlayedMatchesHanoi();
        } else {
            this.averageTimeHanoi = 0;
        }
        return averageTimeHanoi;
    }

    public int getTotalMovesHanoi() {
        return totalMovesHanoi;
    }

    public void setTotalMovesHanoi(int totalMovesHanoi) {
        this.totalMovesHanoi = totalMovesHanoi;
    }

    public double getTotalTimeHanoi() {
        return totalTimeHanoi;
    }

    public void setTotalTimeHanoi(double totalTimeHanoi) {
        this.totalTimeHanoi = totalTimeHanoi;
    }

    

}
