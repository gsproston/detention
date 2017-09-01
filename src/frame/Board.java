package frame;

/*
Board of the main game
*/

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements ActionListener {
        private boolean gameOver = false;
        private int count = 0;
        private Timer timer;
	PlayerSprite playerSprite = new PlayerSprite();
	Background background = new Background(playerSprite);
        Boss boss = new Boss(playerSprite);
        WaveEnemies wave = new WaveEnemies(background);
        BossBattle bossBattle = new BossBattle(playerSprite, background, boss, wave);
        Hud playerHealth = new Hud("playerHealth",playerSprite,boss,wave);
        Hud stageNum = new Hud("stageNum",playerSprite,boss,wave);
        Hud department = new Hud("department",playerSprite,boss,wave);
        Hud bossHealth = new Hud("bossHealth",playerSprite,boss,wave);
        Hud nextStage = new Hud("nextStage",playerSprite,boss,wave);
        Hud waveHealth = new Hud("waveHealth",playerSprite,boss,wave);
        HitDetection hitDetection = new HitDetection(playerSprite,boss,wave);
   	public Board() {
		addKeyListener(new TAdapter());
        	setFocusable(true);
        	setDoubleBuffered(true);
        	timer = new Timer(5, this);
        	timer.start();
        }
    	public void paint(Graphics g) {
        	Graphics2D g2 = (Graphics2D) g;
                Image waveHealthBar = Toolkit.getDefaultToolkit().getImage(waveHealth.getPath());
        	Image backgroundImage = Toolkit.getDefaultToolkit().getImage(background.getPath());
                Image nextStageIcon = Toolkit.getDefaultToolkit().getImage(nextStage.getPath());
                Image endBoss = Toolkit.getDefaultToolkit().getImage(boss.getPath());
                Image battle = Toolkit.getDefaultToolkit().getImage(bossBattle.getPath());
                Image playerHealthBar = Toolkit.getDefaultToolkit().getImage(playerHealth.getPath());
                Image levelNum = Toolkit.getDefaultToolkit().getImage(stageNum.getPath());
                Image stage = Toolkit.getDefaultToolkit().getImage(department.getPath());
                Image bossHealthBar = Toolkit.getDefaultToolkit().getImage(bossHealth.getPath());
                Image waveEnemy = Toolkit.getDefaultToolkit().getImage(wave.getPath());
                Image player = Toolkit.getDefaultToolkit().getImage(playerSprite.getPath());
                
                g2.drawImage(backgroundImage,background.getXpos(),background.getYpos(),this);
                g2.drawImage(levelNum,stageNum.getXpos(),stageNum.getYpos(),this);
                g2.drawImage(stage,department.getXpos(),department.getYpos(),this);
                g2.drawImage(playerHealthBar,playerHealth.getXpos(),playerHealth.getYpos(),this);
                if (Global.spawn == true) {
                    g2.drawImage(waveHealthBar,waveHealth.getXpos(),waveHealth.getYpos(),this);
                }
                if (Global.isRight == true) {
                        g2.drawImage(bossHealthBar,bossHealth.getXpos(),bossHealth.getYpos(),this);
                        if (Global.bossDead == true) {
                            count ++;
                            if (count >= 500) {
                                g2.drawImage(nextStageIcon,nextStage.getXpos(),nextStage.getYpos(),this);
                            }
                        }
                        g2.drawImage(endBoss,boss.getXpos(),boss.getYpos(),this);
                } 
                g2.drawImage(waveEnemy,wave.getXpos(),wave.getYpos(),this);  
        	g2.drawImage(player,playerSprite.getXpos(),playerSprite.getYpos(),this);
                if (Global.displayBoss == true) {
                    g2.drawImage(battle,0,0,this);
                }
                g2.finalize();
    	}
    	public void actionPerformed(ActionEvent e) {
                if (playerSprite.getHealth() == 0) {
                    wave.setFrozen(true);
                }
                background.move();
		playerSprite.move();
                hitDetection.fight();
                playerHealth.reset();
                bossHealth.reset();
                waveHealth.reset();
                if (playerSprite.getXpos() > 100 && playerSprite.getXpos() < 860 && background.getXpos() > -3460 && playerSprite.getHealth() > 0) {
                    wave.spawn();
                } else { 
                    wave.setXpos(970);
                }
                bossBattle.activate();
                if (Global.isRight == true){
                    boss.move();
                }
                if (playerSprite.getXpos() > 960 && Global.bossDead == true) {
                    Global.bossDead = false;
                    Global.level ++;
                    Global.isRight = false;
                    boss.reset();
                    playerSprite.reset();
                    background.reset();
                    stageNum.reset();
                    department.reset();
                    wave.reset();
                    nextStage.reset();
                    bossBattle.reset();
                    count = 0;
                }
        	repaint();
    	}
    	private class TAdapter extends KeyAdapter {
        	public void keyReleased(KeyEvent e) {
            		playerSprite.keyReleased(e);
			background.keyReleased(e);
        	}
        	public void keyPressed(KeyEvent e) {
            		playerSprite.keyPressed(e);
			background.keyPressed(e);
        	}
    	}
}