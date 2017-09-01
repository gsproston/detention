
package frame;

public class Boss {
    private int xpos, ypos, changex, changey, health, originalHealth;
    private int count = 0;
    long t1, t0;
    private String pathRight, pathLeft, pathHurtLeft, pathHurtRight, path;
    private PlayerSprite playerSprite;
    private boolean frozen = false;
    Boss(PlayerSprite playerSprite) {
        this.playerSprite = playerSprite;
        changey = 0;     
        if (Global.level == 1) {
            xpos = 1000;
            ypos = 52;
            originalHealth = 5;
            changex = -1;  
            pathLeft = System.getProperty("user.dir")+"/sprites/physicsBoss Left.gif";
            pathRight = System.getProperty("user.dir")+"/sprites/physicsBoss.gif";
            pathHurtLeft = System.getProperty("user.dir")+"/sprites/physicsHurtLeft.gif";            
            pathHurtRight = System.getProperty("user.dir")+"/sprites/physicsHurtRight.gif";
        } else {
            xpos = 1000;
            ypos = 52;
            originalHealth = 5;
            changex = -1;  
            pathLeft = System.getProperty("user.dir")+"/sprites/physicsBoss Left.gif";
            pathRight = System.getProperty("user.dir")+"/sprites/physicsBoss.gif";
            pathHurtLeft = System.getProperty("user.dir")+"/sprites/physicsHurtLeft.gif";            
            pathHurtRight = System.getProperty("user.dir")+"/sprites/physicsHurtRight.gif";
        } 
        health = originalHealth;
        path = pathLeft;
    }
    public void move() {
        if (playerSprite.getHealth() > 0) {
            xpos += changex;
            ypos += changey; 
        }
        if (frozen == false) {
            if ((playerSprite.getXpos() + 100) < xpos && xpos > 130) {
                path = pathLeft;
                changex = -1;
            } else if (playerSprite.getXpos() > (xpos + 192)) {
                path = pathRight;
                changex = 1;
            }            
        }
        if (Global.bossDead == true) {
            frozen = true;
            count ++;
            if (count >= 100) {
                changex = 0;
            }
            if (count >= 500) {
                xpos = 1000;
            }
        }
    }
    public void hurt(int attack) { //when boss is hurt, health is reduced
        if (health > 0) {
            health = health - attack;
            if (path == pathLeft) {
                path = pathHurtLeft;
                changex = 2;
            } else {
                path = pathHurtRight;
                changex = -2;
            } 
        }
        if (health == 0) {
            Global.bossDead = true;
        }
        frozen = true;
    }
    public void reset() {
            xpos = 1000;
            ypos = 52;
            changex = -1;
            changey = 0;       
            health = originalHealth;
            path = pathLeft;
            count = 0;
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
}
