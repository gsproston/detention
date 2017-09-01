
package frame;

public class HitDetection {
    private PlayerSprite playerSprite;
    private Boss boss;
    private WaveEnemies enemy;
    private int count = 0;
    private boolean playerHit, bossHit, waveHit;
    HitDetection(PlayerSprite playerSprite, Boss boss, WaveEnemies enemy) {
        this.playerSprite = playerSprite;
        this.boss = boss;
        this.enemy = enemy;
    }
    public void fight() {
        if (playerHit == false && bossHit == false && waveHit == false && Global.bossDead == false) {
            if (boss.getXpos() <= (playerSprite.getXpos() + 120) && boss.getPath() == boss.getLeftPath()) {
                if (playerSprite.getPunching() == true) {
                    boss.hurt(1);
                    playerSprite.setChangex(0);
                    bossHit = true;                    
                } else if (boss.getXpos() <= (playerSprite.getXpos() + 100)) {
                    playerSprite.hurt(1);
                    playerSprite.setChangex(-1);
                    playerHit = true;
                    boss.setChangex(0);
                }                    
            }
            if ((boss.getXpos() + 190) <= playerSprite.getXpos() && boss.getPath() == boss.getRightPath()) {
                if (playerSprite.getPunching() == false) {
                    playerSprite.hurt(1);
                    playerSprite.setChangex(1);
                    playerHit = true;
                    boss.setChangex(0);
                } else {
                    boss.hurt(1);
                    playerSprite.setChangex(0);
                    bossHit = true;                   
                }  
            } 
            if (enemy.getXpos() <= (playerSprite.getXpos() + 100) && enemy.getPath() == enemy.getLeftPath()) {
                if (playerSprite.getPunching() == false) {
                    playerSprite.hurt(1);
                    playerSprite.setChangex(-1);
                    playerHit = true;  
                    if (enemy.getEnemy() == "y7") {
                        enemy.hurt(1);
                        waveHit = true;
                    }                          
                } else {
                    enemy.hurt(1);
                    playerSprite.setChangex(0);
                    waveHit = true;
                }                    
            }
            if ((enemy.getXpos() + 80) >= playerSprite.getXpos() && enemy.getPath() == enemy.getRightPath()) {
                if (playerSprite.getPunching() == false) {
                    playerSprite.hurt(1);
                    playerSprite.setChangex(1);
                    playerHit = true;  
                    if (enemy.getEnemy() == "y7") {
                        enemy.hurt(1);
                        playerSprite.setChangex(0);
                    }                          
                } else {
                    enemy.hurt(1);
                    playerSprite.setChangex(0);
                    waveHit = true;                   
                }  
            }              
        }                   
        if (playerHit == true) {             
            enemy.setFrozen(true);
            boss.setFrozen(true);
            count ++;
            if (playerSprite.getXpos() <= 0 || playerSprite.getXpos() >= 834) {
                playerSprite.setChangex(0);        
            }
            if (count > 100) {
                playerSprite.setFrozen(false);
                boss.setFrozen(false);
                enemy.setFrozen(false);
                playerHit = false;
                count = 0;
                playerSprite.setChangex(0);
                if (playerSprite.getPath() == playerSprite.getPathHurtRight()) {
                    playerSprite.setPath(playerSprite.getPathRight());
                } else {
                    playerSprite.setPath(playerSprite.getPathLeft());
                }
            }
        }
        if (bossHit == true && Global.bossDead == false) {
            count ++;
            playerSprite.setFrozen(true);
            if (count >= 100) {
                playerSprite.setFrozen(false);
                boss.setChangex(0);
                bossHit = false;
                boss.setFrozen(false);
                count = 0;
            }                
        }
        if (waveHit == true) {
            count ++;
            playerSprite.setFrozen(true);
            if (count >= 100) {
                playerSprite.setFrozen(false);
                enemy.setChangex(0);
                waveHit = false;
                count = 0;
            }
        }
    }
}
