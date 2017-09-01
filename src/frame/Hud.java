
package frame;

public class Hud {
    private int xpos, ypos;
    private String path, element;
    private PlayerSprite player;
    private Boss boss;
    private WaveEnemies wave;
    Hud(String feature, PlayerSprite playerSprite, Boss bossage, WaveEnemies enemy) {
        this.player = playerSprite;
        this.boss = bossage;
        this.wave = enemy;
        element = feature;
        if (feature == "playerHealth") {
            xpos = -30;
            ypos = -38;
            path = System.getProperty("user.dir")+"/sprites/playerHealth"+player.getHealth()+".png";
        } else if (feature == "stageNum") {
            xpos = 390;
            ypos = 2;
            path = System.getProperty("user.dir")+"/sprites/stage"+Global.level+".png";
        } else if (feature == "department") {
            xpos = 445;
            ypos = 0;
            path = System.getProperty("user.dir")+"/sprites/department"+Global.level+".png";  
        } else if (feature == "bossHealth") {
            xpos = 560;
            ypos = -38;
            path = System.getProperty("user.dir")+"/sprites/physicsBossHealth"+boss.getHealth()+".png";
        } else if (feature == "nextStage") {
            xpos = 0;
            ypos = 0;
            path = System.getProperty("user.dir")+"/sprites/Next Stage.png";
        } else if (feature == "waveHealth") {
            xpos = wave.getHealthXpos();
            ypos = wave.getHealthYpos();
            path = System.getProperty("user.dir")+"/sprites/"+wave.getEnemy()+"Health"+wave.getLocation()+wave.getHealth()+".png";
        }
    }
    public void reset() {
        if (element == "playerHealth") {
            xpos = -30;
            ypos = -38;
            path = System.getProperty("user.dir")+"/sprites/playerHealth"+player.getHealth()+".png";
        } else if (element == "stageNum") {
            xpos = 400;
            ypos = 1;
            path = System.getProperty("user.dir")+"/sprites/stage"+Global.level+".png";
        } else if (element == "department") {
            xpos = 440;
            ypos = 0;
            path = System.getProperty("user.dir")+"/sprites/department"+Global.level+".png";  
        } else if (element == "bossHealth") {
            xpos = 560;
            ypos = -38;
            path = System.getProperty("user.dir")+"/sprites/physicsBossHealth"+boss.getHealth()+".png";
        } else if (element == "nextStage") {
            xpos = 0;
            ypos = 0;
            path = System.getProperty("user.dir")+"/sprites/Next Stage.png";
        } else if (element == "waveHealth") {
            xpos = wave.getHealthXpos();
            ypos = wave.getHealthYpos();
            path = System.getProperty("user.dir")+"/sprites/"+wave.getEnemy()+"Health"+wave.getLocation()+wave.getHealth()+".png";
        }
    }
    public void setPath(String newPath) {
         path = newPath;
    }
    public String getPath() {
        return path;
    }
    public int getXpos() {
	return xpos;
    }
    public int getYpos() {
	return ypos;
    }
}
