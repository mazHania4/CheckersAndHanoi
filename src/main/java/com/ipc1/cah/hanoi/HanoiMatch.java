package com.ipc1.cah.hanoi;

import com.ipc1.cah.players.Player;
import com.ipc1.cah.ui.hanoi_towers.Disk;
import com.ipc1.cah.ui.hanoi_towers.HanoiTowersFrame;
import com.ipc1.cah.ui.hanoi_towers.Tower;
import com.ipc1.cah.utilities.chronometer.Chronometer;

public class HanoiMatch {
    
    private HanoiTowersFrame hanoiFrame;
    private Player player;
    private Chronometer chronometer;
    private Tower towers[];

    public HanoiMatch(Player player, int disks){

        this.player = player;

        towers = new Tower[3];        
        for (int i = 0; i < towers.length ; i++) {
            towers[i] = new Tower();
        }
        for (int i = disks; i >= 1; --i) {
            Disk disk = new Disk(i, towers[0]);
            towers[0].stack(disk);
        }

        this.hanoiFrame = new HanoiTowersFrame(player.getName(), this, towers);

        this.chronometer = new Chronometer(hanoiFrame.getLblPlayerTime());
        chronometer.start();
        chronometer.resumeTimeCounter();


    }

}
