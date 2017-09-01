package frame;

/*
player sprite in the program
*/

import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

//"C:/Users/Germingi/Documents/school/computing/summer project/sprites/"
//"N:/Work/A-Level/computing/summer project/sprites/"

public class PlayerSprite {
	private int xpos, ypos, changex, changey, health, countHealth, countPunching; //will determine where on the frame the sprite will be loaded
	private String path, deadLeft, deadRight, pathRight, pathLeft, punchLeft, punchRight, pathLeftWalking, pathRightWalking, playerHurtRight, playerHurtLeft, deadPathRight, deadPathLeft; //where the image is located 
        private boolean frozen, offScreenLeft, offScreenRight, punching;
        private boolean dead = false;
	PlayerSprite() {
		xpos = -150;
		ypos = 234;
		changex = 0;
		changey = 0;
                health = 3;
                pathRight = System.getProperty("user.dir")+"/sprites/player.png";
                pathLeft = System.getProperty("user.dir")+"/sprites/player left.png";
                pathRightWalking = System.getProperty("user.dir")+"/sprites/Walking Animation.gif";
                pathLeftWalking = System.getProperty("user.dir")+"/sprites/Walking Animation Left.gif";
                playerHurtRight = System.getProperty("user.dir")+"/sprites/playerHurt.gif";
                playerHurtLeft = System.getProperty("user.dir")+"/sprites/playerHurtLeft.gif";
                deadPathLeft = System.getProperty("user.dir")+"/sprites/playerDeadRight.gif";
                deadPathRight = System.getProperty("user.dir")+"/sprites/playerDeadRLeft.gif";
                punchLeft = System.getProperty("user.dir")+"/sprites/punchLeft.gif";
                punchRight = System.getProperty("user.dir")+"/sprites/punchRight.gif";
                deadLeft = System.getProperty("user.dir")+"/sprites/playerDeadEndRight.png";
                deadRight = System.getProperty("user.dir")+"/sprites/playerDeadEndLeft.png";
                frozen = false;
                path = pathRight;
	}
        public void move() {
                xpos += changex;
                ypos += changey;     
                if (dead == true) {
                    frozen = true;
                    countHealth ++;
                    if (countHealth >= 100) {
                        if (path == pathRight || path == pathRightWalking || path == playerHurtRight) {
                            path = deadPathRight;
                        } else if (path == pathLeft || path == pathLeftWalking || path == playerHurtLeft) {
                            path = deadPathLeft;
                        }                       
                    }
                    if (countHealth >= 248) {
                        if (path == deadPathLeft) {
                            path = deadLeft;
                        } else if (path == deadPathRight) {
                            path = deadRight;
                        }
                    }
                }
                if (punching == true) {
                    countPunching ++;
                    if (countPunching >= 100) {
                        changex = 0;
                        if (path == punchLeft) {
                            path = pathLeft;
                            xpos = xpos + 20;
                        } else {
                            path = pathRight;
                            xpos = xpos + 10;
                        }
                        punching = false;
                        countPunching = 0;
                    }                      
                }
                if (xpos < -130) {
                    offScreenLeft = true;
                }
                if (xpos > 960 && Global.bossDead == false) {
                    offScreenRight = true;
                }
                if (offScreenLeft == true) {
                    changex = 2;
                    frozen = true;
                    path = pathRightWalking;
                    if (xpos > 10) {
                        offScreenLeft = false;
                        frozen = false;
                        changex = 0;
                        path = pathRight;
                    }
                }
                if (offScreenRight == true) {
                    changex = -2;
                    frozen = true;
                    path = pathLeftWalking;
                    if (xpos < 830) {
                        changex = 0;
                        frozen = false;
                        path = pathLeft;
                        offScreenRight = false;
                    } 
                }
	}
        public void hurt(int attack) { //when player is hurt, health is reduced
            frozen = true;
            if (health > 0) {
                health = health - attack;
                if (path == pathRight || path == pathRightWalking) {
                    path = playerHurtRight;
                } else {
                    path = playerHurtLeft;
                }               
            } 
            if (health == 0) {
                dead = true;
            }
        }
	public void reset() {
                xpos = -150;
                ypos = 234;
                changex = 0;
                changey = 0;
                path = pathRight; 
                health = 3;
        }
        public void setFrozen(boolean newFrozen) {
            frozen = newFrozen;
        }
        public boolean getFrozen() {
            return frozen;
        }
        public int getHealth() {
            return health;
        }
        public void setChangex(int newChangex) {
            changex = newChangex;
        }
        public void setChangey(int newChangey) {
            changey = newChangey;
        }
	public int getXpos() {
		return xpos;
	}
	public int getYpos() {
		return ypos;
	}
	public void setPath(String newPath) {
		path = newPath;
	}
	public String getPath() {
		return path;
	}
        public String getPathLeft() {
		return pathLeft;
	}
        public String getPathRight() {
		return pathRight;
	}
        public String getPathWalkingLeft() {
		return pathLeftWalking;
	}
        public String getPathWalkingRight() {
		return pathRightWalking;
	}
        public String getPathHurtLeft() {
		return playerHurtLeft;
	}
        public String getPathHurtRight() {
		return playerHurtRight;
	}
        public boolean getPunching() {
                return punching;
        }
	public void keyPressed(KeyEvent e) { //once key is pressed, do action
       		int key = e.getKeyCode();
                if (frozen == false) { //while player is not frozen
                        if (key == KeyEvent.VK_SPACE && punching == false) { //while player is not punching
                            if (path == pathRight || path == playerHurtRight || path == pathRightWalking) {
                                path = punchRight;
                                xpos = xpos - 10;
                            } else if (path == pathLeft || path == playerHurtLeft || path == pathLeftWalking) {
                                path = punchLeft;
                                xpos = xpos - 20;
                            }
                            punching = true;
                            countPunching = 0;
                        }
                        if ((key == KeyEvent.VK_LEFT || key == KeyEvent.VK_A) && xpos <= 0) {
                            changex = 0;
                            if (punching == false) {
                                 path = pathLeft;
                            }
                        }
                        else if ((key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D) && xpos >= 840 && Global.bossDead == false) {
                            changex = 0;
                            if (punching == false) {
                                path = pathRight;                                
                            }
                        }
                        else if ((key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D) && xpos > 960) {
                            changex = 0;
                            if (punching == false) {
                                path = pathRight;                                
                            }
                        }
                        else if ((key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D) && Global.isRight == true) {
                            if (punching == true) {
                                changex = 1;
                            } else {
                                changex = 2;
                                path = pathRightWalking;
                            }
                        }
                        else if ((key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D) && (xpos < 360 || Global.spawn == true)) {
                            if (punching == true) {
                                changex = 1;
                            } else {
                                changex = 2;
                                path = pathRightWalking;                                
                            }
                        }
                        else if ((key == KeyEvent.VK_LEFT || key == KeyEvent.VK_A)) {
                            if (punching == true) {
                                changex = -1;
                            } else {
                                changex = -2;
                                path = pathLeftWalking;                                
                            }
                        }
                        else if ((key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D)) {
                            changex = 0;
                            if (punching == false) {
                                path = pathRightWalking;                               
                            }
                        }
                }
   	}
	public void keyReleased(KeyEvent e) {
        	int key = e.getKeyCode();
                if (frozen == false) {
                    if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_A) {
            		changex = 0;
                        if (punching == false) {
                            path = pathLeft;                            
                        }
                    }
                    if (key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D) {
            		changex = 0;
                        if (punching == false) {
                            path = pathRight;                           
                        }
                    } 
                    if (key == KeyEvent.VK_SPACE && punching == false) {
            		changex = 0;                        
                    }
        	}
    	}
}