
package frame;

import java.util.Random;

public class WaveEnemies {
    private int xpos, ypos, healthXpos, healthYpos, changex, changey, health, originalHealth, spawn, chance, place, wave;
    public int count = 0;
    public int numSpawned;
    private Background background;
    private String path, pathRight, pathLeft, hurtLeft, hurtRight, enemy, location;
    private boolean dead = false;
    private boolean frozen = false;
    Random rand = new Random();
    WaveEnemies(Background background) {
        this.background = background;
        wave = rand.nextInt(1);
        xpos = 0;
        ypos = 234;
        changex = 0;
        changey = 0;       
        if (wave == 1) {
            location = "Left";
            pathLeft = System.getProperty("user.dir")+"/sprites/y7WalkingLeft.gif";
            pathRight = System.getProperty("user.dir")+"/sprites/y7WalkingRight.gif";
            hurtLeft = System.getProperty("user.dir")+"/sprites/y7HurtLeft.gif";
            hurtRight = System.getProperty("user.dir")+"/sprites/y7HurtRight.gif";
            originalHealth = 1;
            health = 0;
            chance = 100;
            enemy = "y7";
        } else {
            location = "Left";
            pathLeft = System.getProperty("user.dir")+"/sprites/y7WalkingLeft.gif";
            pathRight = System.getProperty("user.dir")+"/sprites/y7WalkingRight.gif";
            hurtLeft = System.getProperty("user.dir")+"/sprites/y7HurtLeft.gif";
            hurtRight = System.getProperty("user.dir")+"/sprites/y7HurtRight.gif";
            originalHealth = 1;
            health = 0;
            chance = 100;
            enemy = "y7";
        }
    }
    public void spawn() {
        xpos += changex;
        ypos += changey;            
        count ++;
        if (numSpawned > 0) {
            Global.spawn = true;
        } else if (count >= 100) {
            Global.spawn = false;
        }
        if (numSpawned < 1 && Global.isRight == false && count > 500) {
            spawn = rand.nextInt(chance);
            if (spawn == 1) {
                health = originalHealth;
                place = rand.nextInt(2);
                numSpawned ++;
                if (place == 1) {
                    location = "Left";
                    healthXpos = -27;
                    healthYpos = 20;
                    path = pathRight;
                    changex = 3;
                    xpos = -130;
                    count = 0;
                } else {
                    location = "Right";
                    healthXpos = 830;
                    healthYpos = -38;
                    path = pathLeft;
                    changex = -3;
                    xpos = 970;
                    count = 0;
                }
            }
        } 
        if (dead == true) {
            if (count >= 100) {
                changex = background.getChangex();   
            }
            if (count >= 300) {
                health = originalHealth;
                xpos = 960;
                dead = false;
                changex = 0;
            }
        }
    }
    public void hurt(int attack) { //when player is hurt, health is reduced
        if (health > 0) {
            health = health - attack;
            if (path == pathRight) {
                changex = -1;
                path = hurtRight;
            } else {
                path = hurtLeft;
                changex = 1;
            }            
        }
        if (health == 0) {
            dead = true;
            count = 0;
            numSpawned -= 1;
        }
    }
    public void reset() {
        health = originalHealth;
        xpos = 960;
        dead = false;
        changex = 0;        
    }
    public String getLocation() {
        return location;
    }
    public int getHealthXpos() {
        return healthXpos;
    }
    public int getHealthYpos() {
        return healthYpos;
    }
    public void setFrozen(boolean isFrozen) {
        frozen = isFrozen;
    }
    public boolean getFrozen() {
        return frozen;
    }
    public int getHealth() {
        return health;
    }
    public String getEnemy() {
        return enemy;
    }
    public void setDead(boolean isDead) {
        dead = isDead;
    }
    public boolean getDead() {
        return dead;
    }
    public void setXpos(int newXpos) {
        xpos = newXpos;
    }
    public int getXpos() {
        return xpos;
    }
    public void setYpos(int newYpos) {
        ypos = newYpos;
    }
    public int getYpos() {
        return ypos;
    }
    public void setChangex(int newChangex) {
        changex = newChangex;
    }
    public int getChangex(){
        return changex;
    }
    public void setPath(String newPath) {
        path = newPath;
    }
    public String getPath() {
        return path;
    }
    public String getLeftPath() {
        return pathLeft;
    }
    public String getRightPath() {
        return pathRight;
    }
    public int getNumSpawned() {
        return numSpawned;
    }
    public int getChance() {
        return chance;
    }
}
