package com.dzp.game.mechanics;

import com.dzp.game.mechanics.towers.PigMainTower;
import com.dzp.game.mechanics.towers.PolecatMainTower;
import com.dzp.game.mechanics.towers.PandaMainTower;
import com.dzp.game.mechanics.towers.Tower;
import com.dzp.game.mechanics.mobs.Mob;
import com.dzp.game.mechanics.Nexus;
import com.dzp.game.mechanics.towers.PandaMainTower;
import com.dzp.game.mechanics.towers.PigMainTower;
import com.dzp.game.mechanics.towers.PolecatMainTower;
import com.dzp.game.mechanics.towers.Tower;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class EntityManagerThread extends Thread {
    
    private ArrayList<Tower> towers;
    private ArrayList<Mob> mobs;
    private int tickCounter;
    private int spawnWave;
    
    public EntityManagerThread(int towerLevelPig, int towerLevelPolecat, int towerLevelPanda) {
        towers.add(new PigMainTower(towerLevelPig));
        towers.add(new PolecatMainTower(towerLevelPolecat));
        towers.add(new PandaMainTower(towerLevelPanda));
        tickCounter = 0;
        spawnWave = 0;
    }
 
    ///Spawn/despawn
    public void spawnTower(Tower newTower) {
        towers.add(newTower);
    }
    public void despawnTower(Tower t) {
        towers.remove(t);
        
    }
    public void despawnMob(Mob m) {
        mobs.remove(m);
    }
    public void spawnMob(Mob m) {
        this.mobs.add(m);
    }
    
    private void setSpawnWave(int wave) {
        this.spawnWave = wave;
    }
    
    @Override
    public void run () {
        
        /** 
         * Run code
         */
        
        
        while(Nexus.isAlive()) {
            
            /* MOBS */
            if(mobs.isEmpty()) {
                //setSpawnWave(gameInterface.Run.resources);
            }
            //if(spawnWave) {
            //    
            //}
            for(int i=0;i<=mobs.size()-1;i++) {
                mobs.get(i).act();
            }
            
            /** TOWERS */        
            for(int i=0;i<=towers.size()-1;i++) {
                towers.get(i).fire();
            }

            /* GENERATOR */
            
            
            
            
            
            
            try {
                Thread.sleep(1);
            } catch (InterruptedException ex) {
                Logger.getLogger(EntityManagerThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
}