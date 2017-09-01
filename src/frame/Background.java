package frame;

/*
background for main program
*/

import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

//"N:/Work/A-Level/computing/summer project/sprites/"
//"C:/Users/Germingi/Documents/school/computing/summer project/sprites/"

public class Background {
	private int xpos, ypos, changex, changey; //will determine where on the frame the sprite will be loaded
	private String path = "Not set"; //where the image is located
        private PlayerSprite playerSprite;
	Background(PlayerSprite playersprite) {		
		xpos = 0;
		ypos = 0;
		changex = 0;
		changey = 0;	
                path = System.getProperty("user.dir")+"/sprites/background"+Global.level+".png";
                this.playerSprite = playersprite;
                Global.isRight = false;
	}
	public void reset() {
                xpos = 0;
		ypos = 0;
		changex = 0;
		changey = 0;
                path = System.getProperty("user.dir")+"/sprites/background"+Global.level+".png";
        }
        public void move() {
            if (Global.spawn == true || playerSprite.getHealth() == 0) {
                changex = 0;
            }
            xpos += changex;
            ypos += changey;
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
        public void setChangex(int newChangex) {
            changex = newChangex;
        }
        public int getChangex() {
            return changex;
        }
	public void keyPressed(KeyEvent e) { //once key is pressed, do action
       		int key = e.getKeyCode();
                if (Global.spawn == false) {
                    if ((key == KeyEvent.VK_LEFT || key == KeyEvent.VK_A) && playerSprite.getXpos() <= 240) {
            		changex = 0;
                    }
                    else if ((key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D) && xpos <= -3836) {
            		changex = 0;
                        Global.isRight = true;
                    }
                    else if ((key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D) && playerSprite.getXpos() >= 360) {
            		changex = -2;
                    }
                    else if ((key == KeyEvent.VK_LEFT || key == KeyEvent.VK_A)) {
            		changex = 0;
                    }
                    else if ((key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D)) {
            		changex = 0;
                    }
               }
   	}
	public void keyReleased(KeyEvent e) {
        	int key = e.getKeyCode();
        	if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_A) {
            		changex = 0;
        	}
        	if (key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D) {
            		changex = 0;
        	}
    	}
}