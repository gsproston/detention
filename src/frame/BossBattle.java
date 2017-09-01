
package frame;

public class BossBattle {
    private PlayerSprite playerSprite;
    private Background background;
    private WaveEnemies wave;
    private Boss boss;
    private long t0, t1;
    private int count = 0;
    private String path;
    BossBattle(PlayerSprite playerSprite, Background background, Boss boss, WaveEnemies wave) {
        path = System.getProperty("user.dir")+"/sprites/bossBattle.png";
        this.wave = wave;
        this.playerSprite = playerSprite;
        this.background = background;
        this.boss = boss;
    }
    public void activate() {
        if (Global.battleStarted == false) {
            if (background.getXpos() <= -3838) {
                Global.isRight = true;
                background.setChangex(0);
                playerSprite.setChangex(0);
                Global.displayBoss = true;
                if (boss.getXpos() < 720) {
                    boss.setChangex(0);
                    boss.setFrozen(true);
                    count ++;
                    if (count == 400) {
                        path = System.getProperty("user.dir")+"/sprites/fight.png";
                    }
                    if (count == 800) {
                        Global.displayBoss = false;
                        boss.setFrozen(false);
                        playerSprite.setFrozen(false);
                        Global.battleStarted = true; 
                        count = 0;
                    }
                } 
            } else if (background.getXpos() <= -3480) {
                wave.setChangex(-2);
                background.setChangex(-2);
                playerSprite.setChangex(-2);
                playerSprite.setPath(playerSprite.getPathRight());
                playerSprite.setFrozen(true);
            }        
        }      
    }
    public void reset() {
        count = 0;
        path = System.getProperty("user.dir")+"/sprites/bossBattle.png";
        Global.battleStarted = false;
    }
    public void setPath(String newPath) {
        path = newPath;
    }
    public String getPath() {
        return path;        
    }
}
